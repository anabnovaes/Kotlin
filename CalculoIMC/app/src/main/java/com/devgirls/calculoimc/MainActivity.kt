package com.devgirls.calculoimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow
import kotlin.math.round


class MainActivity : AppCompatActivity() {

    lateinit var txvPeso:TextView
    lateinit var seekBarPeso:SeekBar
    lateinit var botao:Button
    lateinit var seekBarAltura:SeekBar
    lateinit var txvAltura: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //instanciando as constraints que serão usadas
        setContentView(R.layout.activity_main)
        txvPeso = findViewById (R.id.txvPeso)
        seekBarPeso= findViewById(R.id.skbPeso)
        botao = findViewById((R.id.btnCalcular))
        seekBarAltura = findViewById(R.id.skbAltura)
        txvAltura = findViewById(R.id.txvAltura)
        // definindo altura máxima
        seekBarAltura.max = 250
        //definindo peso maximo
        seekBarPeso.max = 320


        //implementando os eventos de clique na seekbar de peso
        seekBarPeso.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar:SeekBar?, progress: Int, fromUser: Boolean) {
                //evento de movimentação da barra de progresso
                txvPeso.text= "" + progress + "kg"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                //evento do primeiro clique e arrasta

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                //ao parar o clique da seekbar


            }




        })

        //implementando eventos de clique na seekbar de altura
        seekBarAltura.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(SeekBarAltura: SeekBar?, progressAltura : Int, fromUserAltura: Boolean) {
                //evento de movimentação da barra de progresso
                txvAltura.text= "" + progressAltura +"cm"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                //ao parar o clique da seekbar


            }

        })
        // fazendo o calculo do imc a partir do clique do botão
        btnCalcular.setOnClickListener{
            //capturando o peso e altura
            var altura = skbAltura.progress.toFloat()
            var peso = skbPeso.progress.toFloat()
            //convertendo a altura para cm
            altura /= 100

            //fazendo o calculo do IMC
            var imc = peso/(altura* altura)

            if(imc <= 17)
            {
                txvImc.text = "Seu IMC é " +imc.toInt() +"Magreza"

            }
            else if(imc <= 18.5)
            {
                txvImc.text = "Seu IMC é " +imc.toInt() +". Abaixo do peso"

            }
            else if(imc <= 24.9)
            {
                txvImc.text = "Seu IMC é " +imc.toInt() +". Peso ideal"
            }
            else if(imc <= 29.9)
            {
                txvImc.text = "Seu IMC é " +imc.toInt() +". Levemente acima do peso"

            }
            else if(imc <= 34.9)
            {
                txvImc.text = "Seu IMC é " +imc.toInt() +". Obesidade grau I"

            }
            else if(imc <= 39.9)
            {
                txvImc.text = "Seu IMC é " +imc.toInt() +  ". Obesidade grau II"

            }
            else
            {
                txvImc.text = "Seu IMC é " +imc.toInt() + ". Obesidade grau III"

            }





        }
    }
}
