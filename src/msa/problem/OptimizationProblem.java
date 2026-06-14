package msa.problem;

// 待求解问题
public abstract class OptimizationProblem {
    protected double[] lowerBounds;
    protected double[] upperBounds;

    public OptimizationProblem(double[] lower, double[] upper) {
        if (lower.length != upper.length) {
            throw new IllegalArgumentException("边界维度不一致");
        }
        this.lowerBounds = lower.clone();
        this.upperBounds = upper.clone();
    }

    public abstract double evaluate(double[] x);
    public int getDimension() { return lowerBounds.length; }
    public double[] getLowerBounds() { return lowerBounds.clone(); }
    public double[] getUpperBounds() { return upperBounds.clone(); }
}