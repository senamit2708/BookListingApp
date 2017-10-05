package com.example.senamit.booklistingapp;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils() {}

    public static ArrayList<Book> extractFeatureFromJSON(String jsonResponse) throws JSONException {
        if (TextUtils.isEmpty(jsonResponse)) {
            return null;
        }
        ArrayList<Book> books = new ArrayList<Book>();
        String authors = null;
        String title = null;
        Bitmap bmp = null;
        String url = null;
        InputStream inputStream = null;
        JSONObject baseJsonObject = new JSONObject(jsonResponse);
        JSONArray jsonItemsArray = baseJsonObject.optJSONArray("items");
        for (int i = 0; i < jsonItemsArray.length(); i++) {
            JSONObject jsonItemObject = jsonItemsArray.optJSONObject(i);
            JSONObject jsonVolumeInfo = jsonItemObject.optJSONObject("volumeInfo");
            JSONArray jsonAuthor = jsonVolumeInfo.optJSONArray("authors");
            JSONObject jsonImageLink = jsonVolumeInfo.optJSONObject("imageLinks");
            url = jsonVolumeInfo.optString("infoLink");
            title = jsonVolumeInfo.optString("title");
            String image = jsonImageLink.optString("smallThumbnail");
            StringBuilder output = new StringBuilder();
            for (int j = 0; j < jsonAuthor.length(); j++) {
                authors = jsonAuthor.optString(j);
                if (j != 0) {
                    output.append(", ");
                }
                output.append(authors);
            }

            try {
                inputStream = new URL(image).openStream();
                bmp = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            books.add(new Book(title, output.toString(), url, bmp));
        }
        return books;
    }

    public static URL createURL(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "url not created properly  " + e);
        }
        Log.i(LOG_TAG, "Inside createURL method");
        return url;
    }

    public static String makeHttpRequest(URL url) throws IOException {
        if (url == null) {
            return null;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        String jsonResponse = null;
        int readTimeOutValue=10000;
        int connectionTimeOutValue = 15000;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(readTimeOutValue);
            urlConnection.setConnectTimeout(connectionTimeOutValue);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code  " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retriving the earthquakeJson result  " + e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    public static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                output.append(line);
                line = bufferedReader.readLine();
            }
            Log.i(LOG_TAG, "Inside the readFromStream method");
        }
        return output.toString();
    }

    public static ArrayList<Book> fetchBooksRequest(String requestUrl) throws JSONException {
        URL url = createURL(requestUrl);
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making HTTP request " + e);
        }

        ArrayList<Book> books = extractFeatureFromJSON(jsonResponse);
        Log.i(LOG_TAG, "Inside the fetchBooksRequest method");
        return books;
    }
}


