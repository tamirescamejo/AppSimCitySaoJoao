package br.com.zup.simcitysaojoao.produto.detalhe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.zup.simcitysaojoao.CHAVE_PRODUTO
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentDetalhesProdutoBinding
import br.com.zup.simcitysaojoao.produto.ProdutosActivity
import br.com.zup.simcitysaojoao.produto.modal.Produtos

class DetalhesProdutoFragment : Fragment() {
    private lateinit var binding: FragmentDetalhesProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalhesProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recuperarExibirProdutos()
        favoritarProduto()
    }

    private fun recuperarExibirProdutos(): Produtos? {
        val produtos = arguments?.getParcelable<Produtos>(CHAVE_PRODUTO)
        if(produtos != null){
            binding.tvNomeProduto.text = produtos.getNomeProduto()
            binding.tvInserirQtd.text = produtos.getQuantidadeProduto()
            binding.tvInserirValor.text = produtos.getValorUnitarioProduto()
            binding.tvInserirReceita.text = produtos.getreceitaProduto()
        }
        return produtos
    }

    private fun favoritarProduto() {
        binding.ivFavorite.setOnClickListener {
            Toast.makeText(context, getString(R.string.msg_botaoFavoritar), Toast.LENGTH_LONG).show()
        }
    }
}