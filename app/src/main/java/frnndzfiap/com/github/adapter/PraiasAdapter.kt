package frnndzfiap.com.github.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import frnndzfiap.com.github.R
import frnndzfiap.com.github.model.PraiaModel

class PraiasAdapter : RecyclerView.Adapter<PraiasAdapter.PraiaViewHolder>() {
    private var praias = listOf<PraiaModel>()

    fun updatePraias(newPraias: List<PraiaModel>) {
        praias = newPraias
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PraiaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.praia_layout, parent, false)
        return PraiaViewHolder(view)
    }
    override fun getItemCount(): Int = praias.size
    override fun onBindViewHolder(holder: PraiaViewHolder, position: Int) {
        val praia = praias[position]
        holder.bind(praia)
    }
    class PraiaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textNomePraia = view.findViewById<TextView>(R.id.textNomePraia)
        val textNomeCidade = view.findViewById<TextView>(R.id.textNomeCidade)
        val textNomeEstado = view.findViewById<TextView>(R.id.textNomeEstado)
        val botaoApagar = view.findViewById<Button>(R.id.botaoApagar)
        fun bind(praia: PraiaModel) {
            textNomePraia.text = praia.nome
            textNomeCidade.text = praia.cidade
            textNomeEstado.text = praia.estado
            //button.setOnClickListener {
                //item.onRemove(item)
            //}
        }
    }
}