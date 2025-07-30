module org.baratech.tempus {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires eu.hansolo.tilesfx;

    opens org.baratech.tempus to javafx.fxml;
    exports org.baratech.tempus;
}