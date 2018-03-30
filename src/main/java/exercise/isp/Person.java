package exercise.isp;

public class Person implements Eater,Worker {

    private final int workingHours;

    private final String food;

    public Person(
            int workingHours,
            String food
    ) {
        this.workingHours = workingHours;
        this.food = food;
    }


    @Override
    public String eat() {
        return this.food;
    }

    @Override
    public int work() {
        return 0;
    }
}
