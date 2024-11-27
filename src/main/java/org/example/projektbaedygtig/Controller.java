package org.example.projektbaedygtig;


import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;

public class Controller {

@FXML
private ChoiceBox<String> choiceBoxSite;

@FXML
private ChoiceBox<String> choiceBoxMonth;

@FXML
private DatePicker datePicker;

    /**
     * Set values for the choiceboxes and datepicker when the program is initialized.
     */
@FXML
    public void initialize() {
        choiceBoxSite.setValue("Site");
        choiceBoxMonth.setValue("January");
        setStartDate();

    }
    @FXML
    private void setStartDate(){
    LocalDate minDate = LocalDate.of(2022, 12, 15);
    LocalDate maxDate = LocalDate.of(2023, 2, 14);
    datePicker.setValue(minDate);
        // Customize the DateCell to enforce the allowed date range
        datePicker.setDayCellFactory(_ -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date != null) {
                    if (date.isBefore(minDate) || date.isAfter(maxDate)) {
                        datePicker.setDisable(true);
                    }
                    else{
                        setDisable(false);
                    }
                }
            }
        });

    }

    /**
     *
     */
   /* @FXML
public void getDataFromDay() {
    //linechart.getData().clear();
    String selectedDate = datePicker.getValue();

    if(selectedDate != null){
        
    }

}

    */



}