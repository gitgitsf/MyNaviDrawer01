package com.veryfargo.mynavidrawer01.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.veryfargo.mynavidrawer01.R;


public class HolidayFragment extends Fragment {

    final  String TAG = getClass().getSimpleName();

    ListView lvHoliday;
    String [] mHolidayList;

    public HolidayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_holiday, container, false);

        view = setup(view);

        return view;
    }

    private View setup(View view) {

        lvHoliday = (ListView) view.findViewById(R.id.lvHoliday);

        // retrieve holidays from res/string.xml
        Resources resources = getResources();
        mHolidayList = new String[resources.getStringArray(R.array.usa_federal_holiday_array).length];
        mHolidayList = resources.getStringArray(R.array.usa_federal_holiday_array);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_list_item_1, mHolidayList);

        lvHoliday.setAdapter(adapter);

        return view;
    }


}
