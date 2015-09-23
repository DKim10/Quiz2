package MainPackage;
import java.util.Scanner;

public class LoanRepaymentCalculator {
	
	//creates private data field InitialTuition
	private double InitialTuition;
	
	//creates private data field TuitionIncrease
	private double TuitionIncrease;
	
	//creates private data field Repayment
	private int Repayment;
	
	//creates private data field APR
	private double APR;
	
	//creates get method for InitialTuition
	public double getInitialTuition() {
		return InitialTuition;
	}
	
	//creates get method for TuitionIncrease
	public double getTuitionIncrease() {
		return TuitionIncrease;
	}
	
	//creates get method for Repayment
	public int getRepayment() {
		return Repayment;
	}
	
	//creates get method for APR
	public double getAPR() {
		return APR;
	}
	
	
	//creates set method for InitialTuition
	//Parameter: bill - takes in user input
	//Stored as double
	public void setInitialTuition(double bill){
		this.InitialTuition = bill;
		
	}
	
	//creates set method for TuitionIncrease
	//Parameter: percent - takes in user input 
	//Stored as double
	public void setTuitionIncrease(double percent){
		this.TuitionIncrease = (percent/100);
		
	}
	
	//creates set method for Repayment
	//Parameter: years - take in user input
	//stored as double
	public void setRepayment(int years){
		this.Repayment = years;
		
	}
	
	//creates set method for APR
	//Parameter: percent takes in user input
	//stored as double
	public void setAPR(double percent){
		this.APR = (percent)/100;		
	}	
	
	public double totalTuitionCost(){
		//Calculates total tuition for all 4 years of college
		//Parameters: None
		//Returns double TotalTuitionCost
		
		//sets TotalTuitionCost to the first year cost of college
		//stored as double
		double totalTuitionCost = this.getInitialTuition();
		
		//for loop calculates tuition increase for the next three years and adds to totalTuitionCost
		for(int years = 1; years < 4; years++) {
			totalTuitionCost += ((totalTuitionCost * this.getTuitionIncrease()) + totalTuitionCost);
		}
		return totalTuitionCost;
	}
	
	public double monthlyPayment() {
		//Calculates required monthly payments to pay off debt
		//Parameters: None
		//Returns: double monthlyPayment
		
		//Calculates monthly payment cost
		//store as double
		double monthlyPayment = totalTuitionCost()*((this.getAPR()/12)/((1-Math.pow((1+(this.getAPR()/12)),-this.getRepayment()))));
		return monthlyPayment;
	}
	
	public static void main(String[] args){
		//Given the inputs from user in set methods, it calculates total tuition cost and monthly repayment required for loan
		//Parameters: None
		//Returns: None
		
		//Creates new instance for class
		LoanRepaymentCalculator input = new LoanRepaymentCalculator();
		
		Scanner user_input = new Scanner(System.in);
		
		//Below initializes set methods within main function to set values for data fields
		
		//Prompts user for initial tuition
		//input is passed into set method InitialTuition
		System.out.println("How much is your initial tuition?");
		input.setInitialTuition(user_input.nextDouble());
		
		//Prompts user for initial increase
		//input is passed into set method tuitionIncrease
		System.out.println("What is the percent tuition increase?");
		input.setTuitionIncrease(user_input.nextDouble());
		
		//Prompts user for years of repayment
		//input is passed into set method Repayment
		System.out.println("How many years do you plan to repay loan?");
		input.setRepayment(user_input.nextInt());
		
		//Prompts user for initial tuition
		//input is passed into set method
		System.out.println("What is your APR?");
		input.setAPR(user_input.nextDouble());
		
		user_input.close();
		
		//initializes calculation functions for total cost of tuition and monthly payments
		double totalTuitionCost = input.totalTuitionCost();
		double monthlyPayment = input.monthlyPayment();
		
		//Prints total cost of tuition for 4 years of college
		System.out.printf("Your total cost of tuition will be $%.2f.\n", totalTuitionCost);
		
		//Prints monthly payment cost to payback student loan
		System.out.printf("Your monthly payment cost will be $%.2f.\n", monthlyPayment);
	}

}
