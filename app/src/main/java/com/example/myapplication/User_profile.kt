package com.example.myapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController

@Composable
fun UserProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp) // Отступы от краёв экрана
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 36.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Иконка слева
            Icon(
                painter = painterResource(id = R.drawable.vector),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
                    .clickable { navController.popBackStack() }
            )

            // Текст "Профиль" по центру
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.profile),
                    fontFamily = FontFamily(Font(R.font.comfortaa)),
                    style = TextStyle(
                        color = colorResource(id = R.color.black),
                        fontSize = 36.sp
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically // Выравниваем элементы по центру
        ) {
            // Фото пользователя
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "Аватар",
                modifier = Modifier
                    .size(61.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(12.dp))

            // Колонка с именем и настройками
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(id = R.string.name),
                    fontFamily = FontFamily(Font(R.font.comfortaa)),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.color_address)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.setting),
                        fontFamily = FontFamily(Font(R.font.comfortaa)),
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.color_address)
                    )
                    Spacer(modifier = Modifier.width(6.dp))

                    // Иконка настроек
                    Icon(
                        painter = painterResource(id = R.drawable.settings),
                        contentDescription = "Настройки",
                        modifier = Modifier.size(16.dp),
                        tint = Color.Unspecified
                    )
                }
            }
        }

        val categories = listOf(
            R.drawable.orders to "Заказы",
            R.drawable.address to "Адреса",
            R.drawable.support to "Поддержка",
            R.drawable.payment to "Платеж"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 36.dp)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(4), // Делаем 4 колонки
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly // Равномерное распределение
            ) {
                items(categories) { (iconRes, title) ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = iconRes),
                            contentDescription = title,
                            tint = Color.Unspecified,
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = title,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.comfortaa)),
                            color = colorResource(id = R.color.color_address)
                        )
                    }
                }
            }
        }

        val options = listOf(
            R.drawable. review to "Оставить отзыв",
            R.drawable.questions to "Часто задаваемые вопросы",
            R.drawable.get_out to "Выйти"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 36.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp) // Отступ между элементами списка
        ) {
            options.forEach { (iconRes, title) ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = title,
                        modifier = Modifier.size(28.dp),
                        tint = Color.Unspecified
                    )

                    Spacer(modifier = Modifier.width(12.dp)) // Отступ между иконкой и текстом

                    Text(
                        text = title,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.comfortaa)),
                        color = colorResource(id = R.color.color_address)
                    )

                }
            }
        }
    }
}