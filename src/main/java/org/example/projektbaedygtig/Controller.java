package org.example.projektbaedygtig;


import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

public class Controller {

@FXML
private ChoiceBox<String> choiceBoxSite;

@FXML
private ChoiceBox<String> choiceBoxMonth;

//Set values for the choiceboxes when the program is initialized.
@FXML
    public void initialize() {
        choiceBoxSite.setValue("Site");
        choiceBoxMonth.setValue("January");
    }

@FXML
public void getDataFromDay() {
    //linechart.getData().clear();
    String selectedDate = DatePicker.getValue();

    if(selectedDate != null){
        
    }

}

}