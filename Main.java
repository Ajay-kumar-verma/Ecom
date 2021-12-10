import java.util.Scanner;
public class Main
{

  static Scanner sc = new Scanner (System.in);
  static Node head = new Node (1, "1", 1);
  static dnode dhd = new dnode ("1", "1", "1", 1);
  static
  {
    Node temp = new Node (100, "A", 100);
    head.next = temp;
  }



  static int updatecount = 0;
  public static void main (String[]args)
  {
    for (;;)
      {
	      System.out.println ("Menu\n1 Order product\n2 See detail\n3 Update");
        int choice = sc.nextInt ();
    	switch (choice)
	     {
	      case 1:order ();  break;
	      case 2:detail (); break;
	      case 3:update (); break;
	      default:System.out.println ("Invalid choice");
        break;
	     }

      }

  }


  // THIS IS FOR ORDER 
 public  static void order ()
  {
    Node temp = head.next;
    if (temp == null)
      {System.out.println ("Sorry stock Empty"); return; }

     String name;
     System.out.println ("Please Enter your name ");
     name = sc.next();
    	System.out.println("Choose your product:\nName\tquanties\tprice\tName\tquanties\tprice");
    
    while (temp != null)
      {
	      System.out.print (temp.pnam + "\t" + temp.no + "\t\t" + "$" +temp.prc + "\t");
        temp = temp.next;
	      if(temp == null)
	       break;

	       System.out.print (temp.pnam + "\t" + temp.no + "\t\t" + "$" +temp.prc);
         temp = temp.next;
         System.out.println();
      }

    System.out.println ();
    System.out.println ("for cancellation Enter -1, any time");
    System.out.println ("Product name:");

    int nofp = 0;
    int price = 0;
    String pnam;
    String sp = " ";

    //search product

    while (true)
      {
	pnam = sc.next ();
	if (pnam.equals ("-1"))
       return;
	sp = sp + " , " + pnam;
	temp = head;
	while (temp != null)
	  {
    if (pnam.equals (temp.pnam))
      {
		nofp = temp.no;
		price = temp.prc;
		break;
	      }
   temp = temp.next;
	  }

	if (temp != null)
	  {
	    break;
	  }

	System.out.println ("soory :( " + pnam + " is not in stock");
      }
    System.out.println ("Enter Quanty");
    int no;
    while (true)
      {
	no = sc.nextInt ();
 if (no == -1)
	  return;

	if (0 < no && no <= nofp)
	  {
    break;
	  }
	System.out.println ("please order less than or equals to " + nofp);
      }





   System.out.println ("Just pay $" + no * price + " for " + no + " " +pnam);
   System.out.println ("If you want to buy type BUY");
   String n = sc.next ();

   if (n.equals ("-1"))
      return;

    if (!(n.equals ("BUY")))
      order ();

    temp = head;
    Node prv = head;
    while (temp != null)
     {
	prv = temp;
	temp = temp.next;
	if (pnam.equals (temp.pnam))
	  {
	    if (nofp == no)
	      {
		prv.next = temp.next;
	      }
	    temp.no = nofp - no;
	    break;

	  }

      }

    System.out.println ("Thank you " + name + ":) Visit again ");


//storing history
    dnode tmp = new dnode (name, sp, pnam, no);
   tmp.next = dhd.next;

    dhd.next = tmp;

  }
// END OF ORDER



  // this is function for details
  public  static void detail ()
  {
   dnode tmp = dhd.next;
    if (tmp == null)
      {
	System.out.println ("NO HISTORY");
	return;
      }

    while (tmp != null)
      {

	System.out.println ("Name of customer: " + tmp.cnam);

	System.out.println ("Searched product: " + tmp.spnam);

	System.out.println ("bought product :" + tmp.pnam);

	System.out.println ("No of product bought: " + tmp.no);

	System.out.println ("---------------------------------");

	tmp = tmp.next;

      }

  }

  static void update ()
  {

    System.out.println ("Enter product name.");

    String pnam = sc.next ();

    System.out.println ("Enter quanties.");

    int pnamber = sc.nextInt ();

    System.out.println ("Enter price in $.");

    int prc = sc.nextInt ();

    if (pnamber == 0)
      {

	System.out.println ("Not updated");
	return;

      }

    ++updatecount;

//updatecount++;

    Node temp = new Node (pnamber, pnam, prc);

    temp.next = head.next;

    head.next = temp;

    return;

  }

}





//this node may be inside main class 

//or outside of main class





class dnode
{

  String cnam, spnam, pnam;

  int no;

    dnode (String name, String prodnam, String buyprod, int no)
  {

    this.cnam = name;

    this.spnam = prodnam;

    this.pnam = buyprod;

    this.no = no;

  }

  dnode next;

//pnam product name or buy product name

//cname customer name

//no of product buy or present





}



















class Node
{

  int no;

  String pnam;

  int prc;

  String cnam, spnam;



    Node (int x, String name, int prc)
  {

    this.no = x;

    this.pnam = name;

    this.prc = prc;

  }





  Node next = null;

}

