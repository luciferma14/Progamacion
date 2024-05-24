module com.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.sql;
    requires com.h2database;
    requires java.desktop;
    requires mysql.connector.j;
    

    opens com.proyecto to javafx.fxml;
    exports com.proyecto;
}
