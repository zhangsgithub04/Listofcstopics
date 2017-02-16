package com.example.zhangs.listofcstopics;

import android.content.Context;
import android.content.Entity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ZHANGS on 2/15/2017.
 */

public class loaddata {

    public static void readtextfromasset(Context c) {
        BufferedReader reader;

        try {
            final InputStream file = c.getAssets().open("cstopic.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while (line != null) {
                Log.d("StackOverflow", line);

                line = reader.readLine();
                String[] fields = line.split(", ");

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    static public String loadJSONFromAsset(Context c) {
        String json = null;
        try {
            InputStream is = c.getAssets().open("yourfilename.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    static public void parsejason(Context c) {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(c));

            JSONArray m_jArry = obj.getJSONArray("formules");

            ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();

            HashMap<String, String> m_li;

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                Log.d("Details-->", jo_inside.getString("formule"));
                String formula_value = jo_inside.getString("formule");
                String url_value = jo_inside.getString("url");

                //Add your values in your `ArrayList` as below:
                m_li = new HashMap<String, String>();
                m_li.put("formule", formula_value);
                m_li.put("url", url_value);

                formList.add(m_li);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    static public Context c;

    static private XmlPullParserFactory xmlPullParserFactory;

    static public String readxmlfromasset() {
        try {
            xmlPullParserFactory = XmlPullParserFactory.newInstance();
            xmlPullParserFactory.setNamespaceAware(false);
            XmlPullParser parser = xmlPullParserFactory.newPullParser();
            // access the xml file and convert it to input stream
            InputStream is = returnXmlInputStream();
            parser.setInput(is, null);
            String returnedStringValue = getLoadedXmlValues(parser);

            return returnedStringValue;

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }



    private static InputStream returnXmlInputStream() throws IOException {
        InputStream is = c.getAssets().open("cstopics.xml");
        return is;
    }

    private static String getLoadedXmlValues(XmlPullParser parser) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        String name = null;
        CSTopic acstopic;
        acstopic= new CSTopic("ddd", "ddd", "ddd");

        while (eventType != XmlPullParser.END_DOCUMENT){

            if(eventType == XmlPullParser.START_TAG){
                name = parser.getName();

                if(name.equals("id")){
                    acstopic.topicID = parser.nextText();
                }
                else if(name.equals("description")){
                    acstopic.topicDescription = parser.nextText();
                }
                else if(name.equals("imagename")){
                    acstopic.imgname = parser.nextText();
                }
            }

            eventType = parser.next();
        }

        return "ok";
    }

}
