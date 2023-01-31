package financeLog.CashFlow;

import java.util.ArrayList;

public class Currency {
	private String name;
	private String displayName;
	private double ratio;
	private static ArrayList<Currency> currencies = new ArrayList<>();
	
	
	public Currency(String name, double ratio, String displayName) {
		this.name = name;
		this.ratio = ratio;
		this.displayName = displayName;
	}
	
	public static void setDefaultCurrencies() {
		
		Currency PLN = new Currency("PLN", 1, "zł");
		Currency USD = new Currency("USD", 3.5, "$");
		Currency EUR = new Currency("EUR", 4.7269, "\u20ac");
		
		currencies.add(PLN);
		currencies.add(EUR);
		currencies.add(USD);		
	}
	
	public String toString() {
		return String.format("%d %2.4f %s", getName(), getRatio(), getDisplayName()); 
	}
	
	public static Currency getCurrency(int index) {
		return currencies.get(index);
	}
	
	public void printCurrencies() {
		
		try {
			for(Currency currency : currencies) {
				System.out.println(currency.toString() + "\n");
			}
		}
		catch(Exception e) {
			System.out.println("No currencies set");
		}	
	}
	
	public double getRatio() {
		return ratio;
	}
	
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}	
	
}
