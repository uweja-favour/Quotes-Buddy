package com.example.quotesbuddy.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesbuddy.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesBuddyViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel()  {

    private val _advice = MutableStateFlow<String?>(null)
    val advice = _advice

    fun fetchAdvice() {
        viewModelScope.launch {
            try {
                val adviceSlip = repository.getAdvice()
                _advice.value = adviceSlip.slip.advice
            }
            catch (e: Exception) {
                throw IllegalArgumentException(e)
            }
        }
    }

}