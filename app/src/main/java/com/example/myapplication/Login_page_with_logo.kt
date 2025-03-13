package com.example.myapplication

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.res.colorResource
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login_page_with_logo"
    ) {
        composable("login_page_with_logo") { LogoScreen(navController) }
        composable("authorization_by_phone_number") { AuthorizationScreen(navController) }
        composable("authorization_by_code") { AuthorizationCodeScreen(navController) }
        composable("restaurant_catalog") { CatalogScreen(navController) }
        composable("user_profile") { UserProfileScreen(navController) }
        composable("basket") { BasketScreen(navController) }
        composable("restaurant_menu") { RestaurantMenuScreen(navController) }
    }
}

@Preview
@Composable
fun ShowLogoScreen(){
    val navController = rememberNavController()
    LogoScreen(navController)
}

@Composable
fun LogoScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.frame_logo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 690.dp, start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.welcome_text),
                color = Color.Black,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.comfortaa)),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Button(
                onClick = { navController.navigate("authorization_by_phone_number") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.background_button)
                ),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
                modifier = Modifier
                    .width(380.dp)
                    .height(52.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Продолжить",
                        fontFamily = FontFamily(Font(R.font.comfortaa)),
                        style = TextStyle(
                            color = colorResource(id = R.color.text_button),
                            fontSize = 20.sp
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}
