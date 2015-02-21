package za.ac.cput.lacoe.Prac_3;

import org.junit.*;
import static org.junit.Assert.*;
import za.ac.cput.lacoe.Products.*;

public class ProductShelvesTest
{
    Product product;

    public ProductShelvesTest() {}

    @Before
    public void setUp()
    {
        product = new ProductShelvesImpl(1, "Pen", 10, 1.5);
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
    public void getQntyTest()
    {
        int expected = 10;
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
        String expected = String.format ("%s\nQuantity %d\nPrice %.2f",
                "Pen", product.getQnty(), product.getPrice());
        String actual = product.getInfo();

        assertEquals(expected, actual);
    }
}
