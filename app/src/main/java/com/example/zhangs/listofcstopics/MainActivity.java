package com.example.zhangs.listofcstopics;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mPlayer;

    public void onDestroy() {

        mPlayer.stop();
        super.onDestroy();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CSTopic [] cstopics = new CSTopic[24];
        cstopics[0] =new CSTopic("bst", "binary search tree","");
        cstopics[1] =new CSTopic("bs", "binary search ","");
        cstopics[2] =new CSTopic("qs", "quick sort","");
        cstopics[3] =new CSTopic("bst", "binary search tree","");
        cstopics[4] =new CSTopic("bst", "binary search tree","");
        cstopics[5] =new CSTopic("bs", "binary search ","");
        cstopics[6] =new CSTopic("qs", "quick sort","");
        cstopics[7] =new CSTopic("bst", "binary search tree","");
        cstopics[8] =new CSTopic("bst", "binary search tree","");
        cstopics[9] =new CSTopic("bs", "binary search ","");
        cstopics[10] =new CSTopic("qs", "quick sort","");
        cstopics[11] =new CSTopic("bst", "binary search tree","");
        cstopics[12] =new CSTopic("bst", "binary search tree","");
        cstopics[13] =new CSTopic("bs", "binary search ","");
        cstopics[14] =new CSTopic("qs", "quick sort","");
        cstopics[15] =new CSTopic("bst", "binary search tree","");
        cstopics[16] =new CSTopic("bst", "binary search tree","");
        cstopics[17] =new CSTopic("bs", "binary search ","");
        cstopics[18] =new CSTopic("qs", "quick sort","");
        cstopics[19] =new CSTopic("bst", "binary search tree","");
        cstopics[20] =new CSTopic("qs", "quick sort","");
        cstopics[21] =new CSTopic("bst", "binary search tree","");
        cstopics[22] =new CSTopic("qs", "quick sort","");
        cstopics[23] =new CSTopic("bst", "binary search tree","");

        cstopicArrayAdapter csadaptor = new cstopicArrayAdapter(this, R.layout.list_view_row_item, cstopics);

        ListView cstopicslistview = new ListView(this);
        cstopicslistview.setAdapter(csadaptor);

        cstopicslistview.setOnItemClickListener(new topiclistener());
        if(csadaptor.getCount() > 5){
            View item = csadaptor.getView(0, null, cstopicslistview);
            item.measure(0, 0);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, (int) (5.5 * item.getMeasuredHeight()));
            cstopicslistview.setLayoutParams(params);
        }

        //setContentView(cstopicslistview);

        ListView lv1 = (ListView)findViewById(R.id.lv);
        lv1.setAdapter(csadaptor);

        lv1.setOnItemClickListener(new topiclistener());

        // first Button
        RelativeLayout rLayout = (RelativeLayout) findViewById(R.id.rl);

        RelativeLayout.LayoutParams lprams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        cstopicslistview.setLayoutParams(lprams);
        lprams.addRule(RelativeLayout.BELOW, R.id.lv);
        //cstopicslistview.setId(1);
        rLayout.addView(cstopicslistview);


        final ImageView v = (ImageView) findViewById(R.id.iv);

        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                switch (arg1.getAction()) {
                    case MotionEvent.ACTION_DOWN: {


                        Intent intent = new Intent(getApplicationContext(), CustomListViewActivity.class);
                        intent.putExtra("test", "test");

                       startActivity(intent);

                        break;
                    }
                }
                return true;
            }
        });



        mPlayer = MediaPlayer.create(this, R.raw.redmoon08);
        mPlayer.start();


    }




}