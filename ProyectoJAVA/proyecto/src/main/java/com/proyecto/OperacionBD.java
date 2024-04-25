package com.proyecto;
import java.sql.*;
import javax.swing.JOptionPane;
import javafx.scene.control.*;

public class OperacionBD {

    ConexionBD conexionBD = new ConexionBD("BDJavaFX","root","root","3306");
    private Connection conexion=null;
    private Statement stmt;
    private ResultSet rs;
    private int filas=0;

        public OperacionBD() {
        }


    public void Validar(int valor,TextField Codigo,TextField Nombre,TextField Apellido,TextField Telefono,TextField Direccion){
    if(valor==0){
    JOptionPane.showMessageDialog(null,"Seleccione La Operacion a Ejecutar Por Favor","Error",JOptionPane.ERROR_MESSAGE);
    }else if(valor==1){
    IngresarPersona(Nombre,Apellido,Telefono,Direccion);
    }else if(valor==2){
    ModificarPersona(Codigo,Nombre,Apellido,Telefono,Direccion);
    }else if(valor==3){
    EliminarPersona(Codigo);
    }else if(valor==4){
    Limpiar(Codigo,Nombre,Apellido,Telefono,Direccion);
    }
    }

        private void IngresarPersona(TextField Nombre,TextField Apellido,TextField Telefono,TextField Direccion){
        if (Nombre.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Ingrese el Nombre Porfavor","Ingresar Persona",JOptionPane.WARNING_MESSAGE);
        }else if(Apellido.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Ingrese el Apellido PorFavor","Ingresar Persona",JOptionPane.WARNING_MESSAGE);
        }else if(Telefono.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Ingrese el Telefono PorFavor","Ingresar Persona",JOptionPane.WARNING_MESSAGE);
        }else if(Direccion.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Ingrese el Direccion PorFavor","Ingresar Persona",JOptionPane.WARNING_MESSAGE);
        }else{
    conexionBD.Operacion("INSERT INTO PersonaFX (Nombre,Apellido,Telefono,Direccion) VALUES ('"+Nombre.getText()+"','"+Apellido.getText()+"','"+Telefono.getText()+"','"+Direccion.getText()+"')","Ingreso Persona");
        }
        }

        private void ModificarPersona(TextField Codigo,TextField Nombre,TextField Apellido,TextField Telefono,TextField Direccion){
        if (Codigo.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Ingrese el Codigo Porfavor","Modficar Persona",JOptionPane.WARNING_MESSAGE);
        }
        else if (Nombre.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Ingrese el Nombre Porfavor","Modficar Persona",JOptionPane.WARNING_MESSAGE);
        }else if(Apellido.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Ingrese el Apellido PorFavor","Modficar Persona",JOptionPane.WARNING_MESSAGE);
        }else if(Telefono.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Ingrese el Telefono PorFavor","Modficar Persona",JOptionPane.WARNING_MESSAGE);
        }else if(Direccion.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Ingrese el Direccion PorFavor","Modficar Persona",JOptionPane.WARNING_MESSAGE);
        }else{
    conexionBD.Operacion("UPDATE PersonaFX SET VALUES Nombre='"+Nombre.getText()+"',Apellido='"+Apellido.getText()+"',Telefono='"+Telefono.getText()+"',Direccion='"+Direccion.getText()+"' WHERE id='"+Codigo.getText()+"'","Modificación Persona");
        }
        }

        private void EliminarPersona(TextField Codigo){
        if (Codigo.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Ingrese el Codigo Porfavor","Modficar Persona",JOptionPane.WARNING_MESSAGE);
        }else{
    conexionBD.Operacion("DELETE PersonaFX WHERE id='"+Codigo.getText()+"'","Eliminación Persona");
        }
        }

        private void Limpiar (TextField Codigo,TextField Nombre,TextField Apellido,TextField Telefono,TextField Direccion){
        Codigo.setText("");
        Nombre.setText("");
        Apellido.setText("");
        Telefono.setText("");
        Direccion.setText("");
        }

}