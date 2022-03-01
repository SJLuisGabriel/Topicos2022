package com.example.topicos2022_proyecto.views;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;

public class Practica1 extends Stage {
    private Scene escena;
    private VBox vBoxP,CajaVertical;
    private HBox hBox1, hBox2, hBox3;
    private BorderPane raiz;
    private FlowPane flow, flow2;
    private GridPane grid;
    private StackPane sp;
    private TilePane tile;
    private AnchorPane anchor;
    private Button btnCajaV1, btnCajaV2, btnCajaV3; //Botones de la Caja Vertical
    private Button btnRaiz1, btnRaiz2, btnRaiz3, btnRaiz4, btnRaiz5; // Botones Raiz
    private Button btnFlowP1, btnFlowP2, btnFlowP3; // Botones FlowPane
    private Button btnFlowPV1, btnFlowPV2, btnFlowPV3; // Botones FlowPaneV
    private Button btnGPane1,btnGPane2,btnGPane3,btnGPane4,btnGPane5,btnGPane6,btnGPane7; // Botones GrindPane

    public Practica1(){
        CrearUI();
        this.setTitle("Practica 1");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBoxP = new VBox();
        hBox1 = new HBox();
        hBox2 = new HBox(); hBox3 = new HBox();

        btnCajaV1 = new Button("Button 1 CajaV"); btnCajaV2 = new Button("Button 2 CajaV");
        btnCajaV3 = new Button("Button 3 CajaV");
        CajaVertical = new VBox(10);
        CajaVertical.setPadding(new Insets(10));
        CajaVertical.getChildren().addAll(btnCajaV1, btnCajaV2, btnCajaV3);
        btnCajaV1.setId("BtnsCajaV"); btnCajaV2.setId("BtnsCajaV"); btnCajaV3.setId("BtnsCajaV");

        btnRaiz1 = new Button("TOP Raiz"); btnRaiz2 = new Button("BOTTOM Raiz");
        btnRaiz3 = new Button("LEFT Raiz"); btnRaiz4 = new Button("RIGHT Raiz");
        btnRaiz5 = new Button("CENTER Raiz");
        raiz = new BorderPane();
        raiz.setPadding(new Insets(10));
        raiz.setTop(btnRaiz1);
        raiz.setBottom(btnRaiz2);
        raiz.setLeft(btnRaiz3);
        raiz.setRight(btnRaiz4);
        raiz.setCenter(btnRaiz5);
        btnRaiz1.setId("BtnsRaiz"); btnRaiz2.setId("BtnsRaiz"); btnRaiz3.setId("BtnsRaiz");
        btnRaiz4.setId("BtnsRaiz"); btnRaiz5.setId("BtnsRaiz");

        btnFlowP1 = new Button("Boton 1 FlowP"); btnFlowP2 = new Button("Boton 2 FlowP");
        btnFlowP3 = new Button("Boton 3 FlowP");
        flow = new FlowPane();
        flow.setPadding(new Insets(10));
        flow.getChildren().addAll(btnFlowP1,btnFlowP2,btnFlowP3);
        btnFlowP1.setId("BtnsFlowP"); btnFlowP2.setId("BtnsFlowP"); btnFlowP3.setId("BtnsFlowP");

        btnFlowPV1 = new Button("Boton 1 FlowPV"); btnFlowPV2 = new Button("Boton 2 FlowPV");
        btnFlowPV3 = new Button("Boton 3 FlowPV");
        flow2 = new FlowPane(Orientation.VERTICAL);//Establecemos la orientación
        flow2.setPadding(new Insets(10));
        flow2.setVgap(10);//Seteamos la separación vertical entre los nodos.
        flow2.getChildren().addAll(btnFlowPV1,btnFlowPV2,btnFlowPV3);
        btnFlowPV1.setId("BtnsFlowPV"); btnFlowPV2.setId("BtnsFlowPV"); btnFlowPV3.setId("BtnsFlowPV");

        btnGPane1 = new Button("Posicion 0, 0 GrPane"); btnGPane2 = new Button("Posicion 0, 1 GrPane");
        btnGPane3 = new Button("Posicion 0, 2 GrPane"); btnGPane4 = new Button("Posicion 1, 0 GrPane");
        btnGPane5 = new Button("Posicion 1, 1 GrPane"); btnGPane6 = new Button("Posicion 1, 2 GrPane");
        btnGPane7 = new Button("Posicion Col 9, Fila 2 GrPane");
        grid = new GridPane();
        grid.setVgap(10); grid.setHgap(10);
        grid.setPadding(new Insets(10));
        grid.add(btnGPane1, 0, 0); grid.add(btnGPane2, 0, 1); grid.add(btnGPane3, 0, 2);
        grid.add(btnGPane4, 1, 0); grid.add(btnGPane5, 1, 1); grid.add(btnGPane6, 1, 2);
        grid.add(btnGPane7, 9, 2);
        btnGPane1.setId("BtnsGrPane"); btnGPane2.setId("BtnsGrPane"); btnGPane3.setId("BtnsGrPane");
        btnGPane4.setId("BtnsGrPane"); btnGPane5.setId("BtnsGrPane"); btnGPane6.setId("BtnsGrPane");
        btnGPane7.setId("BtnsGrPane");


        sp = new StackPane();
        Button b1, b2, b3;
        b1 = new Button("Boton 1 StackPane"); b2 = new Button("Boton 2 StackPane");
        b3 = new Button("Boton 3 StackPane");
        StackPane.setAlignment(b1, Pos.CENTER);
        StackPane.setAlignment(b2, Pos.TOP_LEFT);
        StackPane.setAlignment(b3, Pos.TOP_RIGHT);
        sp.getChildren().addAll(b1, b2, b3);
        b1.setId("BtnsStackP"); b2.setId("BtnsStackP"); b3.setId("BtnsStackP");


        tile = new TilePane(Orientation.VERTICAL);//Por defecto la posicion horizontal
        tile.setPrefColumns(6);//Declaramos 6 columnas
        tile.setPrefRows(4);//Y 4 filas
        for(int i = 0; i < 20; i++) {
            tile.getChildren().add(new Button("Boton TilePane "+ i));
        }


        anchor  = new AnchorPane();
        Button anb1  = new Button("Boton 1 AnchorPane");
        Button anb2  = new Button("Boton 2 AnchorPane");
        Button anb3 = new Button("Boton 3 AnchorPane");
        AnchorPane.setTopAnchor(anb2, 70.0);
        AnchorPane.setRightAnchor(anb2, 10.0);
        AnchorPane.setLeftAnchor(anb2, 20.0);
        AnchorPane.setRightAnchor(anb3, 5.0);
        AnchorPane.setBottomAnchor(anb3, 20.0);
        AnchorPane.setLeftAnchor(anb3, 20.0);
        anchor.getChildren().addAll(anb1, anb2, anb3);
        anb1.setId("BtnsAnchorPane"); anb2.setId("BtnsAnchorPane"); anb3.setId("BtnsAnchorPane");

        hBox1.getChildren().addAll(CajaVertical,raiz,sp);
        hBox2.getChildren().addAll(flow,flow2,anchor);
        hBox3.getChildren().addAll(grid,tile);

        vBoxP.getChildren().addAll(hBox1,hBox3,hBox2);
        escena = new Scene(vBoxP);

        File filecss = new File("src/main/java/com/example/topicos2022_proyecto/views/css/css.css");
        escena.getStylesheets().add(filecss.toURI().toString());
    }
}