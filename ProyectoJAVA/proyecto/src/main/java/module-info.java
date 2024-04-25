module com.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.sql;
    requires com.h2database;
    requires java.desktop;
    

    opens com.proyecto to javafx.fxml;
    exports com.proyecto;
}
