package com.truongdc.android.base.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.truongdc.android.base.navigation.NavGraphDestination
import com.truongdc.android.base.navigation.navigate

@Composable
fun SecondScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(24.dp)
            .fillMaxSize()
    ) {
        Text(text = "Seconds Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(30.dp))
        Row {
            Button(onClick = {
                navController.navigate(NavGraphDestination.Up)
            }) {
                Text(text = "Back to First")
            }
            Spacer(modifier = Modifier.size(30.dp))
            Button(onClick = {
                navController.navigate(NavGraphDestination.Third.createRouter(id = "1999"))
            }) {
                Text(text = "Next to Third")
            }
        }

    }
}