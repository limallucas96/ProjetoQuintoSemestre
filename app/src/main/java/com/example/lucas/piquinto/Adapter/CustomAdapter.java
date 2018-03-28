package com.example.lucas.piquinto.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucas.piquinto.R;

/**
 * Created by Lucas on 20/03/2018.
 */

public class CustomAdapter extends ArrayAdapter<String> {

    private String[] hospede;
    private String[] situacao;

    public CustomAdapter(@NonNull Context context, String[] quartos, String[] hospede, String[] situacao) {
        super(context, R.layout.customlistviewlayout, quartos);

        this.hospede = hospede;
        this.situacao = situacao;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.customlistviewlayout, parent, false);

        String numeroQuarto = getItem(position);

        TextView tvQuarto = view.findViewById(R.id.tvQuarto_id);
        TextView tvHospede = view.findViewById(R.id.tvHospede_id);
        TextView tvSituacao = view.findViewById(R.id.tvSituacao_id);
        ImageView imageQuarto = view.findViewById(R.id.imageQuarto_id);

        tvQuarto.setText(tvQuarto.getText()+numeroQuarto);
        tvHospede.setText(tvHospede.getText()+hospede[position]);
        tvSituacao.setText(tvSituacao.getText()+getSituacao(Integer.parseInt(situacao[position])));


        imageQuarto.setImageResource(R.drawable.hotelicon);

        return view;
    }

    public String getSituacao(int situacao){
        if(situacao == 1)
            return "Todos";
        else
            if (situacao == 2)
                return "Ocupado";
            else
                if (situacao == 3)
                    return "Livre";
        else
            return null;
    }
}
