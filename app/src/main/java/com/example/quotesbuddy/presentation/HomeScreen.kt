package com.example.quotesbuddy.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.*


@Composable
fun HomeScreen(viewModel: QuotesBuddyViewModel = viewModel()) {
    val advice by viewModel.advice.collectAsState()

    LaunchedEffect(true) {
        viewModel.fetchAdvice()
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (advice.isNullOrEmpty()) {
            CircularProgressIndicator()
        } else {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = advice ?: "Error fetching advice", modifier = Modifier.padding(16.dp))
                Button(onClick = { viewModel.fetchAdvice() }) {
                    Text(text = "New Advice")
                }
            }

        }
    }
}