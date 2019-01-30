package com.cloud.telemetry.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.logging.Level;
import java.util.logging.Logger;

@Slf4j
class StatsCalculator {


    private double freeRAM;
    private double maxRAM;
    private double mega = 1048576;
    private int numCores;

    public StatsCalculator() {
        calculateStats();
    }

    void calculateStats() {
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
        log.info("---------------------");
        log.info("NumCores: {} ", numCores);
        log.info("FreeRAM: {}", freeRAM / mega);
        log.info("Used RAM:  {}", ((maxRAM - freeRAM) / mega));
        log.info( "---------------------");
    }

    double getMega() {
        return mega;
    }
}