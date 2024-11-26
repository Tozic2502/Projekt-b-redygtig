package org.example.projektbaedygtig;


import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;
import javafx.scene.chart.LineChart;

public class Controller {

    @FXML
    private ChoiceBox<String> choiceBoxSite, choiceBoxMonth;
    @FXML
    private LineChart monthChart, yearChart, dayChart;

    /**
     * All the months is placed in the monthChoicebox.
     * The default value is set to January in the Choicebox.
     */
@FXML
private DatePicker datePicker;

    /**
     * Set values for the choiceboxes and datepicker when the program is initialized.
     */
@FXML
    public void initialize() {
        choiceBoxSite.setValue("Site");
        choiceBoxMonth.setValue("January");
        OnButtonClickReset();
        OnButtonClickReset();

        choiceBoxMonth.getItems().addAll("January","February", "March","April", "May",
                "June", "July", "August", "September", "October", "November", "December" );

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

    /**
     * When the button is click its reset so you don't need to close and reopen the program to reset it
     * the button works so if you click it, it makes the other chart invisible and makes it so you can see the
     * year chart again
     */
    @FXML
    protected void OnButtonClickReset() {

        monthChart.getData().clear();
        yearChart.getData();
        dayChart.getData().clear();
        if (monthChart.isVisible()) {
            monthChart.setVisible(false);

        } else if (dayChart.isVisible()) {
            dayChart.setVisible(false);

        } else if (!yearChart.isVisible()) {
            yearChart.setVisible(true);
        }

    }

    @FXML
    protected void OnButtonClickPick() {
        String selectedMonth = choiceBoxMonth.getValue();
        yearChart.setVisible(false);

            if (selectedMonth != null) {
                switch (selectedMonth) {
                    case "January":
                        monthChart.getData().clear();
                        monthChart.setVisible(true);
                        monthChart.getData();
                        break;
                    case "February":
                        monthChart.getData().clear();
                        monthChart.setVisible(true);
                        monthChart.getData();
                        break;
                    case "March":
                        monthChart.getData().clear();
                        monthChart.setVisible(true);
                        monthChart.getData();
                        break;
                    case "April":
                        monthChart.getData().clear();
                        monthChart.setVisible(true);
                        monthChart.getData();
                        break;
                    case "May":
                        monthChart.getData().clear();
                        monthChart.setVisible(true);
                        monthChart.getData();
                        break;
                    case "June":
                        monthChart.getData().clear();
                        monthChart.setVisible(true);
                        monthChart.getData();
                        break;
                    case "July":
                        monthChart.getData().clear();
                        monthChart.setVisible(true);
                        monthChart.getData();
                        break;
                    case "August":
                        monthChart.getData().clear();
                        monthChart.setVisible(true);
                        monthChart.getData();
                        break;
                    case "September":
                        monthChart.getData().clear();
                        monthChart.setVisible(true);
                        monthChart.getData();
                        break;
                    case "October":
                        monthChart.getData().clear();
                        monthChart.setVisible(true);
                        monthChart.getData();
                        break;
                    case "November":
                        monthChart.getData().clear();
                        monthChart.setVisible(true);
                        monthChart.getData();
                        break;
                    case "December":
                        monthChart.getData().clear();
                        monthChart.setVisible(true);
                        monthChart.getData();
                        break;

                }
            }

    }

}