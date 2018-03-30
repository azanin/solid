package exercise.lsp;

public class ResizableRectangle extends Rectangle {

    public ResizableRectangle(int height, int width) {
        super(height, width);
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void resize(int height, int width) {
        setWidth(width);
        setHeight(height);
    }
}
