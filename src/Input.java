import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public static int[] getUserAnswer(int length){
        int[] numList = null;

        while(isFirstStage(numList) || isInvalidLength(numList, length) || isExistDuplicate(numList)){
            printGetMessage();
            numList = getNumbers();
        }
        return numList;
    }

    private static boolean isFirstStage(int[] numList){
        return numList == null;
    }

    private static void printGetMessage(){
        Output.printMessage("숫자를 입력해주세요 ex)123 :");
    }

    private static int[] getNumbers(){
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


    private static boolean isInvalidLength(int[] numList, int length){
        return numList.length != length;
    }

    private static boolean isExistDuplicate(int[] numList){
        return searchDuplicate(numList);
    }

    private static boolean searchDuplicate(int[] numList){
        int targetIdx = 0;

        while(targetIdx < numList.length-1){
            if(matchDuplicate(targetIdx, numList)){
                return true;
            }
            targetIdx++;
        }
        return false;
    }

    private static boolean matchDuplicate(int targetIdx, int[] numList){
        for(int i=targetIdx+1; i<numList.length; i++){
            if(numList[targetIdx] == numList[i]){
                return true;
            }
        }
        return false;
    }
}
