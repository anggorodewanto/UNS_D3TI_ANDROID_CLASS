package com.example.nuriskandarz.praktikum_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Nur Iskandar Z on 19/11/2015.
 */
public class JsonParsing {

    public String getJSON(String url) {

        HttpURLConnection urlconn=null;
        StringBuilder stringBuilder=null;
        String jsonString = null;

        try {
            URL u = new URL(url);
            urlconn = (HttpURLConnection) u.openConnection();
            urlconn.setRequestMethod("GET");
            urlconn.setDoInput(true);
            urlconn.setDoOutput(true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
            stringBuilder = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + '\n');
            }

            jsonString = stringBuilder.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlconn.disconnect();
        }



        return jsonString;
    }
}
