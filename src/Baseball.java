public class Baseball {
    public static void main(String[] args) {
        Baseball.start(3);
        Baseball.alertFinish();
    }

    private static void start(int length){
        int[] resultSheet = null;
        int[] answer = AnswerCreator.getAnswer(length);

        while(!isFinish(resultSheet)){
            int[] userAnswer = UserAnswerGetter.getUserAnswer(length);
            resultSheet = Matcher.getResult(answer, userAnswer);
            String resultMessage = ResultMessageBuilder.build(resultSheet);
            printMessage(resultMessage);
        }
    }

    private static void alertFinish(){
        printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


    private static boolean isFinish(int[] resultSheet){
        return isExistResult(resultSheet) && resultSheet[0] == 3;
    }

    private static boolean isExistResult(int[] resultSheet){
        return resultSheet != null;
    }

    private static void printMessage(String message){
        Output.printMessage(message);
    }
}
