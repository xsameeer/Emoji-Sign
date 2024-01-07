/*************
*Program name: Emoji Sign
*Program Description: This program calculates the surface area, volume, and total cost of the signs for Happy R Us customers that 
would like to order a custom Emoji sign. The total cost consists of the volume of neon gas to fill the sign, the surface area or 
amount of plastic to construct the sign, the number of letters in the message for the sign, and the emoji selected for the sign.
--------------------------------------------------------------------------------------------
*Name: Sameer Ali 
*Version date: 02/25/2023
*CMSC 255 901
***************/

import java.text.DecimalFormat;
import java.util.Scanner;

public class EmojiSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //SET choice = yes
        String choice = "yes";
        
        //WHILE choice = “yes”
        while (choice.equals("yes")) {
            //OUTPUT “Enter the radius: ”
            System.out.println("Enter the radius: ");
            //INPUT radius
            double radius = scanner.nextDouble();

            scanner.nextLine(); // consume the leftover newline character
            
            //OUTPUT “Enter the string you would like on your sign: ”
            System.out.println("Enter the string you would like on your sign: ");
            //INPUT text
            String text = scanner.nextLine();
            String textWithoutSpaces = text.replace(" ", "");

            //OUTPUT “Select emoji for the other side of the sign: ”
            System.out.println("Which emoji would you like on your sign: ");
            //INPUT selection
            String selection = scanner.nextLine();
            int emojiCost = 0;
            
            //if (selection == "glasses" || selection == "cool" || selection == "four eyes")
            if (selection.equalsIgnoreCase("glasses") || selection.equalsIgnoreCase("cool") || selection.equalsIgnoreCase("4 eyes")) {
                //emojiCost = 500
                emojiCost = 500;
                //else if (selection == "without glasses" || selection == "wink" || selection == "smile")
            } else if (selection.equalsIgnoreCase("without glasses") || selection.equalsIgnoreCase("wink") || selection.equalsIgnoreCase("smile")) {
                //emojiCost = 450
                emojiCost = 450;
            } else {
                //Output “Selection was invalid, please try again”
                System.out.println("Selection was invalid, please try again.");
                continue;
            }
            //surfaceArea = 4pi r^2
            double surfaceArea = 4 * Math.PI * Math.pow(radius, 2);
            //sphereVolume = (4/3)pi r^3
            double sphereVolume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
            //COUNT text and store in numberOfCharacters
            int numberOfCharacters = textWithoutSpaces.length();
            //Calculate neonGas by multiplying 3.45 by sphereVolume
            double neonGas = 3.45 * sphereVolume;
            //Calculate plasticPrice by multiplying 2.75 by surfaceArea
            double plasticPrice = 2.75 * surfaceArea;
            //Calculate charCost by multiplying 4.5 by numberOfCharacters
            double charCost = 4.5 * numberOfCharacters;
            //Calculate totalCost by emojiCost + neonGas + plasticPrice + charCost
            double totalCost = emojiCost + neonGas + plasticPrice + charCost;

            DecimalFormat df = new DecimalFormat("#,##0.00");
            // Round the totalCost to 2 decimal places using the DecimalFormat class and add commas
            String formattedTotalCost = df.format(totalCost);

            //OUTPUT “Your sign with ” + text + “will cost “ + totalCost 
            System.out.println("Your sign with \"" + text + "\" will cost $" + formattedTotalCost);

            //OUTPUT “Would you like to create another sign? Enter yes to continue.”
            System.out.println("Would you like to create another sign? Enter yes to continue.");
            // INPUT choice
            choice = scanner.next();
        }

        scanner.close();
    }
}
