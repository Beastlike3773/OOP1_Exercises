package sample.topic04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test_Line {

    private Line testObject;

    @Before
    public void Before_Tests(){

    }

    // Constructor tests
    @Test
    public void Constructor_CalledWithTwoPoints_ReturnsLineObject(){
        Assert.assertTrue(new Line(10,10,10,10) instanceof Line);
    }

    @Test
    public void Constructor_CalledWithAPointAndPitch_ReturnsLineObject(){
        Assert.assertTrue(new Line(10, 10, 2) instanceof Line);
    }

    @Test
    public void Constructor_CalledWithPitchAndOffset_ReturnsLineObject() {
        Assert.assertTrue(new Line(2, 4) instanceof Line);
    }

    @Test
    public void Constructor_CalledWithVerticalLineXValue_ReturnsLineObject(){
        Assert.assertTrue(new Line(2) instanceof Line);
    }


}
