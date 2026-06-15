package msa.components.basiccomponents;

import msa.problem.OptimizationProblem;
import msa.problem.Solution;
import msa.core.TerminationCondition;

public class BasicTerminationCondition extends TerminationCondition {
    private int maxIterations;
    private int currentIteration;
    
    public BasicTerminationCondition(int maxIterations) {
        this.maxIterations = maxIterations;
        this.currentIteration = 0;
    }
    
    @Override
    public void init(OptimizationProblem problem) {
    }
    
    @Override
    public boolean check(double temperature, Solution s,boolean isAccepted) {
        currentIteration++;
        return currentIteration > maxIterations;
    }
}