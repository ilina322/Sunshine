package com.example.sunshine.data.remote.model;

public class DayForecast {
    private float temperature;
    private float chanceOfRain;
    private long time;
    private String condition;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getChanceOfRain() {
        return chanceOfRain;
    }

    public void setChanceOfRain(float chanceOfRain) {
        this.chanceOfRain = chanceOfRain;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
