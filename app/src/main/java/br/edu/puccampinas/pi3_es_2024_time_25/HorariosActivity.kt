package br.edu.puccampinas.pi3_es_2024_time_25

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import com.google.android.material.snackbar.Snackbar

class HorariosActivity : AppCompatActivity() {

    private lateinit var textoHorarios: TextView
    private lateinit var btnTempo1: Button
    private lateinit var btnTempo2: Button
    private lateinit var btnTempo3: Button
    private lateinit var btnTempo4: Button
    private lateinit var btnTempo5: Button
    private lateinit var confirmarLocacao: Button
    private lateinit var voltarTempo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horarios)

        textoHorarios = findViewById(R.id.texto_horarios)
        btnTempo1 = findViewById(R.id.btn_tempo_1)
        btnTempo2 = findViewById(R.id.btn_tempo_2)
        btnTempo3 = findViewById(R.id.btn_tempo_3)
        btnTempo4 = findViewById(R.id.btn_tempo_4)
        btnTempo5 = findViewById(R.id.btn_tempo_5)
        confirmarLocacao = findViewById(R.id.Confirmar_locacao)
        voltarTempo = findViewById(R.id.voltar_tempo)

        voltarTempo.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }

        val buttons = listOf(btnTempo1, btnTempo2, btnTempo3, btnTempo4, btnTempo5)

        confirmarLocacao.setOnClickListener {
            val horarioSelecionado = buttons.any { button ->
                button.currentTextColor == ContextCompat.getColor(this, R.color.green)
            }

            if (horarioSelecionado) {
                startActivity(Intent(this, Register2Activity::class.java))
                finish()
            } else {
                val msg = "Por favor, selecione um horário de locação."
                Snackbar.make(it, msg, Snackbar.LENGTH_SHORT).show()
            }
        }


        buttons.forEach { button ->
            button.setOnClickListener {
                textoHorarios.text = "Horário selecionado: ${button.text}"
                button.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                ) // Cor quando selecionado
                confirmarLocacao.isEnabled = true
                confirmarLocacao.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.green
                    )
                ) // Cor quando habilitado
            }
        }

        confirmarLocacao.setOnClickListener {
            if (confirmarLocacao.isEnabled) {
                buttons.forEach { btn ->
                    if (btn.currentTextColor == ContextCompat.getColor(this, R.drawable.border)) {
                        btn.setBackgroundColor(
                            ContextCompat.getColor(
                                this,
                                R.color.green
                            )
                        ) // Cor quando confirmado
                    }
                }
                confirmarLocacao.setBackgroundColor(ContextCompat.getColor(this, R.drawable.selected_button))
            }
        }


        fun resetButtonColors() {
            // Lista dos botões de tempo para resetar a cor.
            val timeButtons = listOf(btnTempo1, btnTempo2, btnTempo3, btnTempo4, btnTempo5)

            // Resetar a cor de fundo para o drawable original nos botões de tempo.
            timeButtons.forEach { button ->
                button.setBackgroundResource(R.color.white)
            }

            // Resetar a cor de fundo do botão de confirmação para a cor definida no colors.xml
            confirmarLocacao.setBackgroundColor(ContextCompat.getColor(this, R.drawable.border))
            confirmarLocacao.isEnabled = false
        }
    }
}