package exercise.finalex.encoders;

public class Custom extends DataType {

    private Custom(String content) {
        super(content);
    }

    public static Custom from(String str) {
        return new Custom(str);
    }

}
