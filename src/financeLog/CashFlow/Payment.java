package financeLog.CashFlow;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Payment extends CashFlow {
	
	private static AtomicInteger nextId = new AtomicInteger();
	
	public Payment(double amount, String categoryName, String comment, int currencyIndex, String timestamp) {
		super(amount, categoryName, comment, currencyIndex, timestamp);
		OperationsRecord.quickAddPayment(this);
		setId(nextId.getAndIncrement());
	}
	
	public Payment(double amount, String categoryName, String comment, int currencyIndex) {
		this(amount, categoryName, comment, currencyIndex, printCurrentDate());
		OperationsRecord.quickAddPayment(this);
		setId(nextId.getAndIncrement());
		
	}
	
	public Payment(double amount, String categoryName) {
		this(amount, categoryName, "", 0, printCurrentDate());	
	}
}