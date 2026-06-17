package msa.examples.myproblem;

import msa.components.basiccomponents.*;
import msa.core.ModularSimulatedAnnealing;
import msa.examples.ContinuousProblem;

public class MyProblemDemo {
    void main() {
        ContinuousProblem problem = new MyProblem(2);
        ModularSimulatedAnnealing<double[],ContinuousProblem> msa = 
        new ModularSimulatedAnnealing<double[],ContinuousProblem>(
            problem,
            new BasicInitializer(100),
            new BasicPerturbation(),
            new BasicCoolingSchedule(0.99,100),
            new BasicTerminationCondition(10000)
        );
        double[] x = msa.solve();
        System.out.println(problem.evaluate(x));
    }
}
