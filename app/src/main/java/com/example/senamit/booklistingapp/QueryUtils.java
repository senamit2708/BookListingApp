package com.example.senamit.booklistingapp;


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

    public static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils() {
    }


    public static ArrayList<Books> extractFeatureFromJSON(String jsonResponse) throws JSONException {
        if (TextUtils.isEmpty(jsonResponse)){
            return null;
        }
        ArrayList<Books> books= new ArrayList<Books>();
        String author=null;
        String title=null;
        JSONObject baseJsonObject =new  JSONObject(jsonResponse);
        JSONArray jsonItemsArray = baseJsonObject.optJSONArray("items");
        for (int i=0; i<jsonItemsArray.length(); i++){
            JSONObject jsonItemObject = jsonItemsArray.optJSONObject(i);
            JSONObject jsonVolumeInfo = jsonItemObject.optJSONObject("volumeInfo");
            JSONArray jsonAuthor = jsonVolumeInfo.optJSONArray("authors");
            String url = jsonVolumeInfo.optString("infoLink");
            title = jsonVolumeInfo.optString("title");
            StringBuilder output = new StringBuilder();
            for (int j=0; j<jsonAuthor.length(); j++)
            {
                 author = jsonAuthor.optString(j);
                output.append(author);
            }
            books.add(new Books(title, output.toString(),url));
            Log.i(LOG_TAG, "author name  "+ output.toString());
            Log.i(LOG_TAG,"link  "+url);
        }
        return books;
    }


    public static URL createURL(String stringUrl){
        URL url= null;
        try {
             url = new URL(stringUrl);
        }  catch (MalformedURLException e) {
            Log.e(LOG_TAG, "url not created properly  " +e);
        }
        Log.i(LOG_TAG,"Inside createURL method");
        return url;
    }

    public static String makeHttpRequest(URL url) throws IOException{
        if (url==null){
            return null;
        }
        HttpURLConnection urlConnection= null;
        InputStream inputStream = null;
        String jsonResponse = null;

        try {
            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode()==200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            }
            else {
                Log.e(LOG_TAG, "Error response code  "+ urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retriving the earthquakeJson result  "+e);
        }
        finally {
            if (urlConnection !=null){
                urlConnection.disconnect();
            }
           if (inputStream !=null){
            inputStream.close();
           }
        }
        return jsonResponse;
    }

    public static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream !=null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (line != null){
                output.append(line);
                line = bufferedReader.readLine();
            }
            Log.i(LOG_TAG, "Inside the readFromStream method");
        }
        return output.toString();
    }

    public static ArrayList<Books> fetchBooksRequest(String requestUrl) throws JSONException {
        URL url = createURL(requestUrl);
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making HTTP request "+e);
        }

        ArrayList<Books> books = extractFeatureFromJSON(jsonResponse);
        Log.i(LOG_TAG,"Inside the fetchBooksRequest method");
        return books;
    }
}


