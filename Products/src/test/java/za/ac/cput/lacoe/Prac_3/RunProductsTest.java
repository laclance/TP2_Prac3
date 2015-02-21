package za.ac.cput.lacoe.Prac_3;

import org.junit.*;
import static org.junit.Assert.*;
import za.ac.cput.lacoe.Products.*;
import za.ac.cput.lacoe.Prac_3.RunProducts;

public class RunProductsTest
{
    Product stockProd;
    Product shelfProd;
    RunProducts run;

    public RunProductsTest() {}

    @Before
    public void setUp()
    {
        run = new RunProducts();
        run.addProduct(2, "Pencil", 100, 0.5, 2.5);
    }

    @Test
    public void addProductTest()
    {
        Product expected = new ProductStockImpl(1, "Pen", 100, 1.5);
        Product actual = run.addProduct(1, "Pen", 100, 1.5, 2.5);

        assertEquals(expected.getID(), actual.getID());
    }

    @Test
    public void findProductTest()
    {
        Product expected = new ProductStockImpl (2, "Pencil", 100, 0.5);
        Product actual = run.findProduct(2);

        assertEquals(expected.getID(), actual.getID());
    }

    @Test
    public void transferStockTest()
    {
        Product expected = new ProductStockImpl(2, "Pencil", 90, 0.5);
        Product actual = run.transferStock(2, 10);

        assertEquals(expected.getID(), actual.getID());
    }

    @Test
    public void addLowStockTest()
    {
        Product expected = new ProductStockImpl(2, "Pencil", 100, 0.5);
        Product actual = run.addLowStock(2);

        assertEquals(expected.getID(), actual.getID());
    }

    @Test
    public void addOrderTest()
    {
        Product expected = new ProductStockImpl(2, "Pencil", 100, 0.5);
        Product actual = run.addOrder(2, 100);

        assertEquals(expected.getID(), actual.getID());
    }

    @Test
    public void deleteProductTest()
    {
        Product expected = new ProductStockImpl(2, "Pencil", 100, 0.5);
        Product actual = run.deleteProduct(2, 10);

        assertEquals(expected.getID(), actual.getID());
    }
}
