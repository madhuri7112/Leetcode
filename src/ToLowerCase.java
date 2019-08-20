public class ToLowerCase {
    public String toLowerCase(String str) {
       StringBuffer sb = new StringBuffer();
       for (char c: str.toCharArray()) {
           char low = c;
           if (c <= 'Z' && c >= 'A') {
               low = (char) ((c - 'A') + 'a');
           }
           sb.append(low);
       }

       return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ToLowerCase().toLowerCase("AbCZ"));
    }

}
