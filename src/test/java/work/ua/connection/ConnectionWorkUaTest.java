package work.ua.connection;

import org.junit.Test;
import work.ua.model.Article;
import work.ua.parser.ParseResponceWorkUa;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ConnectionWorkUaTest {

    ParseResponceWorkUa parse = new ParseResponceWorkUa();
    String url = parse.setParametrVakancy("киев","php") ;

    /**
     *
     * @throws IOException
     */
    @Test
    public void connectionWorkUaTest() throws IOException {

        ConnectionWorkUa con = new ConnectionWorkUa();
        con.getConnectionWorkUa(url);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void getRespoceWorkUa() throws Exception {

        ParseResponceWorkUa parse = new ParseResponceWorkUa();
        for (int i = 0; i < 100; i++) {
            if (!url.isEmpty()) {
                parse.getResponceWorkUa(url);
                url = parse.getNextPage(url);
            }
        }
    }
}
