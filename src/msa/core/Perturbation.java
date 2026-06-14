package msa.core;

import msa.problem.OptimizationProblem;
import msa.problem.Solution;

public abstract class Perturbation {

    protected abstract void init(OptimizationProblem problem);

    protected abstract Solution perturb(double temperature,Solution s);
}