package msa.components.basiccomponents;

import msa.problem.OptimizationProblem;
import msa.problem.Solution;
import msa.core.CoolingSchedule;

public class BasicCoolingSchedule extends CoolingSchedule {
    private double coolingRate;
    private int currentIteration;
    private int maxIterations;
    
    public BasicCoolingSchedule(double coolingRate, int maxIterations) {
        this.coolingRate = coolingRate;
        this.maxIterations = maxIterations;
        this.currentIteration = 0;
    }
    
    @Override
    public void init(OptimizationProblem problem) {
        // 初始化操作
    }
    
    @Override
    public double cool(double temperature, Solution s) {
        currentIteration++;
        if(currentIteration > maxIterations) {
            currentIteration = 0;
            return temperature * coolingRate;
        }
        return temperature;
    }
}