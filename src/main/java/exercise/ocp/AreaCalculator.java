package exercise.ocp;

import java.util.List;

public class AreaCalculator {

    public static double sumOfAreas(List<Shape> shapes) {
        double res = 0.0d;
        for (Shape shape : shapes) {
            res += shape.area();
        }
        return res;
    }

}
