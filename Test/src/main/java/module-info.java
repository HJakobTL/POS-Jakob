module org.example.test {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.test to javafx.fxml;
    exports org.example.test;
}