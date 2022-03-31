package com.example.topicos2022_proyecto.views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

import java.io.File;
import java.io.FileInputStream;

public class Parseador extends Stage implements EventHandler <KeyEvent>{

    private Scene escena;
    private File file, fileA;
    private Image imgOpcion;
    private Button btnAbrir,btnConvertir;
    private VBox vBox;
    private ToolBar tlbMenu;
    private TextArea txtEntrada,txtSalida;
    private FileChooser flcArchivo;
    private String documento = "";
    private String getTxt = "";
    private String imprimir = "", mostrar = "", imprimirbe = "";
    private String comp = "";

    public Parseador(){
        CrearUI();
        this.setTitle("");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        btnAbrir = new Button();
        btnConvertir = new Button("Convertir");
        vBox = new VBox();
        tlbMenu = new ToolBar();
        txtEntrada = new TextArea();
        txtSalida = new TextArea();
        txtEntrada.setPromptText("Introduce El Texto A Parsear");

        file = new File("src/main/java/com/example/topicos2022_proyecto/images2/open_icon.png");
        imgOpcion = new Image(file.toURI().toString());
        ImageView view = new ImageView(imgOpcion);

        txtSalida.setFont(Font.font("Euphorigenic", 25));
        view.setFitHeight(24);
        view.setFitWidth(24);

        btnAbrir.setOnAction(event -> {
            flcArchivo = new FileChooser();
            flcArchivo.setTitle("Buscar Archivo...");
            flcArchivo.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT","*.txt"));
            fileA = flcArchivo.showOpenDialog(this);
            if (fileA != null) {
                AbrirAr(fileA);
            }
        });

        txtEntrada.setOnKeyPressed(this);
        //txtEntrada.setOnKeyReleased(this);
        //txtEntrada.setOnKeyTyped(this);

        btnConvertir.setOnAction(event -> {
            getTxt = txtEntrada.getText();
            Morse();
        });

        btnAbrir.setGraphic(view);
        tlbMenu.getItems().addAll(btnAbrir);
        vBox.getChildren().addAll(tlbMenu,txtEntrada,txtSalida,btnConvertir);

        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10));
        txtSalida.setEditable(false);

        escena = new Scene(vBox,730,500);
    }

    private void Morse() {
        char[] aCaracteres = getTxt.toCharArray();
        imprimir = "";

        for (int i = 0; i < aCaracteres.length; i++){
            comp = String.valueOf(aCaracteres[i]).toUpperCase();
            CodigoMorse(comp);
        }
        txtSalida.setText(imprimir);
    }

    @Override
    public void handle(KeyEvent event) {
        String caracter = event.getCode().toString();
        //System.out.println(caracter);
        CodigoMorse(caracter);
        txtSalida.setText(imprimir);
    }

    private void backspace(){
        getTxt = txtEntrada.getText().toUpperCase();
        imprimir = "";

        char[] caracters = getTxt.toCharArray();

        for (int i = 0; i < caracters.length; i++){
            comp = String.valueOf(caracters[i]);
            CodigoMorse(comp);
        }
    }

    public void enter(){
        getTxt = txtSalida.getText();
        char []caracterchar = mostrar.toCharArray();
        for (int i = 0; i < caracterchar.length ; i++){
            if (caracterchar[i] == '/'){
                imprimirbe += "\n";
            }

            imprimirbe += caracterchar[i];
        }
    }

    private void CodigoMorse(String caracter){
        switch (caracter) {
            case "SPACE": imprimir += "  ";
                break;
            case "BACK_SPACE": enter();
                break;
            case "ENTER": mostrar += "/"; imprimir += "\n";
                break;
            case "A": imprimir += ".- "; mostrar += "A";
                break;
            case "B": imprimir += "-... "; mostrar += "B";
                break;
            case "C": imprimir += "-.-. "; mostrar += "C";
                break;
            case "D": imprimir += "-.. "; mostrar += "D";
                break;
            case "E": imprimir += ". "; mostrar += "E";
                break;
            case "F": imprimir += "..-. "; mostrar += "F";
                break;
            case "G": imprimir += "--. "; mostrar += "G";
                break;
            case "H": imprimir += ".... "; mostrar += "H";
                break;
            case "I": imprimir += ".. "; mostrar += "I";
                break;
            case "J": imprimir += ".--- "; mostrar += "J";
                break;
            case "K": imprimir += "-.- "; mostrar += "K";
                break;
            case "L": imprimir += ".-.. "; mostrar += "L";
                break;
            case "M": imprimir += "-- "; mostrar += "M";
                break;
            case "N": imprimir += "-. "; mostrar += "N";
                break;
            case "O": imprimir += "--- "; mostrar += "O";
                break;
            case "P": imprimir += ".--. "; mostrar += "P";
                break;
            case "Q": imprimir += "--.- "; mostrar += "Q";
                break;
            case "R": imprimir += ".-. "; mostrar += "Q";
                break;
            case "S": imprimir += "... "; mostrar += "S";
                break;
            case "T": imprimir += "- "; mostrar += "T";
                break;
            case "U": imprimir += "..- "; mostrar += "U";
                break;
            case "V": imprimir += "...- "; mostrar += "V";
                break;
            case "W": imprimir += ".-- "; mostrar += "W";
                break;
            case "X": imprimir += "-..- "; mostrar += "X";
                break;
            case "Y": imprimir += "-.-- "; mostrar += "Y";
                break;
            case "Z": imprimir += "--.. "; mostrar += "Z";
                break;
            case "DIGIT0": imprimir += "----- "; mostrar += "DIGIT0";
                break;
            case "DIGIT1": imprimir += ".---- "; mostrar += "DIGIT1";
                break;
            case "DIGIT2": imprimir += "..--- "; mostrar += "DIGIT2";
                break;
            case "DIGIT3": imprimir += "...-- "; mostrar += "DIGIT3";
                break;
            case "DIGIT4": imprimir += "....- "; mostrar += "DIGIT4";
                break;
            case "DIGIT5": imprimir += "..... "; mostrar += "DIGIT5";
                break;
            case "DIGIT6": imprimir += "-.... "; mostrar += "DIGIT6";
                break;
            case "DIGIT7": imprimir += "--... "; mostrar += "DIGIT7";
                break;
            case "DIGIT8": imprimir += "---.. "; mostrar += "DIGIT8";
                break;
            case "DIGIT9": imprimir += "----. "; mostrar += "DIGIT9";
                break;
            case "PERIOD": imprimir += ".-.-.- ";
                break;
            case "COMMA": imprimir += "--..-- ";
                break;
            case "QUOTE": imprimir += ".----. ";
                break;
            case "MINUS": imprimir += "-....- ";
                break;
            case "DIVIDE": imprimir += "-..-. ";
                break;
            case "BRACELEFT": imprimir += "-.--. ";
                break;
            case "BRACERIGHT": imprimir += "-.--.- ";
                break;
            case "PLUS": imprimir += ".-.-. ";
                break;
            default:
                break;
        }
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
        documento = "";
    }
}