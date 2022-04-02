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
    private String getTxt = "", cambiarTxt = "";
    private String imprimir = "", mostrar = "", imprimir2 = "";
    private String comp = "", aux = "";
    private int cont = 0;

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
        getTxt = txtEntrada.getText();
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
        System.out.println(caracter);
        CodigoMorse(caracter);
        txtSalida.setText(imprimir);
    }

    private void backspace(){

        char[] charComp = mostrar.toCharArray();
        mostrar = aux;
        imprimir = "";

        for (int i = 0; i < charComp.length - cont; i++){
            aux += charComp[i];
            comp = String.valueOf(charComp[i]);
            if (charComp[i] == '/') imprimir += "\n";
            if (charComp[i] == ' ') imprimir += "";
            CodigoMorse(comp);
        }

        mostrar = aux;
        aux = "";
        cont = 0;
    }

    private void CodigoMorse(String caracter){
        switch (caracter) {
            case " ":
            case "SPACE":
                imprimir += " "; mostrar += " ";
                break;
            case "BACK_SPACE": cont++; backspace();
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
            case "R": imprimir += ".-. "; mostrar += "R";
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
            case "0":
            case "DIGIT0": imprimir += "----- "; mostrar += "0";
                break;
            case "1":
            case "DIGIT1": imprimir += ".---- "; mostrar += "1";
                break;
            case "2":
            case "DIGIT2": imprimir += "..--- "; mostrar += "2";
                break;
            case "3":
            case "DIGIT3": imprimir += "...-- "; mostrar += "3";
                break;
            case "4":
            case "DIGIT4": imprimir += "....- "; mostrar += "4";
                break;
            case "5":
            case "DIGIT5": imprimir += "..... "; mostrar += "5";
                break;
            case "6":
            case "DIGIT6": imprimir += "-.... "; mostrar += "6";
                break;
            case "7":
            case "DIGIT7": imprimir += "--... "; mostrar += "7";
                break;
            case "8":
            case "DIGIT8": imprimir += "---.. "; mostrar += "8";
                break;
            case "9":
            case "DIGIT9": imprimir += "----. "; mostrar += "9";
                break;
            case ".":
            case "PERIOD": imprimir += ".-.-.- "; mostrar += ".";
                break;
            case ",":
            case "COMMA": imprimir += "--..-- "; mostrar += ",";
                break;
            case "'":
            case "QUOTE": imprimir += ".----. "; mostrar += "'";
                break;
            case "-":
            case "MINUS": imprimir += "-....- "; mostrar += "-";
                break;
            case "DIVIDE": imprimir += "-..-. ";
                break;
            case "{":
            case "BRACELEFT": imprimir += "-.--. "; mostrar += "{";
                break;
            case "}":
            case "BRACERIGHT": imprimir += "-.--.- "; mostrar += "}";
                break;
            case "+":
            case "PLUS": imprimir += ".-.-. "; mostrar += "+";
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