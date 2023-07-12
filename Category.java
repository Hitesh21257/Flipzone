package Assignment2;

import java.util.ArrayList;

public class Category {
    int Category_Id;
    String name;
    ArrayList<Product> add_product=new ArrayList<Product>();

    public void getProducts() {
//        int i = 1;
        for (Product product : add_product) {
//            System.out.print(i+") ");
            product.showDetails();
            System.out.println();
//            i++;
        }
    }

}
