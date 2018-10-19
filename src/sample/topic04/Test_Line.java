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
    Line line1;
    Line line2;

    @Test
    public void constructor_CalledWithTwoPoints_ReturnsLineObject(){
        Assert.assertTrue(new Line(10,10,10,10) instanceof Line);
    }

    @Test
    public void constructor_CalledWithAPointAndPitch_ReturnsLineObject(){
        Assert.assertTrue(new Line(10, 10, 2) instanceof Line);
    }

    @Test
    public void constructor_CalledWithPitchAndOffset_ReturnsLineObject() {
        Assert.assertTrue(new Line(2, 4) instanceof Line);
    }

    @Test
    public void constructor_CalledWithVerticalLineXValue_ReturnsLineObject(){
        Assert.assertTrue(new Line(2) instanceof Line);
    }

    @Test
    public void isVertical_CalledWithVerticalLine_ReturnsTrue(){
        line1 = new Line(2);

        Assert.assertTrue(line1.isVertical());
    }

    @Test
    public void isVertical_CalledWithNonVerticalLine_ReturnsFalse(){
        line1 = new Line(10, 10, 2);

        Assert.assertFalse(line1.isVertical());
    }

    @Test
    public void isHorizontal_CalledWithHorizontalLine_ReturnsTrue(){
        line1 = new Line(10, 10, 0);

        Assert.assertTrue(line1.isHorizontal());
    }

    @Test
    public void isHorizontal_CalledWithNonHorizontalLine_ReturnsFalse(){
        line1 = new Line(10, 10, 1);

        Assert.assertFalse(line1.isHorizontal());
    }

    @Test
    public void isParallel_CalledWithParallelLine_ReturnsTrue(){
        line1 = new Line(10, 10, 2);
        line2 = new Line(5, 5, 2);

        Assert.assertTrue(line1.isParallel(line2));
    }

    @Test
    public void isParallel_CalledWithNonParallelLine_ReturnsFalse(){
        line1 = new Line(10, 10, 2);
        line2 = new Line(5, 5, 1);

        Assert.assertFalse(line1.isParallel(line2));
    }

    @Test
    public void equals_CalledWithEqualLine_ReturnsTrue(){
        line1 = new Line(10, 10, 2);
        line2 = line1;

        Assert.assertTrue(line1.equals(line2));
    }

    @Test
    public void equals_CalledWithNonEqualLine_ReturnsFalse(){
        line1 = new Line(10, 10, 2);
        line2 = new Line(5, 5, 2);

        Assert.assertFalse(line1.equals(line2));
    }

    @Test
    public void intersects_CalledWithNonParallelLine_ReturnsTrue(){
        line1 = new Line(10, 10, 2);
        line2 = new Line(5, 5, 3);

        Assert.assertTrue(line1.intersects(line2));
    }

    @Test
    public void intersects_CalledWithParallelLine_ReturnsFalse(){
        line1 = new Line(10, 10, 2);
        line2 = new Line(5, 5, 2);

        Assert.assertFalse(line1.intersects(line2));
    }
}
