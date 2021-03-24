package com.mercadolibre.productsearch.presentation.base

import java.lang.Exception

data class UiStatus<Data>(
    var status: Status,
    var data: Data? = null,
    var error: Exception? = null
)

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}
