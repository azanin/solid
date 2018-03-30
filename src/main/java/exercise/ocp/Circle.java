package exercise.ocp;

public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.pow(radius, 2) * Math.PI;
    }
}
