package financeLog;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import financeLog.CashFlow.Balance;
import financeLog.CashFlow.CashFlow;
import financeLog.CashFlow.Category;
import financeLog.CashFlow.Currency;
import financeLog.CashFlow.Filters;
import financeLog.CashFlow.Income;
import financeLog.CashFlow.OperationsRecord;
import financeLog.CashFlow.Payment;
import welcomeScreen.User;
import welcomeScreen.WelcomeScreen;

public class main {

	public static void main(String[] args) throws ParseException {

		Currency.setDefaultCurrencies();
		
		Payment pay1 = new Payment(100, "Stokrotka", "Kwiaty", 0, "2022-07-01");
		Payment pay2 = new Payment(200, "Biedronka", "Żywność i chemia", 0, "2022-07-10");
		Payment pay3 = new Payment(550, "Decathlon", "Rower", 0);
		Payment pay4 = new Payment(200, "Paliwo");
		Payment pay5 = new Payment(10, "Żabka", "Watermelon lemonade", 0);
		Payment pay6 = new Payment(10, "Lody");
		Payment pay7 = new Payment(10, "Lody");
		Payment pay8 = new Payment(65, "Pamiątki");
		Payment pay9 = new Payment(100, "Wycieczki", "Hotel w Berlinie", 1);
	
		Income inc1 = new Income(1000, "Salary", "from IBM", 2);
		Income inc2 = new Income(200, "Renting a house", "Kraków", 2);
		
		System.out.println("Payments:");
		
		System.out.println(OperationsRecord.printPayments());
		
		System.out.println("Incomes: ");
		
		System.out.println(OperationsRecord.printIncomes());
		
		
//		System.out.println();
		System.out.println(Balance.getBalance());
		
		//Category.printCategories();

		System.out.println("\nŻabka only: ");
		
		System.out.println(Filters.categoryFilter("Żabka"));
		
		System.out.println("\nAmount = 200: ");
		
		System.out.println(Filters.exactAmountFilter(200));
		
		System.out.println("\nAmount > 400: ");
		
		System.out.println(Filters.moreThanAmountFilter(400));
		
		System.out.println("\nAmount < 99");
		
		System.out.println(Filters.lessThanAmountFilter(99));
		
		System.out.println("\nDate between: 30/06/2022 - 10/07/2022");
		
		System.out.println(Filters.timestampIsBetween("2022-06-30", "2022-07-10"));
				
	}
}