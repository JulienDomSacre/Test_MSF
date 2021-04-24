package com.juliensacre.testmsf.ui.trombi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.map
import androidx.recyclerview.widget.LinearLayoutManager
import com.juliensacre.testmsf.R
import com.juliensacre.testmsf.ui.trombi.model.TrombiContentUiModel
import kotlinx.android.synthetic.main.fragment_trombi.*
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrombiFragment : Fragment(R.layout.fragment_trombi) {
    private val viewModel: TrombiViewModel by viewModel()
    private val viewAdapter = TrombiAdapter { devSelected ->
        devSelected.id.let {
            // Use navigation to go on screen for show the dev information
        }
    }

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeUiData()
        viewModel.fetchTrombi()
        setHasOptionsMenu(true)
    }

    private fun observeUiData() {
        viewModel.uiLiveData.map { it.errorText }
            .observe(viewLifecycleOwner, ::updateErrorContent)
        viewModel.uiLiveData.map { it.contentUiModel }
            .observe(viewLifecycleOwner, ::displayListUser)
    }

    private fun displayListUser(content: TrombiContentUiModel?) {
        pb_trombi_loading.visibility = View.GONE
        rv_trombi_devs.visibility = View.VISIBLE
        content?.let {
            viewAdapter.updateValues(it.listDevs)
        }
    }

    private fun updateErrorContent(errorContent: String?) {
        if(!errorContent.isNullOrEmpty()){
            Toast.makeText(requireContext(),errorContent,Toast.LENGTH_LONG).show()
        }
    }

    private fun initRecyclerView() {
        rv_trombi_devs.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = viewAdapter
        }
    }
}