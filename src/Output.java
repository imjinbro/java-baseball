public class Output {
    public static void printMessage(String message){
        if(isInvalidMessage(message)){
            throw new IllegalArgumentException();
        }

        System.out.println(message);
    }

    private static boolean isInvalidMessage(String message){
        return message.isEmpty();
    }
}
