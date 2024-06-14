module luciferma_jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens luciferma_jfx to javafx.fxml;
    exports luciferma_jfx;
}
