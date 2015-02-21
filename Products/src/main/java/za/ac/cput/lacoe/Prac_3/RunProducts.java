package za.ac.cput.lacoe.Prac_3;

import za.ac.cput.lacoe.Products.*;

import java.util.*;

public class RunProducts
{
    List<Product> stock;
    List<Product> shelves;
    Set<Product> lowStock;
    HashMap<Integer, Integer> orders;

    public RunProducts()
    {
        stock = new ArrayList<Product>();
        shelves = new ArrayList<Product>();
        lowStock = new HashSet<Product>();
        orders = new HashMap<Integer, Integer>();
    }

    public Product addProduct(int id, String name, int qnty, double cost, double price)
    {
        if (findProduct(id) != null)
        {
            System.out.println("Code " + id + " already exists");
            return null;
        }
        else
        {
            Product stockProd = new ProductStockImpl(id, name, qnty, cost);
            Product shelvesProd = new ProductStockImpl(id, name, 0, price);

            stock.add(stockProd);
            shelves.add (shelvesProd);

            System.out.println (name + " added");
            return stockProd;
        }
    }

    public Product deleteProduct(int id, int qnty)
    {
        Product prod = findProduct(id);
        if (prod == null)
        {
            System.out.println("Code " + id + " doesn't exists");
            return null;
        }
        else
        {
            int i = stock.indexOf(prod);
            stock.remove(prod);
            shelves.remove(i);

            System.out.println (id + " " + prod.getName() + " deleted");
            return prod;
        }
    }

    public Product findProduct(int id)
    {
        for (Product prod : stock)
            if (prod.getID() == id)
                return prod;
        return null;
    }

    public Product transferStock(int id, int qnty)
    {
        Product prod = findProduct(id);

        if (prod == null)
        {
            System.out.println("Code " + id + " doesn't exists");
            return null;
        }
        else if ((prod.getQnty() - qnty < 0))
        {
            System.out.println("Not enough stock. Qnty: " + prod.getQnty());
            return null;
        }
        else
        {
            int i = stock.indexOf(prod);
            stock.get(i).setQnty(prod.getQnty() - qnty);
            shelves.get(i).setQnty(shelves.get(i).getQnty() + qnty);

            System.out.println (id + " " + prod.getName() + " transfered: " + qnty);
            return prod;
        }
    }

    public Product addLowStock(int id)
    {
        Product prod = findProduct(id);
        if (prod == null)
        {
            System.out.println("Code " + id + " doesn't exists");
            return null;
        }
        else if (lowStock.contains(prod))
        {
            System.out.println(id + " " + prod.getName() + " already in low stock list");
            return null;
        }
        else
        {
            lowStock.add(prod);
            System.out.println (id + " " + prod.getName() + " added to low stock list");
            return prod;
        }
    }

    public Product addOrder(int id, int qnty)
    {
        Product prod = findProduct(id);
        int curQnty = prod.getQnty();

        if (prod == null)
        {
            System.out.println("Code " + id + " doesn't exists");
            return null;
        }
        else
        {
            orders.put(prod.getID(), qnty);
            System.out.println (id + " " + prod.getName() + " ordered: " + qnty);
            return prod;
        }
    }

    public void veiwAll()
    {
        int i;
        for (i = 0; i < stock.size(); i++)
        {
            System.out.println(stock.get(i).getID() + " " + stock.get(i).getName());
            System.out.println("Stock: " + stock.get(i).getQnty());
            System.out.println("Shelves: " + shelves.get(i).getQnty());
            System.out.println("Cost: " + stock.get(i).getPrice());
            System.out.println("Price: " + shelves.get(i).getPrice());
        }

        System.out.println ("\nLow Stock:");
         i = 0;
        for (Product prod : lowStock)
        {
            System.out.println(prod.getID() + " " + prod.getName());
            System.out.println("Stock: " + prod.getQnty());
            System.out.println("Shelves: " + shelves.get(i).getQnty());
            System.out.print("Ordered: ");
            if (orders.containsKey(prod.getID()))
                System.out.println(orders.get(prod.getID()));
            else
                System.out.println(0);
            i++;
        }
    }
}
