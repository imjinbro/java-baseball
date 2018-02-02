public class Matcher {

    public static int[] getResult(int[] answer, int[] userAnswer){
        if(isInvalidNumLists(answer, userAnswer)){
            throw new IllegalArgumentException();
        }

        int[] resultSheet = new int[2];
        match(resultSheet, answer, userAnswer);

        return resultSheet;
    }


    private static void match(int[] result, int[] answer, int[] userAnswer){
        for(int i=0; i<userAnswer.length; i++){
            if(isStrike(answer[i], userAnswer[i])){
                result[0]++;
                continue;
            }

            if(isBall(answer, userAnswer[i], i)){
                result[1]++;
            }
        }
    }

    private static boolean isStrike(int answerNum, int userAnswerNum){
        return answerNum == userAnswerNum;
    }

    private static boolean isBall(int[] answer, int userAnswerNum, int excludeIdx){
        for(int i=0; i<answer.length; i++){
            if(isExcludeIdx(excludeIdx, i)){
                continue;
            }

            if(doBallMatch(answer[i], userAnswerNum)){
                return true;
            }
        }
        return false;
    }

    private static boolean isExcludeIdx(int excludeIdx, int currentIdx){
        return excludeIdx == currentIdx;
    }

    private static boolean doBallMatch(int answerNum, int userAnswerNum){
        return answerNum == userAnswerNum;
    }


    private static boolean isInvalidNumLists(int[] answer, int[] userAnswer){
        return isNullNumList(answer) || isNullNumList(userAnswer);
    }

    private static boolean isNullNumList(int[] numList){
        return numList == null;
    }
}

