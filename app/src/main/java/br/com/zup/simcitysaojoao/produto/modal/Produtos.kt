package br.com.zup.simcitysaojoao.produto.modal


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Produtos(
    private var nomeproduto: String,
    private var quantidadeProduto: String,
    private var valorUnitarioProduto: String,
    private var receitaProduto: String
) : Parcelable {
    fun getNomeProduto() = this.nomeproduto
    fun getQuantidadeProduto() = this.quantidadeProduto
    fun getValorUnitarioProduto() = this.valorUnitarioProduto
    fun getreceitaProduto() = this.receitaProduto
}
