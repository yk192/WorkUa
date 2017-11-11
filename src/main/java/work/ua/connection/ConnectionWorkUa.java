package work.ua.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectionWorkUa {

    /**
     *
     * @param url
     * @throws IOException
     */
    public void getConnectionWorkUa(String url) throws IOException {

        HttpURLConnection connection = null;

        try {

            URL myUrl = new URL(url);
            connection = (HttpURLConnection) myUrl.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            while((inputLine = reader.readLine()) != null){

                System.out.println(inputLine);
            }

            reader.close();

        } catch (MalformedURLException e) {

            System.err.print(e);
        } finally {

            connection.disconnect();
        }

    }
}
