import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentsInformation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		int studentNumber;
		String name;
		String hometown;
		String favoriteFood;
		String userSelection;
		String cont;
		
		System.out.print("Welcome to our Java class! ");
		
		do {
			System.out.print("Which student would you like to learn more about?"
					+ "(Enter a number 1-10): ");
			try {
				studentNumber = scnr.nextInt();
				name = studentName(studentNumber-1);
			} catch(IndexOutOfBoundsException e) {
				System.out.println("Invalid selection!");
				continue;
			} catch(InputMismatchException e) {
				scnr.next(); // clear the scanner token

				System.out.println("Invalid selection! Please use numeric values only.");
				String clear = scnr.nextLine();
				
				continue;
			}
			
			System.out.printf("Student %d is %s.\n", studentNumber, name);
			
			do {
				System.out.printf("What would you like to know about %s? (Enter \"hometown\""
						+ " or \"favorite food\"): ", name);
				userSelection = scnr.next();
				
				if(userSelection.equalsIgnoreCase("hometown")) {
					
					hometown = studentHometown(studentNumber-1);
					
					System.out.printf("%s is from %s. \nWould you like to know more? (Enter "
							+ "\"yes\" or \"no\"): ", name, hometown);
					cont = scnr.next();
					
					if(cont.equalsIgnoreCase("no")) {
						break;
					}
					else {
						continue;
					}
				}
				else if(userSelection.equalsIgnoreCase("favorite") && scnr.next().equalsIgnoreCase("food")) {
					
					favoriteFood = studentFavoriteFood(studentNumber-1);
					
					System.out.printf("%s's favorite food is %s. \nWould you like to know more? "
							+ "(Enter \"yes\" or \"no\"): ", name, favoriteFood);
					cont = scnr.next();
					
					if(cont.equalsIgnoreCase("no")) {
						break;
					}
					else {
						continue;
					}
				}
				else {
					System.out.println("The data selected doesn't exist. Please try again.");
					continue;
				}
			} while(true);
			System.out.print("Would you like to know more about a different student? (Enter "
					+ "\"yes\" or \"no\"): ");
			cont = scnr.next();
			if(cont.equalsIgnoreCase("no")) {
				break;
			}
			else {
				continue;
			}
		} while(true);
		System.out.println("Goodbye");
		scnr.close();
	}
	
	public static String studentName(int selection) {
		String[] name = {"Norvell", "Andre", "Taylor", "Alicia", "Brian", "Jessica", "Jamale",
				"Aaliyah", "James", "Monica"};
		
		return name[selection];	
	}
	
	public static String studentHometown(int selection) {
		String[] hometown = {"Detroit, MI", "Oak Park, MI", "Taylor, MI", "Chicago, IL", "Columbus, OH",
			"Austin, TX", "Saint Paul, MN", "Detroit, MI", "Sacramento, CA", "Salt Lake City, UT"};
	
		return hometown[selection];	
	}

	public static String studentFavoriteFood(int selection) {
		String[] favoriteFood = {"Shrimp and Chicken Alfredo", "Buffalo Wings", "Brisket", "Fries", 
			"Steak & Eggs", "Philly Cheesesteak", "Fried Pickles", "Ice Cream", "King Crab", 
			"Lamb Chops"};
	
		return favoriteFood[selection];
	}
}
