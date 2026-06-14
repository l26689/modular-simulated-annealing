package msa.components.basiccomponents;

import java.util.Random;

import msa.problem.OptimizationProblem;
import msa.problem.Solution;
import msa.core.Initializer;

public class BasicInitializer extends Initializer {
    private double initialTemp;
    private int dim;
    private double[] lowerBounds;
    private double[] upperBounds;
    
    public BasicInitializer(double initialTemp) {
        this.initialTemp = initialTemp;
    }
    
    @Override
    protected void init(OptimizationProblem problem) {
        this.dim = problem.getDimension();
        this.lowerBounds = problem.getLowerBounds();
        this.upperBounds = problem.getUpperBounds();
    }
    
    @Override
    protected Solution initialSolution() {
        double[] x = new double[dim];
        Random random = new Random();
        for(int i = 0; i < dim; i++) {
            double range = upperBounds[i] - lowerBounds[i];
            x[i] = lowerBounds[i] + random.nextDouble() * range;
        }
        Solution solution = new Solution(x);
        return solution;
    }
    
    @Override
    protected double initialTemperature() {
        return initialTemp;
    }
}