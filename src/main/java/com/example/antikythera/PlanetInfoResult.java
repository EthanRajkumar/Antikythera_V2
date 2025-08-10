package com.example.antikythera;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class PlanetInfoResult {
    private double[] results;

    public PlanetInfoResult(double[] values)
    {
        results = values;
    }

    public double getLongitudeAscension() {
        return results[0];
    }

    public double getInclination() {
        return results[1];
    }

    public double getArgumentPerihelion() {
        return results[2];
    }

    public double getSemimajorAxis() {
        return results[3];
    }

    public double getEccentricity() {
        return results[4];
    }

    public double getMeanAnomaly() {
        return results[5];
    }

    public double getEccentricAnomaly() {
        return results[6];
    }

    public double getHeliocentricDistance() {
        return results[7];
    }

    public double getTrueAnomaly() {
        return results[8];
    }

    public double getEclipticX() {
        return results[9];
    }

    public double getEclipticY() {
        return results[10];
    }

    public double getEclipticZ() {
        return results[11];
    }

    public double getLongitude() {
        return results[12];
    }

    public double getLattitude() {
        return results[13];
    }
}

