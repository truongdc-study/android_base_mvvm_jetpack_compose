package com.truongdc.android.base.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.truongdc.android.base.navigation.AppNavHost
import com.truongdc.android.base.ui.theme.AndroidBaseThemeCompose
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            AndroidBaseThemeCompose {
                navHostController.AppNavHost()
            }
        }
    }
}
