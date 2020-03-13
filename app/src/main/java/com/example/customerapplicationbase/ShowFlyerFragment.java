package com.example.customerapplicationbase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFlyerFragment extends Fragment {

    public ShowFlyerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_show_flyer, container, false);;
        WebView flyer = (WebView)root.findViewById(R.id.webview_flywer);
        flyer.loadUrl("https://1.bp.blogspot.com/-j8vui1ZaN0Y/XhwqpvcxctI/AAAAAAABXCc/tfOSJ359HKgexOulf_j1Irp4ROPtNG8EgCNcBGAsYHQ/s400/shinbun_orikomi_koukoku_ad.png");
        return root;
    }
}
