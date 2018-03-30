package exercise.lsp;

import org.junit.Test;

public class LspTest {

    @Test
    public void resizeRectangleTest() {

        ResizableRectangle rr = new ResizableRectangle(4,6);

        rr.resize(6, 7);

        assert (rr.getHeight() == 6);
        assert (rr.getWidth() == 7);
    }

    /*@Test
    public void resizeSquareTest() {

        Square s = new Square(5);
        ResizableRectangle.resize(s, 6, 7);


        System.out.println(s.getHeight());
        System.out.println(s.getWidth());

        assert false;
    }*/
}