package com.thedeveloperworldisyours.notifydatasetchanged;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by javierg on 25/01/2017.
 */

public class SingleAdapter extends BaseAdapter implements SelectedIndex {

    private final Context mContext;
    private final String[] mValues;
    private int mSelectedIndex = -1;

    @Override
    public void setSelectedIndex(int position) {
        mSelectedIndex = position;
    }

    static class ViewHolder {
        TextView mTextView;
        RadioButton mRadioButton;
    }

    public SingleAdapter(Context context, String[] values) {
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
            viewHolder.mTextView = (TextView) rowView.findViewById(R.id.list_item_text);
            viewHolder.mRadioButton = (RadioButton) rowView.findViewById(R.id.list_item_check_button);

            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.mTextView.setText(mValues[position]);
        if (mSelectedIndex == position) {
            holder.mRadioButton.setChecked(true);
        } else {
            holder.mRadioButton.setChecked(false);
        }

        return rowView;
    }

}