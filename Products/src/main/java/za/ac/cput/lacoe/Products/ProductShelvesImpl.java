package za.ac.cput.lacoe.Products;

public class ProductShelvesImpl  implements Product
{
    private int id;
    private String name;
    private int qnty;
    private double price;
    private int shelfNum;

    public ProductShelvesImpl()
    {
        this.id = 0;
        this.name = "";
        this.qnty = 0;
        this.price = 0.0;
    }

    public ProductShelvesImpl(int id, String name, int qnty, double cost)
    {
        this.id = id;
        this.name = name;
        this.qnty = qnty;
        this.price = cost;
    }

    public int getID () { return id; }

    public String getName(){ return name; }

    public int getQnty ()
    {
        return qnty;
    }

    public void setQnty(int qnty) { this.qnty = qnty; }

    public double getPrice ()
    {
        return price;
    }

    public String getInfo ()
    {
        return String.format ("%s\nQuantity %d\nPrice %.2f", name, getQnty(), price);
    }
}
