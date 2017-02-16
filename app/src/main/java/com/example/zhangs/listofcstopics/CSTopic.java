package com.example.zhangs.listofcstopics;

/**
 * Created by ZHANGS on 2/14/2017.
 */
public class CSTopic {

    public String topicID;

    public String topicDescription;

    public String imgname;

    //constructor
    public CSTopic() {

     }

    // overloaded constructor
    public CSTopic(String ID, String Description, String imagename) {
        this.topicID = ID;  // this is optional, since no ambiguity
        this.topicDescription = Description;
        imgname=imagename;
    }
}
