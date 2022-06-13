package br.com.zup.simcitysaojoao.produto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcitysaojoao.databinding.ProdutosItemBinding
import br.com.zup.simcitysaojoao.produto.modal.Produtos

class ProdutosAdapter(
    private var listaProdutos: MutableList<Produtos>

) : RecyclerView.Adapter<ProdutosAdapter.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosAdapter.viewHolder {
        val binding =
            ProdutosItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val produtos = listaProdutos[position]
        holder.exibirDadosItemLista(produtos)
        holder.binding.cvitemProduto.setOnClickListener {
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

        fun exibirDadosItemLista(produto: Produtos) {
            binding.tvQtdProduto.text = produto.getQuantidadeProduto()
            binding.tvNomeProduto.text = produto.getNomeProduto()
        }
    }
}