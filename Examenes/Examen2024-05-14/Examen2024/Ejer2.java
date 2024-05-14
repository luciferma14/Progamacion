import java.sql.Statement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Ejer2 {
    public static void main(String[] args) throws SQLException {

        String driv = "com.mysql.jdbc.Driver";
        String bibl = "jdbc:mysql://localhost:33006/exdaw";
        String usr= "root";
        String pass = "dbrootpass";

        Scanner scanner = new Scanner(System.in);

        double subtotal = 0.0;
        double total = 0.0;
        double iva = 0.0;
        double importePagar = 0.0;

        System.out.print("Introduce el código de cliente: ");
        int codCliente = scanner.nextInt();

        String queryCab1 = "SELECT NombreCliente, LineaDireccion1, Ciudad, CodigoPostal, Pais, Telefono FROM exdaw.clientes WHERE CodigoCliente = " + codCliente;
        String queryPed = "SELECT CodigoPedido, FechaPedido, Estado, Comentarios FROM exdaw.pedidos WHERE CodigoCliente = " + codCliente + "ORDER BY FechaPedido";
        String queryDet = "SELECT CodigoProducto, Nombre, Cantidad, PrecioUnidad FROM detallepedidos NATURAL JOIN exdaw.productos WHERE CodigoPedido = " + codCliente + "ORDER BY NumeroLinea";

        try {
			Connection con = DriverManager.getConnection(bibl,usr,pass);
            try {
				Class.forName(driv);
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
            
            Statement st = con.createStatement();

            ResultSet rsCab1 = st.executeQuery(queryCab1);
            ResultSet rsPed = st.executeQuery(queryPed);
            ResultSet rsDet = st.executeQuery(queryDet);

            File arch = new File("Factura_" + codCliente + ".txt");
            PrintWriter escr = new PrintWriter(new FileWriter(arch));

            while (rsCab1.next()) {
                escr.println(rsCab1.getString("NombreCliente") + " " + rsCab1.getString("LineaDireccion1") + " " + rsCab1.getString("Ciudad") + " " + rsCab1.getString("CodigoPostal") + " " + rsCab1.getString("Pais") + " " + rsCab1.getString("Telefono"));
                escr.println("------------------------------------------------------------------");
            }

            while (rsPed.next()) {
                escr.println(rsPed.getInt("CodigoPedido") + " " + rsPed.getDate("FechaPedido") + " " + rsPed.getString("Estado") + " " + rsPed.getString("Comentarios"));
                escr.println();

                while (rsDet.next()) {
                    if (rsDet.getInt("CodigoPedido") == rsPed.getInt("CodigoProducto")) {
                        double importe = rsDet.getInt("Cantidad") * rsDet.getDouble("PrecioUnidad");
                        subtotal += importe;

                        escr.println(String.format("%-10s %-30s %-10s %-10s %-10s", rsDet.getString("CodigoProducto"), rsDet.getString("Nombre"), rsDet.getInt("Cantidad"), new DecimalFormat("#.##").format(rsDet.getDouble("PrecioUnidad")), new DecimalFormat("#.##").format(importe)));
                    }
                }

                iva = subtotal * 0.21;
                total += subtotal;
                importePagar = total + iva;

                escr.println();
                escr.println("Subtotal: " + new DecimalFormat("#.##").format(subtotal));
                escr.println("------------------------------------------------------------------");
                subtotal = 0.0;
            }

            escr.println("Total: " + new DecimalFormat("#.##").format(total));
            escr.println("IVA: " + new DecimalFormat("#.##").format(iva));
            escr.println("Importe a Pagar: " + new DecimalFormat("#.##").format(importePagar));
            escr.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}