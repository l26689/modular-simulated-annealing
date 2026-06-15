package msa.components.basiccomponents;

import msa.core.CoolingSchedule;
import msa.examples.rosenbrock.ContinuousProblem;

public class BasicCoolingSchedule extends CoolingSchedule<double[],ContinuousProblem> {
    private double coolingRate;
    private int currentIteration;
    private int maxIterations;
    
    public BasicCoolingSchedule(double coolingRate, int maxIterations) {
        this.coolingRate = coolingRate;
        this.maxIterations = maxIterations;
        this.currentIteration = 0;
    }
    
    @Override
    public void init(ContinuousProblem problem) {
        // 初始化操作
    }
    
    @Override
    public double cool(double temperature, double[] x,boolean isAccepted) {
        currentIteration++;
        if(currentIteration > maxIterations) {
            currentIteration = 0;
            return temperature * coolingRate;
        }
        return temperature;
    }
}