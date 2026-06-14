package msa.examples.rosenbrock;

import msa.problem.*;
import msa.core.ModularSimulatedAnnealing;
import msa.components.basiccomponents.*;

public class RosenbrockDemo {
    void main() {
        ModularSimulatedAnnealing msa = new ModularSimulatedAnnealing(
            new RosenbrockFunction(2),
            new BasicInitializer(100),
            new BasicPerturbation(),
            new BasicCoolingSchedule(0.99,100),
            new BasicTerminationCondition(10000)
        );
        Solution s = msa.solve();
        System.out.println(s.getValue());
    }
    
}
