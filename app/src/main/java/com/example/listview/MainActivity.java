package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //faz alguma coisa
                Toast toast = Toast.makeText(getApplicationContext(), "Teste - "
                        +tarefas.get(i).getNome(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    public void criarTerefa()
    {
        this.tarefas.add(new Tarefa("1", "Estudar android", false));
        this.tarefas.add(new Tarefa("2", "Projeto Integrador", false));
        this.tarefas.add(new Tarefa("3", "GTA", true));
    }
}
