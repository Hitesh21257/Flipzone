package Assignment2;

import java.util.ArrayList;

public class Product{
    String name;
    double  Product_Id;
    int price;

    String discription;
    int primediscount=0;
    int elitediscount=0;
    int normaldiscount=0;

    public void showDetails() {
        System.out.println("Name: "+name);
        System.out.println("Product ID: "+Product_Id);
        System.out.println(discription);
        System.out.println("Price: "+price);
    }


}
