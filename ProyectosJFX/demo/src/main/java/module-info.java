module luciferma_jfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens luciferma_jfx to javafx.fxml;
    exports luciferma_jfx;
}
