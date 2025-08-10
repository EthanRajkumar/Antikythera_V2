package com.example.antikythera;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class BodyPredictController extends SceneController {

    @FXML
    protected Label titleLabel, ascensionLongitude, inclination, argumentPerihelion, semimajorAxis, eccentricity, meanAnomaly, eccentricAnomaly, heliocentricDistance, trueAnomaly, eclipticCoordinates, longitude, lattitude;

    @FXML
    protected void openBodySelect() {
        SceneSwapper.SwapScene("body_select.fxml");
    }

    @Override
    public void Initialize(Stage stage) {
        UniversalTime ut = new UniversalTime(Session.ZonedDateTime);
        double d = UtilMath.d(ut.getYear(), ut.getMonth(), ut.getDays(), ut.getHours(), ut.getMinutes(), ut.getSeconds(), ZoneId.of("GMT"));

        String baseText = titleLabel.getText();
        String dateText = Session.ZonedDateTime.toLocalDate().toString();

        PlanetInfoResult info = null;

        switch (Session.PlanetView)
        {
            case "sun":
            {
                baseText = baseText.replace("[BODY]", "the Sun").replace("[DATE]", dateText);
                info = Planets.Sun(d);
                break;
            }

            case "moon":
            {
                baseText = baseText.replace("[BODY]", "the Moon").replace("[DATE]", dateText);
                info = Planets.Moon(d);
                break;
            }

            case "mercury":
            {
                baseText = baseText.replace("[BODY]", "Mercury").replace("[DATE]", dateText);
                info = Planets.Mercury(d);
                break;
            }

            case "venus":
            {
                baseText = baseText.replace("[BODY]", "Venus").replace("[DATE]", dateText);
                info = Planets.Venus(d);
                break;
            }

            case "mars":
            {
                baseText = baseText.replace("[BODY]", "Mars").replace("[DATE]", dateText);
                info = Planets.Mars(d);
                break;
            }

            case "jupiter":
            {
                baseText = baseText.replace("[BODY]", "Jupiter").replace("[DATE]", dateText);
                info = Planets.Jupiter(d);
                break;
            }

            case "saturn":
            {
                baseText = baseText.replace("[BODY]", "Saturn").replace("[DATE]", dateText);
                info = Planets.Saturn(d);
                break;
            }

            case "neptune": {
                baseText = baseText.replace("[BODY]", "Neptune").replace("[DATE]", dateText);
                info = Planets.Neptune(d);
                break;
            }

            case "uranus": {
                baseText = baseText.replace("[BODY]", "Uranus").replace("[DATE]", dateText);
                info = Planets.Uranus(d);
                break;
            }
        }

        ascensionLongitude.setText("" + info.getLongitudeAscension());
        inclination.setText("" + info.getInclination());
        argumentPerihelion.setText("" + info.getArgumentPerihelion());
        semimajorAxis.setText("" + info.getSemimajorAxis());
        eccentricity.setText("" + info.getEccentricity());
        heliocentricDistance.setText("" + info.getHeliocentricDistance());
        trueAnomaly.setText("" + info.getTrueAnomaly());
        longitude.setText("" + info.getLongitude());
        lattitude.setText("" + info.getLattitude());

        if (Session.PlanetView != "sun")
        {
            meanAnomaly.setText("" + info.getMeanAnomaly());
            eccentricAnomaly.setText("" + info.getEccentricAnomaly());
            eclipticCoordinates.setText("(" + (int)info.getEclipticX() + ", " + (int)info.getEclipticY() + ", " + (int)info.getEclipticZ() + ")");
        }

        titleLabel.setText(baseText);
    }
}