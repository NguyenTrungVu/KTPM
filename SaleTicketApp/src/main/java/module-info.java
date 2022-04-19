module com.nv.saleticketapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    
    opens com.nv.saleticketapp to javafx.fxml;
    exports com.nv.saleticketapp;
}
