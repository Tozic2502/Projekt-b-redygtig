package org.example.projektbaedygtig;


import javafx.event.ActionEvent;
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

        /**
         * Add a listener for month selection
         */
        ChoiceBoxMonth.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Selected Month" + newValue);
        });
    }

    public void OnButtonClickReset(ActionEvent actionEvent) {
    }
}