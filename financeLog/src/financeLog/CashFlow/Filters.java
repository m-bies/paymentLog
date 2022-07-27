package financeLog.CashFlow;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.ArrayList;

public class Filters {
	
	private static ArrayList<Payment> filteredPayments = new ArrayList<>();
	
	public static String categoryFilter(String categoryName) {
		
		filteredPayments.clear();
		
		for (Payment payment : OperationsRecord.getPayments()) {
			if(payment.getCategory().getName() == categoryName) {
				filteredPayments.add(payment);
			}
		}
		return toString(filteredPayments);
	}
	
	public static String exactAmountFilter(double amount) {
	
		filteredPayments.clear();
		
		for (Payment payment : OperationsRecord.getPayments()) {
			if(payment.getAmount() == amount) {
				filteredPayments.add(payment);
			}
		}
		return toString(filteredPayments);
	}
	
	public static String moreThanAmountFilter(double amount) {
		
		filteredPayments.clear();
		
		for (Payment payment : OperationsRecord.getPayments()) {
			if(payment.getAmount() >= amount) {
				filteredPayments.add(payment);
			}
		}
		return toString(filteredPayments);
	}
	
	public static String lessThanAmountFilter(double amount) {
		
		filteredPayments.clear();
		
		for (Payment payment : OperationsRecord.getPayments()) {
			if(payment.getAmount() <= amount) {
				filteredPayments.add(payment);
			}
		}
		return toString(filteredPayments);
	}
	
	public static String timestampIsBetween(String after, String before) throws ParseException {
		
		filteredPayments.clear();
		
		after = "01/01/2000";
		before = "10/10/2100";
		
		Date dateAfter;
		Date dateBefore;
		
		dateAfter = new SimpleDateFormat("dd/MM/yyyy").parse(after);
		dateBefore = new SimpleDateFormat("dd/MM/yyyy").parse(before);
		
		for (Payment payment : OperationsRecord.getPayments()) {
			
			if(payment.getTimestamp().after(dateAfter) && payment.getTimestamp().before(dateBefore)) {
				filteredPayments.add(payment);
			}
		}
		return toString(filteredPayments);
	}	
	
	public static String toString(ArrayList<Payment> filteredPayments2) {
		return filteredPayments.toString().replace("[", " ").replace("]", "").replace(",", "\n");
	}
}
