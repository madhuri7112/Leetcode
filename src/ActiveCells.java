import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActiveCells {

    public List<Integer> cellComplete(int[] states, int days) {

        List<Integer> output = new ArrayList<>();
        for (int i=0; i< states.length; i++) {
            output.add(states[i]);
        }

        for (int i=0; i < days; i++) {
            output = transform(output);
        }

        return output;
    }

    public List<Integer> transform(List<Integer> states) {

        List<Integer> output = new ArrayList<>();

        output.add(states.get(1) == 0 ? 0 : 1);
        for (int i=1; i<states.size()-1;i++) {
            output.add(states.get(i-1) == states.get(i+1) ? 0 : 1);
        }
        output.add(states.get(6) == 0 ? 0 : 1);
        return output;
    }

    public static void main(String[] args) {
        int[] states = {1,0,0,0,0,1,0,0};
        System.out.println(new ActiveCells().cellComplete(states, 1));
    }

}
