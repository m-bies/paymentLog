package financeLog.CashFlow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
		
		LocalDate dateAfter = LocalDate.parse(after).minusDays(1);
		LocalDate dateBefore = LocalDate.parse(before).plusDays(1);
		
		Date simpleDateAfter = new SimpleDateFormat("yyyy-MM-dd").parse(dateAfter.toString());
		Date simpleDateBefore = new SimpleDateFormat("yyyy-MM-dd").parse(dateBefore.toString());
		
		for (Payment payment : OperationsRecord.getPayments()) {
			
			if(payment.getTimestamp().after(simpleDateAfter) && payment.getTimestamp().before(simpleDateBefore)) {
				filteredPayments.add(payment);
			}
		}
		return toString(filteredPayments);
	}	
	
	public static String toString(ArrayList<Payment> filteredPayments) {
		return filteredPayments.toString().replace("[", " ").replace("]", "").replace(",", "\n");
	}
}
