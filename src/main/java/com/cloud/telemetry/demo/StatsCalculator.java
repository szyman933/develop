package com.cloud.telemetry.demo;
import java.io.Serializable;

public class StatsCalculator implements Serializable {

    private double freeRAM;
    private double maxRAM;

    private int numCores;

    public StatsCalculator() {
        calculateStats();
    }

    public void calculateStats() {
        numCores = Runtime.getRuntime().availableProcessors();
        freeRAM = Runtime.getRuntime().freeMemory();
        maxRAM = Runtime.getRuntime().maxMemory();

    }

    public double getFreeRAM() {
        return freeRAM;
    }

    public double getMaxRAM() {
        return maxRAM;
    }


    public int getNumCores() {
        return numCores;
    }



    public void printStats() {
        System.out.println("---------------------");

        System.out.println("NumCores: " + numCores);
        System.out.println("FreeRAM: " + freeRAM);
        System.out.println("Used RAM: " + (maxRAM-freeRAM));

        System.out.println("---------------------");
    }
}