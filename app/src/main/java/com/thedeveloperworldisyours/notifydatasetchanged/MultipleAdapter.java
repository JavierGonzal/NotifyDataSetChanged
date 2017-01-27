package com.thedeveloperworldisyours.notifydatasetchanged;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by javierg on 25/01/2017.
 */

public class MultipleAdapter extends BaseAdapter implements SelectedIndex {

    private final Context mContext;
    List<MultipleData> mList;

    @Override
    public void setSelectedIndex(int position) {

        if (mList.get(position).isSelected()) {
            mList.get(position).setSelected(false);
        } else {
            mList.get(position).setSelected(true);
        }
    }

    static class ViewHolder {
        TextView mTextView;
        RadioButton mRadioButton;
    }

    public MultipleAdapter(Context context, List<MultipleData> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
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
        holder.mTextView.setText(mList.get(position).getText());
        holder.mRadioButton.setChecked(mList.get(position).isSelected());

        return rowView;
    }

}
