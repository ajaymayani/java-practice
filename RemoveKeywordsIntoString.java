package string_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveKeywordsIntoString {

    public static void main(String[] args) {

        List<String> keywords = new ArrayList<>();
        keywords.add("what");
        keywords.add("is");
        keywords.add("how");
        keywords.add("which");
        keywords.add("can");
        keywords.add("would");
        keywords.add("could");
        keywords.add("are");
        keywords.add("your");
        keywords.add("you");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string : ");
        String str = sc.nextLine().toLowerCase();

        String search = removeKeywords(str, keywords);

        System.out.println("Output : " + search);

        //sendNetworkRequest(search);
    }

    /*private static void sendNetworkRequest(String search) {

        try {
            URL url = new URL("http://localhost:8080/api/posts/search/" + search);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            //set the type of request
            con.setRequestMethod("GET");

            //get response code
            int responseCode = con.getResponseCode();

            System.out.println("Response code ;" + responseCode);

            //Read the response body

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), Charset.forName("UTF-8")));
            String inputLine;
            StringBuilder sb = new StringBuilder();

            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }

            System.out.println("Response body : " + sb.toString());
            br.close();
            con.disconnect();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }*/

    public static String removeKeywords(String str, List<String> list) {
        String[] words = str.split(" ");

        List<String> stringList = Arrays.stream(words).filter(w -> !list.contains(w)).collect(Collectors.toList());

        return String.join(" ", stringList);
    }
}
