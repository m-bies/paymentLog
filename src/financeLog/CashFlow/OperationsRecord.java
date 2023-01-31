package financeLog.CashFlow;

import java.util.ArrayList;

public class OperationsRecord {
	
	private static ArrayList<Payment> payments = new ArrayList<>();
	private static ArrayList<Income> incomes = new ArrayList<>();
	
	public static CashFlow getCashFlow(CashFlow cashFlow) {
		return cashFlow;
	}	

	public static ArrayList<Payment> getPayments() {
		return payments;
	}
	
	public static ArrayList<Income> getIncomes() {
		return incomes;
	}
	
	public static String printPayments() {
		return getPayments().toString().replace("[", " ").replace("]", "").replace(",", "\n");
	}
	
	public static String printIncomes() {
		return getIncomes().toString().replace("[", " ").replace("]", "").replace(",", "\n");
	}
		
	public static void quickAddPayment(Payment payment) {
		getPayments().add(payment);
	}	

	public static void quickAddIncome(Income income) {
		getIncomes().add(income);
	}	
}