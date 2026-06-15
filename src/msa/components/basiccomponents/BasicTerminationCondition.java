package msa.components.basiccomponents;

import msa.core.TerminationCondition;
import msa.examples.rosenbrock.ContinuousProblem;
import msa.examples.rosenbrock.ContinuousSolution;

public class BasicTerminationCondition extends TerminationCondition<double[],ContinuousProblem,ContinuousSolution>{
    private int maxIterations;
    private int currentIteration;
    
    public BasicTerminationCondition(int maxIterations) {
        this.maxIterations = maxIterations;
        this.currentIteration = 0;
    }
    
    @Override
    public void init(ContinuousProblem problem) {
    }
    
    @Override
    public boolean check(double temperature, ContinuousSolution s,boolean isAccepted) {
        currentIteration++;
        return currentIteration > maxIterations;
    }
}