package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.listview.adapter.MeuAdapter;
import com.example.listview.modelos.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Tarefa> tarefas = new ArrayList<>();
    private ArrayAdapter<Tarefa> arrayAdapterTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criarTerefa();
        listView = findViewById(R.id.list_view_tarefas);

        arrayAdapterTarefa = new MeuAdapter(MainActivity.this, (ArrayList<Tarefa>) tarefas);
        listView.setAdapter(arrayAdapterTarefa);
    }

    public void criarTerefa()
    {
        this.tarefas.add(new Tarefa("1", "Estudar android", false));
        this.tarefas.add(new Tarefa("2", "Projeto Integrador", false));
        this.tarefas.add(new Tarefa("3", "GTA", true));
    }
}
