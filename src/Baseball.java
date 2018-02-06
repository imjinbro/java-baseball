public class Baseball {
    public static void main(String[] args) {
        Baseball.start();
    }

    public static void start(){
        int[] answer = getAnswer();
        int[] resultSheet = null;

        while(!isFinish(resultSheet)){
            int[] userAnswer = getUserAnswer(answer.length);
            resultSheet = getResult(answer, userAnswer);
            printMessage(getResultMessage(resultSheet));
        }

        printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


    private static boolean isFinish(int[] resultSheet){
        return isExistResult(resultSheet) && resultSheet[0] == 3;
    }

    private static boolean isExistResult(int[] resultSheet){
        return resultSheet != null;
    }

    private static int[] getAnswer(){
        return AnswerCreator.getAnswer();
    }

    private static int[] getUserAnswer(int length){
        return UserAnswerGetter.getUserAnswer(length);
    }

    private static int[] getResult(int[] answer, int[] userAnswer){
        return Matcher.getResult(answer, userAnswer);
    }

    private static String getResultMessage(int[] resultSheet){
        return ResultMessageBuilder.build(resultSheet);
    }

    private static void printMessage(String message){
        Output.printMessage(message);
    }
}
