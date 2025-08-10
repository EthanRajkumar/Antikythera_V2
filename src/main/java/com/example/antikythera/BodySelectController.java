package com.example.antikythera;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class BodySelectController extends SceneController {

    @FXML
    protected void openTitleScene() {
        SceneSwapper.SwapScene("main_menu.fxml");
    }

    @FXML
    protected void openSunPrediction() {
        Session.PlanetView = "sun";
        SceneSwapper.SwapScene("time_select.fxml");
    }

    @FXML
    protected void openMoonPrediction() {
        Session.PlanetView = "moon";
        SceneSwapper.SwapScene("time_select.fxml");
    }

    @FXML
    protected void openMercuryPrediction() {
        Session.PlanetView = "mercury";
        SceneSwapper.SwapScene("time_select.fxml");
    }

    @FXML
    protected void openVenusPrediction() {
        Session.PlanetView = "venus";
        SceneSwapper.SwapScene("time_select.fxml");
    }

    @FXML
    protected void openMarsPrediction() {
        Session.PlanetView = "mars";
        SceneSwapper.SwapScene("time_select.fxml");
    }

    @FXML
    protected void openJupiterPrediction() {
        Session.PlanetView = "jupiter";
        SceneSwapper.SwapScene("time_select.fxml");
    }

    @FXML
    protected void openSaturnPrediction() {
        Session.PlanetView = "saturn";
        SceneSwapper.SwapScene("time_select.fxml");
    }

    @FXML
    protected void openUranusPrediction() {
        Session.PlanetView = "uranus";
        SceneSwapper.SwapScene("time_select.fxml");
    }

    @FXML
    protected void openNeptunePrediction() {
        Session.PlanetView = "neptune";
        SceneSwapper.SwapScene("time_select.fxml");
    }
}
