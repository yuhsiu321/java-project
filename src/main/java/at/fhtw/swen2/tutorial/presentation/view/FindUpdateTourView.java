package at.fhtw.swen2.tutorial.presentation.view;

import at.fhtw.swen2.tutorial.presentation.ViewManager;
import at.fhtw.swen2.tutorial.presentation.viewmodel.FindUpdateTourViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.UpdateTourViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
@Slf4j
public class FindUpdateTourView extends Dialog<Void> implements Initializable {

    @Autowired
    private FindUpdateTourViewModel findUpdateTourViewModel;

    @FXML
    public TextField nameTextField;
    @FXML
    public Button findUpdateButton;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       nameTextField.textProperty().bindBidirectional(findUpdateTourViewModel.FindUpdateNameProperty());
    }

    @Autowired
    private ViewManager viewManager;

    public void findUpdateButtonAction() throws IOException {

        if (findUpdateTourViewModel.findUpdate() != null) {
            Parent parent = viewManager.load("at/fhtw/swen2/tutorial/presentation/view/UpdateTour");
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        }

        //show tour detail

    }

}
