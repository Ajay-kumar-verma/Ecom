import java.util.*;

public class Ecom {
 
    public static void main(String []args){

   
    for(;;)
    {
      try{  

      System.out.println("....... Menu ......"); 
      System.out.print("1 : Order Product"); 
      System.out.println("\t2 : Add item ");
      System.out.print("3 : Remove Item ");
      System.out.println("\t4 : history"); 
     
      System.out.print("Enter you choice : ");
      Scanner sc= new Scanner(System.in);
         
     switch(sc.nextInt())
      {
        case 1:
        Fun.Order();
        break;
        case 2:
        Fun.Add_item();
        break;

        case 3:
        Fun.Remove_item();
        break;
        
        case 4:
        Fun.History();
        break; 
        default:
        System.out.println("`````````Invalid Choice `````````");
        break;
       
    } 
       
     System.out.println ("___________________________________________________________"); 
 
    }
    catch(Exception e){System.out.println("Invalid Entry :" +e);}

    }  
    
  }

}

/*----------------------------------------------------------------*/
class Fun{
static Product root=new Product("Shampoo",100,300);
static int  count=1; 

static void  Order(){
 count=1;
  System.out.print("Enter your Name  : ");
Scanner sc=new Scanner(System.in); 
String name =sc.nextLine();
System.out.println("\t\t\tName\t\tprice\t\tquantity");
LowHigh(root);
// System.out.println(" ");
Highlow(root);
System.out.println(" ");
System.out.println("\t\tOrder Finished .....\n\t\tThank you :) "+name);
}


// Displaying product
static void LowHigh(Product temp){
  if(temp==null)
       return;
  LowHigh(temp.ll);
  System.out.println("\t\t\t"+temp.product_name+"\t\t"+temp.price+"\t\t"+temp.quanties);
  LowHigh(temp.rl);
}


static void Highlow(Product temp){
  count++;
  if(temp==null)
      return;
 Highlow(temp.rl);
 System.out.println("\t\t\t"+temp.product_name+"\t\t"+temp.price+"\t\t"+temp.quanties);
 Highlow(temp.ll);

 
}



// -----------------------------------------------
// Adding item in EcomStore 
static void  Add_item(){
  Scanner sc= new Scanner(System.in);
  System.out.print("Enter Product name : ");
  String product_name= sc.nextLine().split(" ")[0];
  System.out.print("Enter Product Price : ");
  int  product_price= Integer.parseInt(sc.nextLine().split(" ")[0]);
  //it will read whole line and take first value
  System.out.print("Enter Product quantity : ");
  int product_quantity=Integer.parseInt(sc.nextLine().split(" ")[0]);
  Product new_Product=new Product(product_name,product_price,product_quantity);

  Product temp=root;
  Product prev=null;
 while(temp!=null) 
  {      prev=temp;
    if(product_price<temp.price)
    {     temp=temp.ll;}
    else
    {  temp=temp.rl; }     
  }


  if(product_price<prev.price)
   prev.ll=new_Product;
  else
  prev.rl=new_Product;


System.out.println("Add item....");
}

static void  Remove_item(){
    System.out.println("Remove  item....");
 }
    
    

static void  History(){
System.out.println("History......");
}




}





/*--------------------------------------------------------------*/
// Product class 
class Product
{
 int quanties;
 int price;
 String product_name; 
  Product(String product_name,int price,int quanties)
    {
      this.quanties= quanties;
      this.price= price;
      this.product_name= product_name;;
    }

  Product ll=null;
  Product rl=null;
}