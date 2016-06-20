package com.veryfargo.mynavidrawer01.fragments;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.veryfargo.mynavidrawer01.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FlowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlowerFragment extends Fragment {

    final  String TAG = getClass().getSimpleName();
    final static String TEXT_FAVOR_FLOWER = "My favor flower is ";
    final static String TEXT_LESS_FAVOR_FLOWER = " and less favor flower is ";

    String [] mFlowerList;
    Integer[] imageId = {
            R.drawable.f01_carnations,
            R.drawable.f02_iris,
            R.drawable.f03_daffodils,
            R.drawable.f04_sweetpea,
            R.drawable.f05_lily,
            R.drawable.f06_rose,
            R.drawable.f06_rose,
            R.drawable.f06_rose,
            R.drawable.f06_rose,
            R.drawable.f06_rose,
            R.drawable.f06_rose,
            R.drawable.f06_rose
    };

    ListView lvFlower;
    TextView tvFlower;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "favorFlower";
    private static final String ARG_PARAM2 = "unfavorFlower";

    // TODO: Rename and change types of parameters
    private String mFavorFlower;
    private String mUnfavorFlower;


    public FlowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FlowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FlowerFragment newInstance(String param1, String param2) {
        FlowerFragment fragment = new FlowerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1); //favor flower
        args.putString(ARG_PARAM2, param2);  // unfavor flower
        Log.d("FlowerFragment newInstance()", "param1=" + param1 + ", param2= " + param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFavorFlower = getArguments().getString(ARG_PARAM1);
            mUnfavorFlower = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_flower, container, false);

        view =setupView(view);
        return view;
    }

    private View setupView(View view) {

        tvFlower = (TextView) view.findViewById(R.id.tvFlower);
        lvFlower = (ListView) view.findViewById(R.id.lvFlower);

        tvFlower.setText(TEXT_FAVOR_FLOWER + mFavorFlower
                + TEXT_LESS_FAVOR_FLOWER + mUnfavorFlower);


        Resources resources = getResources();
        mFlowerList = new String[resources.getStringArray(R.array.birth_month_flower_array).length];
        mFlowerList = resources.getStringArray(R.array.birth_month_flower_array);

       // TODO: 6/18/16 create my own layout with image, textview
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_list_item_1, mFlowerList);

        lvFlower.setAdapter(adapter);

        return view;
    }

}
