package com.example.zhangs.listofcstopics;

import android.app.NotificationManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

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

        CSTopic[] cstopics;

        dataloader.readtextfromasset(this);
        //dataloader.hardcodedtopics();

        cstopics= dataloader.allcstopics;


        cstopicArrayAdapter csadaptor = new cstopicArrayAdapter(this, R.layout.list_view_row_item, cstopics);

        ListView cstopicslistview = new ListView(this);
        cstopicslistview.setAdapter(csadaptor);

        cstopicslistview.setOnItemClickListener(new topiclistener());

        /*
        if(csadaptor.getCount() > 5){
            View item = csadaptor.getView(0, null, cstopicslistview);
            item.measure(0, 0);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, (int) (5.5 * item.getMeasuredHeight()));
            cstopicslistview.setLayoutParams(params);
        }
        */

        //setContentView(cstopicslistview);

        ListView lv1 = (ListView)findViewById(R.id.lv);
        lv1.setAdapter(csadaptor);

        lv1.setOnItemClickListener(new topiclistener());

/*
        // first Button
        RelativeLayout rLayout = (RelativeLayout) findViewById(R.id.rl);


        RelativeLayout.LayoutParams lprams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        cstopicslistview.setLayoutParams(lprams);
        lprams.addRule(RelativeLayout.BELOW, R.id.lv);
        //cstopicslistview.setId(1);
        rLayout.addView(cstopicslistview);
*/

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

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.customlist:
                Intent intent = new Intent(getApplicationContext(), moreCustomListViewActivity.class);
                intent.putExtra("test", "test");

                startActivity(intent);
                return true;
            case R.id.help:

                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(this)
                                .setSmallIcon(R.drawable.cat)
                                .setContentTitle("My notification")
                                .setContentText("Hello World!");

                // Sets an ID for the notification
                int mNotificationId = 001;
                // Gets an instance of the NotificationManager service
                NotificationManager mNotifyMgr =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // Builds the notification and issues it.
                mNotifyMgr.notify(mNotificationId, mBuilder.build());

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }


}