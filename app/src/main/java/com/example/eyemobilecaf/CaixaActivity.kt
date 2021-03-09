package com.example.eyemobilecaf

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.eyemobilecaf.databinding.ActivityCaixaBinding
import java.text.NumberFormat

class CaixaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCaixaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCaixaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val valorConsumo = intent.extras?.getDouble("VALOR_CONSUMO", 0.0)
        val formatarMoeda = NumberFormat.getCurrencyInstance()

        val tvValorConsumido = findViewById<TextView>(R.id.tvValorConsumido)
        tvValorConsumido.text = resources.getString(R.string.consumido).format(formatarMoeda.format(valorConsumo))

        val tvTotalCaixa = findViewById<TextView>(R.id.tvTotalCaixa)
        tvTotalCaixa.text = resources.getString(R.string.total).format(formatarMoeda.format(valorConsumo))

        val etDesconto = findViewById<EditText>(R.id.etDesconto)
        etDesconto.addTextChangedListener (object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val strDesconto = s.toString().trim()
                val desconto = if(strDesconto.isNotEmpty()) strDesconto.toDouble() else 0.0
                tvTotalCaixa.text = resources.getString(R.string.total).format(formatarMoeda.format(valorConsumo?.minus(desconto)))
            }

        })
    }
}