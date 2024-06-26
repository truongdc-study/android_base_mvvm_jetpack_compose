package com.truongdc.android.base.ui.screens.slpash

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.truongdc.android.base.R
import com.truongdc.android.base.navigation.AppDestination
import com.truongdc.android.base.navigation.navigate
import com.truongdc.android.base.ui.theme.AppColors
import com.truongdc.android.base.ui.theme.DpSize
import com.truongdc.android.base.ui.theme.DpSize.dp30
import com.truongdc.android.base.ui.theme.SpSize.sp18
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navHostController: NavHostController,
    viewModel: SplashViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getIsLogin().collect { isLogin ->
            delay(1500)
            if (isLogin) {
                navHostController.navigate(AppDestination.MovieList) {
                    popUpTo(AppDestination.Splash.route) { inclusive = true }
                }
            } else {
                navHostController.navigate(AppDestination.Login) {
                    popUpTo(AppDestination.Splash.route) { inclusive = true }
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_movie),
                contentDescription = null,
                modifier = Modifier
                    .height(dp30)
                    .width(dp30)
            )
            Spacer(modifier = Modifier.width(DpSize.dp10))
            Text(
                text = "MOVIE APP",
                fontSize = sp18,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

    }
}
