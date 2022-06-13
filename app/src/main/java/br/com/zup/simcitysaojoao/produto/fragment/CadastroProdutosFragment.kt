package br.com.zup.simcitysaojoao.produto.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.produto.adapter.ProdutosAdapter
import br.com.zup.simcitysaojoao.databinding.FragmentCadastroProdutosBinding
import br.com.zup.simcitysaojoao.produto.modal.Produtos

class CadastroProdutosFragment : Fragment() {
    private lateinit var binding: FragmentCadastroProdutosBinding

    private val produtosAdapter: ProdutosAdapter by lazy {
        ProdutosAdapter(arrayListOf())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastroProdutosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCadastrarNovoProduto.setOnClickListener {
            adicionarItemListaProdutos()
            limparCamposEdicao()
            Toast.makeText(context, "Produto Cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
        }

        binding.btnVerProdutos.setOnClickListener {
            listaProdutosView()
        }

        binding.btnValorTotalProduto.setOnClickListener {
            valorTotalView()
        }
    }

    private fun adicionarItemListaProdutos() {
        val listaNovoProduto = mutableListOf<Produtos>()

        val produtos = recuperarDadosCamposEdicao()

        if (produtos != null) {
            listaNovoProduto.add(produtos)
            produtosAdapter.atualizarListaProdutos((listaNovoProduto))
        } else {
            exibirMensagemErro()
        }
    }

    private fun recuperarDadosCamposEdicao(): Produtos? {
        val nomeProduto = binding.etNomeProduto.text.toString()
        val qtdProduto = binding.etQuantidadeProduto.text.toString()
        val valorProduto = binding.etValorUnitarioProduto.text.toString()
        val receitaProduto = binding.etReceita.text.toString()

        if (nomeProduto.isNotEmpty() && qtdProduto.isNotEmpty() && valorProduto.isNotEmpty() && receitaProduto.isNotEmpty()) {
            limparCamposEdicao()
            return Produtos(nomeProduto, qtdProduto, valorProduto, receitaProduto)
        }
        return null
    }

    private fun exibirMensagemErro() {
        binding.etNomeProduto.error = "Campo obrigatório"
        binding.etQuantidadeProduto.error = "Campo obrigatório"
        binding.etValorUnitarioProduto.error = "Campo obrigatório"
        binding.etReceita.error = "Campo obrigatório"
    }

    private fun limparCamposEdicao() {
        binding.etNomeProduto.text.clear()
        binding.etQuantidadeProduto.text.clear()
        binding.etValorUnitarioProduto.text.clear()
        binding.etReceita.text.clear()
    }

    private fun listaProdutosView() {
        NavHostFragment.findNavController(this).navigate(
            R.id.action_cadastroProdutosFragment_to_listaProdutoFragment
        )
    }

    private fun valorTotalView() {
        NavHostFragment.findNavController(this).navigate(
            R.id.action_cadastroProdutosFragment_to_valorTotalProdutoFragment
        )
    }
}