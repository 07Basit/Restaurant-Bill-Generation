import java.io.*;
import java.util.*;

public class billitemsdis
{

	public static void main(String[] args) 
	{
		 //Declaring prices
		 int vburgerprice= 49;    //price of veg burger.
		 int chburgerprice= 89;	  //price of chicken burger.
		 int paburgerprice= 69;	  //price of paneer burger.
		 int vhburgerprice= 55;	  //price of veg spicy burger.
	     int chhburgerprice= 99;  //price of chicken spicy burger.
	     int pahburgerprice= 78;  //price of paneer spicy burger.
		 int pfriesprice= 49;     //price of plain fries.
		 int heatppprice= 54;	  //price of heat peri peri fries.
		 int spfriesprice= 65;	  //price of sweet potato fries.
		 int lsodaprice= 49;	  //price of lemon soda.
		 int ccolaprice= 54;	  //price of coca cola.
		 int forangeprice= 65;	  //price of fun orange.
		
		//CALLING THE menuPrinting function from class menuDisplay to display the menu
		 menuDisplay menup = new menuDisplay(); // creating an object of class MenuDisplay
		 menup.menuPrinting();					//calling the menuPrinting function to display the menu
		
		 
		 //Entering items
		System.out.println("\n\n\n\t\t\t\t\t   ***** ENTER THE ITEMS FOR BILL GENERATION *****\n\n");
	
	    int itemnumber=1; 	//initializing itemnumber containing the specific number of item.
	    int totalitems=0;	// initializing totalitems which contains the total number of items.
	    
	    double totalprice = 0;
	    
	    //for the temp bill calcualtion
	    
	    int subtotalprice = 0; //initializing subtotalprice which will store the calculated value of the total price bfore taxes.
	    int quantity=0;		   //initializing quantity which stores the quantity of the a particular item to calculate subtotalprice.
	    int foodprice;		   //declaring the foodprice variable which stores the price of item for calculation.
	    
	    //for the final bill calculation
	    
	    double sgst;				//declaring the sgst variable which calculates the sgst on the subtotalprice.
	    double cgst;				//declaring the cgst variable which calculates the cgst on the subtotalprice.
	    double totaltax; 			//adding sgst and cgst
	    double totalbill;			//declaring the totalbill which stores the total bill with taxes.
	    
		System.out.println("\n\n\tTotal number of items: "+totalitems);
		
		
		
		//CREATING A FILE
		File myFile = new File("data1.txt");	//creating an object myFile of File class to create a file
		
		try 
		{
			myFile.createNewFile();				//Creating a file using createNewFile() method with the help of myFile object
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}//file created using createNewFile method
		
		
		
		//WRITING THE FILE 
		
		try 
		{
			FileWriter output = new FileWriter("data1.txt");	//creating an object output of class FileWriter to write into a file
			
			output.write("\t\tBILL ITEMS\n\n");						//Writing data into file using write method with the help of output object
			
			output.close();										//closing the file
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		char q;   //choice variable declaration for the do-while loop
		
		//start of the do while loop for adding items to the list 
		do
		{
			
			  System.out.println("\tPlease enter your " +itemnumber+ " order code");
			    
			  Scanner sc = new Scanner(System.in);  //creating a object with Scanner class
			  String itcode = sc.next();   //Accepting the food item code with itcode storing the code of each item.
			    

			    //start of switch case
			  	switch(itcode)
			    {
			    	case "vb": //veg burger
			    		System.out.println("\tVeg burger\tRs."+vburgerprice);
			    		System.out.println("\tPlease enter the quantity:");
			    		quantity = sc.nextInt(); //Accepting the food item code
			    		foodprice=vburgerprice;
			    		
			    		int temp_price=Sub.sum(quantity,foodprice); //calling the static function sum with class Sub
			    		subtotalprice = subtotalprice+temp_price;   //Calclulating subtotalprice(price before taxes)
			    		
			    		//Working with strings to store in file
			    		String iquantity = String.valueOf(quantity);	//converting the item quatinty from int to string
			    		String iprice = String.valueOf(temp_price);		//converting the item price from int to string
			    		
			    		String itemname = "                Veg burger ";		//string which will print the item name
			    		String vbspace = "                    ";		
			    		String ibillprint = itemname.concat(iquantity).concat(vbspace).concat(iprice);	//concatenating all the strings to print ibilprint which conatins item name, quantity and price
			    		
			    		//Appending items to the file
					     try 
					     {
					    	//creating an object orderp to use FileWriter method which will append the file
					    	 FileWriter orderp = new FileWriter("data1.txt",true);	//Here, true is a boolean value which will append the file data1.txt
					    	 orderp.write(ibillprint);			//Writing the ibillprint containing item name, quantity and value in the file
					    	 orderp.close();					//Closing the file
					     } 
					     catch (IOException e) 
					     {
					    	 // TODO Auto-generated catch block
					    	 e.printStackTrace();
					     }
			    		
					     break;
			    	
			    	case "cb": //Chicken burger
			    		System.out.println("\tChicken burger\tRs."+chburgerprice);
			    		System.out.println("\tPlease enter the quantity:");
			    		quantity = sc.nextInt();
			    		foodprice=chburgerprice;
			    		
			    		int temp_price1=Sub.sum(quantity,foodprice);
			    		subtotalprice = subtotalprice+temp_price1;
			    		
			    		//Working with strings to store in file
			    		String jquantity = String.valueOf(quantity);	
			    		String jprice = String.valueOf(temp_price1);	
			    		
			    		String jitemname = "\n                Chicken burger ";	
			    		String jbspace = "                ";		
			    		String jbillprint = jitemname.concat(jquantity).concat(jbspace).concat(jprice);
			    		
			    		//Appending items to the file
					     try 
					     {
					    	 FileWriter orderp = new FileWriter("data1.txt",true);	
					    	 orderp.write(jbillprint);			
					    	 orderp.close();					
					     } 
					     catch (IOException e) 
					     {
					    	 // TODO Auto-generated catch block
					    	 e.printStackTrace();
					     }
			    		break;
			    	
			    	case "pb": //Paneer burger
			    		System.out.println("\tPaneer  burger\tRs."+paburgerprice);
			    		System.out.println("\tPlease enter the quantity:");
			    		quantity = sc.nextInt();
			    		foodprice=paburgerprice;
			    		
			    		int temp_price2=Sub.sum(quantity,foodprice);
			    		subtotalprice = subtotalprice+temp_price2;
			    		
			    		//Working with strings to store in file
			    		String kquantity = String.valueOf(quantity);	
			    		String kprice = String.valueOf(temp_price2);		
			    		
			    		String kitemname = "\n                Paneer burger ";		
			    		String kbspace = "                ";		
			    		String kbillprint = kitemname.concat(kquantity).concat(kbspace).concat(kprice);	
			    		
			    		//Appending items to the file
					     try 
					     {
					    	 FileWriter orderp = new FileWriter("data1.txt",true);	
					    	 orderp.write(kbillprint);			
					    	 orderp.close();					
					     } 
					     catch (IOException e) 
					     {
					    	 // TODO Auto-generated catch block
					    	 e.printStackTrace();
					     }
			    		break;
		    		
			    	case "vh" :	//Veg spicy burger
			    		System.out.println("\tVeg spicy burger\tRs."+vhburgerprice);
			    		System.out.println("\tPlease enter the quantity:");
			    		quantity = sc.nextInt();
			    		foodprice=vhburgerprice;
			    		
			    		int temp_price3=Sub.sum(quantity,foodprice);
			    		subtotalprice = subtotalprice+temp_price3;
			    		
			    		//Working with strings to store in file
			    		String lquantity = String.valueOf(quantity);	
			    		String lprice = String.valueOf(temp_price3);		
			    		String litemname = "\n                Veg sp burger ";		
			    		String lbspace = "                ";		
			    		String lbillprint = litemname.concat(lquantity).concat(lbspace).concat(lprice);	
			    		
			    		//Appending items to the file
					     try 
					     {
					    	 FileWriter orderp = new FileWriter("data1.txt",true);	
					    	 orderp.write(lbillprint);			
					    	 orderp.close();				
					     } 
					     catch (IOException e) 
					     {
					    	 // TODO Auto-generated catch block
					    	 e.printStackTrace();
					     }
		    		    break;

			    	case "ch": 	//Chicken spicy burger
			    		System.out.println("\tChicken spicy burger\tRs."+chhburgerprice);
			    		System.out.println("\tPlease enter the quantity:");
			    		quantity = sc.nextInt();
			    		foodprice=chhburgerprice;
			    		
			    		int temp_price4=Sub.sum(quantity,foodprice);
			    		subtotalprice = subtotalprice+temp_price4;
			    		
			    		//Working with strings to store in file
			    		String mquantity = String.valueOf(quantity);	
			    		String mprice = String.valueOf(temp_price4);		
			    		
			    		String mitemname = "\n                Chicken sp burger ";		
			    		String mbspace = "                ";		
			    		
			    		String mbillprint = mitemname.concat(mquantity).concat(mbspace).concat(mprice);	
			    		
			    		//Appending items to the file
					     try 
					     {
					    	 FileWriter orderp = new FileWriter("data1.txt",true);	
					    	 orderp.write(mbillprint);			
					    	 orderp.close();					
					     } 
					     catch (IOException e) 
					     {
					    	 // TODO Auto-generated catch block
					    	 e.printStackTrace();
					     }
		    		    break;
		    		
			    	case "ph": 	//Paneer spicy burger
			    		System.out.println("\tPaneer spicy burger\tRs."+pahburgerprice);
			    		System.out.println("\tPlease enter the quantity:");
			    		quantity = sc.nextInt();
			    		foodprice=pahburgerprice;
			    		
			    		int temp_price5=Sub.sum(quantity,foodprice);
			    		subtotalprice = subtotalprice+temp_price5;
			    		
			    		//Working with strings to store in file
			    		String nquantity = String.valueOf(quantity);	//converting the item quatinty from int to string
			    		String nprice = String.valueOf(temp_price5);		//converting the item price from int to string
			    		
			    		String nitemname = "\n                Paneer sp burger ";		//string which will print the item name
			    		String nbspace = "                ";		
			    		String nbillprint = nitemname.concat(nquantity).concat(nbspace).concat(nprice);	//concatenating all the strings to print ibilprint which conatins item name, quantity and price
			    		
			    		//Appending items to the file
					     try 
					     {
					    	 FileWriter orderp = new FileWriter("data1.txt",true);	
					    	 orderp.write(nbillprint);			
					    	 orderp.close();					
					     } 
					     catch (IOException e) 
					     {
					    	 // TODO Auto-generated catch block
					    	 e.printStackTrace();
					     }
		    		    break;
		    		
		    		case "pf": 	//Plain fries
		    			System.out.println("\tPlain Fries\tRs."+pfriesprice);
		    			System.out.println("\tPlease enter the quantity:");
			    		quantity = sc.nextInt();
			    		foodprice=pfriesprice;
			    		
			    		int temp_price6=Sub.sum(quantity,foodprice);
			    		subtotalprice = subtotalprice+temp_price6;
			    		
			    		//Working with strings to store in file
			    		String oquantity = String.valueOf(quantity);	
			    		String oprice = String.valueOf(temp_price6);		
			    		
			    		String oitemname = "\n                Plain fries ";		
			    		String obspace = "                ";		
			    		
			    		String obillprint = oitemname.concat(oquantity).concat(obspace).concat(oprice);	
			    		
			    		//Appending items to the file
					     try 
					     {
					    	 FileWriter orderp = new FileWriter("data1.txt",true);	
					    	 orderp.write(obillprint);		
					    	 orderp.close();					
					     } 
					     catch (IOException e) 
					     {
					    	 // TODO Auto-generated catch block
					    	 e.printStackTrace();
					     }
			    		
		    		    break;
		    		
			    	case "ppf":  //Hot peri peri fries
			    		System.out.println("\tHot Peri Peri Fries\tRs."+heatppprice);
			    		System.out.println("\tPlease enter the quantity:");
			    		quantity = sc.nextInt();
			    		foodprice=heatppprice;
			    		
			    		int temp_price7=Sub.sum(quantity,foodprice);
			    		subtotalprice = subtotalprice+temp_price7;
			    		
			    		//Working with strings to store in file
			    		String pquantity = String.valueOf(quantity);	
			    		String pprice = String.valueOf(temp_price7);		
			    		
			    		String pitemname = "\n                H periperi Fries ";		
			    		String pbspace = "                ";		
			    		String pbillprint = pitemname.concat(pquantity).concat(pbspace).concat(pprice);	
			    		
			    		//Appending items to the file
					     try 
					     {
					    	 FileWriter orderp = new FileWriter("data1.txt",true);	
					    	 orderp.write(pbillprint);			
					    	 orderp.close();					
					     } 
					     catch (IOException e) 
					     {
					    	 // TODO Auto-generated catch block
					    	 e.printStackTrace();
					     }
			    		break;
		    		
			    	case "spf":  //Sweet potato fries
			    		System.out.println("\tSweet Potato fries\tRs."+spfriesprice);
			    		System.out.println("\tPlease enter the quantity:");
			    		quantity = sc.nextInt();
			    		foodprice=spfriesprice;
			    		
			    		int temp_price8=Sub.sum(quantity,foodprice);
			    		subtotalprice = subtotalprice+temp_price8;
			    		
			    		//Working with strings to store in file
			    		String qquantity = String.valueOf(quantity);	
			    		String qprice = String.valueOf(temp_price8);		
			    		
			    		String qitemname = "\n                S.potato fries ";		
			    		String qbspace = "                ";		
			    		String qbillprint = qitemname.concat(qquantity).concat(qbspace).concat(qprice);	
			    		
			    		//Appending items to the file
					     try 
					     {
					    	 FileWriter orderp = new FileWriter("data1.txt",true);	
					    	 orderp.write(qbillprint);			
					    	 orderp.close();					
					     } 
					     catch (IOException e) 
					     {
					    	 // TODO Auto-generated catch block
					    	 e.printStackTrace();
					     }
		    		    break;
			    	
			    	case "l": 	 //lemon soda
			    		System.out.println("\tlemon Soda\tRs."+lsodaprice);
			    		System.out.println("\tPlease enter the quantity:");
			    		quantity = sc.nextInt();
			    		foodprice=lsodaprice;
			    		
			    		int temp_price9=Sub.sum(quantity,foodprice);
			    		subtotalprice = subtotalprice+temp_price9;
			    		
			    		//Working with strings to store in file
			    		String rquantity = String.valueOf(quantity);	
			    		String rprice = String.valueOf(temp_price9);		
			    		
			    		String ritemname = "\n                lemon soda ";		
			    		String rbspace = "                ";		
			    		
			    		String rbillprint = ritemname.concat(rquantity).concat(rbspace).concat(rprice);	
			    		
			    		//Appending items to the file
					     try 
					     {
					    	 FileWriter orderp = new FileWriter("data1.txt",true);	
					    	 orderp.write(rbillprint);			
					    	 orderp.close();					
					     } 
					     catch (IOException e) 
					     {
					    	 // TODO Auto-generated catch block
					    	 e.printStackTrace();
					     }
		    		    break;
		    		
			    	case "coc":  //Coca cola
			    		System.out.println("\tCoca Cola\tRs."+ccolaprice);
			    		System.out.println("\tPlease enter the quantity:");
			    		quantity = sc.nextInt();
			    		foodprice=ccolaprice;
			    		
			    		int temp_price10=Sub.sum(quantity,foodprice);
			    		subtotalprice = subtotalprice+temp_price10;
			    		
			    		//Working with strings to store in file
			    		String squantity = String.valueOf(quantity);	
			    		String sprice = String.valueOf(temp_price10);		
			    		
			    		String sitemname = "\n                Coca Cola ";		
			    		String sbspace = "                ";		
			    		String sbillprint = sitemname.concat(squantity).concat(sbspace).concat(sprice);	
			    		
			    		//Appending items to the file
					     try 
					     {
					    	 FileWriter orderp = new FileWriter("data1.txt",true);	
					    	 orderp.write(sbillprint);			
					    	 orderp.close();					
					     } 
					     catch (IOException e) 
					     {
					    	 // TODO Auto-generated catch block
					    	 e.printStackTrace();
					     }
		    		    break;
		    		
			    	case "o": 	 //Fun Orange
			    		System.out.println("\tFun Orange\tRs."+forangeprice);
			    		System.out.println("\tPlease enter the quantity:");
			    		quantity = sc.nextInt();
			    		foodprice=forangeprice;
			    		
			    		int temp_price11=Sub.sum(quantity,foodprice);
			    		subtotalprice = subtotalprice+temp_price11;
			    		
			    		//Working with strings to store in file
			    		String tquantity = String.valueOf(quantity);	
			    		String tprice = String.valueOf(temp_price11);		
			    		
			    		String titemname = "\n                Fun Orange ";		
			    		String tbspace = "                ";		
			    		String tbillprint = titemname.concat(tquantity).concat(tbspace).concat(tprice);	
			    		
			    		//Appending items to the file
					     try 
					     {
					    	FileWriter orderp = new FileWriter("data1.txt",true);	
					    	 orderp.write(tbillprint);			
					    	 orderp.close();					
					     } 
					     catch (IOException e) 
					     {
					    	 // TODO Auto-generated catch block
					    	 e.printStackTrace();
					     }
			    		break;
		    		
			    	
		    		default : 
		    			System.out.println("\t*****INVALID CODE ENTERED! PLEASE TRY AGAIN*****");
			    }	//end of switch case
			    
			    itemnumber++; //incrementing the item number
			  
			    totalitems++;	//totalitems is incremented after each order
			
			System.out.println("\tTotal number of items:\t"+totalitems); 
			
			
			System.out.println("\n\n\tDo you want to add more items?\t Y for yes and N for no\n");
			
			q = sc.next().charAt(0); //accepting choice to whether continue adding items to cart or not
			
		}while(q=='y'||q=='Y'); //end of do-while loop
	    
		
		
		invoiceInfo pbill = new invoiceInfo();	//creating an object pbill for the invoiceInfo class
		
		pbill.infobill_print();  //calling the information page of the final bill
		pbill.billno_print();	//calling the random bill no(invoice number) method from the class invoiceInfo
		pbill.datetimeprint();	//calling the date and time printing method from the class invoiceInfo
		
		
		
		//Reading the file 
		
		File thisfile = new File("data1.txt");	//creating an object thisfile with class File to access the file data1.txt
		
		try 
		{
			Scanner sa = new Scanner(thisfile);	//sa is an object created to read through the file
			while(sa.hasNextLine())				//while loop to access all the data of the file
			{
				String line = sa.nextLine();	// transferring all the data of file to string line
				System.out.println(line);		//printing the string line which prints the bill items with quantity and price
			}
			
			sa.close();							//closing the file
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//total price before taxes
		System.out.println("\n\t\tTOTAL PRICE BEFORE TAXES\t"+subtotalprice);
		
		System.out.println("\n\t\t-------------------------------------");
		
		//Calulating the taxes
		sgst = 2.5*subtotalprice/100;	//sgst calculation.
		cgst = 2.5*subtotalprice/100;					//As sgst and cgst taxes are the same, So the sgst calculated value is also given to cgst
		totaltax = sgst+cgst;
		
		//Displaying the TAXES
		System.out.println("\n\t\tTAXES:\t");
		System.out.println("\n\t\tSGST 2.5%\t\t\t"+sgst); //displaying sgst tax
		System.out.println("\n\t\tCGST 2.5%\t\t\t"+cgst);	//displaying cgst tax
		System.out.println("\n\t\tTOTAL TAXES\t\t\t"+totaltax);	//displaying cgst tax
		
		System.out.println("\n\t\t-------------------------------------");
		
		totalbill = totaltax + subtotalprice;	//total bill(AFTER TAXES) = sgst+cgst+price before taxes
		
		
		//Displaying the total bill
		System.out.println("\n\t\tTOTAL BILL AFTER TAXES\t\t"+totalbill);
		
		System.out.println("\n\t\t-------------------------------------");
	
		System.out.println("\n\t\tService Category: Restaurant");
		
		System.out.println("\n\t\t*************CHECK CLOSED************");
		
		System.out.println("\n\t\t\t PLEASE VISIT US AGAIN\t");
	
	}	//END OF MAIN METHOD

}	//END OF THE CLASS CONTAINING THE MAIN METHOD


//CLASS TO DISPLAY THE MENU OPTIONS

class menuDisplay
{
	public void menuPrinting()
	{
		System.out.println("\t\t\t\t\t\t---------------------------------");
		System.out.println("\t\t\t\t\t\t| WELCOME TO THE BURGER FACTORY |");
		System.out.println("\t\t\t\t\t\t---------------------------------");
		System.out.println("\n\t\t\t\t\t\t     ***** MENU PAGE *****");
		System.out.println("\n\n\t---Item(code of item)---");
		
		//start of the menu
		
		//Burgers
		System.out.print("\n\n\n\tBURGERS:");
		System.out.print("\tVeg.Burger(vb)\t        Chicken Burger(cb)\t     Paneer Burger(pb)");
		System.out.print("\n\t\t\t     49\t\t\t        89\t\t             69\n\n");
		System.out.print("\n\n\t\t\tVeg spicy Burger(vh)     Chicken spicy Burger(ch)      Paneer spicy Burger(ph)");
		System.out.print("\n\t\t\t     55\t\t\t        99\t\t             78");
		
		//Fries
		System.out.print("\n\n\n\n\tFRIES:");
		System.out.print("\t\tPlain Fries(pf)\t        Hot peri peri Fries(ppf)     Sweet Potato Fries(spf)");
		System.out.print("\n\t\t\t     49\t\t\t        54\t\t             65\n");
				
		//Beverages
		System.out.print("\n\n\n\tBEVERAGES:");
		System.out.print("\tLime Soda(l)\t        Coca Cola(coc)                Fun Orange(o)");
		System.out.print("\n\t\t\t     49\t\t\t        54\t\t           65\n");
	
	}//menuPrinting method ends

} //END OF menuDisplay CLASS


//CLASS WITH STATIC FUNCTION WHICH CALCULATES THE PRICE BEFORE TAXES.
class Sub
{
	static int sum(int quant,int fprice)
	{
		int subtotal;
		subtotal = quant*fprice;   //subtotal or price before taxes declared locally here calculates by multiplying the amount and quantity.
		return subtotal;          //subtoal returns the total price before taxes.
	}
}	//END OF Sub CLASS


class invoiceInfo
{
	public void  infobill_print()
	{
		System.out.println("\n\n\n\t\t\tTHE BURGER FACTORY\n");
		System.out.println("\t\tShop No.4,Manish Market,Manish Nagar\n\t\t4 Bungalows,Andheri(W),Mumbai-400 053");
		System.out.println("\n\t\t   Contact no. 9834838282\n\t\t   Email: theburgerfact@gmail.com\n\t\t   Website www.theburgerfactory.com");
		System.out.println("\n\t\t-------------------------------------\t");
		System.out.println("\n\t\t\t   TAX INVOICE");
		System.out.println("\n\t\t   GST NO. 27AAECB7044K1WH");
	}
	
	public void billno_print()
	{
		Random rnd = new Random();
		int b1= rnd.nextInt(10000000);
		
		System.out.println("\n\t\t   INVOICE NUMBER:   "+"100"+b1);
	}
	
	
	public void datetimeprint()
	{
		Date date = new Date();
		System.out.println("\n\t\t"+date.toString()+"\n\t\tOrder Type: DINE IN");
		
		System.out.println("\n\t\t-------------------------------------\t");
	}
}