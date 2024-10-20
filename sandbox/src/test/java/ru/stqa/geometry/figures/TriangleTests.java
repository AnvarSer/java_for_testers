package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-5.0, 3.0, 8.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

        try {
            new Triangle (5.0, -3.0, 8.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

        try {
            new Triangle (5.0, 3.0, -8.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void cannotCreateTriangleWhenTriangleSideInequalityViolation () {
        try {
            new Triangle(1.0, 2.0, 10.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

        try {
            new Triangle(4.0, 15.0, 10.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

        try {
            new Triangle(3.0, 7.0, 2.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void canCalculateTriangleArea(){
        Assertions.assertEquals(14.7, new Triangle(5.0, 6.0, 7.0 ).triangleArea(), 0.01);
    }

    @Test
    void canCalculateTrianglePerimeter(){
        Assertions.assertEquals(18, new Triangle(5.0, 6.0, 7.0 ).trianglePerimeter());
    }

    @Test
    void canCalculateTriangleAreaTriangle_1(){
        Assertions.assertEquals(6.0, new Triangle(3, 4, 5).triangleArea(), 0.01);
    }

    @Test
    void canCalculateTrianglePerimeterTriangle_1(){
        Assertions.assertEquals(12.0, new Triangle(3, 4, 5).trianglePerimeter());
    }

    @Test
    void canCalculateTriangleAreaTriangle_2(){
        Assertions.assertEquals(27.81, new Triangle(7, 8, 10).triangleArea(), 0.01);
    }

    @Test
    void canCalculateTrianglePerimeterTriangle_2(){
        Assertions.assertEquals(25.0, new Triangle(7, 8, 10).trianglePerimeter());
    }

    @Test
    void testEquality(){
        var t1 = new Triangle(3.0, 4.0, 5.0);
        var t2 = new Triangle(3.0, 4.0, 5.0);
        Assertions.assertTrue(t1.equals(t2));
    }

    @Test
    void testEquality2(){
        var t1 = new Triangle(3.0, 4.0, 5.0);
        var t2 = new Triangle(4.0, 5.0, 3.0);
        Assertions.assertTrue(t1.equals(t2));
    }

}
