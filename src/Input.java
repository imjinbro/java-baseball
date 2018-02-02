import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    public static int[] getNumbers(){
        char[] numListStr = readNumListStr();
        return convertToIntArr(numListStr);
    }

    private static char[] readNumListStr(){
        char[] numListStr = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            numListStr = br.readLine().toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return numListStr;
    }

    private static int[] convertToIntArr(char[] charArr){
        int length = charArr.length;
        int[] result = new int[length];

        for(int i=0; i<length; i++){
            result[i] = charToInt(charArr[i]);
        }

        return result;
    }

    private static int charToInt(char ch){
        if(isInvalidCharOfRange(ch)){
            throw new IllegalArgumentException();
        }
        return ch - '0';
    }

    private static boolean isInvalidCharOfRange(char ch){
        return ch < '1' || ch > '9';
    }
}
