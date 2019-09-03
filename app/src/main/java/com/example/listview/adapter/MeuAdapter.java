package com.example.listview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.listview.R;
import com.example.listview.modelos.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MeuAdapter extends ArrayAdapter<Tarefa> {

    private Context context;
    private List<Tarefa> tarefas;

    public MeuAdapter(Context context, ArrayList<Tarefa> list)
    {
        super(context, 0, list);
        this.context = context;
        tarefas = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if(listItem==null)
        {
            listItem = LayoutInflater.from(context).inflate(R.layout.layout_lista, parent, false);
        }

        ConstraintLayout constraintLayoutLista = listItem.findViewById(R.id.constraint_layout_lista);

        Tarefa tarefaAtual = tarefas.get(position);
        TextView nome = listItem.findViewById(R.id.text_view_tarefa_nome);
        nome.setText(tarefaAtual.getNome());

        TextView status = listItem.findViewById(R.id.text_view_tarefa_status);
        if(Boolean.parseBoolean(tarefaAtual.getStatus().toString()))
        {
            status.setText("");
            //constraintLayout_Lista.setBackground(context, R.color.colorConcluido);
            constraintLayoutLista.setBackgroundColor(context.getResources().getColor(R.color.colorConcluido));
            constraintLayoutLista.invalidate();
        }
        else
        {
            status.setText("Concluir");
            constraintLayoutLista.setBackgroundColor(context.getResources().getColor(R.color.colorNConcluido));
            constraintLayoutLista.invalidate();

        }



        return listItem;
    }
}
