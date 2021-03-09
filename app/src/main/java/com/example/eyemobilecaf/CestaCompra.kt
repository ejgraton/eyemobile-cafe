package com.example.eyemobilecaf

import android.view.View
import android.widget.Button
import java.text.NumberFormat

class CestaCompra(val PagarButton: Button) {

    interface ICestaCompraListener {
        fun MovimentoNaCesta(cesta: CestaCompra)
    }

    private var cestaListener: ICestaCompraListener? = null

    fun setCestaListener(listener: ICestaCompraListener){
        cestaListener = listener
    }

    var extrato = HashMap<Int, Double>()
    val formatarMoeda = NumberFormat.getCurrencyInstance()

    fun AlterarQtdItem(idxMenu: Int, produto: Produto, qtd: Double) {
        extrato.put(idxMenu, produto.Preco * qtd)

        PagarButton.text = "Pagar %s".format(formatarMoeda.format(TotalCompra()))

        cestaListener?.MovimentoNaCesta(this)
    }
    fun TotalCompra(): Double {
        return extrato.map{ it.value }.sum()
    }



}