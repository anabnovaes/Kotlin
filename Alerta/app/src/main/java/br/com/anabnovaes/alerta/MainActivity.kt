package br.com.anabnovaes.alerta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //criando o alerta do primeiro botão
        val alerta = AlertDialog.Builder(this)
        btnAlert.setOnClickListener {
            //título do alerta
            alerta.setTitle("Alerta de um botão")
                //mensagem de apresentação
                .setMessage("Aqui você pode escrever uma mensagem")
                    //mensagem de OK (concordando)
                .setPositiveButton("OK"){
                    //ação de clique do botão positivo
                        // o sinal abaixo é para os casos em que o segundo parâmetro não é necessario
                        _,_->

                }
                    //criando e exibindo o alerta
                .create()
                .show()
        }
        //criando o alerta do segundo botão
        btnAlert2.setOnClickListener {
            alerta.setTitle("Alerta de dois botões")
                .setMessage("Mensagem aqui ")
                .setPositiveButton("OK",null)
                .setNegativeButton("Finalizar"){_,_->
                    //ação de clique do botão negativo
                    //tirando o app de memória e finalizando
                    finishAndRemoveTask()
                }
                .create()
                .show()
        }
        btnAlert3.setOnClickListener {
            //título
            alerta.run {
                setTitle("Alerta com três botões")
                            //botão de confirmação
                        .setPositiveButton("OK", null)
                                //botão de negativa
                        .setNegativeButton("Finalizar"){ _,_ ->
                            finishAndRemoveTask()

                        }
                setNeutralButton("Cancelar", null)
                        //obriga o usuário a clicar nas ações de um botão, clicando fora não funciona
                    .setCancelable(false)
                    //cria um icone no alerta por localização de arquivos
                    .setIcon(R.mipmap.ic_launcher_round)
                    .create()
                    .show()
            }
        }
    }
}
