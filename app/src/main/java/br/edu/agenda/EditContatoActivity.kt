package br.edu.agenda

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import br.edu.agenda.databinding.ActivityEditContatoBinding

class EditContatoActivity : ComponentActivity() {

    private lateinit var binding: ActivityEditContatoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditContatoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contatoId = intent.getLongExtra("id", -1)
        val nome = intent.getStringExtra("nome") ?: ""
        val fone = intent.getStringExtra("fone") ?: ""
        val endereco = intent.getStringExtra("endereco") ?: ""
        val cidade = intent.getStringExtra("cidade") ?: ""

        binding.inputNome.setText(nome)
        binding.inputFone.setText(fone)
        binding.inputEndereco.setText(endereco)
        binding.inputCidade.setText(cidade)

        binding.buttonAdd.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("id", contatoId)
            resultIntent.putExtra("nome", binding.inputNome.text.toString())
            resultIntent.putExtra("fone", binding.inputFone.text.toString())
            resultIntent.putExtra("endereco", binding.inputEndereco.text.toString())
            resultIntent.putExtra("cidade", binding.inputCidade.text.toString())
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
