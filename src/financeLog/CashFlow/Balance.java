package financeLog.CashFlow;

public class Balance {
	
	private static double balance;
	private static double dt, ct;
	
	public static double getBalance() {
		
		for (CashFlow cashFlow : OperationsRecord.getPayments()) {
			ct = cashFlow.getAmount() + ct;
		}
		System.out.println("money spent: " + ct + " zł");
		
		for (CashFlow cashFlow : OperationsRecord.getIncomes()) {
			dt = cashFlow.getAmount() + dt;
		}
		System.out.println("money received: " + dt + " zł");
		
		System.out.print("balance: ");
		return dt - ct;
	}

	public static void setBalance(double balance) {
		Balance.balance = balance;
	}
}