module com.uq.proyectofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens com.uq.proyectofx to javafx.fxml;
    exports com.uq.proyectofx;
    exports com.uq.proyectofx.controller;
    opens com.uq.proyectofx.controller to javafx.fxml;
}