public class UserAnswerGetter {

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
        return Input.getNumbers();
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
