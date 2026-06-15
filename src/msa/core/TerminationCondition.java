package msa.core;

import msa.problem.OptimizationProblem;
import msa.problem.Solution;

public abstract class TerminationCondition {

    protected abstract void init(OptimizationProblem problem);
    
    protected abstract boolean check(double temperature, Solution s,boolean isAccepted);
}