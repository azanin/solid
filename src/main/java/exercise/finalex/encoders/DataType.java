package exercise.finalex.encoders;

import java.util.Objects;

public abstract class DataType {

    private String content;

    public DataType(String content) {
        assert content != null && !content.isEmpty();
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataType dataType = (DataType) o;
        return Objects.equals(content, dataType.content);
    }
}
