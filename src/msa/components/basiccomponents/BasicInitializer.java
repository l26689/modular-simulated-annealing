package msa.components.basiccomponents;

import java.util.Random;

import msa.core.Initializer;
import msa.examples.rosenbrock.ContinuousProblem;
import msa.examples.rosenbrock.ContinuousSolution;

public class BasicInitializer extends Initializer<double[],ContinuousProblem,ContinuousSolution> {
    private double initialTemp;
    private int dim;
    private double[] lowerBounds;
    private double[] upperBounds;
    
    public BasicInitializer(double initialTemp) {
        this.initialTemp = initialTemp;
    }
    
    @Override
    protected void init(ContinuousProblem problem) {
        this.dim = problem.getDimension();
        this.lowerBounds = problem.getLowerBounds();
        this.upperBounds = problem.getUpperBounds();
    }
    
    @Override
    protected ContinuousSolution initialSolution() {
        double[] x = new double[dim];
        Random random = new Random();
        for(int i = 0; i < dim; i++) {
            double range = upperBounds[i] - lowerBounds[i];
            x[i] = lowerBounds[i] + random.nextDouble() * range;
        }
        ContinuousSolution solution = new ContinuousSolution(x);
        return solution;
    }
    
    @Override
    protected double initialTemperature() {
        return initialTemp;
    }
}