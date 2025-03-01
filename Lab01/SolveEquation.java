import javax.swing.JOptionPane;
public class SolveEquation {
   public static void main(String[] args) {
      String[] options = {"Linear Equation", "Linear System", "Quadratic Equation"};
      int choice = JOptionPane.showOptionDialog(null, "Choose type of equation:", "Equation Solver", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
      switch(choice) {
         case 0: solveLinearEquation(); break;
         case 1: solveLinearSystem(); break;
         case 2: solveQuadraticEquation(); break;
         default: JOptionPane.showMessageDialog(null, "Invalid");
      }
   }
   public static void solveLinearEquation() {
      double a = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient a:"));
      double b = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient b:"));
      if (a==0) {
         if (b==0) {
            JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions.");
         } else {
            JOptionPane.showMessageDialog(null, "The equation has no solution.");
         }
      } else {
         double x = -b/a;
         JOptionPane.showMessageDialog(null, "The solution is x = " + x);
      }
   }
   public static void solveLinearSystem(){
      double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11:"));
      double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12:"));
      double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21:"));
      double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22:"));
      double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1:"));
      double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2:"));
      double D = a11 * a22 - a21 * a12;
      double D1 = b1 * a22 - b2 * a12;
      double D2 = a11 * b2 - a21 * b1;
      if (D != 0) {
         double x1 = D1/D;
         double x2 = D2/D;
         JOptionPane.showMessageDialog(null, "The solution is:\nx1 = " + x1 + "\nx2 = " + x2);
      } else {
         if (D1 == 0 && D2 == 0) {
            JOptionPane.showMessageDialog(null, "The system has infinitely many solutions.");
         } else {
            JOptionPane.showMessageDialog(null, "The system has no solution.");
         }
      }
   }
   public static void solveQuadraticEquation() {
      double a = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient a:"));
      double b = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient b:"));
      double c = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient c:"));
      if (a==0) {
         solveLinearEquation();
         return;
      }
      double delta = b * b - 4 * a * c;
      if (delta > 0) {
         double x1 = (-b + Math.sqrt(delta)) / (2 * a);
         double x2 = (-b - Math.sqrt(delta)) / (2 * a);
         JOptionPane.showMessageDialog(null, "The equation has two distinct roots:\nx1 = " + x1 + "\nx2 = " + x2);
      } else if (delta == 0) {
         double x = -b/(2*a);
         JOptionPane.showMessageDialog(null, "The equation has a double root: x = " + x);
      } else {
         double real = -b / (2*a);
         double imaginary = Math.sqrt(-delta) / (2*a);
         JOptionPane.showMessageDialog(null, "The equation has two complex roots:\nx1 = " + real + " + " + imaginary + "i\nx2 = " + real + " - " + imaginary + "i");
      }
   }
}