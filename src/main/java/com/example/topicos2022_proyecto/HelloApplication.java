package com.example.topicos2022_proyecto;

import com.example.topicos2022_proyecto.views.Parseador;
import com.example.topicos2022_proyecto.views.Practica1;
import com.example.topicos2022_proyecto.views.loteria;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application{

    private BorderPane bdpPrincipal;
    private MenuBar mnbOPciones;
    private Menu menCompetencia1, menCompetencia2,menSalir;
    private MenuItem miLoteria,miPractica1, mitSalir, miParseador;
    private Scene escena;
    private VBox vBox;

    @Override
    public void start(Stage primaryStage) {

        CrearUI();
        primaryStage.setScene(escena);
        //primaryStage.setMaximized(true);
        primaryStage.setMaxHeight(250);
        primaryStage.setTitle("Formulario Principal");
        primaryStage.show();
    }

    private void CrearUI() {

        vBox = new VBox();

        bdpPrincipal = new BorderPane();
        mnbOPciones = new MenuBar();
        menCompetencia1 = new Menu("1er. Competencia");
        menCompetencia2 = new Menu("2da. Competencia");
        menSalir = new Menu("Salir");

        //Agregar menus al menubar
        mnbOPciones.setStyle("-fx-background-color: #84b6f4");
        mnbOPciones.getMenus().addAll(menCompetencia1,menCompetencia2,menSalir);
        bdpPrincipal.setTop(mnbOPciones);

        //Instaciamos los MenusItems
        miLoteria = new MenuItem("Loteria");
        miPractica1 = new MenuItem("Practica 1");
        miParseador = new MenuItem("Codigo Morse");
        /*miLoteria.setOnAction(event -> {
            new loteria();
        });*/

        miLoteria.setOnAction(event -> MenuOpciones(1));
        miPractica1.setOnAction(event -> MenuOpciones(2));
        miParseador.setOnAction(event -> MenuOpciones(3));

        menCompetencia1.getItems().addAll(miLoteria,miPractica1,miParseador);

        mitSalir = new MenuItem("Hasta Luego");
        mitSalir.setOnAction(event -> MenuOpciones(20));
        menSalir.getItems().addAll(mitSalir);

        vBox.getChildren().addAll(mnbOPciones);

        escena = new Scene(vBox,280,30);
    }

    private void MenuOpciones(int opc){
        switch (opc){
            case 1: new loteria(); break;
            case 2: new Practica1(); break;
            case 3: new Parseador(); break;
            case 20: System.exit(0);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}