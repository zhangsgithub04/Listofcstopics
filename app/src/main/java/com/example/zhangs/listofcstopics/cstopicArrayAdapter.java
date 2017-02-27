package com.example.zhangs.listofcstopics;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by ZHANGS on 2/14/2017.
 */
public class cstopicArrayAdapter extends ArrayAdapter<CSTopic> {

    Context mContext;

    int layoutResourceId;
    CSTopic data[] =null;

    public cstopicArrayAdapter( Context mContext, int layoutResourceId, CSTopic[] data)
    {
        super(mContext, layoutResourceId, data);
        this.layoutResourceId=layoutResourceId;
        this.mContext=mContext;
        this.data=data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        if (convertView==null)
        {
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            convertView =inflater.inflate(layoutResourceId, parent, false);

        }
        CSTopic onecstopic = data[position];

        TextView cstopicdesc=(TextView) convertView.findViewById(R.id.textViewItem);
        cstopicdesc.setText(onecstopic.topicDescription);
        //cstopicdesc.setTag(onecstopic.topicID);
        cstopicdesc.setTag(position);
        return convertView;
    }
}
