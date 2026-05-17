package com.erde.praktikummobilelibrary.Modul_7

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CalculatorScreenViewModel : ViewModel() {
    private var _discount = MutableStateFlow(0)
    val discount = _discount.asStateFlow()

    fun reset() {
        setMemberName("Guest")
        setMemberStatus(false)
        _discount.update { 0 }
    }

    fun compute(number: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            Thread.sleep(10000)
            val percent = if (number > 100000) 0.2 else 0.1
            _discount.update { (percent * number).toInt() }
            if (number > 100000) {
                setMemberStatus(true)
                setMemberName("Raditya Dharma")
            } else reset()
        }
    }

    private var _user = MutableStateFlow(User())
    val user = _user.asStateFlow()

    private fun setMemberName(name: String) {
        _user.update { it.copy(name = name) }
    }

    private fun setMemberStatus(status: Boolean) {
        _user.update { it.copy(memberStatus = status) }
    }
}

data class User(val name: String = "Guest",
                val memberStatus: Boolean = false)