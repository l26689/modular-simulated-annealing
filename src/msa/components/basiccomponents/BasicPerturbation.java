package msa.components.basiccomponents;

import java.util.Random;

import msa.problem.OptimizationProblem;
import msa.problem.Solution;
import msa.core.Perturbation;

public class BasicPerturbation extends Perturbation {

    private double[] lowerBounds;
    private double[] upperBounds;

    @Override
    protected void init(OptimizationProblem problem) {
        this.lowerBounds = problem.getLowerBounds();
        this.upperBounds = problem.getUpperBounds();
    }
    
    @Override
    protected Solution perturb(double temperature, Solution s,boolean isAccepted) {
        Random random = new Random();
        double[] newX = s.getX().clone();
        
        for(int i = 0; i < newX.length; i++) {
            double delta = (upperBounds[i] - lowerBounds[i]) * 0.1;
            newX[i] += (random.nextDouble() - 0.5) * delta * 2;
            if(newX[i] < lowerBounds[i]) newX[i] = lowerBounds[i];
            if(newX[i] > upperBounds[i]) newX[i] = upperBounds[i];
        }
        
        return new Solution(newX);
    }
}