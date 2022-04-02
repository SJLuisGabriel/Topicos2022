package com.example.topicos2022_proyecto;

import com.example.topicos2022_proyecto.models.Conexion;
import com.example.topicos2022_proyecto.views.Parseador;
import com.example.topicos2022_proyecto.views.Practica1;
import com.example.topicos2022_proyecto.views.Taqueria;
import com.example.topicos2022_proyecto.views.loteria;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;

public class HelloApplication extends Application implements EventHandler {

    private BorderPane bdpPrincipal;
    private MenuBar mnbOPciones;
    private Menu menCompetencia1, menCompetencia2,menSalir;
    private MenuItem miLoteria,miPractica1, mitSalir, miParseador, miTaqueria;
    private Scene escena;
    private VBox vBox;

    @Override
    public void start(Stage primaryStage) {

        //primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWING,this);
        new Parseador();
        CrearUI();
        //primaryStage.setScene(escena);
        //primaryStage.setMaximized(true);
        primaryStage.setTitle("Formulario Principal");
        //primaryStage.show();
    }

    private void CrearUI() {

        vBox = new VBox();

        bdpPrincipal = new BorderPane();
        mnbOPciones = new MenuBar();
        menCompetencia1 = new Menu("1er. Competencia");
        menCompetencia2 = new Menu("2da. Competencia");
        menSalir = new Menu("Salir");

        //Agregar menus al menubar
       // mnbOPciones.setStyle("-fx-background-color: #1E8449");
        //mnbOPciones.setStyle("-fx-font-size: 29");
        mnbOPciones.setStyle("-fx-background-color:transparent");
        menCompetencia1.setStyle("");
        mnbOPciones.getMenus().addAll(menCompetencia1,menCompetencia2,menSalir);
        bdpPrincipal.setTop(mnbOPciones);

        //Instaciamos los MenusItems
        miLoteria = new MenuItem("Loteria");
        miPractica1 = new MenuItem("Practica 1");
        miParseador = new MenuItem("Codigo Morse");
        miTaqueria = new MenuItem("Taqueria BD");
        /*miLoteria.setOnAction(event -> {
            new loteria();
        });*/

        miLoteria.setOnAction(event -> MenuOpciones(1));
        miPractica1.setOnAction(event -> MenuOpciones(2));
        miParseador.setOnAction(event -> MenuOpciones(3));
        miTaqueria.setOnAction(event -> MenuOpciones(4));

        menCompetencia1.getItems().addAll(miLoteria,miPractica1,miParseador,miTaqueria);

        mitSalir = new MenuItem("Hasta Luego");
        mitSalir.setOnAction(event -> MenuOpciones(20));
        menSalir.getItems().addAll(mitSalir);

        vBox.getChildren().addAll(mnbOPciones);

        escena = new Scene(vBox,600,250);

        //escena.getStylesheets().add(getClass().getResource("src/main/java/com/example/topicos2022_proyecto/views/css/styleMain.css").toString());

        File Filecss = new File("src/main/java/com/example/topicos2022_proyecto/views/css/styleMain.css");
        escena.getStylesheets().add(Filecss.toURI().toString());
        Conexion.getConexion();
    }

    private void MenuOpciones(int opc){
        switch (opc){
            case 1: new loteria(); break;
            case 2: new Practica1(); break;
            case 3: new Parseador(); break;
            case 4: new Taqueria(); break;
            case 20: System.exit(0);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
        Alert alerta  = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Bienvenido");
        alerta.setHeaderText("Mensaje Del Sistema");
        alerta.setContentText("Manejo De Eventos De La Ventana Usando Dialogos");
        alerta.showAndWait();
    }


}