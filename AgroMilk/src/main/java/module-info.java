module com {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
    requires java.desktop;
    requires bcrypt;

    // Exporta o pacote do modelo para que o MongoDB PojoCodecProvider consiga acessá-lo
    opens com to org.mongodb.bson, javafx.fxml;
    opens com.controllers to javafx.fxml;

    exports com;
    exports com.util;
    exports com.model;
    exports com.controllers;
}