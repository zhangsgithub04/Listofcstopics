package com.example.zhangs.listofcstopics;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by ZHANGS on 2/15/2017.
 */
public class CustomListViewActivity extends AppCompatActivity
{


    String[] itemname ={
            "Computer Science",
            "Math",
            "Statistics",
            "English"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_customlistview_layout);


        ArrayAdapter<?> aa= new ArrayAdapter<String>(this, R.layout.list_view_row_item_multiplefields, R.id.Itemname, itemname);

        ListView lv1 = (ListView)findViewById(R.id.clv);

        lv1.setAdapter(aa);

    }

}
