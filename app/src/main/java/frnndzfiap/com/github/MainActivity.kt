package frnndzfiap.com.github

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView
import frnndzfiap.com.github.adapter.PraiasAdapter
import frnndzfiap.com.github.viewmodel.PraiasViewModel
import androidx.activity.viewModels


class MainActivity : ComponentActivity() {
    val viewModel: PraiasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val PraiasAdapter = PraiasAdapter()

        recyclerView.adapter = PraiasAdapter

        val button = findViewById<Button>(R.id.button)
        val editTextNome = findViewById<EditText>(R.id.nomePraia)
        val editTextCidade = findViewById<EditText>(R.id.cidadePraia)
        val editTextEstado = findViewById<EditText>(R.id.estadoPraia)

        button.setOnClickListener {
            val nome = editTextNome.text.toString()
            val cidade = editTextCidade.text.toString()
            val estado = editTextEstado.text.toString()

            if (editTextNome.text.isEmpty() || editTextCidade.text.isEmpty() || editTextEstado.text.isEmpty()) {
                editTextNome.error = "Preencha todos os campos"
                return@setOnClickListener
            }

            viewModel.addItem(nome, cidade, estado)

            editTextNome.text.clear()
            editTextCidade.text.clear()
            editTextEstado.text.clear()
        }

        viewModel.praiasLiveData.observe(this) { praias ->
            PraiasAdapter.updatePraias(praias)
        }
    }
}