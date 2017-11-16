package work.ua.parser;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import work.ua.model.Article;
import work.ua.model.PageNumber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseResponceWorkUa {

    public void getResponceWorkUa(String url) {

        List<Article> list  = new ArrayList<>();

        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();

            Elements elements = doc.getElementsByTag("h2");

            for(Element s : elements){

                Elements element = s.getAllElements();
                String url2 = element.attr("href");
                String title = element.attr("title");
                list.add(new Article(url2, title));
            }

            list.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getCountPages(String url){

        List<PageNumber> list = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();

            Elements elements = doc.getElementsByAttributeValue("class","pagination hidden-xs");
           Elements el = elements.select("li");



            for(Element e : el){




                System.out.println(e);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
