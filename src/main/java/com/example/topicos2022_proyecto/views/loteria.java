package com.example.topicos2022_proyecto.views;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;

public class loteria extends Stage {

    private VBox vBox, vBox1;
    private HBox hBox1, hBox2;
    private Button btnAtras, btnSiguiente, btnSeleccionar;
    private Label lblNombreCarta, lblCarta, lblTiempo;
    private GridPane gdpPlantilla;
    private Image imgCarta;
    private Scene escena;
    private Button [][] arBtnCartas = new Button[3][3];
    private File file, file2;
    private int a = 0, b = 1, c = 0, Ncarta = 9, d = 0, contadorMazoIgual = 0, cnttiempS2 = 0, cnttiempS1 = 0;
    private int cnttiempM2 = 0, cnttiempM1 = 0;
    int [] aleatorios = new int [54];
    private Timer timer,timeTiempo;
    private boolean empezar = false, termino = false;
    private String [] arImagenes = {"anubis.jpg","ares.jpg","artemisa.jpg","atenea.jpg","azazel.jpg",
            "basilisco.jpg","cerbero.jpg","chimera.png","cronos.jpg",//1
            "cthulhu.jpg","djinn.jpg","dragon.jpg","fenrir.jpg","freya.jpg", "ganesha.png","grifo.jpg","hades.jpg",
            "hefesto.jpg",//2
            "hela.jpg","hercules.jpg","hermes.jpg","hlobo.jpg","hydra.jpg","isis.jpg", "jinetes.jpg",
            "jormungandr.jpg","leviatan.jpg",//3
            "loki.jpg","medusa.jpg","mictlantecuhtli.png","minotauro.jpg", "odin.jpg","osiris.jpg",
            "poseidon.jpg","prometeo.jpg","quetzalcoatl.jpg",//4
            "ra.png","rakshasa.jpg","shiva.jpg","sirena.jpg", "wendigo.jpg","wukong.png","xipetotec.jpg",
            "ymir.jpg","zeus.jpg",//5
            "unicornio.jpg","oni.jpg","manticora.jpg","kraken.jpg","hipocampos.jpg","golem.jpg","esfinge.jpg",
            "ciclope.jpg","centauro.jpg",//6
            "Adorso.jpg"};

    private String [] arNombresCartas = {"ANUBIS","ARES","ARTEMISA","ATENEA","AZAZEL","BASILISCO","CERBERO","CHIMERA","CRONOS","CTHULHU",
            "DJINN","DRAGON","FENRIR","FREYA","GANESHA","GRIFO","HADES","HEFESTO","HELA","HERACLES","HERMES","HOMBRE LOBO","HYDRA","ISIS",
            "JINETES DEL APOCALIPSIS","JORMUNGANDR","LEVIATAN","LOKI","MEDUSA","MICTLANTECUHTLI","MINOTAURO","ODIN","OSIRIS","POSEIDON",
            "PROMETEO","QUETZALCOATL","RA","RAKSHASA","SHIVA","SIRENA","WENDIGO","WUKONG","XIPETOTEC","YMIR","ZEUS","UNICORNIO","ONI",
            "MANTICORA","KRAKEN","HIPOCAMPOS","GOLEM","ESFINGE","CICLOPE","CENTAURO"};

    public loteria(){
        CrearUI();
        this.setTitle("Loteria");

        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        btnAtras = new Button("< Plantilla Anterior");
        btnSiguiente = new Button("Plantilla Siguiente >");
        btnSeleccionar = new Button("Seleccionar Plantilla");
        lblNombreCarta = new Label("");
        lblCarta = new Label();
        lblTiempo = new Label("Tiempo De Juego: 00:00");
        vBox = new VBox();
        hBox1 = new HBox();
        hBox2 = new HBox();
        vBox1 = new VBox();
        gdpPlantilla = new GridPane();
        lblNombreCarta.setFont(Font.font("Candara", 20));
        lblNombreCarta.setWrapText(true);
        btnSeleccionar.setId("BtnsLoteria");
        btnAtras.setId("BtnsLoteria");
        btnSiguiente.setId("BtnsLoteria");

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                arBtnCartas [j][i] = new Button();
                arBtnCartas [j][i].setPrefSize(200,180);
                file = new File("src/main/java/com/example/topicos2022_proyecto/images/"+arImagenes[a]);
                imgCarta = new Image(file.toURI().toString());
                ImageView view = new ImageView(imgCarta);
                view.setFitHeight(170);
                view.setFitWidth(150);
                view.setPreserveRatio(true);
                arBtnCartas [j][i].setGraphic(view);
                int numj = j, numi = i;
                arBtnCartas [j][i].setOnAction(event -> {Comparar(numi,numj); Parar();});
                arBtnCartas[j][i].setId("btnPlantilla");
                gdpPlantilla.add(arBtnCartas[j][i],i,j);
                a++;
            }
        }

        btnSiguiente.setOnAction(event -> {
            b++;
            if (b > 6) b = 1;
            CambioDPl();
        });

        btnAtras.setOnAction(event -> {
            b--;
            if (b < 1) b = 6;
            CambioDPl();
        });

        file2 = new File("src/main/java/com/example/topicos2022_proyecto/images/"+arImagenes[54]);
        imgCarta = new Image(file2.toURI().toString());
        ImageView view = new ImageView(imgCarta);

        view.setFitWidth(200);
        view.setFitHeight(200);
        view.setPreserveRatio(true);
        lblCarta.setGraphic(view);
        lblCarta.setAlignment(Pos.CENTER);

        btnSeleccionar.setOnAction(event -> {
            btnSiguiente.setVisible(false);
            btnAtras.setVisible(false);
            btnSeleccionar.setVisible(false);
            empezar = true;

            if (d == 0){
                CartaAleatorio();
                d++;
            }
            TimerCarta();
        });

        hBox1.getChildren().addAll(btnAtras,btnSiguiente);
        vBox1.getChildren().addAll(lblTiempo,lblNombreCarta,lblCarta,btnSeleccionar);
        hBox2.getChildren().addAll(gdpPlantilla,vBox1);

        vBox.setStyle("-fx-background-color:#4CAF50");
        vBox1.setStyle("-fx-background-color:#81C784");
        hBox1.setSpacing(10);
        vBox1.setAlignment(Pos.TOP_CENTER);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setSpacing(30);
        vBox.setSpacing(10);
        vBox1.setSpacing(10);
        vBox.setPadding(new Insets(10));
        lblCarta.setStyle("-fx-background-radius: 40 40 40 40");

        vBox.getChildren().addAll(hBox1,hBox2);
        escena = new Scene(vBox,880,615);
        File filecss = new File("src/main/java/com/example/topicos2022_proyecto/views/css/css.css");
        escena.getStylesheets().add(filecss.toURI().toString());
    }

    public void CambioDPl(){
        switch (b) {
            case 1: Ncarta = 0; break;
            case 2: Ncarta = 9; break;
            case 3: Ncarta = 18; break;
            case 4: Ncarta = 27; break;
            case 5: Ncarta = 36; break;
            case 6: Ncarta = 45; break;
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                file = new File(
                        "src/main/java/com/example/topicos2022_proyecto/images/"+arImagenes[Ncarta]);
                imgCarta = new Image(file.toURI().toString());
                ImageView view = new ImageView(imgCarta);
                view.setFitHeight(170);
                view.setFitWidth(150);
                view.setPreserveRatio(true);
                arBtnCartas [j][i].setGraphic(view);
                Ncarta++;
            }
        }
    }

    public void CartaAleatorio(){

        int cantidad = 54, index = 0;

        while(index < cantidad) {
            int propuesto = (int)(Math.random()*cantidad);
            boolean repetido = false;
            while(!repetido) {
                for(int i=0; i<index; i++) {
                    if(propuesto == aleatorios[i]) {
                        repetido = true;
                        break;
                    }
                }
                if(!repetido) {
                    aleatorios[index] = propuesto;
                    index++;
                }
            }
        }
    }

    public void TimerCarta (){

        timeTiempo = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                Platform.runLater(
                        new Runnable() {
                            @Override
                            public void run() {
                                cnttiempS2++;
                                if (cnttiempS2 == 10) {
                                    cnttiempS1++;
                                    cnttiempS2 = 0;
                                    if (cnttiempS1 == 6) {
                                        cnttiempS1 = 0;
                                        cnttiempM2++;
                                        if (cnttiempM2 == 10) {
                                            cnttiempM2 = 0;
                                            cnttiempM1++;
                                        }
                                    }
                                }
                                lblTiempo.setText("Tiempo De Juego: " + cnttiempM1 + "" + cnttiempM2 + ":" + cnttiempS1 + cnttiempS2);
                            }
                        }
                );
            }
        });

        timer = new Timer(2000, new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                Platform.runLater(
                    new Runnable() {
                        @Override
                        public void run() {
                            if (c <= 54) {
                                file2 = new File(
                                        "src/main/java/com/example/topicos2022_proyecto/images/" +
                                                arImagenes[aleatorios[c]]);
                                imgCarta = new Image(file2.toURI().toString());
                                ImageView view2 = new ImageView(imgCarta);
                                view2.setFitWidth(200);
                                view2.setFitHeight(200);
                                view2.setPreserveRatio(true);
                                lblCarta.setGraphic(view2);
                                lblNombreCarta.setText(arNombresCartas[aleatorios[c]]);
                                lblNombreCarta.widthProperty();
                            }
                            c++;
                            if (c == 54) { termino = true; Parar(); }
                        }
                    }
                );
            }
        });

        timer.start();
        timeTiempo.start();
    }

    public void Parar (){

        if (termino) {
            String resultado = "";
            timer.stop();
            timeTiempo.stop();
            if ( contadorMazoIgual == 9) {
                resultado = "LOTERIAA!!!!!!!! \nGanaste!!!!";
                playSound();
            }else {
                resultado = "Buen Intendo Suerte Para La Proxima.... :(";
                playSound();
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Resultado");
            alert.setHeaderText(null);
            alert.setContentText(resultado);
            alert.showAndWait();
        }
    }

    public void Comparar(int i, int j){
        int quitar = 0;
        if(empezar){
            switch (i){
                case 0:
                    switch (j){
                        case 0: quitar = 9; break;
                        case 1: quitar = 8; break;
                        case 2: quitar = 7; break;
                    } break;
                case 1:
                    switch (j){
                        case 0: quitar = 6; break;
                        case 1: quitar = 5; break;
                        case 2: quitar = 4; break;
                    }break;
                case 2:
                    switch (j){
                        case 0: quitar = 3; break;
                        case 1: quitar = 2; break;
                        case 2: quitar = 1; break;
                    }break;
            }
            File fileC = new File(
                    "src/main/java/com/example/topicos2022_proyecto/images/"+arImagenes[Ncarta-quitar]);
            arBtnCartas[j][i].setOnAction(event -> {

                if (file2.equals(fileC)) {
                    CambioDorso(i,j);
                    contadorMazoIgual++;
                    if (contadorMazoIgual == 9) {
                        termino = true;
                        Parar();
                    }
                }
            });
        }
    }

    public void CambioDorso (int i, int j){

        File fileDC = new File("src/main/java/com/example/topicos2022_proyecto/images/"+arImagenes[54]);
        imgCarta = new Image(fileDC.toURI().toString());
        ImageView view = new ImageView(imgCarta);
        view.setFitHeight(170);
        view.setFitWidth(150);
        view.setPreserveRatio(true);
        arBtnCartas [j][i].setGraphic(view);
    }

    public void playSound() {
        try {
            String archAudio = "";
            if (contadorMazoIgual == 9) archAudio = "src/main/java/com/example/topicos2022_proyecto/sounds/nike_to_victory.wav";
            else archAudio = "src/main/java/com/example/topicos2022_proyecto/sounds/tyr_still_not_funny.wav";
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(archAudio).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error");
            ex.printStackTrace();
        }
    }
}
