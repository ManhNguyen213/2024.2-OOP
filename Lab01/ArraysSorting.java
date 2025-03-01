import java.util.Arrays;
import java.util.Scanner;
public class ArraysSorting {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Number of elements: ");
		int size = input.nextInt();
		int[] myArray = new int[size];
		System.out.println("Enter " + size + " numbers:");
		for (int i=0; i<size; i++) {
			myArray[i] = input.nextInt();
		}
		Arrays.sort(myArray);
		int sum = 0;
		for (int num : myArray) {
			sum += num;
		}
		double average = (double) sum / size;
		System.out.println("Sorted Array: " + Arrays.toString(myArray));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        input.close();
	}
}
