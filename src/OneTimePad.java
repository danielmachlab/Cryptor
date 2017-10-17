import java.util.Scanner;
import java.lang.String;
import java.util.Random;


/**
 * Driver class for EasyEncrypt. This class is used to encrypt and decrypt messages as well as manage interaction with user.
 * @author Daniel Machlab
 */
public class OneTimePad {

    /**
     * Main method for OneTimePad class. This method is used to encrypt and decrypt messages as well as manage interaction with user.
     * @param args none
     */
    public static void main(String[] args) {

        Scanner readInput = new Scanner(System.in);
        char[] userMessage;
        String enOrDecrypt = "Encrypted";

        int[] nValueArray;
        boolean needToEncrypt;

        System.out.println("OneTimePad\n---------\n");

        System.out.print("Enter message: ");
        userMessage = readInput.nextLine().toUpperCase().toCharArray();
        Random rand = new Random();
        nValueArray = new int[userMessage.length];


        System.out.print("Enter 1 to encrypt message or 0 to decrypt message: ");
        needToEncrypt = 1 == readInput.nextInt();
        readInput.nextLine();

        if (!needToEncrypt) {
            enOrDecrypt = "Decrypted";
            String nValString="";
            System.out.print("Enter n-values separated by a space: ");
            if(readInput.hasNextInt())
                nValString = readInput.nextLine();
            else
                System.out.println("error");

            readInput = new Scanner(nValString);
            int i = 0;
            while(readInput.hasNext()){
                nValueArray[i] = (readInput.nextInt()%26) * -1;
                i++;
            }
        }

        else{
            for(int i = 0; i < userMessage.length; i ++) {
                nValueArray[i] =rand.nextInt(26);
            }
        }

        EasyEncrypt e = new EasyEncrypt(userMessage, nValueArray);
        System.out.print("\nMessage: \t\t\t");
        for(int i = 0; i< userMessage.length; i++){
            System.out.print("\t"+userMessage[i]);
        }

        char[] newMessage = e.encryptDecryptMessage();
        System.out.print("\nn-values: \t\t\t");
        int nValIndex = 0;
        for(int i = 0; i<userMessage.length; i ++) {
            if(userMessage[i] == ' ' || userMessage[i] == '.')
                System.out.print("\t  ");
            else {
                System.out.print("\t" + Math.abs(nValueArray[nValIndex]));
                nValIndex++;
            }
        }

        System.out.print("\n"+ enOrDecrypt + " message: \t");
        for(int i = 0; i<userMessage.length; i++){
            System.out.print("\t" + newMessage[i]);
        }
    }
}
