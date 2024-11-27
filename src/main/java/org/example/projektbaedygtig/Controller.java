package org.example.projektbaedygtig;


import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class Controller {

@FXML
private ChoiceBox<String> choiceBoxSite;

@FXML
private ChoiceBox<String> choiceBoxMonth;


@FXML
    public void initialize() {
        choiceBoxSite.setValue("Site");
        choiceBoxMonth.setValue("January");
    }
}