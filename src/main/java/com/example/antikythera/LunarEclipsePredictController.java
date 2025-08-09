package com.example.antikythera;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

public class LunarEclipsePredictController extends SceneController {

    @FXML
    TableView<LunarEclipse> eclipseView;

    @FXML
    Label predictionTime, predictionVisibility, predictionHeader, predictionHeader2;

    List<LunarEclipse> eclipses;

    @Override
    public void Initialize(Stage stage)
    {
        eclipseView.setEditable(true);
        TableColumn firstNameCol = new TableColumn("Saros");
        firstNameCol.setMinWidth(50);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<SolarEclipse, String>("Saros"));


        TableColumn secondNameCol = new TableColumn("Magnitude");
        secondNameCol.setMinWidth(75);
        secondNameCol.setCellValueFactory(new PropertyValueFactory<SolarEclipse, String>("Magnitude"));

        TableColumn thirdNameCol = new TableColumn("Date");
        thirdNameCol.setMinWidth(75);
        thirdNameCol.setCellValueFactory(new PropertyValueFactory<SolarEclipse, String>("Time"));


        EclipseFinder ef = new EclipseFinder();
        eclipses = ef.GetLunarEclipses();

        eclipseView.setItems(FXCollections.observableArrayList(eclipses));

        eclipseView.getColumns().add(firstNameCol);
        eclipseView.getColumns().add(secondNameCol);
        eclipseView.getColumns().add(thirdNameCol);

        predictionVisibility.setText("");
        predictionTime.setText("");
        predictionHeader.setText("Predict an eclipse to get started.");
        predictionHeader2.setText("");
    }

    @FXML
    protected void openEclipseSelect() {
        SceneSwapper.SwapScene("eclipse_select.fxml");
    }

    @FXML
    protected void openSolarEclipsePredictions() {
        SceneSwapper.SwapScene("solar_eclipse_prediction.fxml");
    }

    @FXML
    protected void openLunarEclipsePredictions() {
        SceneSwapper.SwapScene("solar_eclipse_prediction.fxml");
    }

    @FXML
    protected void predictSelected()
    {
        LunarEclipse eclipse = eclipseView.getSelectionModel().getSelectedItem();

        EclipseFinder ef = new EclipseFinder();
        LunarEclipse nearest = ef.PredictReoccuringLunar(eclipse);
        UniversalTime time = nearest.time;

        String hourString = (time.getHours() < 10 ? "0" : "") + time.getHours();
        String minuteString = (time.getMinutes() < 10 ? "0" : "") + time.getMinutes();
        String timeString = hourString + ":" + minuteString + " GMT";
        String dateString = time.getDays() + "/" + time.getMonth() + "/" + time.getYear();
        predictionTime.setText(dateString + " Universal Time\n" + timeString);
        predictionVisibility.setText(nearest.getVisibility());
        predictionHeader.setText("The next eclipse will occur on: ");
        predictionHeader2.setText("This eclipse will be visible from: ");
    }

    @FXML
    protected void predictNearest()
    {
        EclipseFinder ef = new EclipseFinder();
        LunarEclipse nearest = ef.PredictNextLunarEclipse(eclipses);
        UniversalTime time = nearest.time;

        String hourString = (time.getHours() < 10 ? "0" : "") + time.getHours();
        String minuteString = (time.getMinutes() < 10 ? "0" : "") + time.getMinutes();
        String timeString = hourString + ":" + minuteString + " GMT";
        String dateString = time.getDays() + "/" + time.getMonth() + "/" + time.getYear();
        predictionTime.setText(dateString + " Universal Time\n" + timeString);
        predictionVisibility.setText(nearest.getVisibility());
        predictionHeader.setText("The next eclipse will occur on: ");
        predictionHeader2.setText("This eclipse will be visible from: ");
    }
}
