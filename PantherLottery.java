import java.util.Scanner;
import java.util.Random;

public class PantherLottery {
   public static void main (final String[] args) {
      int winnings = 0;          // This is for the total winnings
      int power = 0;             // This is for calculating the power amount
      final int max = 99;        // This is for the max range for allowed integers in the array
      final int gameCost = 25;   // This is the for the cost of playing one round of the game
        
      final Scanner kb = new Scanner(System.in);
        
      final int[] userArray = new int[5];       // Creating an array for user input
      final int[] winningArray = new int[5];    // Creating array for random generator
      final Random generator = new Random();

      System.out.print("Welcome Player\n\n");
      System.out.print("What is your name player: ");
      final String fname = kb.next();                  // Get first name of player
      final String lname = kb.next();                  // Get last name of player

      int credit;
      System.out.print("What is your total credit: ");
      credit = kb.nextInt();                            // Get player's credit
      System.out.print("\n\n");

      System.out.println("\t=======================================");
      System.out.println("\t Welcome to the Panther Lottery " + fname +"!");
      System.out.println("\t\t  $25 Bet per Round \n\t\t       Have Fun");
      System.out.println("\t=======================================\n\n\n");

      System.out.println("Would you like to play the lottery " + fname + "?");
      String decision1;

      System.out.print("Enter \"yes\" or \"no\": ");
      decision1 = kb.next();

      // Checking if player has enough credits to play and if the player wants to play the game
      if (credit >= gameCost && decision1.equals("yes") || decision1.equals("Yes")) {

         // If player meets all requirements program will run at least once
         do {                                                                           
            credit -= gameCost;
            System.out.print("Enter five integers, each between 1 and 99: ");

            for (int i = 0; i < 5; i++) {       // Gets 5 integers from user
               userArray[i] = kb.nextInt();
            }
                
            // Checks if user enters valid input    
            for (int k = 0; k < 5; k++) {                        
               if (userArray[k] > max || userArray[k] < 1) {
                  System.out.println("Sorry you didn't enter a valid bet please try again");
                  System.out.print("Enter five integers, each between 1 and 99: ");
                  
                  // If user enters in valid input this loop gets new input from user      
                  for (int i = 0; i < 5; i++) {                  
                     userArray[i] = kb.nextInt();
                  }
               }
            }   
                
            System.out.print("The winning numbers are: ");
              
            // This loop checks that there are no duplicates in the winning numbers    
            for (int j = 0; j < 5; j++) {                      
               for (int k = 4; k > 0; k--) {
                  if (winningArray[j] == winningArray[k] || winningArray[j] == 0) {
                     winningArray[j] = generator.nextInt(max) + 1;
                  }
               }
               final int value2 = winningArray[j];     // Displays winning numbers
               System.out.print(value2 + " ");
            }

            System.out.println(" ");
            
            // This for loop calculates the winning amount
            for (int i = 0; i < 5; i++) {                 
               for (int k = 0; k < 5; k++) {                
                  if (userArray[i] == winningArray[k]) {
                     power = i + 1;                       // Winning positions start at 1
                     winnings += Math.pow(3, power);                  
                  }
               }
            } 

            // If user wins nothing it will display this output
            if (power == 0) {                                                                 
               System.out.println("Sorry you didn't win anything, better luck next time");
               System.out.println("Your new Total Credit is: $" + credit + ".00\n");
               System.out.println("Would you like to play the lottery again " + fname + "? ");
            }

            // If user wins something it will display this output
            else {                                                                          
               System.out.println("Congratulations, you win $" + winnings + ".00");
               System.out.print("Your new Total Credit is: $" + (credit + winnings));
               System.out.println(".00\n");
               System.out.println("Would you like to play the lottery again " + fname + "? ");
            }
             
            System.out.print("Enter \"yes\" or \"no\": ");
            decision1 = kb.next();

         // This makes sure that the player keeps playing as long as they meet the requirements
         } while (credit >= gameCost && decision1.equals("yes") || decision1.equals("Yes"));
       
         // This is the initial check to see if the player has enough credits to play the game
         if (credit < gameCost) {
            System.out.println("You don't have enough credit to play this game!\n\n");
            System.out.println("Your total winnings are $" + winnings + ".00");
            System.out.println("Your new Total Credit is: $" + credit + ".00");
            System.out.print("Please see the cashier at the window for your money ");
            System.out.println(fname + " " + lname);
         }

         // This displays the total winnings after a player no longer decides to play
         else {   
            System.out.println("Your total winnings are $" + winnings + ".00");
            System.out.println("Your new Total Credit is: $" + credit + ".00");
            System.out.print("Please see the cashier at the window for your money ");
            System.out.println(fname + " " + lname);
         }
   
      }

      // This displays the total winnings if the user says "no" to play again
      else if (decision1.equals("No") || decision1.equals("no")) {   
         System.out.println("Your total winnings are $" + winnings + ".00");
         System.out.println("Your new Total Credit is: $" + credit + ".00");
         System.out.print("Please see the cashier at the window for your money ");
         System.out.println(fname + " " + lname);
      }

      // This checks if player has enough to play the game
      else if (credit < gameCost) {   
         System.out.println("You don't have enough credit to play this game!\n\n");
         System.out.println("Your total winnings are $" + winnings + ".00");
         System.out.println("Your new Total Credit is: $" + credit + ".00");
         System.out.print("Please see the cashier at the window for your money ");
         System.out.println(fname + " " + lname);
      }

      // This checks if the user enters valid input otherwise it displays an output
      else {   
         System.out.println("\nPlease enter a valid response");
      }
   }    
}


