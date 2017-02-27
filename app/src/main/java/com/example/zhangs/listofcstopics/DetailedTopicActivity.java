package com.example.zhangs.listofcstopics;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.lang.String;

/**
 * Created by ZHANGS on 2/15/2017.
 */
public class DetailedTopicActivity  extends AppCompatActivity {

    public void onDestroy() {

        super.onDestroy();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_layout);

        //Receiving data passed from the first activity inside onCreate() method of Second Activity
        String idstring = getIntent().getStringExtra("order");
        int id=Integer.parseInt(idstring);
        ImageView iw= (ImageView)findViewById(R.id.timg);
        //int resID = getResources().getIdentifier("cat", "drawable",  getPackageName());
        int resID = getResources().getIdentifier(dataloader.allcstopics[id].imgname, "drawable",  getPackageName());

        iw.setImageResource(resID);

    }

    /** Called when the user clicks the Send button */
    public void goBack(View view) {
        // Do something in response to button
        onBackPressed();
    }
}