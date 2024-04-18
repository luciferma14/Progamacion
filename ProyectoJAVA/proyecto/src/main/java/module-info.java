module com.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    

    opens com.proyecto to javafx.fxml;
    exports com.proyecto;
}
