package financeLog.CashFlow;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime; 

public class CashFlow {

	private int id;  
	private double amount;
	private Category category;
	private String comment;
	private Currency currency;
	private int currencyIndex;
	private String categoryName;
	private Date timestamp;
	
	//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //("dd/MM/YYYY HH:mm:ss")
	
	static LocalDate now = LocalDate.now();
	Locale locale = new Locale("pl", "PL");
	
	//konstruktory
	public CashFlow(double amount, String categoryName, String comment, int currencyIndex, String timestamp) {
		this.amount = amount; 						
		this.comment = comment;		
		
		try {
			this.timestamp = new SimpleDateFormat("yyyy-MM-dd").parse(timestamp);
		} 
		catch (ParseException e) {
			try {
				this.timestamp = new SimpleDateFormat("yyyy-MM-dd").parse(printCurrentDate());
			} 
			catch (ParseException e1) {
				e1.printStackTrace();
				System.out.println("Nie udało się utworzyć timestamp");
			}
		}
		
		this.currencyIndex = currencyIndex; 
		this.currency = Currency.getCurrency(currencyIndex);
		this.category = Category.setCategory(categoryName);
		
	}

	public CashFlow(double amount, String categoryName, String comment, int currencyIndex) {
		this(amount, categoryName, comment, currencyIndex, printCurrentDate());
		this.amount = amount; 						
		this.comment = comment;				
		this.currencyIndex = currencyIndex; 
		this.currency = Currency.getCurrency(currencyIndex);
		this.category = Category.setCategory(categoryName);
	}
	
	public CashFlow(double amount, String category) {
		this(amount, category, "", 0, printCurrentDate());			
	}
	//konstruktory end
	
	
	
	public String toString() {
		return String.format("#%-4d %-13s %-15s %10.2f %-5s %-3s", getId(), getTimestampAsString(), getCategory().getName(), getAmount(), "zł", getComment()); 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		if(this.currency == Currency.getCurrency(2)) {
			return Currency.getCurrency(2).getRatio() * amount;
		}
		else if(this.currency == Currency.getCurrency(1)) {
			return Currency.getCurrency(1).getRatio() * amount;
		}
		else return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	
	public String getTimestampAsString() {
		return DateFormat.getDateInstance(DateFormat.DEFAULT, locale).format(timestamp);
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void setTimestamp(String date) {
				
		try {
			Date newTimestamp = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			this.timestamp = newTimestamp;
		}
		catch(Exception e) {
			System.out.println("Nie udało się utworzyć timestamp");
		}
	}
	
	public static String printCurrentDate() {
		
		return now.toString();
	}
	
	public static LocalDate returnCurrentDate() {
		
		return now;
	}
	
	
}