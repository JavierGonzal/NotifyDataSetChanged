package com.thedeveloperworldisyours.notifydatasetchanged;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MultipleFragment extends Fragment implements AdapterView.OnItemClickListener {

    MultipleAdapter mAdapter;

    public MultipleFragment() {
        // Required empty public constructor
    }

    public static MultipleFragment newInstance() {
        return new MultipleFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_multiple, container, false);
        ListView listView = (ListView) view.findViewById(R.id.fragment_multiple_list_view);

        MultipleData android = new MultipleData("Android", false);
        MultipleData iPhone = new MultipleData("iPhone", false);
        MultipleData windowsMobile = new MultipleData("WindowsMobile", false);

        MultipleData blackberry = new MultipleData("Blackberry", false);
        MultipleData webOS = new MultipleData("WebOS", false);
        MultipleData ubuntu = new MultipleData("Ubuntu", false);

        MultipleData windows7 = new MultipleData("Windows7", false);
        MultipleData max = new MultipleData("Max OS X", false);
        MultipleData linux = new MultipleData("Linux", false);

        MultipleData os = new MultipleData("OS/2", false);
        MultipleData symbian = new MultipleData("Symbian", false);

        List<MultipleData> list = new ArrayList<>();
        list.add(0, android);
        list.add(1, iPhone);
        list.add(2, windowsMobile);

        list.add(3, blackberry);
        list.add(4, webOS);
        list.add(5, ubuntu);

        list.add(6, windows7);
        list.add(7, max);
        list.add(8, linux);

        list.add(9, os);
        list.add(10, symbian);

        mAdapter = new MultipleAdapter(getActivity(),list);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        mAdapter.setSelectedIndex(position);
        mAdapter.notifyDataSetChanged();
    }
}
