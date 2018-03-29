package exercise.finalex.model;

public final class Unit {
    public static final Unit value = new Unit();

    private Unit() {
    }

    @Override
    public String toString() {
        return "()";
    }
}
