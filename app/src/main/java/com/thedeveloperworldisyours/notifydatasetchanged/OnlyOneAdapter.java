package com.thedeveloperworldisyours.notifydatasetchanged;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

/**
 * Created by javierg on 25/01/2017.
 */

public class OnlyOneAdapter extends BaseAdapter implements View.OnClickListener {

    private final Context mContext;
    private final String[] mValues;

    static class ViewHolder {
        Button mButton;
    }

    public OnlyOneAdapter(Context context, String[] values) {
        this.mContext = context;
        this.mValues = values;
    }

    @Override
    public int getCount() {
        return mValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.mButton = (Button) rowView.findViewById(R.id.list_item_button);

            viewHolder.mButton.setOnClickListener(this);

            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.mButton.setText(mValues[position]);

        if (holder.mButton.getTag() != null && (holder.mButton.getTag()).equals("Info")) {

            holder.mButton.setBackgroundColor(Color.BLUE);
            holder.mButton.setTextColor(Color.WHITE);
            holder.mButton.setTag("");
        } else {
            holder.mButton.setBackgroundResource(android.R.drawable.btn_default);
            holder.mButton.setTextColor(Color.BLACK);
        }

        return rowView;
    }

    @Override
    public void onClick(View v) {

        v.setTag("Info");
        this.notifyDataSetChanged();
    }
}
