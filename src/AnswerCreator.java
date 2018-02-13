import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnswerCreator {

    public static int[] getAnswer(int length){
        List<Integer> numList = getNumList();
        Collections.shuffle(numList);

        return pickAnswerNums(numList, length);
    }

    private static List<Integer> getNumList(){
        return Arrays.asList(1,2,3,4,5,6,7,8,9);
    }

    private static int[] pickAnswerNums(List<Integer> numList, int length){
        int[] pickNumList = new int[length];

        for(int i=0; i<length; i++){
            pickNumList[i] = numList.get(i);
        }

        return pickNumList;
    }
}
