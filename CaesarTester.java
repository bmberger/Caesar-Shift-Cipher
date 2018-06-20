
/**
 * Purpose: test encryption and decryption
 * @author Briana Berger
 * @version 06/07/2018
 */

import java.util.Scanner; 
public class CaesarTester
{
    public static final char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    /**
     * Constructor for objects of class CaesarTester
     */
    public CaesarTester()
    {
        // default constructor
    }
    
    public static void main(String[] args) 
    { 
        Scanner reader = new Scanner(System.in); 
        System.out.print("Enter your shift key value (0 - 25): ");
        final int shiftVal = reader.nextInt();
        if(shiftVal < 0 || shiftVal > 25)
        {
            System.out.println("Please enter a valid shift key value between 0 and 25.");
            return;
        }
        
        System.out.println("-----------------------------------------");
        
        //prints out regular and ciphered alphabet
        System.out.println("Regular Alphabet: ");
        for(char c : alphabet)
        {
            System.out.print(c);
        }
        System.out.println();
        
        System.out.println("Ciphered Alphabet: ");
        char[] cipher = Encryption.cipherABC(shiftVal, alphabet);
        for(char c : cipher)
        {
            System.out.print(c);
        }
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("Decrypted Alphabet: ");
        System.out.println(Decryption.decryptABC(shiftVal, cipher));
        System.out.println("-----------------------------------------");
        //Menu to encrypt, decrypt, or quit with user inputted messages.
        int option = 0;
        String message = "";
        while(option != 3)
        {
            System.out.println("Now, your turn! Would you like to encyrpt or decrypt a message? (or quit?)");
            System.out.println("               [1] Encrypt");
            System.out.println("               [2] Decrypt");
            System.out.println("               [3] Quit");
            System.out.print("Your choice based on the number above: ");
            option = reader.nextInt();
            System.out.println();
            if(option == 0 || option > 3)
                System.out.println("Please enter a valid option of 1, 2, or 3.");
            else if(option == 1)
            {
                System.out.print("Enter the message that you want to encrypt: ");
                reader.nextLine();
                message = reader.nextLine();
                
                String [] messageArr = new String[message.length()];
                for (int i = 0; i < message.length(); i++)
                        messageArr[i] = message.substring(i, i+1);  
                System.out.println(Encryption.cipherMessage(shiftVal, messageArr));
            }
            else if(option == 2)
            {
                System.out.print("Enter the ciphered message that you want to decrypt: ");
                reader.nextLine();
                message = reader.nextLine();
                
                System.out.print("Enter your shift key value (0 - 25): ");
                int shiftValue = reader.nextInt();
                
                String [] messageArr = new String[message.length()];
                for (int i = 0; i < message.length(); i++)
                        messageArr[i] = message.substring(i, i+1);
                System.out.println(Decryption.decryptMessage(shiftValue, messageArr));
            }
            else if(option == 3)
            {
                break;
            }
            System.out.println("-----------------------------------------");
        }
    }
}