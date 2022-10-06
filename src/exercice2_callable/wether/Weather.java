package exercice2_callable.wether;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class Weather {
    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("Input city`s name");
            BufferedReader df = new BufferedReader(new InputStreamReader(System.in));
            String name = df.readLine();

            if (name!=null && !name.equals("q")) {
                String json = getWeather(name);
                JSONObject obj = new JSONObject(json);

                String st = "In the city " + name + "\n" + "Temperature = " +
                        obj.getJSONObject("main").getDouble("temp") + "\n" + "Min temp= " +
                        obj.getJSONObject("main").getDouble("temp_min") + "\n" + "Max temp=" +
                        obj.getJSONObject("main").getDouble("temp_max") +
                                "\n=======================================================================================";
                System.out.println(st);
            } else break;
        }

    }

    private static String getWeather(String name) throws IOException {
        URL url = new URL(
                "https://api.openweathermap.org/data/2.5/weather?q="+name+"&appid=fd3472abf94df529d9b8cb485d137192&units=metric");
        URLConnection connection= url.openConnection();

        BufferedReader bf = new BufferedReader(new InputStreamReader (connection.getInputStream()));

        StringBuilder st = new StringBuilder();
        String a = "";

        while ((a = bf.readLine()) != null) {
            st.append(a);
        }

        bf.close();
        return st.toString();
    }
}
