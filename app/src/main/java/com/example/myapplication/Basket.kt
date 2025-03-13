package com.example.myapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Button
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun BasketScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Верхняя строка с заголовком "Корзина"
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Иконка назад
                Icon(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { navController.popBackStack() }
                )

                // Текст "Корзина" по центру
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.basket),
                        fontFamily = FontFamily(Font(R.font.comfortaa)),
                        style = TextStyle(
                            color = colorResource(id = R.color.black),
                            fontSize = 36.sp
                        ),
                        textAlign = TextAlign.Center
                    )
                }
            }

            // Фиксированная строка заголовков
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ваш заказ",
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.comfortaa))
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Кол-во",
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.comfortaa))
                    )

                    Text(
                        text = "Цена",
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.comfortaa))
                    )
                }
            }

            // Список заказов
            listOf(
                "Креветки Терияки" to "540р",
                "Овощи Терияки" to "490р"
            ).forEach { (dish, price) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = dish,
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.comfortaa)),
                        modifier = Modifier.width(IntrinsicSize.Max),
                        maxLines = 2, // Максимум 2 строки
                        overflow = TextOverflow.Ellipsis

                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "1",
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.comfortaa))
                        )

                        Text(
                            text = price,
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.comfortaa))
                        )

                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp,start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Общая стоимость",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.comfortaa))
                )

                Text(
                    text = "1030р",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.comfortaa))
                )
            }

            Button(
                onClick = { /* Обработка нажатия, например, переход на оплату */ },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.background_button),
                    contentColor = colorResource(id = R.color.text_button)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.place_an_order),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.comfortaa))
                )
            }
        }
    }
}