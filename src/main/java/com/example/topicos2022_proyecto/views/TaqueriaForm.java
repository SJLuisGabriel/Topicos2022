package com.example.topicos2022_proyecto.views;

import com.example.topicos2022_proyecto.models.ClientesDAO;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaqueriaForm extends Stage {

    private Scene escena;
    private VBox vBox;
    private TextField txtNombre, txttelefono, txtdireccion;
    private Button btnGuardar;
    private ClientesDAO objPDAO;
    private TableView<ClientesDAO> tbvProductos;

    public TaqueriaForm(TableView<ClientesDAO> tbvProductos, ClientesDAO objPDAO){
        this.tbvProductos = tbvProductos;
        if( objPDAO != null )
            this.objPDAO = objPDAO;             // La acción es una actualización
        else
            this.objPDAO = new ClientesDAO();  // La acción es una inserción
        CrearUI();
        this.setTitle("Gestion De Producto");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {

        txtNombre = new TextField();
        txtNombre.setPromptText("Nombre Del Cliente");
        txtNombre.setText(objPDAO.getNomcte());

        txttelefono = new TextField();
        txttelefono.setPromptText("Telefono Del Cliente");
        txttelefono.setText(objPDAO.getTelcte());

        txtdireccion = new TextField();
        txtdireccion.setPromptText("Direccion Del Cliente");
        txtdireccion.setText(objPDAO.getDircte());

        btnGuardar = new Button("Guardar");

        btnGuardar.setOnAction(event -> {
            objPDAO.setNomcte(txtNombre.getText());
            objPDAO.setTelcte(txttelefono.getText());
            objPDAO.setDircte(txtdireccion.getText());

            if( objPDAO.getCvecte() > 0 )
                objPDAO.ACTUALIZAR();
            else
                objPDAO.INSERTAR();

            tbvProductos.setItems(objPDAO.SELECCIONAR());
            tbvProductos.refresh();

            this.close();
        });

        vBox = new VBox();
        vBox.setSpacing(10.0);
        vBox.setPadding(new Insets(10.0));
        vBox.getChildren().addAll(txtNombre,txttelefono,txtdireccion,btnGuardar);
        escena = new Scene(vBox,300 ,250);
    }
}

