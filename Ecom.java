import java.util.*;

public class Ecom {
 
    public static void main(String []args){

   
    for(;;)
    {
      try{  

      System.out.println("....... Menu ......"); 
      System.out.println("1 : Order Product\t2 : Upadte item "); 
      System.out.println("3 : Add Item\t4 : Remove item ");
      System.out.println("5 : history\t6 : No of customer"); 
      System.out.println("7 : sort items ");
      System.out.print("Enter you choice : ");
      Scanner sc= new Scanner(System.in);
         
     switch(sc.nextInt())
      {
        case 1:
        Fun.Order();
        break;
        case 2:
        Fun.Update();
        break;
        
        case 3:
        Fun.Add_item();
        break;

        case 4:
        Fun.Remove_item();
        break;
        
        case 5:
        Fun.History();
        break; 

        case 6:
        Fun.Customer();
        break; 
        
        case 7:
        Fun.sort();
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
static LinkedList<Product> head=new LinkedList<Product>();
static{ head.add(new Product("Shampoo",100,300));  head.add(new Product("Power",50,400));  }
static Stack<Product> history=new Stack<Product>();


// THIS IS FOR ORDER 
static void  Order(){
  Iterator i= head.iterator();
   if(!i.hasNext())
   {
     System.out.println("Stock Empty.....!");
     return;
   }

System.out.print("Enter your Name  : ");
Scanner sc=new Scanner(System.in); 
String name =sc.nextLine();
System.out.println("\t\tName\tprice\tquantity"+"\t\t"+"Name\tprice\tquantity");
while(i.hasNext()){
// i.next() // it return Obects type 
  Product p1=(Product)i.next();
  System.out.print("\t\t"+p1.product_name+"\t"+p1.price+"\t"+p1.quanties);
  if(i.hasNext()){
    Product p2=(Product)i.next();
    System.out.print("\t\t\t"+p2.product_name+"\t"+p2.price+"\t"+p2.quanties);
  }
  System.out.println();
}
System.out.println("\t\tOrder Finished .....\n\t\tThank you :) "+name);
// END OF ORDER 
}





static void Update(){
  Scanner sc= new Scanner(System.in); 
  System.out.println("Enter product name to Update ");
  String pname=sc.nextLine().split(" ")[0];
  Iterator i= head.iterator();
  Boolean found=false;
  Product node=null;
  while(i.hasNext()){
  Product p=(Product)i.next();
      if(p.product_name.equalsIgnoreCase(pname)){
            node=p; 
            found=true;
            break;
      }
  }
  
  if(found){
    System.out.println("Enter new price and quantity : ");
    node.price=sc.nextInt();
     int q= sc.nextInt();
     if(q==0)
        head.remove(node);
    else    
     node.quanties=q;
  
  }else{
    System.out.println("Item doesnt exist...!");
  }
  
  System.out.println("Item updated...!");
  //UPDATE SECTION 
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
  head.add(new_Product);   
  
System.out.println("item added....!");

// added items....!
}





static void  Remove_item(){
Scanner sc= new Scanner(System.in); 
System.out.println("Enter product name to remove ");
String pname=sc.nextLine().split(" ")[0];
Iterator i= head.iterator();
Boolean del=false;
while(i.hasNext()){
Product p=(Product)i.next();
    if(p.product_name.equalsIgnoreCase(pname)){
             head.remove(p);
             System.out.println("Data removed ....!");
             del=true;
             break;
    }
}

 if(!del)
    System.out.println("Item doesnt exist ....!");
 

System.out.println("``````````````````````````````````````````` ");
// REMOVED ITEMS...!
 }
    
    




static void  History(){

  System.out.println("History....!");
  
  // HISTORY  
  }
  

static void Customer(){

  System.out.println("Details of customer ....!");
}

static void  sort(){

System.out.println("Enter value for sorting in order ");
System.out.println("11 : Ascending Item name  \t12 Descending Item name  ");
System.out.println("21 : Ascending Price \t22 Descending price ");
System.out.println("31 : Ascending quantity \t32 Descending quantity ");
Scanner sc= new Scanner(System.in); 
int n= sc.nextInt ();
if(n==11)
//  head.;
// Collections.sort(head);
 
 if(n==12)
 Collections.sort(head,(Product o1,Product o2)-> o1.product_name.compareTo(o2.product_name));
 if(n==12)
 Collections.sort(head,(Product o1,Product o2)-> o2.product_name.compareTo(o1.product_name));
 

if(n==21)
  Collections.sort(head,(Product o1,Product o2)->o1.price-o2.price);
 if(n==22)
  Collections.sort(head,(Product o1,Product o2)-> -o1.price+o2.price);


 if(n==31)
  Collections.sort(head,(Product o1,Product o2)->o1.quanties-o2.quanties);
 if(n==32)
  Collections.sort(head,(Product o1,Product o2)-> -o1.quanties+o2.quanties);

// System.out.println("This issection is for sorting ...!");
}


// Function class 
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

}