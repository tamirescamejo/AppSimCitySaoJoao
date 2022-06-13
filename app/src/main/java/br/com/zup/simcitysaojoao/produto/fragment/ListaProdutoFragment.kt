package br.com.zup.simcitysaojoao.produto.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.simcitysaojoao.databinding.FragmentListaProdutoBinding

class ListaProdutoFragment : Fragment() {
    private lateinit var binding: FragmentListaProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }
}