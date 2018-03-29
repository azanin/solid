package exercise.finalex.encoders;

public class Json extends DataType {

    private Json(String content) {
        super(content);
    }

    public static Json from(String str) {
        return new Json(str);
    }
}
