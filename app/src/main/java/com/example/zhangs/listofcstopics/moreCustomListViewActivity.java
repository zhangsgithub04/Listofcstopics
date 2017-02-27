package com.example.zhangs.listofcstopics;

/**
 * Created by ZHANGS on 2/24/2017.
 */

    import android.app.Activity;
    import android.app.ListActivity;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.AdapterView.OnItemClickListener;
    import android.widget.ArrayAdapter;
    import android.widget.ListView;
    import android.widget.Toast;

public class moreCustomListViewActivity extends AppCompatActivity {

        ListView list;
        String[] itemname ={
                "Safari",
                "Camera",
                "Global",
                "FireFox",
                "UC Browser",
                "Android Folder",
                "VLC Player",
                "Cold War"
        };

        Integer[] imgid={
                R.drawable.cat,
                R.drawable.cat,
                R.drawable.oneontalogo,
                R.drawable.cat,
                R.drawable.oneontalogo,
                R.drawable.oneontalogo,
                R.drawable.oneontalogo,
                R.drawable.oneontalogo
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.list_customlistview_more_layout);

            CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);

            list=(ListView)findViewById(R.id.list);

            list.setAdapter(adapter);

            list.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // TODO Auto-generated method stub
                    String Slecteditem= itemname[+position];
                    Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

                }
            });
        }
    }