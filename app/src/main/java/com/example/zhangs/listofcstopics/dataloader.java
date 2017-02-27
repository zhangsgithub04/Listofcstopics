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

public class dataloader {

    public static CSTopic allcstopics[]=null;

    public static void hardcodedtopics() {
        allcstopics = new CSTopic[24];
        allcstopics[0] = new CSTopic("bst", "binary search tree", "cat");
        allcstopics[1] = new CSTopic("bs", "binary search ", "cat.png");
        allcstopics[2] = new CSTopic("qs", "quick sort", "oneontalogo.png");
        allcstopics[3] = new CSTopic("bst", "binary search tree", "oneontalogo");
        allcstopics[4] = new CSTopic("bst", "binary search tree", "");
        allcstopics[5] = new CSTopic("bs", "binary search ", "");
        allcstopics[6] = new CSTopic("qs", "quick sort", "");
        allcstopics[7] = new CSTopic("bst", "binary search tree", "");
        allcstopics[8] = new CSTopic("bst", "binary search tree", "");
        allcstopics[9] = new CSTopic("bs", "binary search ", "");
        allcstopics[10] = new CSTopic("qs", "quick sort", "");
        allcstopics[11] = new CSTopic("bst", "binary search tree", "");
        allcstopics[12] = new CSTopic("bst", "binary search tree", "");
        allcstopics[13] = new CSTopic("bs", "binary search ", "");
        allcstopics[14] = new CSTopic("qs", "quick sort", "");
        allcstopics[15] = new CSTopic("bst", "binary search tree", "");
        allcstopics[16] = new CSTopic("bst", "binary search tree", "cat");
        allcstopics[17] = new CSTopic("bs", "binary search ", "oneontalogo");
        allcstopics[18] = new CSTopic("qs", "quick sort", "oneontalogo");
        allcstopics[19] = new CSTopic("bst", "binary search tree", "cat.jpg");
        allcstopics[20] = new CSTopic("qs", "quick sort", "");
        allcstopics[21] = new CSTopic("bst", "binary search tree", "cat.jpg");
        allcstopics[22] = new CSTopic("qs", "quick sort", "");
        allcstopics[23] = new CSTopic("bst", "binary search tree", "oneontalogo.png");
    }

    public static void readtextfromasset(Context c) {
        BufferedReader reader;



        try {
            final InputStream file = c.getAssets().open("cstopics.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();

                int numofcstopics= Integer.parseInt(line);

                allcstopics=new CSTopic[numofcstopics];

                for( int row=0; row<numofcstopics; row++) {
                    line = reader.readLine();
                    String[] fields = line.split(", ");
                    allcstopics[row]=new CSTopic();

                    allcstopics[row].topicID=fields[0];
                    allcstopics[row].topicDescription=fields[1];
                    allcstopics[row].imgname=fields[2];
                }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }


    static public String loadJSONFromAsset(Context c) {
        String json = null;
        try {
            InputStream is = c.getAssets().open("cstopics.json");
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
