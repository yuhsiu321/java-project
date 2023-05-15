package at.fhtw.swen2.tutorial.presentation.view;

import at.fhtw.swen2.tutorial.presentation.ViewManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
@Slf4j
public class ControlView implements Initializable {
    @FXML
    public Button deleteButton;
    @FXML
    public Button moreButton;
    @FXML
    private Button createButton;



    @Autowired
    private ViewManager viewManager;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createButton.setOnAction(event -> {
            try {
                handleNewTour();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        deleteButton.setOnAction(event -> {
            try {
                handleDelete();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        moreButton.setOnAction(event -> {
            try {
                handleUpdate();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void handleNewTour() throws IOException {
        Parent parent = viewManager.load("at/fhtw/swen2/tutorial/presentation/view/CreateTour");
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    private void handleDelete() throws IOException{
        Parent parent = viewManager.load("at/fhtw/swen2/tutorial/presentation/view/DeleteTour");
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }
    private void handleUpdate() throws IOException{
        Parent parent = viewManager.load("at/fhtw/swen2/tutorial/presentation/view/FindUpdateTour");
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }
}
