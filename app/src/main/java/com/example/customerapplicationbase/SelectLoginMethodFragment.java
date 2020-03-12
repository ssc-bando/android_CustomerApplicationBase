package com.example.customerapplicationbase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDeepLinkBuilder;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectLoginMethodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectLoginMethodFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Activity mParent;

    public SelectLoginMethodFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectLoginMethodFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectLoginMethodFragment newInstance(String param1, String param2) {
        SelectLoginMethodFragment fragment = new SelectLoginMethodFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_login_method, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mParent = activity;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button b;
        // Navigationで別のActivityを起動するのは無理ぽい(単にFragmentが切り替わるだけ)
        //b = view.findViewById(R.id.button3);
        //b.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_selectLoginMethodFragment_to_mobile_navigation));

        b = view.findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     Intent intent = new Intent(mParent, MainActivity.class);
                                     mParent.startActivity(intent);
                                 }
                             });

        b = view.findViewById(R.id.button4);
        b.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_selectLoginMethodFragment_to_showPermissionFragment));
    }
}
