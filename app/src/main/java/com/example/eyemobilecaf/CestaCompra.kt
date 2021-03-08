package com.example.eyemobilecaf

import android.view.View

class CestaCompra(val PagarButton: View) {
    var extrato = HashMap<Int, Double>()

    fun AlterarQtdItem(idxMenu: Int, produto: Produto, qtd: Double) {
        extrato.put(idxMenu, produto.Preco * qtd)
    }

    fun TotalCompra(){
        return extrato.map{ it.value }.sum()
    }

}