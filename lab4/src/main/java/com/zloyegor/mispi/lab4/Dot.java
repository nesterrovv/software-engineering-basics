package com.zloyegor.mispi.lab4;

public class Dot {
    private final double x;
    private final double y;
    private final double r;
    private final String executionTime;
    private final String localTime;
    private final boolean result;

    public Dot(double x, double y, double r,
               String executionTime, String localTime, boolean result) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.executionTime = executionTime;
        this.localTime = localTime;
        this.result = result;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public String getLocalTime() {
        return localTime;
    }

    public boolean isResult() {
        return result;
    }
}
