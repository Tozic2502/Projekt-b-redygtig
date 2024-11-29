package org.example.projektbaedygtig;

import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.chart.LineChart;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    @FXML
    private ChoiceBox<String> choiceBoxSite, choiceBoxMonth;
    @FXML
    private LineChart<Number, Number> monthChart, yearChart, dayChart;
    @FXML
    private DatePicker datePicker;

    private static ArrayList<ArrayList<String>> array = HelloController.getData();

    /**
     * Initializing method, where the site numbers are connected to the choicebox so the user can choose a site.
     * Sets at a startprompt to the choiceboxes and a buttons, so the user knows they do.
     * Gets the choices for the month choicebox.
     */
    @FXML
    public void initialize() {
        int[] uniqueSites = {
                16019, 16009, 16010, 57117, 54392, 54403, 54449, 16020, 16023, 16021, 16024,
                16015, 16011, 16014, 88062, 54280, 16025, 16016, 16012, 87887, 16013, 22229,
                298, 87891, 15523, 54286, 57124, 57115, 57116, 54405, 84673, 57126, 82445,
                54282, 54378, 54290, 54394, 54401, 2506, 54396, 54390, 54292, 54411, 54384,
                54288, 57119, 57122, 54284, 54407, 54399, 22224, 60127, 60129, 41460, 16017,
                16022, 16008, 54388, 57123, 54409, 54374, 54386, 60131, 16018, 57120, 84671,
                54376, 88262, 88990, 92029, 54294
        };

        for (int site : uniqueSites) {
            choiceBoxSite.getItems().add(String.valueOf(site));
        }
        choiceBoxSite.setValue("Site");
        choiceBoxMonth.getItems().addAll("January", "February", "December");
        choiceBoxMonth.setValue("January");

        OnButtonClickReset();
        setStartDate();
    }

    @FXML
    private void setStartDate() {
        LocalDate minDate = LocalDate.of(2022, 12, 15);
        LocalDate maxDate = LocalDate.of(2023, 2, 14);
        //datePicker.setValue(minDate);
        datePicker.setDayCellFactory(e -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date != null && (date.isBefore(minDate) || date.isAfter(maxDate))) {
                    setDisable(true);
                }
            }
        });
    }

    @FXML
    protected void OnButtonClickReset() {
        monthChart.getData().clear();
        yearChart.getData().clear();
        dayChart.getData().clear();

        monthChart.setVisible(false);
        dayChart.setVisible(false);
        yearChart.setVisible(true);
    }

    public int getDaykWh(ArrayList<ArrayList<String>> array, String date, int site) {
        int kWh = 0;
        for (ArrayList<String> entry : array) {
            if (entry.get(1).contains(date) && (site == -1 || entry.get(2).equals(String.valueOf(site)))) {
                kWh += Integer.parseInt(entry.get(4));
            }
        }
        return kWh;
    }

    public ArrayList<Integer> getAllDays(ArrayList<ArrayList<String>> array, String month, int site) {
        ArrayList<Integer> data = new ArrayList<>();
        String monthNumber = getNumberFromMonth(month);

        for (int day = 1; day <= 31; day++) {
            String date = String.format("-%s-%02d", monthNumber, day);
            data.add(getDaykWh(array, date, site));
        }
        return data;
    }

    public String getNumberFromMonth(String month) {
        return switch (month) {
            case "January" -> "01";
            case "February" -> "02";
            case "December" -> "12";
            default -> "01"; // Default to January if invalid
        };
    }


    @FXML
    public void showGraph() {

        // Get the selected month and site from the UI
        String selectedMonth = choiceBoxMonth.getValue();
        String selectedSite = choiceBoxSite.getValue();
        // Validate the site selection
        int siteId;
        try {
            siteId = Integer.parseInt(selectedSite);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid site selected: " + selectedSite, e);
        }

        // Generate data for the selected month and site
        ArrayList<Integer> data = getAllDays(array, selectedMonth, siteId);

        // Clear existing data from the monthChart
        monthChart.getData().clear();
        dayChart.getData().clear();
        yearChart.getData().clear();

        NumberAxis xAxis = (NumberAxis) monthChart.getXAxis();
        NumberAxis yAxis = (NumberAxis) monthChart.getYAxis();
        xAxis.setAutoRanging(true);
        xAxis.setLowerBound(1);
        xAxis.setUpperBound(data.size());
        xAxis.setTickUnit(1);

        yAxis.setAutoRanging(true);



        // Create a new data series
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
            series.getData().add(new XYChart.Data<>(i + 1, data.get(i)));
        }

        // Set series name and add to the chart
        series.setName("Data for " + selectedMonth + " (Site: " + selectedSite + ")");
        monthChart.getData().add(series);
        monthChart.applyCss();
        monthChart.layout();
        System.out.println("Lower Bound: " + yAxis.getLowerBound());
        System.out.println("Upper Bound: " + yAxis.getUpperBound());

        System.out.println("Lower Bound: " + xAxis.getLowerBound());
        System.out.println("Upper Bound: " + xAxis.getUpperBound());
        // Make the monthChart visible
        monthChart.setVisible(true);
        dayChart.setVisible(false);
        yearChart.setVisible(false);
    }

    @FXML
    protected void OnButtonClickPick() {
        String selectedMonth = choiceBoxMonth.getValue();
        yearChart.setVisible(false);
        showGraph(); // Show data on monthChart

        // Handle visibility based on whether a specific date is picked
        if (datePicker.getValue() != null) {
            dayChart.setVisible(false);
            monthChart.setVisible(true);
        } else {
            monthChart.setVisible(true);
            dayChart.setVisible(false);
        }
    }

}