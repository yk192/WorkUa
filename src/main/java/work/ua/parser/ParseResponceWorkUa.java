package work.ua.parser;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ParseResponceWorkUa {

    public void getResponceWorkUa(String url){

        try {
            Document doc = Jsoup.connect(url).get();

            System.out.println(doc.body());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
