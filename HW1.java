/*
 * Prisha Patel
 * COP 3330
 * Hatim Boustique
 * Unit 1 HW 1
 */

// Import Everything Rather Than Scanner, Will Be More Beneficial To Me 
import java.util.*;
import java.text.DecimalFormat;

public class HW1 
{
    public static void main(String[] atgs)
    {
        // Scans The User's Inputs
        Scanner Scan = new Scanner(System.in);

        // Ask The User For Their ID
        System.out.println("Enter the Student's ID: ");
        String  id = Scan.nextLine();
        
        // Ask The User For Their Name
        System.out.println("Enter the Student's full name: ");
        String name = Scan.nextLine();
        
        // Ask The User For Their CRN/Credit Hours For First Class
        String [] first;
            System.out.println("Enter CRN/Credit hours for the First Class (like 5665/3)");        
            String info1 = Scan.nextLine();
            first = info1.split ("/");
        
        // Ask The User For Their CRN/Credit Hours For Second Class
        String [] second;
            System.out.println("Enter CRN/Credit hours for the Second Class (like 5665/3)");        
            String info2 = Scan.nextLine();
            second = info2.split ("/");

        // Indicates To Close The System To Stop Letting Outside Inputs Be Implemented After Stating Close
        Scan.close();

        // Set Values For Credit Hours & Health Fee
        Double healthCharge = 35.00;
        Double credit = 120.25;
        Double credit1 = Integer.parseInt(first[1]) * credit;
        Double credit2 = Integer.parseInt(second[1]) * credit ;
        Double totalCredit = credit1 + credit2 + healthCharge;    

        // Print Fee Invoice
        System.out.println("\nThank You!\nHERE IS THE FEE INVOICE...\n\n");
        System.out.println("              SIMPLE COLLEGE\n              ORLANDO FL 10101\n              **************************************");
        System.out.println("              Fee Invoice Prepared for:\n              [" + name + "][" + id + "]\n              1 Credit Hour = $" + credit);
        System.out.println("\n              CRN     CREDIT HOURS");
        
        // Decimal Formating For Prices
        String pattern="###,###.00";
        DecimalFormat df = new DecimalFormat(pattern);    
        System.out.println("              " + first[0] + "     " + first[1] + "                 $" + df.format(credit1));
        System.out.println("              " + first[0] + "     " + second[1] + "                 $" + df.format(credit2));        
        
        System.out.println("\n                      Health & ID Fees   $" + df.format(healthCharge));
        System.out.println("              --------------------------------------------------");
        System.out.println("                      Total Payments     $" + df.format(totalCredit));
    }
}
