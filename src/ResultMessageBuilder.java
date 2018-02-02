public class ResultMessageBuilder {

    public static String build(int[] resultSheet){
        if(isInvalidResult(resultSheet)){
            throw new IllegalArgumentException();
        }

        if(isNothing(resultSheet)){
            return "낫씽";
        }

        return getResultMessage(resultSheet);
    }

    private static boolean isInvalidResult(int[] resultSheet){
        return resultSheet == null;
    }

    private static boolean isNothing(int[] resultSheet){
        for(int result : resultSheet){
            if(!isZeroNum(result)){
                return false;
            }
        }

        return true;
    }

    private static boolean isZeroNum(int result){
        return result == 0;
    }

    private static String getResultMessage(int[] resultSheet){
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<resultSheet.length; i++){
            if(isZeroNum(resultSheet[i])){
                continue;
            }
            builder.append(resultSheet[i]).append(" ").append(getModifier(i)).append(" ");
        }

        return builder.toString();
    }

    private static String getModifier(int idx){
        String[] ModifierList = {"스트라이크", "볼"};
        return ModifierList[idx];
    }
}
