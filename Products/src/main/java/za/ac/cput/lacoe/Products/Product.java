package za.ac.cput.lacoe.Products;

public interface Product
{
    public int getID();
    public String getName();
    public int getQnty ();
    public void setQnty(int qnty);
    public double getPrice ();
    public String getInfo ();
}
