package org.example.projektbaedygtig;


import javafx.fxml.FXML;
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

    /**
     * Method that limits the dates you can choose from and set the initial date to minDate.
     * To avoid unnecessary problems if choosing a date outside the date limits.
     */
    @FXML
    private void setStartDate(){
    LocalDate minDate = LocalDate.of(2022, 12, 15);
    LocalDate maxDate = LocalDate.of(2023, 2, 14);
    datePicker.setValue(minDate);
        datePicker.setDayCellFactory(_ -> new DateCell() {
    @Override
    public void updateItem(LocalDate date, boolean empty) {
        super.updateItem(date, empty);
            if (date != null) {
                if (date.isBefore(minDate) || date.isAfter(maxDate)) {
                    setDisable(true);
                    }
                }
            }
        });

    }
}