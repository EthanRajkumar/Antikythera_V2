package com.example.antikythera;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class PlanetInfoResult {
    public double f;                   // Julian date
    public LocalDateTime inputDateTime;
    public ZoneId zoneId;
    public LocalDateTime utcDateTime;

    public PlanetInfoResult(double f, LocalDateTime inputDateTime,
                            ZoneId zoneId, LocalDateTime utcDateTime) {
        this.f = f;
        this.inputDateTime = inputDateTime;
        this.zoneId = zoneId;
        this.utcDateTime = utcDateTime;
    }
}

