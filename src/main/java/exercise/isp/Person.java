package exercise.isp;

public abstract class Person implements Worker {

    private final int workingHours;

    private final String food;

    protected Person(
            int workingHours,
            String food
    ) {
        this.workingHours = workingHours;
        this.food = food;
    }
}
