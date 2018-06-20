/**
 * Purpose: To decrypt the user's text and then print out the decrypted message.
 *
 * @author Briana Berger
 * @version 06/07/2018
 */

import java.util.Scanner; 
public class Decryption extends CaesarTester
{
    /**
     * Constructor for objects of class Decryption
     */
    public Decryption()
    {
        // default constructor
    }
    
    /**
     * Static method to generate the decryption based on the key and the base char array.
     * Used for alphabet decryption.
     */
    public static String decryptABC(int shift, char[] base)
    {
        String decryptedMessage = "";
        for(char d : base)
        {
            decryptedMessage += d;
        }
        
        return decryptedMessage.substring(base.length - shift) + decryptedMessage.substring(0,base.length - shift);
    }
    /**
     * Static method to generate the decryption based on the key and the base char array.
     * Used for message decryption.
     */
    public static String decryptMessage(int shift, String[] base)
    {
        String[] abc = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String cipheredMessage = "";
        String[] ciphered = new String[base.length];
        int val = abc.length - 1;

        for(int i = 0; i < ciphered.length; i++)
        {
            for (int k = 0; k < abc.length; k++)
            {
                if(abc[k].equalsIgnoreCase(base[i]))
                {
                    if(k - shift >= 0)
                    {
                        ciphered[i] = abc[k - shift];
                    }
                    else
                    {
                        ciphered[i] = abc[(val - k) + (shift - 1)];
                    }
                }
                else if(base[i].equals(" "))
                {
                    ciphered[i] = " ";
                }
            }
        }
        
        for(String c : ciphered)
        {
            cipheredMessage += c;
        }
        return cipheredMessage;
    }
}