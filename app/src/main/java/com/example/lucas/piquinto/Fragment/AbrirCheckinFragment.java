package com.example.lucas.piquinto.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lucas.piquinto.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AbrirCheckinFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AbrirCheckinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AbrirCheckinFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public AbrirCheckinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab2, container, false);
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
