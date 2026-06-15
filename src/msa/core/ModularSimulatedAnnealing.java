package msa.core;

import java.util.Random;

public class ModularSimulatedAnnealing<X,Prob extends Problem<X>> {
    private Initializer<X,Prob> initializer;//初始化器
    private Perturbation<X,Prob> perturbation;//扰动器
    private CoolingSchedule<X,Prob> coolingSchedule;//冷却器
    private TerminationCondition<X,Prob> terminationCondition;//终止条件
    private Random random = new Random();//随机数生成器
    private Prob problem;//优化问题

    public ModularSimulatedAnnealing(
        Prob problem ,
        Initializer<X,Prob> initializer,
        Perturbation<X,Prob> perturbation,
        CoolingSchedule<X,Prob> coolingSchedule,
        TerminationCondition<X,Prob> terminationCondition){
            this.problem = problem;
            this.initializer = initializer;
            this.perturbation = perturbation;
            this.coolingSchedule = coolingSchedule;
            this.terminationCondition = terminationCondition;
            perturbation.init(problem);
            coolingSchedule.init(problem);
            terminationCondition.init(problem);
        }

    public X solve(){
        double temperature= initializer.initialTemperature();
        X currentX = initializer.initialX();
        double currentValue = problem.evaluate(currentX);

        X bestX = problem.copyX(currentX);
        double bestValue = currentValue;

        X newX = problem.copyX(currentX);
        double newValue = currentValue;

        boolean isAccepted = false;

        while (!terminationCondition.check(temperature, currentX,isAccepted)) {

            newX = perturbation.perturb(temperature,currentX,isAccepted);

            newValue = problem.evaluate(newX);

            if(newValue<currentValue){
                currentX = newX;
                isAccepted = true;

                if(currentValue<bestValue){
                    bestX = problem.copyX(currentX);
                    bestValue = currentValue;
                }
            }
            else{
                isAccepted = random.nextDouble()<Math.exp((currentValue-newValue)/temperature);
                if(isAccepted){
                    currentX = newX;
                }
            }
            temperature = coolingSchedule.cool(temperature,currentX,isAccepted);
        }
        
        return bestX;
    }
}