package com.elkite.eattherainbow.tools.helpers.recyclerview

open class ViewItemAction(
    private val doOnAction: () -> Unit = {}
) {
    fun onAction() {
        doOnAction()
    }
}