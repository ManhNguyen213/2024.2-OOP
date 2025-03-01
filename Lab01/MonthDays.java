import java.util.Scanner;
public class MonthDays {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String month;
		int year;
		while(true) {
			System.out.print("Enter month: ");
			month = input.next();
			System.out.print("Enter year: ");
			if (input.hasNextInt()) {
				year = input.nextInt();
				if (year < 0) {
					System.out.println("Invalid year!");
					input.nextLine();
					continue;
				}
			} else {
				System.out.println("Invalid year format!");
				input.nextLine();
				continue;
			}
			int days = getDays(month, year);
			if (days == -1) {
				System.out.println("Invalid month!");
			} else {
				System.out.println("The month of " + month + " in the year " + year + " has " + days + " days.");
				break;
			}
		}
		input.close();
	}
	public static int getDays(String month, int year) {
		switch (month.toLowerCase()) {
			case "1": case "january": case "jan.": case "jan": return 31;
			case "2": case "february": case "feb.": case "feb": return isLeapYear(year) ? 29 : 28;
			case "3": case "march": case "mar.": case "mar": return 31;
        	case "4": case "april": case "apr.": case "apr": return 30;
        	case "5": case "may": return 31;
        	case "6": case "june": case "jun.": case "jun": return 30;
        	case "7": case "july": case "jul.": case "jul": return 31;
        	case "8": case "august": case "aug.": case "aug": return 31;
        	case "9": case "september": case "sept.": case "sep": return 30;
        	case "10": case "october": case "oct.": case "oct": return 31;
        	case "11": case "november": case "nov.": case "nov": return 30;
        	case "12": case "december": case "dec.": case "dec": return 31;
        	default: return -1;
		}
	}
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}
