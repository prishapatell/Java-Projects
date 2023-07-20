
// Richard Phillips & Prisha Patel
import java.text.DecimalFormat;
import java.util.*;

public class HW2 {

  public static void main(String[] args) {
    // default values stored for these variables
    String fullName = "Erika T. Jones";
    String employeeNumber = "ej789";
    double payRate = 100.0, hoursWorked = 1.0;
    System.out.println("------------------------------------");

    // TA will change the payrate and the hours worked to test your code
    // class employee being called assigning it to variable e creating a new
    DecimalFormat myDecimalFormat = new DecimalFormat();
    myDecimalFormat.setMinimumFractionDigits(2);
    myDecimalFormat.setMaximumFractionDigits(2);

    Employee e;
    e = new Employee(fullName, employeeNumber, payRate, hoursWorked);
    // System.out.println(e); // To Test your toString method

    // e.printCheck(); // This prints the check of Erika T. Jones
    Company company = new Company();
    company.hire(e);
    company.hire(new Employee("Saeed Happy", "sh895", 2, 200));
    company.hire(new Employee("Enrico Torres", "et897", 3, 150));
    company.hire(new Employee("Prisha Patel", "pp324", 3, 150));
    // Company.printCompanyInfo(); //Prints company info
    // You may add as many employees to company as you want.
    // The TAs will add their own employees
    // Make sure that each employee of company has a unique employeeNumber

    company.printCheck("sh895"); // checks to see if an employee has that employeeNumber
    System.out.println("------------------------------------");
    //company.deleteEmployeesBySalary(94.0); //deletes employee if they equal max salary
    //company.reverseEmployees(); // reverses the employees 
    // System.out.println(company.SearchByName("Prisha")); // will return true or false if the person is found in the employee list
    // Company.printEmployees(); // Will print out company name/tax id/ # of employees
    // System.out.println("Bye!"); // Shows that program is over and everything is printed out
    
  }
}

// ________________________________________________________________
class Employee {

  // Add the private attributes and the methods as mentioned above...
  private String fullName;
  private String employeeNumber;
  private double payRate;
  private double hoursWorked;

  public Employee(String fullName, String employeeNumber, double payRate, double hoursWorked) {
    this.fullName = fullName;
    this.employeeNumber = employeeNumber;
    this.payRate = payRate;
    this.hoursWorked = hoursWorked;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(String employeeNumber) {
    this.employeeNumber = employeeNumber;
  }

  public double getPayRate() {
    return payRate;
  }

  public void setPayRate(double payRate) {
    this.payRate = payRate;
  }

  public double getHoursWorked() {
    return hoursWorked;
  }

  public void setHoursWorked(double hoursWorked) {
    this.hoursWorked = hoursWorked;
  }

  public void printCheck() {
    DecimalFormat myDecimalFormat = new DecimalFormat("0.00");
    System.out.println("Employee's name: " + fullName);
    System.out.println("Employee's number: " + employeeNumber);
    System.out.println("Employee's pay: " + myDecimalFormat.format(payRate));
    System.out.println("Employee's hours: " + myDecimalFormat.format(hoursWorked));
  }

  @Override // Overrides the implicit toSting from println() and return what is stated below
  public String toString() {
    DecimalFormat myDecimalFormat = new DecimalFormat("0.00");
    return ("[" +
        employeeNumber +
        "/" +
        fullName +
        ", " +
        myDecimalFormat.format(hoursWorked) +
        " Hours @ " +
        myDecimalFormat.format(payRate) +
        " per hour]");
  }

  public double netPay() {
    double grossPay = payRate * hoursWorked;
    double tax = grossPay * 0.06;
    return grossPay - tax;
  }

}

// ________________________________________________________________
class Company {

  private static ArrayList<Employee> employeeList;
  private static String companyName;

  public static String getCompanyName() {
    return companyName;
  }

  public static void setCompanyName(String companyName) {
    Company.companyName = companyName;
  }

  private static String companyTaxId;

  public static String getCompanyTaxId() {
    return companyTaxId;
  }

  public static void setCompanyTaxId(String companyTaxId) {
    Company.companyTaxId = companyTaxId;
  }

  // Add static Setters and Getters for companyName and companyTaxId
  // No need to add a Setter and Getter for employeeList

  public Company() {
    employeeList = new ArrayList<>();
    companyName = "People's Place";
    companyTaxId = "v1rtua7C0mpan1";
    employeeList = new ArrayList<Employee>();
  }

  public boolean hire(Employee employee) {
    // Add empoyee to employeeList
    // Note well that we can't add an employee whose employeeNumber already
    // //assigned to another employee. In that case, this method returns false.
    // This method returns true otherwise

    for (Employee employ : employeeList) {
      if (employ.getEmployeeNumber().equals(employee.getEmployeeNumber())) {
        System.out.println("Employee number already assigned.");
        return false;
      }
    }
    employeeList.add(employee);
    return true;
  }

  public static void printCompanyInfo() {
    // This method prints the compay name, its tax id and the current number //of
    // employees
    // You may choose to print that any way you like!
    System.out.println(
        "Company Name: " +
            companyName +
            " | Tax Id: " +
            companyTaxId +
            " | # of Employees: " +
            employeeList.size());

  }

  public static void printEmployees() {
    for (Employee employee : employeeList) {
      System.out.println(employee);
    }
    // This methods prints all employees (One employee per line)
    // Note that you already have toString in Employee
  }

  public int countEmployees(double maxSalary) {
    //This method returns the number of employees paid less than maxSalary
    int total = 0;
    for (Employee employee : Company.employeeList) {
      if (employee.netPay() < maxSalary) {
        total++;
      }
    }
    return total;
  }

  public boolean searchByName(String fullName) {
    // This method returns true if fullName exists as an employee.
    // It returns false otherwise
    // this is a not a case sensitive search.

    for (Employee employee : employeeList) {
      if (employee.getFullName().equalsIgnoreCase(fullName)) {
        return true;
      }
      break;
    }
    return false;
  }

  public boolean SearchByName(String fullName) {
    // This method returns true if fullName exists as an employee.
    // It returns false otherwise
    // this is a not a case sensitive search.

    for (Employee employee : employeeList) {
      if (employee.getFullName().equalsIgnoreCase(fullName)) {
        return true;
      }
      break;
    }
    return false;
  }

  public void reverseEmployees() {
    // This method reverses the order in which the employees were added to //the
    // list. The last employee is swapped with the first employee, the second last
    // with the second and so on..
    Collections.reverse(employeeList);
  }


  public void deleteEmployeesBySalary(double targetSalary) {
    // This method deletes all employees who are paid targetSalary as a net
    // salary
    int initialSize = employeeList.size();
    int count = 0;

    for (int i = 0; i < employeeList.size(); i++) {
      Employee employee = employeeList.get(i);
      if (employee.netPay() == targetSalary) {
        employeeList.remove(i);
        i--;
        count++;
      }
    }

    if (count > 0) {
      System.out.println("Deleted " + count + " employee(s) with net salary " + targetSalary);
    } else {
      System.out.println("No employees with net salary " + targetSalary + " found.");
    }

    int remainingSize = employeeList.size();
    System.out.println("Employees remaining: " + remainingSize + " (before deletion: " + initialSize + ")");
  }

  public void printCheck(String employeeNumber) {
    // This method prints the check of the employee whose employee number is
    // employeeNumber. It prints NO SUCH EMPLOYEE EXISTS if employeeNumber is
    // not a registered employee number.
    Employee employee = null;
    for (Employee employ : employeeList) {
      if (employ.getEmployeeNumber().equals(employeeNumber)) {
        employee = employ;
        break;
      }
    }

    if (employee != null) {
      String fullName = employee.getFullName();
      double payRate = employee.getPayRate();
      double hoursWorked = employee.getHoursWorked();
      double grossPay = payRate * hoursWorked;
      double tax = grossPay * 0.06;
      double netPay = grossPay - tax;

      DecimalFormat myDecimalFormat = new DecimalFormat("0.00");
      System.out.println("Employee's name: \t" + fullName);
      System.out.println("Employee's number: \t" + employeeNumber);
      System.out.println("Hourly rate of pay: \t" + myDecimalFormat.format(payRate));
      System.out.println("Hours worked: \t\t" + myDecimalFormat.format(hoursWorked));
      System.out.println("\nTotal Gross Pay: \t$" + myDecimalFormat.format(grossPay) + "\n");
      System.out.println("Deductions:");
      System.out.println("Tax (6%): \t\t$" + myDecimalFormat.format(tax) + "\n");
      System.out.println("Net Pay: \t\t" + myDecimalFormat.format(netPay) + " Dollars\n");
    } else {
      System.out.println("NO SUCH EMPLOYEE EXISTS");
    }
  }
}
// End of Class Company
