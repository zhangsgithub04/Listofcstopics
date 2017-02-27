package com.example.zhangs.listofcstopics;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ZHANGS on 2/14/2017.
 */
public class topiclistener implements AdapterView.OnItemClickListener{

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Context context = view.getContext();
        TextView textViewItem =((TextView) view.findViewById(R.id.textViewItem));

        String listItemText = textViewItem.getText().toString();
        String listItemId=textViewItem.getTag().toString();

        //Just toast it
        //Toast.makeText(context, "Bingo,   TopicId: "+ listItemId + " Topic Description: "+ listItemText,Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(context, DetailedTopicActivity.class);
        intent.putExtra("order", listItemId);

        context.startActivity(intent);



    }
    private final static String EXTRA_MESSAGE = "topicid";

}
