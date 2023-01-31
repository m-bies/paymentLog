package financeLog.CashFlow;

import java.util.concurrent.atomic.AtomicInteger;

public class Income extends CashFlow {
	
	private static AtomicInteger nextId = new AtomicInteger();
	
	public Income(double amount, String categoryName, String comment, int currencyIndex) {
		super(amount, categoryName, comment, currencyIndex);
		OperationsRecord.quickAddIncome(this);
		setId(nextId.getAndIncrement());
	}
	
	public Income(double amount, String categoryName) {
		this(amount, categoryName, "", 0);	
	}	
}
