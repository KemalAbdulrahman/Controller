// The Stock program is following the MVC design template and this is our controller object.
// The main functionality for buying and selling the stocks are in this controller object.
// This is the ONLY file you may edit




import java.util.LinkedList;
import java.util.Scanner;

public class Controller {
	
	public Controller() {
		LinkedList<Stock> googList = new LinkedList<Stock>();
		LinkedList<Stock> amazList = new LinkedList<Stock>();
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter 1 for Google stock or 2 for Amazon, 3 to quit: ");
			int stockSelect = input.nextInt();
			double price = 0;
			if(stockSelect == 3)
				break;
			System.out.print("Input 1 to buy, 2 to sell: ");
			int controlNum = input.nextInt();
			System.out.print("How many stocks: ");
			int quantity = input.nextInt();
			
			if(controlNum == 1) {
				System.out.print("At what price: ");
				price = input.nextDouble();
				if(stockSelect == 1) {
					Controller.buyStock(googList, "Google", quantity, price);
				}
				else
					Controller.buyStock(amazList, "Amazon", quantity, price);
			}
			else {
				System.out.print("Press 1 for LIFO accounting, 2 for FIFO accounting: ");
				controlNum = input.nextInt();
				if(controlNum == 1) {
					if(stockSelect == 1)
						Controller.sellLIFO(amazList,"amazon", quantity, stockSelect, price);
					else
						Controller.sellLIFO(amazList,"amazon", quantity,stockSelect,price);
				}
				else {
					if(stockSelect == 1)
						Controller.sellFIFO(googList, stockSelect ,"google", quantity, price);
					else
						Controller.sellFIFO(googList, stockSelect, "google", quantity, price);
				}
			}
			
		} while(true);
		input.close();
	}
			
	public static void buyStock(LinkedList<Stock> list, String name, int quantity, double price) {
		Stock temp = new Stock(name,quantity,price);
		list.push(temp);
		System.out.printf("You bought %d shares of %s stock at $%.2f per share %n", quantity, name, price);
	}
	
	public static void sellLIFO(LinkedList<Stock> list,String stockName,int stockquatity, int sellAmount,double price) {
	    // You need to write the code to sell the stock using the LIFO method (Stack)
	    // You also need to calculate the profit/loss on the sale
		int totalQuality=0;
		
		for(int i=0;i<list.size()-1;i++)
		{
			if(list.get(i).getName()==stockName)
				totalQuality+=list.get(i).getQuantity();
		}
		
		if(sellAmount<totalQuality) {
			double total=0;
			int count=0;
			boolean checkStock=true;
			for (int i=list.size();i>=0 && checkStock;i--)
				if (list.get(i).getName() == stockName){
				if (count>sellAmount) {
					int share=count-sellAmount;
					total+= share * list.get(i).getPrice();
					checkStock=false;
				}
				else {
					total+=list.get(i).getQuantity()*list.get(i).getPrice();
				}
					   
	    double profit = 0; // the price paid minus the sale price, negative # means a loss
		System.out.printf("You sold %d shares of %s stock at %.2f per share %n", sellAmount, list.element().getName(), total/sellAmount);
	    System.out.printf("You made $%.2f on the sale %n", profit);
		}
	}
}
	
	public static void sellFIFO(LinkedList<Stock> list, int sellAmount,String stockName,int stockquatity,double price) {
	    // You need to write the code to sell the stock using the FIFO method (Queue)
	    // You also need to calculate the profit/loss on the sale
		
		int totalQuality=0;
		double total;
		for(int i=list.size()-1;i>0;i--)
		{
			if(list.get(i).getName()==stockName)
				totalQuality+=list.get(i).getQuantity();
		}
		
		if(sellAmount<totalQuality) {
			total=0;
			int count=0;
			boolean checkStock=true;
			for (int i=list.size();i>=0 && checkStock;i--)
				if (list.get(i).getName() == stockName){
				if (count>sellAmount) {
					int share=count-sellAmount;
					total+= share * list.get(i).getPrice();
					checkStock=false;
				}
				else {
					total+=list.get(i).getQuantity()*list.get(i).getPrice();
				}
			
	
	    total = 0; // this variable will store the total after the sale
	    double profit = 0; // the price paid minus the sale price, negative # means a loss
		System.out.printf("You sold %d shares of %s stock at %.2f per share %n", sellAmount, list.element().getName(), total/sellAmount);
	    System.out.printf("You made $%.2f on the sale %n", profit);
	}
	
	
}
}
}