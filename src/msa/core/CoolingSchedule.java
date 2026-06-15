package msa.core;

import msa.problem.OptimizationProblem;
import msa.problem.Solution;

public abstract class CoolingSchedule {

    protected abstract void init(OptimizationProblem problem);

    protected abstract double cool(double temperature,Solution s,boolean isAccepted);
}