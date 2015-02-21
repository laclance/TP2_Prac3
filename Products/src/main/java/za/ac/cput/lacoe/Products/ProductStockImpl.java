package za.ac.cput.lacoe.Products;

public class ProductStockImpl implements Product
{
    private int id;
    private String name;
    private int qnty;
    private double cost;

    public ProductStockImpl()
    {
        this.id = 0;
        this.name = "";
        this.qnty = 0;
        this.cost = 0.0;
    }

    public ProductStockImpl(int id, String name, int qnty, double cost)
    {
        this.id = id;
        this.name = name;
        this.qnty = qnty;
        this.cost = cost;
    }

    public int getID ()
    {
        return id;
    }

    public String getName(){ return name; }

    public int getQnty ()
    {
        return qnty;
    }

    public void setQnty(int qnty) { this.qnty = qnty; }

    public double getPrice ()
    {
        return cost;
    }

    public String getInfo ()
    {
        return String.format ("%s\nStock %d\nCost %.2f", name, getQnty(), cost);
    }
}
