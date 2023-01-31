package financeLog.CashFlow;

import java.util.ArrayList; 

public class Category {
	
	private String name;
	private int usageCounter = 1;
	
	private static ArrayList<Category> categories = new ArrayList<>();
	
	private static ArrayList<String> categoryNames = new ArrayList<>();
	
	public Category(String name) {
		this.name = name;
		categories.add(this);
		categoryNames.add(name);
	}
	
	public static ArrayList<Category> getCategories() {
		
		return categories;
	}
	
	public static Category getCategory(Category category) {
		return category;
	}
	
	public static Category setCategory(String categoryName) {
		
		if(!categoryNames.isEmpty()) {
			
			if(categoryNames.contains(categoryName)) {
				
				for (Category category : categories) {
					
					if(category.getName() == categoryName) {
						category.usageCounter++;
						return category;
					}
				}		
			}
			/* TO JEST CHYBA NIEPOTRZEBNE
			else {
				return new Category(categoryName);
			}
			*/
		}
		return new Category(categoryName);	
	}
	
	public static String getCategoriesNames() {
		if(!categories.isEmpty()) {
			
			for (Category category : categories) {
				return category.getName();
			}
		}
		return null;			
	}

	
	public static void printCategories() {
		
		System.out.print("kategorie: \n");
		
			for(Category category : categories) {
				System.out.println(category.toString());
			}	
	}
	
	public String toString() {
		return String.format("usage: %d, %s", getUsageCounter(), getName()); 
	}
	
	public int getUsageCounter() {
		return usageCounter;
	}

	public void setUsageCounter(int usageCounter) {
		this.usageCounter = usageCounter;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toLowerCase();
	}
}

/*

public static void printCategories() {
	//return getCategories().toString().replace("[", "kategorie: ").replace("]", "").replace(",", " ");
	arrangeCategories();
	System.out.print("kategorie: ");
	for(Category category : categories) {
			System.out.print(category.getName() + " ");
		}
}




public static void arrangeCategories() {
//categories.sort(Comparator.comparing(Category::getName));
//tu napisać żeby się nie powtarzały

Category[] uniqueCategoriesArray = new Category[categories.size()];

Category[] temp = categories.toArray(new Category[categories.size()]);		
int index = 0;

for (int i = 0; i < temp.length; i++) {
	int flag = 0;
	
	for (int j = 0; j < i; j++) {
		
		if(temp[i] == uniqueCategoriesArray[j]) {
			flag = 1;
			break;
		}
	}
	if (flag == 0) {
		uniqueCategoriesArray[index] = temp[i];
		index++;
	}
}
List<String> uniqueCategories = Arrays.asList(uniqueCategoriesArray);
for(Category category : uniqueCategories) {
	System.out.print(category.getName() + " ");
}
}

*/