package com.ristlitelink.ristlitelink

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ristlitelink.ristlitelink.activities.SignInActivity
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashComposable {
                navigateToSignInActivity()
            }
        }
    }

    @Composable
    fun SplashComposable(onTimeout: () -> Unit) {
        LaunchedEffect(key1 = true) {
            delay(2000) // Wait for 2000 ms
            onTimeout()
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.big_logo),
                contentDescription = "logo",
                modifier = Modifier
                    .align(Alignment.Center) // Align image to the center
                    .size(width = 230.dp, height = 230.dp)
            )
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.BottomCenter) // Align progress indicator to the bottom center
                    .padding(bottom = 10.dp),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewSplashScreen() {
        SplashComposable {
            navigateToSignInActivity()
        }
    }

    private fun navigateToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun navigateToSignInActivity() {
        startActivity(Intent(this, SignInActivity::class.java))
        finish()
    }
}