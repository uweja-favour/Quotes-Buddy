package com.example.quotesbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.pm.ShortcutInfoCompat.Surface
import com.example.quotesbuddy.presentation.HomeScreen
import com.example.quotesbuddy.ui.theme.QuotesBuddyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuotesBuddyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Surface(
                       modifier = Modifier
                           .fillMaxSize()
                           .padding(innerPadding)
                   ) {
                       MyApp()
                   }
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    HomeScreen()
}