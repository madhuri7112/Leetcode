import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {

        if (wall.size() == 0) {
            return 0;
        }
        int totalWidth = 0;
        HashMap<Integer, Integer> cutsAtIndex = new HashMap<>();
        int numRows = wall.size();
        for (List<Integer> row: wall) {
            int offset = 0;
            totalWidth = 0;
            for (int width: row) {
                offset += width;
                totalWidth += width;
                cutsAtIndex.put(offset, cutsAtIndex.getOrDefault(offset, numRows)-1);
            }
        }
        cutsAtIndex.put(totalWidth, numRows);
        int minCuts = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Integer> entry : cutsAtIndex.entrySet()) {
            minCuts = Math.min(entry.getValue(), minCuts);
        }


        return minCuts;
    }
}
