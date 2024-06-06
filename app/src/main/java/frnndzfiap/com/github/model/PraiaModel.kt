package frnndzfiap.com.github.model

class PraiaModel (
    val nome: String,
    val cidade: String,
    val estado: String,
    val onRemove: (PraiaModel) -> Unit
        )
