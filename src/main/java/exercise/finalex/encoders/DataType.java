package exercise.finalex.encoders;

public abstract class DataType {

    private String content;

    public DataType(String content) {
        assert inputCheck();
        this.content = content;
    }

    private boolean inputCheck() {
        return content != null && !content.isEmpty();
    }

    public String getContent() {
        return this.content;
    }
}
