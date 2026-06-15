package msa.components.basiccomponents;

import java.util.Random;

import msa.core.Perturbation;
import msa.examples.rosenbrock.ContinuousProblem;
import msa.examples.rosenbrock.ContinuousSolution;

public class BasicPerturbation extends Perturbation<double[],ContinuousProblem,ContinuousSolution> {

    private double[] lowerBounds;
    private double[] upperBounds;
    
    @Override
    protected void init(ContinuousProblem problem) {
        this.lowerBounds = problem.getLowerBounds();
        this.upperBounds = problem.getUpperBounds();
    }
    
    @Override
    protected ContinuousSolution perturb(double temperature, ContinuousSolution s,boolean isAccepted) {
        Random random = new Random();
        double[] newX = s.getX().clone();
        
        for(int i = 0; i < newX.length; i++) {
            double delta = (upperBounds[i] - lowerBounds[i]) * 0.1;
            newX[i] += (random.nextDouble() - 0.5) * delta * 2;
            if(newX[i] < lowerBounds[i]) newX[i] = lowerBounds[i];
            if(newX[i] > upperBounds[i]) newX[i] = upperBounds[i];
        }
        
        return new ContinuousSolution(newX);
    }
}