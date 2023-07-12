package Assignment2;
import java.util.*;
public class Customer extends Cart{

    double wallet=0;
    String name;
    String email;
    String password;
    int age;
    String  phone_number;

    public  ArrayList<Integer> coupons=new ArrayList<Integer>();

    int coupons_checking=0;
    String Status="Unregistered";

    public Customer(String name, String email, String password, int age, String phone_number) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phone_number = phone_number;
    }
    public void Upgrade_status(){

    }
    public  double get_totalamount(){
        double finalprice=0;
        for(int i=0;i<this.carting.size()-1;i++){
            for(int j=i+1;j<this.carting.size();j++){
                if(((this.carting.get(i).price)*this.quantity.get(i))<=((this.carting.get(j).price)*this.quantity.get(j))){
                    Product mm=this.carting.get(j);
                    Integer qu=this.quantity.get(j);
                    Product mmm=this.carting.get(i);
                    Integer quu=this.quantity.get(i);
                    this.carting.set(i,mm);
                    this.quantity.set(i,qu);
                    this.carting.set(j,mmm);
                    this.quantity.set(j,quu);
                }
            }
        }

        if(this.coupons.size()==0){
            for(int i=0;i<this.carting.size();i++){
                Product ppp=this.carting.get(i);

                int quan=this.quantity.get(i);


                int pricee=ppp.price;
                double dch=0;
                double pricing=0;
                if(this.Status.equals("NORMAL")){
                    int discoun=ppp.normaldiscount;
                    dch=(100*quan)+((pricee*quan)*0.05);
                    pricing=(pricee*quan)-((pricee*quan*discoun*0.01));
                    finalprice+=dch+pricing;
                }
                else if(this.Status.equals("PRIME")){
                    int discoun=ppp.primediscount;
                    dch=(100*quan)+((pricee*quan)*0.02);
                    if(discoun>=5){
                        pricing=(pricee*quan)-((pricee*quan*discoun*0.01));
                    }else{
                        pricing=(pricee*quan)-((pricee*quan*5*0.01));
                    }
                    finalprice+=dch+pricing;

                }else if(this.Status.equals("ELITE")){
                    int discoun=ppp.elitediscount;


                    dch=(100*quan);

                    if(discoun>=10){
                        pricing=(pricee*quan)-((pricee*quan*discoun*0.01));
                    }else{
                        pricing=(pricee*quan)-((pricee*quan*10*0.01));
                    }
                    finalprice+=dch+pricing;
                }
            }
        }
        else{
            for(int i=0;i<this.carting.size();i++){
                Product oop=this.carting.get(i);
                int quant=this.quantity.get(i);
                int prici=oop.price;
                double dch=0;
                double pricing=0;

                if(this.Status.equals("NORMAL")){
                    int discoun=oop.normaldiscount;
                    dch=(100*quant)+((prici*quant)*0.05);
                    pricing=(prici*quant)-((prici*quant*discoun*0.01));

                    finalprice+=dch+pricing;


                }else if(this.Status.equals("ELITE") && coupons_checking==0){
                    int maxcoup=Collections.max(this.coupons);
                    int diss=oop.elitediscount;
                    dch=(100*quant);
                    if(maxcoup>=diss && maxcoup>=10){
                        pricing=(prici*quant)-((prici*quant*maxcoup*0.01));
                        coupons_checking=1;
                        finalprice+=dch+pricing;
                    }else if(diss>maxcoup && diss>10){
                        pricing=(prici*quant)-((prici*quant*diss*0.01));
                        finalprice+=dch+pricing;

                    }else{
                        pricing=(prici*quant)-((prici*quant*10*0.01));
                        finalprice+=dch+pricing;
                    }

                }else if(this.Status.equals("ELITE") &&coupons_checking==1){
                    int discoun=oop.elitediscount;
                    dch=(100*quant);
                    if(discoun>=10){
                        pricing=(prici*quant)-((prici*quant*discoun*0.01));
                    }else{
                        pricing=(prici*quant)-((prici*quant*0.1));
                    }
                    finalprice+=dch+pricing;


                }
                else if(this.Status.equals("PRIME") && coupons_checking==0){
                    int maxcoup=Collections.max(this.coupons);
                    int diss=oop.primediscount;
                    dch=(100*quant)+((prici*quant)*0.02);
                    if(maxcoup>=diss && maxcoup>=5){
                        pricing=(prici*quant)-((prici*quant*maxcoup*0.01));
                        coupons_checking=1;
                        finalprice+=dch+pricing;
                    }else if(diss>maxcoup && diss>5){
                        pricing=(prici*quant)-((prici*quant*diss*0.01));
                        finalprice+=dch+pricing;

                    }else{
                        pricing=(prici*quant)-((prici*quant*5*0.01));
                        finalprice+=dch+pricing;
                    }

                }else if(this.Status.equals("PRIME") &&coupons_checking==1){
                    dch=dch=(100*quant)+((prici*quant)*2*0.01);
                    int discoun=oop.primediscount;
                    if(discoun>=5){
                        pricing=(prici*quant)-((prici*quant*discoun*0.01));

                    }else{
                        pricing=(prici*quant)-((prici*quant*0.05));

                    }
                    finalprice+=dch+pricing;
                }
            }

        }
        return finalprice;

    }
    public double get_total_in_deals(){
        double pricc=0;
        for(int i=0;i<this.dealcart.size();i++){
            Deals dd=this.dealcart.get(i);
            pricc+=dd.combined_price;
        }
        return pricc;
    }

    public void  get_cart_empty(){
        this.carting.clear();
        this.dealcart.clear();
        System.out.println("Cart succcessfully emptied");
    }

    public void printing_order_info(){
        double finalprice=0;
        for(int i=0;i<this.carting.size()-1;i++){
            for(int j=i+1;j<this.carting.size();j++){
                if(((this.carting.get(i).price)*this.quantity.get(i))<=((this.carting.get(j).price)*this.quantity.get(j))){
                    Product mm=this.carting.get(j);
                    Integer qu=this.quantity.get(j);
                    Product mmm=this.carting.get(i);
                    Integer quu=this.quantity.get(i);
                    this.carting.set(i,mm);
                    this.quantity.set(i,qu);
                    this.carting.set(j,mmm);
                    this.quantity.set(j,quu);
                }
            }
        }

        if(this.coupons.size()==0){
            for(int i=0;i<this.carting.size();i++){
                double indidualprice=0;
                Product ppp=this.carting.get(i);
                System.out.println("Product Name:"+ppp.name);
                System.out.println("Product ID:"+ppp.Product_Id);
                System.out.println(ppp.discription);
                System.out.println("Price:"+ppp.price);

                int quan=this.quantity.get(i);


                int pricee=ppp.price;
                double dch=0;
                double pricing=0;
                if(this.Status.equals("NORMAL")){
                    int discoun=ppp.normaldiscount;
                    dch=(100*quan)+((pricee*quan)*0.05);
                    pricing=(pricee*quan)-((pricee*quan*discoun*0.01));
                    indidualprice+=dch+pricing;
                    System.out.println("Delivery charges:"+dch);
                    System.out.println("Discount:"+(pricee*quan*discoun*0.01));
                    System.out.println("Total cost ="+indidualprice);
                    finalprice+=indidualprice;
                    System.out.println("Deliveries are made within 7-10 days");
                }
                else if(this.Status.equals("PRIME")){
                    int discoun=ppp.primediscount;
                    dch=(100*quan)+((pricee*quan)*0.02);
                    System.out.println("Delivery charges:"+dch);
                    if(discoun>=5){
                        pricing=(pricee*quan)-((pricee*quan*discoun*0.01));
                        System.out.println("Discount:"+(pricee*quan*discoun*0.01));
                    }else{
                        pricing=(pricee*quan)-((pricee*quan*5*0.01));
                        System.out.println("Discount:"+(pricee*quan*5*0.01));
                    }

                    indidualprice=dch+pricing;
                    System.out.println("Total cost ="+indidualprice);
                    finalprice+=indidualprice;
                    if(indidualprice>=5000) {

                        Random xxx = new Random();
                        int dixx = xxx.nextInt(5, 15);
                        this.coupons.add(dixx);
                        System.out.println("You won 1 coupan:" + dixx);
                    }
                    System.out.println("Total Cost"+indidualprice);
                    System.out.println("Order placed. It will be delivered in 3-6 days.");


                }else if(this.Status.equals("ELITE")){
                    int discoun=ppp.elitediscount;


                    dch=(100*quan);
                    System.out.println("Delivery charges:"+dch);

                    if(discoun>=10){
                        pricing=(pricee*quan)-((pricee*quan*discoun*0.01));
                        System.out.println("Discount:"+pricee*quan*discoun*0.01);
                    }else{
                        pricing=(pricee*quan)-((pricee*quan*10*0.01));
                        System.out.println("Discount:"+pricee*quan*10*0.01);
                    }
                    indidualprice=dch+pricing;
                    System.out.println("Total cost ="+indidualprice);

                    finalprice+=indidualprice;
                    if(indidualprice>=5000) {
                        for(int k=0;k<3;k++){
                            Random xxx = new Random();
                            int dixx = xxx.nextInt(5, 15);
                            this.coupons.add(dixx);
                            System.out.println("You won" + k+1 +" coupan:" + dixx);
                        }

                    }
                    System.out.println("Total Cost"+indidualprice);
                    System.out.println("Order placed. It will be delivered in 2 days.");
                }
            }
        }
        else{
            for(int i=0;i<this.carting.size();i++){
                double indidualprice=0;
                Product oop=this.carting.get(i);
                System.out.println("Product Name:"+oop.name);
                System.out.println("Product ID:"+oop.Product_Id);
                System.out.println(oop.discription);
                System.out.println("Price:"+oop.price);
                int quant=this.quantity.get(i);
                int prici=oop.price;
                double dch=0;
                double pricing=0;

                if(this.Status.equals("NORMAL")){
                    int discoun=oop.normaldiscount;
                    dch=(100*quant)+((prici*quant)*0.05);
                    pricing=(prici*quant)-((prici*quant*discoun*0.01));
                    finalprice+=dch+pricing;

                    System.out.println("Delivery charges:"+dch);
                    System.out.println("Discount:"+(prici*quant*discoun*0.01));
                    System.out.println("Total cost ="+finalprice);
                    System.out.println("Deliveries are made within 7-10 days");
                }else if(this.Status.equals("ELITE") && coupons_checking==0){
                    int maxcoup=Collections.max(this.coupons);
                    int diss=oop.elitediscount;
                    dch=(100*quant);
                    System.out.println("Delivery charges:"+dch);
                    if(maxcoup>=diss && maxcoup>=10){
                        pricing=(prici*quant)-((prici*quant*maxcoup*0.01));
                        coupons_checking=1;
                        indidualprice=dch+pricing;
                        System.out.println("Discount:"+prici*quant*maxcoup*0.01);
                    }else if(diss>maxcoup && diss>10){
                        pricing=(prici*quant)-((prici*quant*diss*0.01));
                        indidualprice=dch+pricing;
                        System.out.println("Discount:"+prici*quant*diss*0.01);

                    }else{
                        pricing=(prici*quant)-((prici*quant*10*0.01));
                        indidualprice=dch+pricing;
                        System.out.println("Discount:"+prici*quant*10*0.01);
                    }
                    System.out.println("Total Cost"+indidualprice);
                    finalprice+=indidualprice;
                    if(indidualprice>=5000) {
                        for(int k=0;k<3;k++){
                            Random xxx = new Random();
                            int dixx = xxx.nextInt(5, 15);
                            this.coupons.add(dixx);
                            System.out.println("You won" + k+1 +" coupan:" + dixx);
                        }

                    }



                }else if(this.Status.equals("ELITE") &&coupons_checking==1){
                    int discoun=oop.elitediscount;
                    dch=(100*quant);
                    System.out.println("Delivery Charge:"+dch);
                    if(discoun>=10){
                        pricing=(prici*quant)-((prici*quant*discoun*0.01));
                        System.out.println("Discount:"+prici*quant*discoun*0.01);
                    }else{
                        pricing=(prici*quant)-((prici*quant*0.1));
                        System.out.println("Discount:"+prici*quant*0.1);
                    }
                    indidualprice=dch+pricing;
                    System.out.println("Total Cost:"+indidualprice);
                    finalprice+=indidualprice;
                    if(indidualprice>=5000) {
                        for(int k=0;k<3;k++){
                            Random xxx = new Random();
                            int dixx = xxx.nextInt(5, 15);
                            this.coupons.add(dixx);
                            System.out.println("You won" + k+1 +" coupan:" + dixx);
                        }

                    }

                }
                else if(this.Status.equals("PRIME") && coupons_checking==0){
                    int maxcoup=Collections.max(this.coupons);
                    int diss=oop.primediscount;
                    dch=(100*quant)+((prici*quant)*0.02);
                    System.out.println("Delivery Charge:"+dch);

                    if(maxcoup>=diss && maxcoup>=5){
                        pricing=(prici*quant)-((prici*quant*maxcoup*0.01));
                        System.out.println("Discount:"+prici*quant*maxcoup*0.01);
                        coupons_checking=1;
                        indidualprice=dch+pricing;
                    }else if(diss>maxcoup && diss>5){
                        pricing=(prici*quant)-((prici*quant*diss*0.01));
                        System.out.println("Discount:"+prici*quant*diss*0.01);
                        indidualprice=dch+pricing;

                    }else{
                        pricing=(prici*quant)-((prici*quant*5*0.01));
                        System.out.println("Discount:"+prici*quant*5*0.01);
                        indidualprice=dch+pricing;
                    }
                    finalprice+=indidualprice;
                    System.out.println("Total cost:"+indidualprice);
                    if(indidualprice>=5000) {

                        Random xxx = new Random();
                        int dixx = xxx.nextInt(5, 15);
                        this.coupons.add(dixx);
                        System.out.println("You won 1 coupan:" + dixx);
                    }
                    System.out.println("Order placed. It will be delivered in 3-6 days.");

                }else if(this.Status.equals("PRIME") &&coupons_checking==1){
                    dch=dch=(100*quant)+((prici*quant)*2*0.01);
                    System.out.println("Delivery Charge:"+dch);

                    int discoun=oop.primediscount;
                    if(discoun>=5){
                        pricing=(prici*quant)-((prici*quant*discoun*0.01));
                        System.out.println("Discount:"+prici*quant*discoun*0.01);


                    }else{
                        pricing=(prici*quant)-((prici*quant*0.05));
                        System.out.println("Discount:"+prici*quant*0.05);
                    }
                    indidualprice=dch+pricing;
                    System.out.println("Total Cost:"+indidualprice);
                    finalprice+=indidualprice;
                    if(indidualprice>=5000) {

                        Random xxx = new Random();
                        int dixx = xxx.nextInt(5, 15);
                        this.coupons.add(dixx);
                        System.out.println("You won 1 coupan:" + dixx);
                    }
                    System.out.println("Order placed. It will be delivered in 3-6 days.");
                }
            }

        }
        System.out.println("Total price:"+finalprice);
        this.wallet-=finalprice;
    }

}
