// 2.2.5: Sum, difference, product, and quotient of 2 double numbers
import javax.swing.JOptionPane;
public class CalculateNumbers {
   public static void main(String[] args) {
      String firstNumber, secondNumber;
      double number1, number2;
      firstNumber = JOptionPane.showInputDialog(null, "Input first number:", "Input", JOptionPane.INFORMATION_MESSAGE);
      number1 = Double.parseDouble(firstNumber);
      secondNumber = JOptionPane.showInputDialog(null, "Input second number:", "Input", JOptionPane.INFORMATION_MESSAGE);
      number2 = Double.parseDouble(secondNumber);
      double sum = number1 + number2;
      double difference = number1 - number2;
      double product = number1 * number2;
      String quotient;
      if (number2 != 0) {
         quotient = String.valueOf(number1/number2);
      } else {
         quotient = "Can't divide";
      }
      String result = "Sum: " + sum + "\n" + "Difference: " + difference + "\n" + "Product: " + product + "\n" + "Quotient: " + quotient;
      JOptionPane.showMessageDialog(null, result, "Results", JOptionPane.INFORMATION_MESSAGE);
      System.exit(0);
   }
}