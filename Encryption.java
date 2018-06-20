
/**
 * Purpose: To encrypt the user's text and then print out the encrypted message.
 *
 * @author Briana Berger
 * @version 06/07/2018
 */

import java.util.Scanner; 
public class Encryption extends CaesarTester
{
    /**
     * Constructor for objects of class Encryption
     */
    public Encryption()
    {
        // default constructor
    }
    
    /**
     * Static method to generate the cipher based on the key and the base char array.
     * Used for alphabet cipher.
     */
    public static char[] cipherABC(int shift, char[] base)
    {
        String cipheredMessage = "";
        char[] ciphered = new char[base.length];
        int j = 0;

        for(int i = shift; i < base.length; i++)
        {
            ciphered[j] = base[i];
            j++;
        }
        
        int i = 0;
        while(ciphered[base.length - 1] == (char) 0)
        {
            ciphered[j] = base[i];
            j++;
            i++;
        }
        
        return ciphered;
    }
    /**
     * Static method to generate the cipher based on the key and the base char array.
     * Used for message cipher.
     */
    public static String cipherMessage(int shift, String[] base)
    {
        String[] abc = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String cipheredMessage = "";
        String[] ciphered = new String[base.length];
        int val = 1;

        for(int i = 0; i < ciphered.length; i++)
        {
            for (int k = 0; k < abc.length; k++)
            {
                if(abc[k].equalsIgnoreCase(base[i]))
                {
                    if(k + shift < abc.length)
                    {
                        ciphered[i] = abc[k + shift];
                    }
                    else
                    {
                        ciphered[i] = abc[(abc.length - (val + k)) + (shift - 1)];
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
