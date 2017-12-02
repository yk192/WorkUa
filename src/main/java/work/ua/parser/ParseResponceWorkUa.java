package work.ua.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import work.ua.model.Article;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseResponceWorkUa {

    private final String BASE_URL = "https://www.work.ua/jobs";

    /**
     * Get id vacansion and title
     * @param url
     */
    public void getResponceWorkUa(String url) {

        List<Article> list = new ArrayList<>();
        Document doc = null;
        try {

            doc = Jsoup.connect(url).get();
            Elements elements = doc.getElementsByTag("h2");
            for (Element s : elements) {

                Elements element = s.getAllElements();
                String url2 = element.attr("href");
                String title = element.attr("title");
                if (!title.isEmpty()) {

                    list.add(new Article(url2, title));
                }
            }

            list.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Get next page
     *
     * @param url
     * @return
     */
    public String getNextPage(String url) {

        String nextPage = null;

        try {

            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.getElementsByClass("no-style");
            for (Element element : elements) {

                if (element.toString().contains("Следующая")) {
                    Elements el = element.getElementsByTag("a");
                    String page = el.attr("abs:href");

                    if (!page.isEmpty()) {
                        nextPage = page;
                    } else {

                       break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nextPage;
    }

    /**
     * set parameters for search vacancy
     *
     * @param vacancyName
     * @param city
     * @return
     */
    public String setParametrVakancy(String city, String vacancyName){

        return BASE_URL + "-" + city + "-" + vacancyName;
    }
}
