package com.example.antikythera;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class TimeSelectController extends SceneController {

    @FXML
    protected DatePicker datePicker;

    @FXML
    protected ChoiceBox<String> timeZoneSelect;

    @Override
    public void Initialize(Stage stage) {
        List<String> choices = List.of(
                "GMT-14:00", "GMT-13:00", "GMT-12:00", "GMT-11:00", "GMT-10:00", "GMT-09:00", "GMT-08:00", "GMT-07:00",
                "GMT-06:00", "GMT-05:00", "GMT-04:00", "GMT-03:00", "GMT-02:00", "GMT-01:00", "GMT", "GMT+01:00",
                "GMT+02:00", "GMT+03:00", "GMT+04:00", "GMT+05:00", "GMT+06:00", "GMT+07:00", "GMT+08:00", "GMT+09:00",
                "GMT+10:00", "GMT+11:00", "GMT+12:00", "GMT+13:00", "GMT+14:00"
        );

        timeZoneSelect.setItems(FXCollections.observableList(choices));
    }

    @FXML
    protected void openBodyPrediction() {
        Session.ZonedDateTime = ZonedDateTime.of(datePicker.getValue(), LocalTime.now(), ZoneId.of(timeZoneSelect.getValue()));
        SceneSwapper.SwapScene("body_prediction.fxml");
    }
}
