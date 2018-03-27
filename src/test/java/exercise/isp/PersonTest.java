package exercise.isp;

import static org.junit.Assert.*;

public class PersonTest {

    public void workTest() {
        Person bob = null;
        assertTrue(bob.work() == 8);
    }

    public void eatTest() {
        Person bob = null;
        assertTrue(bob.eat().equals("carrots"));
    }

}