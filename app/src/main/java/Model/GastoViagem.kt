package Model


class GastoViagem(
    val distancia: Double,
    val preco: Double,
    val autonomo: Double,
) {

    fun obteGastor() :Double{
        val valortotal = (distancia * preco) / autonomo
    return valortotal

    }
}