package za.ac.cput.lacoe.Prac_3;

import org.junit.*;
import static org.junit.Assert.*;
import za.ac.cput.lacoe.Products.*;

public class ProductStockTest
{
    Product product;

    public ProductStockTest()
    {
    }

    @Before
    public void setUp()
    {
        product = new ProductStockImpl(1, "Pen", 100, 1.5);
    }

    @Test
    public void getIDTest()
    {
        int expected = 1;
        int actual = product.getID();

        assertEquals(expected, actual);
    }

    @Test
    public void getNameTest()
    {
        String expected = "Pen";
        String actual = product.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void getQntyTest() {
        int expected = 100;
        int actual = product.getQnty();

        assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest()
    {
        double expected = 1.5;
        double actual = product.getPrice();

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void getInfoTest()
    {
        String expected = String.format ("%s\nStock %d\nCost %.2f",
                "Pen", product.getQnty(), product.getPrice());
        String actual = product.getInfo();

        assertEquals(expected, actual);
    }
}
