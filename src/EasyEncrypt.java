import java.lang.String;


/**
 * EasyEncrypt contains field and methods used directly to encrypt/decrypt.
 */
public class EasyEncrypt {


    private int[] nValueArray;
    private char[] userMessageArray;

    private final static String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static char alphabet[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public EasyEncrypt(char[] userMessage, int[] nValueArray) {
        this.userMessageArray = userMessage;
        this.nValueArray = nValueArray;
        /*this.nValueMultiplier = nValueMultiplier;*/
    }


    /**
     * Method
     * Reference for String.valueOf(): stackoverflow.com/questions/7655127/how-to-convert-a-char-array-back-to-a-string
     * @return Returns a char[] containing the encryped or decrypted message.
     */
    public char[] encryptDecryptMessage() {
        int nValIndex = 0;
        for (int i = 0; i < userMessageArray.length; i++) {

            if(userMessageArray[i] != ' ' && userMessageArray[i] != '.') {
                userMessageArray[i] = applyNValue(userMessageArray[i], nValueArray[nValIndex]);
                nValIndex++;
            }
        }
        return userMessageArray;
    }


    /**
     * Method changes the input char by the nValue amount of characters in the alphabet.
     * @param originalChar The original letter.
     * @param nValue The amount of letters to shift the original letter by.
     * @return Returns the shifted letter.
     */
    private char applyNValue(char originalChar, int nValue) {
        int charIndex = indexCharTranslation(originalChar);
        return indexCharTranslation((charIndex + nValue + 26) % 26);
    }

    /**
     * Overridden method returning the character value of an index position in the alphabet array.
     * @param index The index of the character the method will return.
     * @return The character at inputted index.
     */
    private static char indexCharTranslation(int index) {
        return alphabet[index];
    }

    /**
     * Overridden method returning the index value of where the input character is located in alphabetString.
     * @param character Input character.
     * @return Index value of the input character.
     */
    private static int indexCharTranslation(char character) {
        return alphabetString.indexOf(character);
    }

}
