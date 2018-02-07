import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    public static int[] getNumbers(){
        char[] numListStr = readNumListStr();
        return convertToIntArr(numListStr);
    }

    private static char[] readNumListStr(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] numListStr = null;
        try {
            numListStr = br.readLine().toCharArray();
        } catch (IOException e) {
            Output.printMessage(e.getMessage());
        }

        return numListStr;
    }

    private static int[] convertToIntArr(char[] charArr){
        int length = charArr.length;
        int[] result = new int[length];

        for(int i=0; i<length; i++){
            if(isInvalidCharOfRange(charArr[i])){
                return null;
            }
            result[i] = charToInt(charArr[i]);
        }
        return result;
    }

    private static boolean isInvalidCharOfRange(char ch){
        return ch < '1' || ch > '9';
    }

    private static int charToInt(char ch){
        return ch - '0';
    }
}
