import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        util(n, n, new StringBuffer(), result);
        return result;
    }

    private void util(int numCloseBrackets, int numOpenBrackets, StringBuffer currentString, List<String> result) {
        if (numCloseBrackets == 0 && numOpenBrackets == 0) {
            result.add(currentString.toString());
            return;
        }

        if (numOpenBrackets > 0) {
            currentString.append('(');
            util(numCloseBrackets, numOpenBrackets-1, currentString, result);
            currentString.deleteCharAt(currentString.length()-1);
        }

        if (numCloseBrackets > 0 && numCloseBrackets > numOpenBrackets) {
            currentString.append(')');
            util(numCloseBrackets-1, numOpenBrackets, currentString, result);
            currentString.deleteCharAt(currentString.length()-1);
        }


    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
