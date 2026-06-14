package msa.core;

import msa.problem.OptimizationProblem;
import msa.problem.Solution;

public abstract class Initializer {
    
    protected abstract void init(OptimizationProblem problem);
    
    protected abstract Solution initialSolution();

    protected abstract double initialTemperature();
}
