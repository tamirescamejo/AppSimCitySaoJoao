package br.com.zup.simcitysaojoao.produto.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.CHAVE_PRODUTO
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentCadastroProdutosBinding
import br.com.zup.simcitysaojoao.produto.modal.Produtos

class CadastroProdutosFragment : Fragment() {
    private lateinit var binding: FragmentCadastroProdutosBinding

    private var nomeProduto: String = ""
    private var qtdProduto: String = ""
    private var valorProduto: String = ""
    private var receitaProduto: String = ""
    private var listaProdutos = mutableListOf<Produtos>()

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
            adicionarProdutoListaProdutos()
            limparCamposEdicao()
        }

        binding.btnVerProdutos.setOnClickListener {
            verListaProdutos()
        }

        binding.btnValorTotalProduto.setOnClickListener {
            verValorTotalProduto()
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

    private fun adicionarProdutoListaProdutos() {
        val produtos = recuperarDadosCamposEdicao()

        if (produtos != null) {
            listaProdutos.add(Produtos(nomeProduto, qtdProduto, valorProduto, receitaProduto))
            Toast.makeText(context, getString(R.string.msg_cadastradoComSucesso), Toast.LENGTH_SHORT).show()
        } else {
            exibirMensagemErro()
        }
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

    private fun verListaProdutos() {
        val bundle = bundleOf(CHAVE_PRODUTO to listaProdutos)

        NavHostFragment.findNavController(this).navigate(
            R.id.action_cadastroProdutosFragment_to_listaProdutoFragment, bundle)

    }

    private fun verValorTotalProduto() {
        NavHostFragment.findNavController(this).navigate(
            R.id.action_cadastroProdutosFragment_to_valorTotalProdutoFragment
        )
    }
}