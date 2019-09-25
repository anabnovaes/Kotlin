package br.com.rafael.podedirigir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tela2.*
import android.widget.ArrayAdapter as ArrayAdapter1

class Tela2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        txvSaudacao.text = "Seja bem vindo ${intent.getStringExtra("Nome")}"

        //Criando uma lista de idades
        val listaIdades = arrayListOf("Selecione sua idade", 1)

        //Preenchendo a lista de idades
        for (numero in 2..100){
            listaIdades.add(numero)
        }
        // Criando um adaptador
        val idadesAdapter = ArrayAdapter1(this,android.R.layout.simple_spinner_dropdown_item, listaIdades)

        //plugando o adaptador no spinner
        spnIdades.adapter = idadesAdapter

        //identificando o clique no verificar
        btnVerificar.setOnClickListener {
            //Obtendo a idade selecionada
            val idade = spnIdades.selectedItem as Int

            //verificando a idade
            if (idade>=18){
                txvResultado.text = "Você pode dirigir!"
            }
            else{
                txvResultado.text = "Você não possui idade para dirigir"
            }

        }



    }
}
