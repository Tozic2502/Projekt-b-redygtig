package org.example.projektbaedygtig;


import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.chart.LineChart;

public class Controller {

    @FXML
    private ChoiceBox<String> choiceBoxSite;
    @FXML
    private LineChart monthChart, yearChart, dayChart;

    @FXML
    public void initialize() {
        choiceBoxSite.setValue("Site");
        choiceBoxMonth.setValue("January");
        OnButtonClickReset();
        OnButtonClickReset();
    }

    @FXML
    private ChoiceBox<String> choiceBoxMonth;

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


            if (selectedMonth != null) {
                switch (selectedMonth) {
                    case "January":
                        monthChart.getData().clear();
                        monthChart.setVisible(true);
                        monthChart.getData().addAll();
                        break;
                    case "February":

                        break;
                    case "March":

                        break;
                    case "April":

                        break;
                    case "May":

                        break;
                    case "June":

                        break;
                    case "July":

                        break;
                    case "August":

                        break;
                    case "September":

                        break;
                    case "October":

                        break;
                    case "November":

                        break;
                    case "December":

                        break;

                }
            }

    }

}