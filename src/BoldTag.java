public class BoldTag {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];

        for (int i=0; i<s.length(); i++) {
            for (String dWord: dict) {
                if (s.startsWith(dWord, i)) {
                    for (int j=i; j< i+dWord.length(); j++) {
                        bold[j] = true;
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i=0; i < s.length(); i++) {
            if(!bold[i]) {
                sb.append(s.charAt(i));
                continue;
            }
            sb.append("<b>");
            sb.append(s.charAt(i));
            i++;
            while(i < s.length() && bold[i]) {
                sb.append(s.charAt(i));
                i++;
            }
            i--;
            sb.append("</b>");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] dict = {"abc","123"};
        new BoldTag().addBoldTag("abcxyz123", dict);
    }
}
