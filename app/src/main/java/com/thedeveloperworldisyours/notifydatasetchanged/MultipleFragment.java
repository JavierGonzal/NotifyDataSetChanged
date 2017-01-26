package com.thedeveloperworldisyours.notifydatasetchanged;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class MultipleFragment extends Fragment {

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

        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };

        MultipleAdapter adapter = new MultipleAdapter(getActivity(),values);
        listView.setAdapter(adapter);
        return view;
    }

}
