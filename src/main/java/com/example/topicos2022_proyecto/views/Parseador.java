package com.example.topicos2022_proyecto.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class Parseador extends Stage {

    private Scene escena;
    private File file, fileA;
    private Image imgOpcion;
    private Button btnAbrir;
    private VBox vBox;
    private ToolBar tlbMenu;
    private TextArea txtEntrada,txtSalida;
    private FileChooser flcArchivo;
    private String documento = "";

    public Parseador(){

        CrearUI();
        this.setTitle("");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        btnAbrir = new Button();
        vBox = new VBox();
        tlbMenu = new ToolBar();
        txtEntrada = new TextArea();
        txtSalida = new TextArea();
        txtEntrada.setPromptText("Introduce El Texto A Parsear");

        file = new File("src/main/java/com/example/topicos2022_proyecto/images2/open_icon.png");
        imgOpcion = new Image(file.toURI().toString());
        ImageView view = new ImageView(imgOpcion);

        view.setFitHeight(24);
        view.setFitWidth(24);

        btnAbrir.setOnAction(event -> {
            flcArchivo = new FileChooser();
            flcArchivo.setTitle("Buscar Archivo...");
            flcArchivo.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT","*.txt"));
            fileA = flcArchivo.showOpenDialog(this);
            if (fileA != null)
                AbrirAr(fileA);
        });

        btnAbrir.setGraphic(view);
        tlbMenu.getItems().addAll(btnAbrir);
        vBox.getChildren().addAll(tlbMenu,txtEntrada,txtSalida);

        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10));
        txtSalida.setEditable(false);

        escena = new Scene(vBox,730,500);
    }


    public void AbrirAr (File archivo){
        try{
            FileInputStream entrada = new FileInputStream(archivo);
            int asci;

            while ((asci = entrada.read()) != -1){
                char caracter = (char) asci;
                documento += caracter;
            }
        }catch (Exception e){e.getMessage();}

        txtEntrada.setText(documento);
    }
}
