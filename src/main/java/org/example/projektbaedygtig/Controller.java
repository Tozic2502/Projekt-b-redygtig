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

    @FXML
    private ChoiceBox<String> monthChoiceBox;

    @FXML
    public void initialize() {
        /**
         * Populate months
         */
        monthChoiceBox.getItems().addAll("January","February", "March","April", "May",
                "June", "July", "August", "September", "October", "November", "December" );

        /**
         *  A default value/month is set
         */
        monthChoiceBox.setValue("January");


        monthChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Selected Month" + newValue);
        });
    }


}