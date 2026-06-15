package msa.examples.rosenbrock;

import msa.core.ModularSimulatedAnnealing;
import msa.components.basiccomponents.*;

public class RosenbrockDemo {
    void main() {
        ModularSimulatedAnnealing<double[],ContinuousProblem,ContinuousSolution> msa = 
        new ModularSimulatedAnnealing<double[],ContinuousProblem,ContinuousSolution>(
            new RosenbrockFunction(2),
            new BasicInitializer(100),
            new BasicPerturbation(),
            new BasicCoolingSchedule(0.99,100),
            new BasicTerminationCondition(10000)
        );
        ContinuousSolution s = (ContinuousSolution)msa.solve();
        System.out.println(s.getValue());
    }
    
}
