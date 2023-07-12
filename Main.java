package Assignment2;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Admin ad=new Admin();
        int back=0;

        Scanner sc=new Scanner(System.in);
        Scanner sss=new Scanner(System.in);
        Scanner sd=new Scanner(System.in);
        System.out.println("--------Welcome to Flipzon--------");


        while(true){
            System.out.println("1)Enter as Admin");
            System.out.println("2)Explore the product Catalog");
            System.out.println("3)Show Available Deals");
            System.out.println("4)Enter as Customer");
            System.out.println("5)Exit the Application");
            int x=sc.nextInt();
            if(x==1) {
                while (true) {
                    Scanner ss=new Scanner(System.in);
                    System.out.println("Dear Admin");
                    System.out.println("Please enter your username and password!!");
                    String uname=ss.nextLine();
                    int  pword=sc.nextInt();

                    if((uname.equals(Admin.uname)) &&(pword==Admin.passwrod)){
                        System.out.println("Welcome "+Admin.uname +"!!!");
                        while(true) {

                            System.out.println("Please choose any one of the following actions:");
                            System.out.println("1) Add category\n" +
                                    "2) Delete category\n" +
                                    "3) Add Product\n" +
                                    "4) Delete Product\n" +
                                    "5) Set Discount on Product\n" +
                                    "6) Add giveaway deal\n" +
                                    "7) Back");
                            int y=sc.nextInt();
                            if(y==1){
                                ad.Add_Category();
                            }else if(y==2){
                                System.out.println("Enter the Category id you wanted to delete");
                                int dc=sc.nextInt();
                                ad.Delete_category(dc);

                            }else if(y==3){
                                ad.Add_product();

                            }else if(y==4){
                                System.out.println("Enter the category name");
                                String nn=ss.nextLine();
                                System.out.println("Enter the product id");
                                double ddf=sd.nextDouble();

                            }else if(y==5){
                                System.out.println("Dear Admin give the Product ID you want to add discount for");
                                System.out.println("Enter the Product ID :");
                                double ddd=sd.nextDouble();
                                System.out.println("Enter discount for Elite");
                                int e=sc.nextInt();
                                System.out.println("Enter discount for Prime");
                                int ddp=sc.nextInt();
                                System.out.println("Enter discount for Normal");
                                int dnn=sc.nextInt();
                                ad.Set_Discount_on_product(ddd,e,ddp,dnn);

                            }else if(y==6){
                                Scanner sdd=new Scanner(System.in);
                                System.out.println("Dear Admin give the Product IDs you want to combine and giveaway a deal for");
                                System.out.println("Enter the first Product ID :");
                                double d1=sd.nextDouble();
                                System.out.println("Enter the second Product ID:");
                                double d2=sdd.nextDouble();
                                System.out.println("Enter the combined price(Should be less than their combined price):");
                                int com=sc.nextInt();
                                ad.Add_giveaway_deals(d1,d2,com);

                            }else if(y==7){
                                back=1;
                                break;
                            }
                        }
                        if(back==1){
                            break;
                        }

                    }else{
                        System.out.println("!!!!Please Fill correct Details!!!!");

                    }

                }
            }

            else if(x==2){
                ad.showProducts();
            }

            else if(x==3){
//                ad.showDeals();
            }
            else if(x==4){
                while(true){
                    System.out.println("1) Sign up\n" +
                            "2) Log in\n" +
                            "3) Back");
                    int y4=sc.nextInt();
                    if(y4==1){
                        Scanner sdd=new Scanner(System.in);
                        Scanner ddd=new Scanner(System.in);
                        System.out.println("Enter name");
                        String nn=sss.nextLine();
                        System.out.println("Enter password");
                        String pp=sdd.nextLine();
                        System.out.println("Enter age");
                        int age=sc.nextInt();
                        System.out.println("Enter the phone number");
                        String pno=ddd.nextLine();
                        System.out.println("Enter the email_id");
                        String em=sss.nextLine();
                        Customer c=new Customer(nn,em,pp,age,pno);
                        Admin.no_of_registered_people.add(c);
                        c.wallet=1000;
                        c.Status="NORMAL";
                        System.out.println("customer successfully registered!!");

                    }else if(y4==2){
                        Scanner sf=new Scanner(System.in);
                        System.out.println("Enter name");
                        String nam=sss.nextLine();
                        System.out.println("Enter password");
                        String psw=sf.nextLine();
                        System.out.println("Enter the email");
                        String emm=sss.nextLine();
                        int registered=0;
                        for(int i=0;i<Admin.no_of_registered_people.size();i++){
                            Customer cc=Admin.no_of_registered_people.get(i);
                            if(cc.name.equals(nam) && cc.password.equals(psw) &&cc.email.equals(emm)){
                                registered=1;
                            }
                        }
                        if(registered==0){
                            System.out.println("Please registered first and then login again");
                        }else if(registered==1){
                            for(int i=0;i<Admin.no_of_registered_people.size();i++){
                                Customer cc=Admin.no_of_registered_people.get(i);
                                if(cc.name.equals(nam) && cc.password.equals(psw) &&cc.email.equals(emm)){
                                    System.out.println("Welcome "+cc.name+"!!!!");
                                    while(true){
                                        System.out.println("1) browse products");
                                        System.out.println("2) browse deals");
                                        System.out.println("3) add a product to cart");
                                        System.out.println("4) add products in deal to cart");
                                        System.out.println("5) view coupons");
                                        System.out.println("6) check account balance");
                                        System.out.println("7) view cart");
                                        System.out.println("8) empty cart");
                                        System.out.println("9) checkout cart");
                                        System.out.println("10) upgrade customer status");
                                        System.out.println("11) Add amount to wallet");
                                        System.out.println("12) back");
                                        int y5=sc.nextInt();
                                        if(y5==1){


                                        }else if(y5==2){

                                        }else if(y5==3){
                                            System.out.println("Enter product ID ");
                                            double pid=sd.nextDouble();
                                            System.out.println("Enter the quantity ");
                                            int quan=sc.nextInt();
                                            int caat=(int) pid;
                                            for(int j=0;j<Admin.no_of_category.size();j++){
                                                Category ccc=Admin.no_of_category.get(j);
                                                if(ccc.Category_Id==caat){
                                                    for(int k=0;k<ccc.add_product.size();k++){
                                                        Product pppp=ccc.add_product.get(k);
                                                        if(pppp.Product_Id==pid){
                                                            cc.carting.add(pppp);
                                                            cc.quantity.add(quan);
                                                            System.out.println("Item successfully added to cart");
                                                        }
                                                    }

                                                }

                                            }

                                        }else if(y5==4){

                                        }else if(y5==5){
                                            System.out.println("!!!Here is your Coupons!!!");
                                            for(int j=0;j<cc.coupons.size();j++){
                                                int coup=cc.coupons.get(j);
                                                System.out.println((j+1)+" "+coup);
                                            }


                                        }else if(y5==6){
                                            System.out.println("Current account balance is Rupees  "+cc.wallet);

                                        }else if(y5==7){

                                        }else if(y5==8){
                                            cc.get_cart_empty();

                                        }else if(y5==9){
                                            double finn=cc.get_totalamount();
                                            double finndeal=cc.get_total_in_deals();
                                            if(finn+finndeal>cc.wallet){
                                                System.out.println("Insufficient balance!!!");
                                            }else{
                                                System.out.println("Your order is placed successfully. Details:");
                                                cc.printing_order_info();
                                            }



                                        }else if(y5==10){
                                            System.out.println("Current status:");
                                            System.out.println(cc.Status);
                                            System.out.println("Choose a new status:");
                                            String zz=sss.nextLine();
                                            cc.Status=zz;
                                            System.out.println("Status updated to" + " "+cc.Status);
                                            if(cc.Status.equals("ELITE")){
                                                cc.wallet-=300;
                                            }else if(cc.Status.equals("PRIME")){
                                                cc.wallet-=200;
                                            }

                                        }else if(y5==11){
                                            System.out.println("Enter amount to add");
                                            int hh=sc.nextInt();
                                            cc.wallet+=hh;

                                        }else if(y5==12){
                                            break;
                                        }
                                    }

                                }
                            }
                        }

                    }else if(y4==3){
                        break;
                    }
                }



            }else if(x==5){
                System.out.println("-----Thanks for Using this application-----");
                break;
            }

        }
    }
}
