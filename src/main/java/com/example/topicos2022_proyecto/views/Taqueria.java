package com.example.topicos2022_proyecto.views;

import com.example.topicos2022_proyecto.components.CellCustome;
import com.example.topicos2022_proyecto.models.ClientesDAO;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Taqueria extends Stage {
    private Scene escena;
    private VBox vBox;
    private TableView<ClientesDAO> tbvClientes;
    private Button btnNuevo;
    private ClientesDAO cteDAO;

    public Taqueria() {

        CrearUI();
        this.setTitle("Taqueria Clienetes");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        tbvClientes = new TableView<>();
        btnNuevo = new Button("Nuevo Cliente");
        cteDAO = new ClientesDAO();
        btnNuevo.setOnAction(event -> {
            //new TaqueriaForm(tbvClientes, null);
        });

        vBox = new VBox();
        vBox.setSpacing(10.0);
        vBox.setPadding(new Insets(10.0));
        vBox.getChildren().addAll(tbvClientes,btnNuevo);
        escena = new Scene(vBox,560,300);
        CrearTabla();
    }

    private void CrearTabla() {
        TableColumn<ClientesDAO,Integer> tbcIdCliente = new TableColumn<>("ID");
        tbcIdCliente.setCellValueFactory(new PropertyValueFactory<>("cvecte"));

        TableColumn<ClientesDAO,String> tbcNomCliente = new TableColumn<>("NOMBRE");
        tbcNomCliente.setCellValueFactory(new PropertyValueFactory<>("nomcte"));

        TableColumn<ClientesDAO,String> tbctelcte = new TableColumn<>("TELEFONO");
        tbctelcte.setCellValueFactory(new PropertyValueFactory<>("telcte"));

        TableColumn<ClientesDAO,String> tbcdircte = new TableColumn<>("DIRECCION");
        tbcdircte.setCellValueFactory(new PropertyValueFactory<>("dircte"));

        tbvClientes.getColumns().addAll(tbcIdCliente,tbcNomCliente,tbctelcte,tbcdircte);
        tbvClientes.setItems(cteDAO.SELECCIONAR());
    }
}