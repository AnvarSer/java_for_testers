package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

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

}
