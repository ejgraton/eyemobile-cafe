package com.example.eyemobilecaf

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class CafeXYZTextWatcher(val cesta: CestaCompra?, val Menu: Array<Produto>) : TextWatcher {
    var idxMenu: Int = -1;

    fun atualizaIndice(i: Int) {
        idxMenu = i
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(s: Editable?) {
        val qtdStr = s.toString().trim()
        val qtd = if(qtdStr.isEmpty()) 0.0 else qtdStr.toDouble()
        cesta?.AlterarQtdItem(idxMenu, Menu[idxMenu], qtd)
    }
}