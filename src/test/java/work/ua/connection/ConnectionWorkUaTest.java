package work.ua.connection;

import org.junit.Test;
import work.ua.parser.ParseResponceWorkUa;

import java.io.IOException;

public class ConnectionWorkUaTest {

    String url = "https://www.work.ua/jobs-kyiv-java/";

    @Test
    public void connectionWorkUaTest() throws IOException {

        ConnectionWorkUa con = new ConnectionWorkUa();

        con.getConnectionWorkUa(url);
    }

    @Test
    public void getRespoceWorkUa(){

        ParseResponceWorkUa parse = new ParseResponceWorkUa();
        parse.getResponceWorkUa(url);
    }
}
