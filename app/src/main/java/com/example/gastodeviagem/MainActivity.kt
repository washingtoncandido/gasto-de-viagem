package com.example.gastodeviagem

import Model.GastoViagem
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculate) {
            calcularGasto()
        }
    }

    private fun calcularGasto() {
        if(validarDistancia()&& validarAutonomy() && validarPreco()) {

           try {
               val distancia = editDistancia.text.toString().toDouble()
               val price = editPreco.text.toString().toDouble()
               val autonomi = editAutonomy.text.toString().toDouble()
               val calculate =
                   GastoViagem(distancia = distancia, preco = price, autonomo = autonomi)
               textValotTotal.text = "R$ ${"%.2f".format(calculate.obteGastor())}"

           }catch (nfe:NumberFormatException){
               Toast.makeText(
                    this,
                    getString(R.string.informe_valores_validos),
                    Toast.LENGTH_SHORT
                ).show()
           }
        }else{
            Toast.makeText(
                this,
                getString(R.string.preencha_todos_campos), Toast.LENGTH_SHORT
            )
                .show()
        }
    }

    fun validarDistancia(): Boolean {
        return editDistancia.text.toString() != ""
                && editDistancia.text.toString() != "0"
    }
    fun validarPreco(): Boolean {
        return editPreco.text.toString() != ""
                && editPreco.text.toString() != "0"

    }
    fun validarAutonomy(): Boolean {
        return  editAutonomy.text.toString() != ""
                && editAutonomy.text.toString() != "0"
    }

}