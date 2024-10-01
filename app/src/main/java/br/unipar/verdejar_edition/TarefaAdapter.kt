package br.unipar.verdejar_edition

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class TarefaAdapter (

    private val context : Context,
    private val listaTarefa : MutableList <Tarefa>) : ArrayAdapter<Tarefa>(context,0,listaTarefa){

    override fun getView (position: Int, convertView: View?, parent: ViewGroup): View {

        val tarefa = listaTarefa.get(position)

        val view = LayoutInflater.from(context).inflate(R.layout.item_tarefa, parent, false)

        val nome = view.findViewById<TextView>(R.id.txtNome)
        val nivel = view.findViewById<TextView>(R.id.txtNivel)
        val data = view.findViewById<TextView>(R.id.txtData)

        nome.text = tarefa.nome
        nivel.text = tarefa.nivel
        data.text = tarefa.data

        return view

    }
}