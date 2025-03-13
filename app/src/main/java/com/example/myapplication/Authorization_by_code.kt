package com.example.myapplication

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun AuthorizationCodeScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column{
            Box(
                modifier = Modifier.padding(top = 25.dp, start = 16.dp) // Сначала отступы
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { navController.popBackStack() }
                )
            }

            Text(
                text = stringResource(id = R.string.autorization),
                fontFamily = FontFamily(Font(R.font.comfortaa)),
                color = Color.Black,
                fontSize = 36.sp,
                modifier = Modifier
                    .padding(start = 16.dp, top = 32.dp)

            )

            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                // Текст остаётся слева
                Text(
                    text = stringResource(id = R.string.sms),
                    fontFamily = FontFamily(Font(R.font.comfortaa)),
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 32.dp)
                )

                // Центрируем только обводку
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp), // Отступ сверху
                    horizontalArrangement = Arrangement.Center // Центрируем внутри строки
                ) {
                    Box(
                        modifier = Modifier
                            .width(380.dp)
                            .height(52.dp)
                            .border(2.dp, colorResource(id = R.color.text_button), shape = RoundedCornerShape(26.dp))
                            .padding(horizontal = 16.dp), // Внутренний отступ
                        contentAlignment = Alignment.Center
                    ) {
                        TextField(
                            value = "",
                            onValueChange = {},
                            placeholder = { Text(text = "****") },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(textAlign = TextAlign.Center) // Центрируем вводимый текст
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp), // Отступ от обводки
                    horizontalArrangement = Arrangement.Center // Центрируем кнопку
                ) {
                    Button(
                        onClick = { navController.navigate("restaurant_catalog") },
                        modifier = Modifier
                            .width(380.dp)
                            .height(52.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.background_button), // Цвет кнопки из colors.xml
                            contentColor = colorResource(id = R.color.text_button) // Цвет текста кнопки из colors.xml
                        ),
                        shape = RoundedCornerShape(16.dp) // Закругление углов
                    ) {
                        Text(
                            text = stringResource(id = R.string.enter), // Текст "Далее"
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.comfortaa))
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter // Работает для Box
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.keyboard),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
            }


        }
    }
}