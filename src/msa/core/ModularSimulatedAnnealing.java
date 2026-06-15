package msa.core;

import java.util.Random;

public class ModularSimulatedAnnealing<X,Prob extends Problem<X>,Sol extends Solution<X>> {
    private Initializer<X,Prob,Sol> initializer;//初始化器
    private Perturbation<X,Prob,Sol> perturbation;//扰动器
    private CoolingSchedule<X,Prob,Sol> coolingSchedule;//冷却器
    private TerminationCondition<X,Prob,Sol> terminationCondition;//终止条件
    private Random random = new Random();//随机数生成器
    private Prob problem;//优化问题

    public ModularSimulatedAnnealing(
        Prob problem ,
        Initializer<X,Prob,Sol> initializer,
        Perturbation<X,Prob,Sol> perturbation,
        CoolingSchedule<X,Prob,Sol> coolingSchedule,
        TerminationCondition<X,Prob,Sol> terminationCondition){
            this.problem = problem;
            this.initializer = initializer;
            this.perturbation = perturbation;
            this.coolingSchedule = coolingSchedule;
            this.terminationCondition = terminationCondition;
            perturbation.init(problem);
            coolingSchedule.init(problem);
            terminationCondition.init(problem);
        }

    public Sol solve(){
        double temperature= initializer.initialTemperature();
        Sol currentSolution = initializer.initialSolution();
        currentSolution.setValue(problem.evaluate(currentSolution.getX()));

        Sol bestSolution = (Sol)currentSolution.clone();
        Sol newSolution;

        boolean isAccepted = false;

        while (!terminationCondition.check(temperature, currentSolution,isAccepted)) {

            newSolution = perturbation.perturb(temperature,currentSolution,isAccepted);

            newSolution.setValue(problem.evaluate(newSolution.getX()));

            if(newSolution.getValue()<currentSolution.getValue()){
                currentSolution = newSolution;
                isAccepted = true;

                if(currentSolution.getValue()<bestSolution.getValue()){
                    bestSolution = (Sol)currentSolution.clone();
                }
            }
            else{
                isAccepted = random.nextDouble()<Math.exp((currentSolution.getValue()-newSolution.getValue())/temperature);
                if(isAccepted){
                    currentSolution = newSolution;
                }
            }
            temperature = coolingSchedule.cool(temperature,currentSolution,isAccepted);
        }
        
        return bestSolution;
    }
}