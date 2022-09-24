package codewars1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Code10 {
    public static void main(String[] args) throws IOException {
        String city = "A";
        String apiKey = "1c8e36972ad571de24f8fde1171a3277";

        System.out.println(getUrlContent("https://api.openweathermap.org/data/2.5/weather?q=" + city +
                "&appid=" + apiKey +"&units=metric"));
    }

    private static String getUrlContent(String urlAddress) throws IOException {
        StringBuilder content = new StringBuilder();
        URL url = new URL(urlAddress);
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append("\n");
        }
        bufferedReader.close();
        return content.toString();
    }

}
