module org.example.fazenda {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;

    // Exporta o pacote do modelo para que o MongoDB PojoCodecProvider consiga acessá-lo
    opens com.model to org.mongodb.bson, javafx.fxml;

    exports com;
    exports com.util;
    exports com.model;
}