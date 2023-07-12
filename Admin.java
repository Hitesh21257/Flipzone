package Assignment2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    Scanner sc=new Scanner(System.in);

    Scanner sss=new Scanner(System.in);
    Scanner sd=new Scanner(System.in);
    static String uname="Hitesh Yadav";
    static int  passwrod=12341234;

    static ArrayList<Customer> no_of_registered_people=new ArrayList<Customer>();
    static ArrayList<Category> no_of_category=new ArrayList<Category>();

    static ArrayList<Deals> no_of_deals=new ArrayList<Deals>();

    public void showProducts() {
        for (Category category : no_of_category) {
            category.getProducts();
        }
    }

    public void showDeal() {
        for (Deals deal : no_of_deals) {

        }
    }

    public  void Add_Category() {
        Scanner st=new Scanner(System.in);
        System.out.println("Add category ID");
        int id=sc.nextInt();
        int Check=0;
        for(int i=0;i<Admin.no_of_category.size();i++){
            Category abc= Admin.no_of_category.get(i);
            if(abc.Category_Id==id){
                Check=1;
                break;
            }
        }
        if(Check==0) {
            Scanner ssc=new Scanner(System.in);
            Category c = new Category();
            c.Category_Id = id;
            System.out.println("Add name of the category");
            String nam=st.nextLine();
            c.name=nam;
            Admin.no_of_category.add(c);

            System.out.println("Add a Product:-");
            Product p=new Product();
            System.out.println("Product Name");
            String pn=st.nextLine();
            System.out.println("Product ID");
            Double pi=ssc.nextDouble();
            System.out.println("Price");
            int pp=sc.nextInt();
            p.name=pn;
            p.Product_Id=pi;
            p.price=pp;
            System.out.println("Enter the discription of the product--->");
            String dd=st.nextLine();
            p.discription=dd;
            c.add_product.add(p);

        }else{
            System.out.println("Dear Admin, the category ID is already used!!! Please set a different and a unique category ID");
        }
    }
    public void Add_product(){
        System.out.println("Enter category ID");
        int ac=sc.nextInt();
        int checking=0;
        for(int i=0;i<Admin.no_of_category.size();i++){
            Category abc= Admin.no_of_category.get(i);
            if(abc.Category_Id==ac){
                checking=1;
                break;
            }
        }
        if(checking==1){
            for(int i=0;i<Admin.no_of_category.size();i++){
                Category abc= Admin.no_of_category.get(i);
                if(abc.Category_Id==ac){
                    System.out.println("Add a Product:-");
                    Product p=new Product();
                    System.out.println("Product Name");
                    String pn=sss.nextLine();
                    System.out.println("Product ID");
                    Double pi=sd.nextDouble();
                    System.out.println("Price");
                    int pp=sc.nextInt();
                    p.name=pn;
                    p.Product_Id=pi;
                    p.price=pp;
                    System.out.println("Enter the discription of the product--->");
                    String dd=sss.nextLine();
                    p.discription=dd;
                    abc.add_product.add(p);
                }
            }

        }else if(checking==0){
            System.out.println("Please add the Category and then add the product in it--->>>");
        }
    }
    public void Delete_category(int id){
        for(int i=0;i<Admin.no_of_category.size();i++){
            Category c=Admin.no_of_category.get(i);
            if(c.Category_Id==id){
                Admin.no_of_category.remove(i);
            }
        }
    }
    public void Delete_product(String namee,double iid){
        for(int i=0;i<Admin.no_of_category.size();i++){
            Category catt=Admin.no_of_category.get(i);
            if(catt.name.equals(namee)){
                    if(catt.add_product.size()>1){
                        for(int j=0;j<catt.add_product.size();j++){
                            Product pppp=catt.add_product.get(j);
                            if(pppp.Product_Id==iid){
                                catt.add_product.remove(j);
                            }
                        }
                    }else if(catt.add_product.size()==1){
                        Product pp=catt.add_product.get(0);
                        if(pp.Product_Id==iid){
                            Admin.no_of_category.remove(i);
                        }
                    }

            }
        }
    }
    public void Set_Discount_on_product(double id,int elite,int prime,int normal){
        int cat=(int) id;
        for(int i=0;i<Admin.no_of_category.size();i++) {
            Category cc = Admin.no_of_category.get(i);
            if (cc.Category_Id == cat) {
                for (int j = 0; j < cc.add_product.size(); j++) {
                    Product p = cc.add_product.get(j);
                    if (p.Product_Id == id) {
                        p.elitediscount=elite;
                        p.normaldiscount=normal;
                        p.primediscount=prime;
                    }
                }
            }
        }

    }
    public void Add_giveaway_deals(double id1,double id2,int combined_price){
        int cat1=(int) id1;
        int cat2=(int) id2;
        int price1=0;
        int price2=0;

        for(int i=0;i<Admin.no_of_category.size();i++){
            Category cc=Admin.no_of_category.get(i);
            if(cc.Category_Id==cat1){
                for(int j=0;j<cc.add_product.size();j++){
                    Product p=cc.add_product.get(j);
                    if(p.Product_Id==id1){
                        price1=p.price;
                    }
                }
            }
            if(cc.Category_Id==cat2){
                for(int j=0;j<cc.add_product.size();j++){
                    Product p=cc.add_product.get(j);
                    if(p.Product_Id==id2){
                        price2=p.price;
                    }
                }
            }
        }
        if(price1+price2>combined_price){
            Deals d1=new Deals(id1,id2,combined_price);
            Admin.no_of_deals.add(d1);
        }else{
            System.out.println("Combined price is greater than the the individual price");
        }

    }

}
