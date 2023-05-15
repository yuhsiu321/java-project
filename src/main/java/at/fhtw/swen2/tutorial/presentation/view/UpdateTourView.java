package at.fhtw.swen2.tutorial.presentation.view;

import at.fhtw.swen2.tutorial.presentation.viewmodel.UpdateTourViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
@Slf4j
public class UpdateTourView extends Dialog<Void> implements Initializable {
    @Autowired
    private UpdateTourViewModel updateTourViewModel;

    @FXML
    public TextField nameTextField;
    @FXML
    public Button updateButton;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTextField.textProperty().bindBidirectional(updateTourViewModel.UpdateNameProperty());
    }

    public void updateButtonAction() {
        //update tour detail
        //updateTourViewModel.update();


    }
}
