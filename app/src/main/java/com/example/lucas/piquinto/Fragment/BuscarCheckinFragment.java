package com.example.lucas.piquinto.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lucas.piquinto.Controller.QueryController;
import com.example.lucas.piquinto.R;

import java.util.ArrayList;
import java.util.List;

public class BuscarCheckinFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    private ListView listaQuartos;
    private RadioGroup radioGroup;
    private RadioButton btnLivre, btnTodos, btnOcupados;
    private ArrayAdapter<String> adapter;

    private QueryController queryController;

    private String quarto_url = "http://192.168.11.1/quickroomservice/quarto_query.php";

    public BuscarCheckinFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab3, container, false);

        listaQuartos = view.findViewById(R.id.listviewQuartos_id);

        queryController = new QueryController(quarto_url);
        String situacao = queryController.getData("situacao");

        List<String> teste = new ArrayList<>();
        teste.add(situacao);
        teste.add("Quarto 2");
        teste.add("Quarto 3");

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, teste);

        listaQuartos.setAdapter(adapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
