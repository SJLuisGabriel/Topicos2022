module com.example.topicos2022_proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires mariadb.java.client;


    opens com.example.topicos2022_proyecto to javafx.fxml;
    exports com.example.topicos2022_proyecto;
}