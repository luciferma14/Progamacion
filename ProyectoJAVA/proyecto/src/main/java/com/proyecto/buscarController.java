package com.proyecto;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class buscarController {

    @FXML
    private void cambiaAOpciones() throws IOException {
        App.setRoot("busResPresDev");
    }
    
    // @FXML
    // private void cambiarAFindLibros() throws IOException {
    //     App.setRoot("encontrarLibros");
    // }

    @FXML
    private TextField FTitulo;
    @FXML
    private TextField FAutor;
    @FXML
    private TextField FISBN;
    @FXML
    private TextField FGenero;

    public PreparedStatement ps;

	public ResultSet rs;

    private static String driv = "com.mysql.jdbc.Driver";
    private static String bibl = "jdbc:mysql://localhost:33006/Biblioteca";
    private static String usr= "root";
    private static String pass = "dbrootpass";

    @FXML
    private void FindLibros() throws SQLException, IOException{

        String tit = FTitulo.getText();
        String aut = FAutor.getText();
        String isbn = FISBN.getText();
        String gen = FGenero.getText();
        
        try {
            Connection con = DriverManager.getConnection(bibl, usr, pass);

            String query1 = "SELECT titulo FROM libros WHERE titulo LIKE ?";
            String query2 = "SELECT autor FROM libros WHERE autor LIKE ?";
            String query3 = "SELECT isbn FROM libros WHERE isbn LIKE ?";
            String query4 = "SELECT genero FROM libros WHERE genero LIKE ?";

            try{
                PreparedStatement st1 = con.prepareStatement(query1);
                    st1.setString(1, tit);
                    ResultSet rs = st1.executeQuery();

                PreparedStatement st2 = con.prepareStatement(query2);
                    st2.setString(1, aut);
                    rs = st2.executeQuery();
                
                PreparedStatement st3 = con.prepareStatement(query3);
                    st3.setString(1, isbn);
                    rs = st3.executeQuery();

                PreparedStatement st4 = con.prepareStatement(query4);
                    st4.setString(1, gen);
                    rs = st4.executeQuery();

                if (rs.next()) {
                    
                    App.setRoot("encontrarLibros");

                } else {
                    
                    JOptionPane.showMessageDialog(null, "No tenemos ningún libro con esas características." +'\n' + "Inténtelo otra vez.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } 
    }
}