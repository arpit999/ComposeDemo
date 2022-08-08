package com.hometech.composedemo

/**
 *
 */
fun <T> List<T>.updateItem(item: T, condition: (T) -> Boolean) : List<T> {
    val items = this.toMutableList()
    val index = items.indexOfFirst(condition)
    if (index != -1) {
        items[index] = item
    }
    return items.toList()
}