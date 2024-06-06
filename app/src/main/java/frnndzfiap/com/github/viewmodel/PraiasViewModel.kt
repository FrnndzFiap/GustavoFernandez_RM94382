package frnndzfiap.com.github.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import frnndzfiap.com.github.model.PraiaModel

class PraiasViewModel: ViewModel() {

    private var praias = mutableListOf<PraiaModel>()
    val praiasLiveData = MutableLiveData<List<PraiaModel>>()

    fun addItem(nome: String, cidade: String, estado: String) {
        val praia = PraiaModel(nome = nome, cidade = cidade, estado = estado, onRemove = ::removeItem)
        praias.add(praia)
        praiasLiveData.value = praias
    }

    private fun removeItem(item: PraiaModel) {
        praias.remove(item)
        praiasLiveData.value = praias
    }
}