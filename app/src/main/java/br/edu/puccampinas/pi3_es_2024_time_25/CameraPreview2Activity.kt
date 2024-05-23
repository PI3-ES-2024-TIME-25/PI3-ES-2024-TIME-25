package br.edu.puccampinas.pi3_es_2024_time_25

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.puccampinas.pi3_es_2024_time_25.databinding.ActivityCameraPreview2Binding


class CameraPreview2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityCameraPreview2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCameraPreview2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnOpenCamera2.setOnClickListener {
            val intentCameraPreview = Intent(this, ContinuarSegundaFotoActivity::class.java)
            startActivity(intentCameraPreview)
        }

        binding.voltar.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()

        }
    }

}