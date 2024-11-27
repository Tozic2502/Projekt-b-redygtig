package org.example.projektbaedygtig;


import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class Controller {

    @FXML
    private ChoiceBox<String> ChoiceBoxMonth;

    @FXML
    public void initialize() {
        /**
         * Populate months
         */
        ChoiceBoxMonth.getItems().addAll("January","February", "March","April", "May",
                "June", "July", "August", "September", "October", "November", "December" );

        /**
         *  A default value/month is set
         */
        ChoiceBoxMonth.setValue("January");


        ChoiceBoxMonth.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Selected Month" + newValue);
        });
    }


}