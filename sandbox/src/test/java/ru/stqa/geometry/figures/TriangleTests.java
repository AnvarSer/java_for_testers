package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateTriangleArea(){
        Assertions.assertEquals(14.7, Triangle.triangleArea(5.0, 6.0, 7.0), 0.01);
    }

    @Test
    void canCalculateTrianglePerimeter(){
        Assertions.assertEquals(18, Triangle.printTrianglePerimeter(5, 6, 7));
    }

    @Test
    void canCalculateTriangleAreaTriangle_1(){
        Assertions.assertEquals(6.0, Triangle.triangleArea(3.0, 4.0, 5.0), 0.01);
    }

    @Test
    void canCalculateTrianglePerimeterTriangle_1(){
        Assertions.assertEquals(12.0, Triangle.printTrianglePerimeter(3, 4, 5));
    }

    @Test
    void canCalculateTriangleAreaTriangle_2(){
        Assertions.assertEquals(27.81, Triangle.triangleArea(7.0, 8.0, 10.0), 0.01);
    }

    @Test
    void canCalculateTrianglePerimeterTriangle_2(){
        Assertions.assertEquals(25.0, Triangle.printTrianglePerimeter(7, 8, 10));
    }

}
