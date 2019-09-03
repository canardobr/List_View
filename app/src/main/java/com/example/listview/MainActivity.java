package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        // Clique curto - Chamar outra activity
        // Ao clicar no item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //faz alguma coisa
                // Exibe uma mensagem
                /*Toast toast = Toast.makeText(getApplicationContext(), "Teste - "
                        +tarefas.get(i).getNome(), Toast.LENGTH_LONG);
                toast.show();*/

                //Abrindo a nova activity
                Intent intent = new Intent(MainActivity.this, TarefaActivity.class);
                intent.putExtra("TITULO",tarefas.get(i).getNome());
                intent.putExtra("DESCRICAO", tarefas.get(i).getDescricao());
                startActivity(intent);
            }
        });

        // Click longo - concluir tarefa
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(!tarefas.get(i).getStatus()) {
                    tarefas.get(i).setStatus(true); // Definindo um novo valor
                }
                else
                {
                    tarefas.get(i).setStatus(false);
                }
                listView.invalidateViews(); // Apagar e recarregar novamente o listView

                return false;
            }
        });
    }

    public void criarTerefa()
    {
        this.tarefas.add(new Tarefa("1", "Estudar android", "Estudando android com o Pudim", false));
        this.tarefas.add(new Tarefa("2", "Projeto Integrador", "Pudim adora projeto integrador",false));
        this.tarefas.add(new Tarefa("3", "GTA", "Pudim não joga GTA",true));
    }
}
