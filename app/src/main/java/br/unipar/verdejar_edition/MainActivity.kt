package br.unipar.verdejar_edition

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val listaDeTarefas = mutableListOf<Tarefa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edNome = findViewById<EditText>(R.id.edNome)
        val edNivel = findViewById<EditText>(R.id.edNivel)
        val btnRegistral = findViewById<Button>(R.id.btnRegistrar)
        val txtTotal = findViewById<TextView>(R.id.txtTotal)
        val listaTarefas = findViewById<ListView>(R.id.listaTarafa)

        val adapter = TarefaAdapter(this, listaDeTarefas)
        var cont = 0

        listaTarefas.adapter = adapter

        btnRegistral.setOnClickListener {

            val nome = edNome.text.toString()
            val nivel = edNivel.text.toString()
            val dataAtual = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

            if (nome.isNotEmpty() && nivel.isNotEmpty()){

                val novaTarefa = Tarefa(nome, nivel , dataAtual)

                // atualiza a tela
                listaDeTarefas.add(novaTarefa)
                adapter.notifyDataSetChanged()

                cont ++

                txtTotal.setText("$cont")
            }
        }

        listaTarefas.setOnItemLongClickListener{ _,_,positon,_ ->

            cont--
            txtTotal.setText("$cont")

            val removeTarefa = listaDeTarefas.removeAt(positon)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Tarefa Removida", Toast.LENGTH_LONG).show()
            true
        }


    }
}