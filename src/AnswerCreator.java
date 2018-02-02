import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnswerCreator {

    public static int[] getAnswer(){
        List<Integer> numList = getNumList();
        shuffleList(numList);

        return pickAnswerNums(numList);
    }

    private static List<Integer> getNumList(){
        return IntStream.rangeClosed(1, 9)
                        .boxed()
                        .collect(Collectors.toList());
    }

    private static void shuffleList(List<Integer> numList){
        Collections.shuffle(numList);
    }

    private static int[] pickAnswerNums(List<Integer> numList){
        int[] pickNumList = new int[3];
        int cnt = 0;

        for(int num : numList){
            if(isLimit(cnt, pickNumList.length)){
                break;
            }
            pickNumList[cnt++] = num;
        }
        return pickNumList;
    }

    private static boolean isLimit(int cnt, int listLength){
        return cnt == listLength;
    }

}
