import java.util.HashMap;

public class Codec {

    HashMap<String, String> mapping = new HashMap<>();
    int index = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String encoded = Integer.toString(index);
        mapping.put(encoded, longUrl );
        index ++;
        return encoded;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return mapping.getOrDefault(shortUrl, "");
    }
}