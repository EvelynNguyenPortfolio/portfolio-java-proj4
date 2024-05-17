import java.util.HashMap;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Part2 {
    public static void main (String[] args)
    {
        //declare HashMap, Scanner, and DecimalFormat object
        HashMap<String, Double> pizzaCost = new HashMap<>();
        HashMap<String, String> pizzaSize = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#.00");

        //declare userSize and anotherPizza variables
        String userSize;
        int anotherPizza;
        //initialize tax variable
        final double tax = 0.08;

        //put key and values into the HashMaps
        pizzaSize.put("S", "small pizza");
        pizzaSize.put("M", "medium pizza");
        pizzaSize.put("L", "large pizza");
        pizzaSize.put("XL", "x-large pizza");

        pizzaCost.put("S", 14.5);
        pizzaCost.put("M", 19.5);
        pizzaCost.put("L", 22.99);
        pizzaCost.put("XL", 28.5);

        //print menu using pizzaSize HashMap
        System.out.println("The below list shows the available pizza sizes:");
        for (String size: pizzaSize.keySet())
        {
            System.out.println("Enter "+size+" for a "+pizzaSize.get(size));
        }
        //loop obtaining key and printing value of pizzaCost HashMap
        do {
        //prompt user to enter a pizza size
            System.out.println("Please enter your pizza size.");
            userSize = scan.next();
            userSize = userSize.toUpperCase();
        //use .containsKey() method to check if the pizza size the user inputted is a key in the HashMap and print value of the pizza size key if it is in the HashMap
            if(pizzaCost.containsKey(userSize))
            {
                System.out.println("You entered "+userSize+" for a "+pizzaSize.get(userSize)+".");
                System.out.println("Price: $"+formatter.format(pizzaCost.get(userSize)));
                System.out.println("Tax: $"+formatter.format(pizzaCost.get(userSize)*tax));
                double total = pizzaCost.get(userSize)+ (pizzaCost.get(userSize)*tax);
                System.out.println("Total: $"+formatter.format(total));
                System.out.println("Would you like to enter another size? Enter 1 for yes and 2 for no.");
                anotherPizza = scan.nextInt();
            }else
            {
                System.out.println("Sorry, the size you entered is not one of the sizes listed above. Would you like to enter another size? Enter 1 for yes and 2 for no.");
                anotherPizza = scan.nextInt();
            }
            System.out.println();
        //repeat loop if anotherPizza is equal to 1
        }while(anotherPizza==1);
    }
}
