package br.com.zup.simcitysaojoao.produto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcitysaojoao.databinding.ProdutosItemBinding
import br.com.zup.simcitysaojoao.produto.modal.Produtos

class ProdutosAdapter(
    private var listaProdutos: MutableList<Produtos>,
    private val clickProduto: (produto: Produtos) -> Unit
) : RecyclerView.Adapter<ProdutosAdapter.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosAdapter.viewHolder {
        val binding =
            ProdutosItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val produtos = listaProdutos[position]
        holder.exibirProdutosLista(produtos)
        holder.binding.cvitemProduto.setOnClickListener {
            clickProduto(produtos)
        }
    }

    override fun getItemCount(): Int = listaProdutos.size

    fun atualizarListaProdutos(novaListaProdutos: MutableList<Produtos>) {
        if (listaProdutos.size == 0) {
            listaProdutos = novaListaProdutos
        } else {
            listaProdutos.addAll(novaListaProdutos)
        }
        notifyDataSetChanged()
    }

    class viewHolder(val binding: ProdutosItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun exibirProdutosLista(produtos: Produtos) {
            binding.tvQtdProduto.text = produtos.getQuantidadeProduto()
            binding.tvNomeProduto.text = produtos.getNomeProduto()
        }
    }
}