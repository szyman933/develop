package com.cloud.telemetry.demo;
import java.util.logging.Level;
import java.util.logging.Logger;

class StatsCalculator {

    protected final Logger logger = Logger.getLogger(getClass().getName());

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
        logger.log(Level.INFO,"---------------------");
        logger.log(Level.INFO,"NumCores: {0} " , numCores);
        logger.log(Level.INFO,"FreeRAM: {0}" , freeRAM);
        logger.log(Level.INFO,"Used RAM: {0} " , (maxRAM-freeRAM));
        logger.log(Level.INFO,"---------------------");
    }
}