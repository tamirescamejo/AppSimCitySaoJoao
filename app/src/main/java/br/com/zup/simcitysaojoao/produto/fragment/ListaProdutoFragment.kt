package br.com.zup.simcitysaojoao.produto.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.simcitysaojoao.CHAVE_PRODUTO
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentListaProdutoBinding
import br.com.zup.simcitysaojoao.produto.adapter.ProdutosAdapter
import br.com.zup.simcitysaojoao.produto.modal.Produtos

class ListaProdutoFragment : Fragment() {
    private lateinit var binding: FragmentListaProdutoBinding

    private val produtosAdapter: ProdutosAdapter by lazy {
        ProdutosAdapter(arrayListOf(), ::irParaDetalheProduto)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gerarListaProdutos()
    }

    private fun gerarListaProdutos() {
        var listaProdutos = arguments?.getParcelableArrayList<Produtos>(CHAVE_PRODUTO)
        if (listaProdutos != null) {
            produtosAdapter.atualizarListaProdutos(listaProdutos)
            exibirRecyclerView()
        }
    }

    private fun exibirRecyclerView() {
        binding.rvListaProduto.adapter = produtosAdapter
        binding.rvListaProduto.layoutManager = LinearLayoutManager(context)
    }

    private fun irParaDetalheProduto(produto: Produtos) {
        val bundle = bundleOf(CHAVE_PRODUTO to produto)

        NavHostFragment.findNavController(this).navigate(
            R.id.action_listaProdutoFragment_to_detalhesProdutoFragment
        )
    }
}