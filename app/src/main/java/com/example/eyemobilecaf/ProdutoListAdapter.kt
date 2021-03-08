package com.example.eyemobilecaf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat

class ProdutoListAdapter (private val dataSet: Array<Produto>, val cesta: CestaCompra) :
        RecyclerView.Adapter<ProdutoListAdapter.ViewHolder>() {

    val formatarMoeda = NumberFormat.getCurrencyInstance()

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View, val textWatcher: CafeXYZTextWatcher) : RecyclerView.ViewHolder(view) {
        val tvProduto: TextView
        val tvPreco: TextView
        val ivProduto: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            tvProduto = view.findViewById(R.id.tvProduto)
            tvPreco = view.findViewById(R.id.tvPreco)
            ivProduto = view.findViewById(R.id.ivPrduto)

            (view.findViewById(R.id.tnQtd) as EditText).addTextChangedListener( textWatcher )
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.produto_view, viewGroup, false)

        return ViewHolder(view, CafeXYZTextWatcher(cesta, dataSet))
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textWatcher.atualizaIndice(position)
        val resID: Int = viewHolder.itemView.context.resources.getIdentifier(dataSet[position].ImagemAsset, "drawable", viewHolder.itemView.context.packageName)

        viewHolder.ivProduto.setImageResource(resID)
        viewHolder.tvProduto.text = dataSet[position].Nome
        viewHolder.tvPreco.text = formatarMoeda.format(dataSet[position].Preco)

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

