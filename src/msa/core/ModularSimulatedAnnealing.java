package msa.core;

import java.util.Random;
import msa.problem.OptimizationProblem;
import msa.problem.Solution;

public class ModularSimulatedAnnealing{
    private Initializer initializer;//初始化器
    private Perturbation perturbation;//扰动器
    private CoolingSchedule coolingSchedule;//冷却器
    private TerminationCondition terminationCondition;//终止条件
    private Random random = new Random();//随机数生成器
    private OptimizationProblem problem;//优化问题

    public ModularSimulatedAnnealing(
        OptimizationProblem problem ,
        Initializer initializer,
        Perturbation perturbation,
        CoolingSchedule coolingSchedule,
        TerminationCondition terminationCondition){
            this.problem = problem;
            this.initializer = initializer;
            this.perturbation = perturbation;
            this.coolingSchedule = coolingSchedule;
            this.terminationCondition = terminationCondition;
            perturbation.init(problem);
            coolingSchedule.init(problem);
            terminationCondition.init(problem);
        }

    public Solution solve(){
        double temperature= initializer.initialTemperature();
        Solution currentSolution = initializer.initialSolution();
        currentSolution.setValue(problem.evaluate(currentSolution.getX()));
        Solution bestSolution = currentSolution.clone();
        Solution newSolution;

        while (!terminationCondition.check(temperature, currentSolution)) {

            newSolution = perturbation.perturb(temperature,currentSolution);
            newSolution.setValue(problem.evaluate(newSolution.getX()));

            if(newSolution.getValue()<currentSolution.getValue()){
                currentSolution = newSolution;
                if(currentSolution.getValue()<bestSolution.getValue()){
                    bestSolution = currentSolution.clone();
                }
            }
            else if(random.nextDouble()<Math.exp((currentSolution.getValue()-newSolution.getValue())/temperature)){
                currentSolution = newSolution;
            }
            temperature = coolingSchedule.cool(temperature,currentSolution);
        }
        
        return bestSolution;
    }
}