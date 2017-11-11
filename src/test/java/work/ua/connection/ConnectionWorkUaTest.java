package work.ua.connection;

import org.junit.Test;

import java.io.IOException;

public class ConnectionWorkUaTest {

    @Test
    public void connectionWorkUaTest() throws IOException {

        String url = "https://www.work.ua/jobs-kyiv-java/";

        ConnectionWorkUa con = new ConnectionWorkUa();
        con.connectionWorkUa(url);


    }
}
