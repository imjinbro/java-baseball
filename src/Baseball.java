public class Baseball {
    public static void main(String[] args) {
        Baseball.start();
        Baseball.alertFinish();
    }

    private static void start(){
        int length = getLength();
        int[] resultSheet = null;
        int[] answer = AnswerCreator.getAnswer(length);

        while(!isFinish(resultSheet, length)){
            int[] userAnswer = UserAnswerGetter.getUserAnswer(length);
            resultSheet = Matcher.getResult(answer, userAnswer);
            String resultMessage = ResultMessageBuilder.build(resultSheet);
            printMessage(resultMessage);
        }
    }

    private static int getLength(){
        return 3;
    }

    private static void alertFinish(){
        printMessage(getLength() +"개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


    private static boolean isFinish(int[] resultSheet, int length){
        return isExistResult(resultSheet) && resultSheet[0] == length;
    }

    private static boolean isExistResult(int[] resultSheet){
        return resultSheet != null;
    }

    private static void printMessage(String message){
        Output.printMessage(message);
    }
}
