import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mostFreqSubTreeSum {
    HashMap<Integer, Integer> frequency = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
         getSubtreeSum(root);
         List<Integer> result = new ArrayList<>();
         int maxFrequency = 0;
         for (Map.Entry<Integer, Integer> entry: frequency.entrySet()) {
             if (entry.getValue() > maxFrequency) {
                 result.clear();
                 result.add(entry.getKey());
                 maxFrequency = entry.getValue();
             } else if (entry.getValue() == maxFrequency) {
                 result.add(entry.getKey());
             }
         }

         int[] resultArray = new int[result.size()];

         for (int i=0;i<result.size();i++) {
             resultArray[i] = result.get(i);
         }

         return resultArray;
    }

    public int getSubtreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = root.val + getSubtreeSum(root.left) + getSubtreeSum(root.right);

        frequency.put(sum, frequency.getOrDefault(sum, 0 ) + 1);

        return sum;
    }
}
