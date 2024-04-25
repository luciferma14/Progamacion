//1
import Programacion.Blog.JavaFX.OperacionesBD.OperacionBD;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.beans.value.*;
//1

public class JavaFXComponentes extends Application{

 OperacionBD op = new OperacionBD();

    public JavaFXComponentes() {
    }

    @Override
    public void start(Stage stage){
     stage.setTitle("Componentes JavaFX");
     Group raiz = new Group();
     Scene escena = new Scene(raiz,500,500);
     stage.setScene(escena);
     stage.show();


     //2
     Rectangle recFondo = new Rectangle();
     recFondo.setFill(Color.LIGHTBLUE);
     recFondo.setWidth(500);
     recFondo.setHeight(500);

     raiz.getChildren().add(recFondo);
  //2

  //3
  VBox principal = new VBox() , labels = new VBox(), textbox = new VBox();
  principal.setSpacing(5);
  principal.setLayoutX(50);
  principal.setLayoutY(50);
  labels.setSpacing(10);
  textbox.setSpacing(5);
  //3

  //4
  HBox componentes = new HBox();
  componentes.setSpacing(15);
  //4

  //5
  Label lbCodigo,lbNombre,lbApellido,lbTelefono,lbDireccion;
  lbCodigo = new Label("Codigo:");
  lbNombre = new Label("Nombre:");
  lbApellido = new Label("Apellido:");
  lbTelefono = new Label("Telefono:");
  lbDireccion = new Label("Direccion:");

  final TextField txtCodigo,txtNombre,txtApellido,txtTelefono,txtDireccion;
  txtCodigo = new TextField();
  txtCodigo.setPromptText("Ingrese El Codigo");

  txtNombre = new TextField();
  txtNombre.setPromptText("Ingrese El Nombre");

  txtApellido = new TextField();
  txtApellido.setPromptText("Ingrese El Apellido");

  txtTelefono = new TextField();
  txtTelefono.setPromptText("Ingrese El Telefono");

  txtDireccion = new TextField();
  txtDireccion.setPromptText("Ingrese La Direccion");

  final ChoiceBox cboOperacion = new ChoiceBox();
  cboOperacion.getItems().addAll("Seleccione la Operacion a Ejecutar","Ingresar","Modificar","Eliminar","Limpiar");
  cboOperacion.setTooltip(new Tooltip("Seleccione Operacion a Base de Datos"));

  cboOperacion.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
   public void changed(ObservableValue ov, Number value, Number new_value){
    op.Validar(new_value.intValue(),txtCodigo,txtNombre,txtApellido,txtTelefono,txtDireccion);
   }
  });
  //5

  //6
  labels.getChildren().addAll(lbCodigo,lbNombre,lbApellido,lbTelefono,lbDireccion);
  textbox.getChildren().addAll(txtCodigo,txtNombre,txtApellido,txtTelefono,txtDireccion);
  componentes.getChildren().addAll(labels,textbox);
  principal.getChildren().addAll(componentes,cboOperacion);

  raiz.getChildren().addAll(principal);
  //6

    }
 //7
    public static void main(String[] args){
     Application.launch(args);
    }
    //7

}