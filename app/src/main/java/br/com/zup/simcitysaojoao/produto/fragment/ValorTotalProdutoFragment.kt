package br.com.zup.simcitysaojoao.produto.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentValorTotalProdutoBinding

class ValorTotalProdutoFragment : Fragment() {
    private lateinit var bindind: FragmentValorTotalProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindind = FragmentValorTotalProdutoBinding.inflate(inflater, container, false)
        return bindind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindind.btnCadastrarNovoProdutoCarrinho.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(
                R.id.action_valorTotalProdutoFragment_to_cadastroProdutosFragment
            )
        }

        bindind.btnVerProdutosCarrinho.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(
                R.id.action_valorTotalProdutoFragment_to_listaProdutoFragment
            )
        }
    }
}