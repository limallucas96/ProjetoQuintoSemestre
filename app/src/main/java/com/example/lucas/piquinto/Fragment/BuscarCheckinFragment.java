package com.example.lucas.piquinto.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lucas.piquinto.Adapter.CustomAdapter;
import com.example.lucas.piquinto.Controller.QueryController;
import com.example.lucas.piquinto.R;

import java.util.ArrayList;
import java.util.List;

public class BuscarCheckinFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    //Componetes da tela
    private ListView listaQuartos;
    private RadioGroup radioGroup;
    private RadioButton btnLivre, btnTodos, btnOcupados;
    private ListAdapter customAdapter;

    //Variaveis para conexão
    private QueryController queryController;

    //Queries para popular listview
    private final String QUERY_TODOS = "http://192.168.11.1/quickroomservice/quarto_query.php";
    private final String QUERY_LIVRES = "http://192.168.11.1/quickroomservice/quarto_livre_query.php";
    private final String QUERY_OCUPADOS = "http://192.168.11.1/quickroomservice/quarto_ocupado_query.php";


    public BuscarCheckinFragment() {
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Opções de quarto");
        menu.add("Informações");
        menu.add("Fazer Check-out");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        if(item.getTitle() == "Informações")
            Toast.makeText(getActivity(), "Informacoes", Toast.LENGTH_SHORT).show();
        if(item.getTitle() == "Fazer Check-out")
            Toast.makeText(getActivity(), "Check out", Toast.LENGTH_SHORT).show();

        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //FIND VIEW BLOCK
        View view = inflater.inflate(R.layout.fragment_tab3, container, false);
        radioGroup = view.findViewById(R.id.radioGroup);
        btnLivre = view.findViewById(R.id.radioLivres_id);
        btnTodos = view.findViewById(R.id.radioTodos_id);
        btnOcupados = view.findViewById(R.id.radioOcupados_id);
        listaQuartos = view.findViewById(R.id.listviewQuartos_id);
        //END OF VIEW BLOCK

        //Deixando btnTodos marcado como Default
        radioGroup.check(R.id.radioTodos_id);

        queryController = new QueryController(QUERY_TODOS);

        final String[] quartos_todos = queryController.getData("quarto_id");
        final String[] hospede_todos = queryController.getData("hospede_id");
        final String[] situacao_todos = queryController.getData("situacao");

        customAdapter = new CustomAdapter(getContext(), quartos_todos, hospede_todos, situacao_todos);
        listaQuartos.setAdapter(customAdapter);

        registerForContextMenu(listaQuartos);







        listaQuartos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        btnTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customAdapter = new CustomAdapter(getContext(), quartos_todos, hospede_todos, situacao_todos);
                listaQuartos.setAdapter(customAdapter);
            }
        });

        btnLivre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                queryController = new QueryController(QUERY_LIVRES);

                final String[] quartos_livre = queryController.getData("quarto_id");
                final String[] hospede_livre = queryController.getData("hospede_id");
                final String[] situacao_livre = queryController.getData("situacao");

                customAdapter = new CustomAdapter(getContext(), quartos_livre, hospede_livre, situacao_livre);
                listaQuartos.setAdapter(customAdapter);
        }
        });

        btnOcupados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                queryController = new QueryController(QUERY_OCUPADOS);

                final String[] quartos_ocupados = queryController.getData("quarto_id");
                final String[] hospede_ocupados = queryController.getData("hospede_id");
                final String[] situacao_ocupados = queryController.getData("situacao");

                customAdapter = new CustomAdapter(getContext(), quartos_ocupados, hospede_ocupados, situacao_ocupados);
                listaQuartos.setAdapter(customAdapter);
            }
        });



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
