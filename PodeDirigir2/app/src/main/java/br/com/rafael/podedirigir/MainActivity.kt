package br.com.rafael.podedirigir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Clicando no botão entrar
        // funcao anonima, lambda, sem parametros
        btnEntrar.setOnClickListener {
            //Verificando o editText
            val nome = edtNome.text.toString()
            // o comando .isEmpty verifica se tem texto, isNotEmpty o contrário
            if(nome.isEmpty()== true){
                //Exibindo uma mensagem com o toast
                // 3 parametros para funcionar
                Toast.makeText(this, "Digite seu nome:", Toast.LENGTH_LONG).show ()
            }else{
                //mudando de tela
                //delegar a funcao de enviar um email a outro app..intent
                val intent = Intent (this,/*aqui vai o nome da tela pra onde quero que vá*/Tela2Activity::class.java)
                intent.putExtra("Nome", nome)
                startActivity(intent)
            }


        }

    }
}
