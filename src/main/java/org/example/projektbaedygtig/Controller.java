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


@FXML
    public void initialize() {
        choiceBoxSite.setValue("Site");
        choiceBoxMonth.setValue("January");
    }

@FXML
public void getDataFromDay() {
    //linechart.getData().clear();
    selectedDate = DatePicker.getValue();

    if(selectedDate != null);

}

}