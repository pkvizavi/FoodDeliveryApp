package com.example.myapplication

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.background
import androidx.compose.ui.text.font.Font
import androidx.compose.material3.Divider
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.LazyRow

@Composable
fun CatalogScreen(navController: NavHostController) {
    val comfortaa = FontFamily(Font(R.font.comfortaa)) // Подключаем шрифт
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp) // Отступы от краёв экрана
    ) {
        // Контейнер для строки с заголовком, адресом и фото
        Row(
            modifier = Modifier
                .fillMaxWidth(), // Растягиваем на всю ширину
            horizontalArrangement = Arrangement.SpaceBetween, // Адрес слева, фото справа
            verticalAlignment = Alignment.CenterVertically // Выравниваем по вертикали
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically // Выравнивание по центру
                ) {
                    Text(
                        text = stringResource(id = R.string.address_delivery),
                        fontFamily = FontFamily(Font(R.font.comfortaa)), // Указываем шрифт
                        style = TextStyle(
                            color = colorResource(id = R.color.color_address),
                            fontSize = 16.sp
                        )
                    )

                    Spacer(modifier = Modifier.width(4.dp)) // Отступ между текстом и иконкой

                    Image(
                        painter = painterResource(id = R.drawable.down_arrow), // Стрелка вниз
                        contentDescription = null,
                        modifier = Modifier.size(16.dp) // Размер иконки
                    )
                }

                Spacer(modifier = Modifier.height(2.dp)) // Отступ между строками

                Text(
                    text = stringResource(id = R.string.addr), // Адрес пользователя
                    fontFamily = FontFamily(Font(R.font.comfortaa)), // Такой же шрифт
                    style = TextStyle(
                        color = colorResource(id = R.color.color_address),
                        fontSize = 12.sp
                    )
                )
            }

            // Фото пользователя (справа)
            Image(
                painter = painterResource(id = R.drawable.user), // Замените на свою картинку
                contentDescription = "Фото пользователя",
                modifier = Modifier
                    .size(50.dp) // Размер фото
                    .clip(CircleShape) // Делаем круглым
                    .border(2.dp, Color.Gray, CircleShape) // Обводка
                    .clickable { navController.navigate("user_profile")}
            )
        }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Центрируем обводку
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp), // Отступ сверху
                horizontalArrangement = Arrangement.Center // Центрируем внутри строки
            ) {
                Box(
                    modifier = Modifier
                        .width(380.dp)
                        .height(52.dp)
                        .border(
                            2.dp,
                            colorResource(id = R.color.text_button),
                            shape = RoundedCornerShape(26.dp)
                        )
                        .padding(horizontal = 8.dp), // Внутренний отступ
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Иконка "Search" по центру
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                                .weight(1f), // Растягиваем, чтобы заняло доступное пространство и центрировалось
                            tint = Color.Unspecified
                        )

                        // Иконка "Фильтр" справа с отступом 8.dp
                        Icon(
                            painter = painterResource(id = R.drawable.filter),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(start = 4.dp),
                            tint = Color.Unspecified
                        )
                    }
                }
            }
            Icon(
                painter = painterResource(id = R.drawable.subscription),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(top = 16.dp)
            )

            Divider(
                color = colorResource(id = R.color.line), // Цвет из colors.xml
                thickness = 1.dp, // Толщина линии
                modifier = Modifier
                    .fillMaxWidth() // Растягиваем на всю ширину
                    .padding(vertical = 8.dp) // Отступы сверху и снизу
            )

            val categories = listOf(
                R.drawable.burger to "бургеры",
                R.drawable.sushi to "суши",
                R.drawable.pizza to "пицца",
                R.drawable.shaurma to "шаурма",
                R.drawable.georgian to "грузия"
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Text(
                    text = stringResource(id = R.string.categories), // Используем строку из ресурсов
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.comfortaa)),
                    fontWeight = FontWeight.Bold, // Делаем заголовок жирным
                    color = Color.Black,
                )

                // Горизонтальный список категорий
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    contentPadding = PaddingValues(horizontal = 4.dp)
                ) {
                    items(categories) { (iconRes, title) ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.width(77.dp) // Фиксированная ширина для выравнивания
                        ) {
                            Icon(
                                painter = painterResource(id = iconRes),
                                contentDescription = title,
                                tint = Color.Unspecified, // Оставляем оригинальный цвет SVG
                                modifier = Modifier
                                    .size(75.dp) // Размер иконки

                            )
                            Spacer(modifier = Modifier.height(4.dp)) // Отступ между иконкой и текстом
                            Text(
                                text = title,
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.comfortaa)),
                                color = Color.Black
                            )
                        }
                    }
                }

                Divider(
                    color = colorResource(id = R.color.line), // Цвет из colors.xml
                    thickness = 1.dp, // Толщина линии
                    modifier = Modifier
                        .fillMaxWidth() // Растягиваем на всю ширину
                        .padding(vertical = 4.dp) // Отступы сверху и снизу
                )

            }

            Row(){

                Text(
                    text = stringResource(id = R.string.restaurant), // Используем строку из ресурсов
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.comfortaa)),
                    fontWeight = FontWeight.Bold, // Делаем заголовок жирным
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 8.dp)
                )

                Spacer(modifier = Modifier.weight(1f)) // Занимает всё свободное пространство

                Icon(
                    painter = painterResource(id = R.drawable.sort),
                    contentDescription = "Фильтрация категорий",
                    tint = Color.Unspecified, // Оставляем оригинальный цвет SVG
                    modifier = Modifier
                        .size(30.dp) // Размер иконки
                        .padding(top = 8.dp)
                )
            }

            val restaurants = listOf(
                Restaurant(
                    name = "Katsuei",
                    imageRes = R.drawable.rest1,
                    rating = "4.8",
                    deliveryInfo = "10-15 мин | Бесплатная доставка от 700р"
                ),
                Restaurant(
                    name = "Sushi Place",
                    imageRes = R.drawable.rest2,
                    rating = "4.5",
                    deliveryInfo = "15-20 мин | Бесплатная доставка от 500р"
                )
            )

            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(restaurants) { restaurant ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.White)
                                .padding(top = 16.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxWidth()) {
                                Image(
                                    painter = painterResource(id = restaurant.imageRes),
                                    contentDescription = "Изображение ресторана",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .clickable { navController.navigate("restaurant_menu")}
                                )

                                // Лайк
                                Icon(
                                    painter = painterResource(id = R.drawable.like),
                                    contentDescription = "Нравится",
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .padding(8.dp)
                                        .size(31.dp)
                                )

                                // Рейтинг
                                Row(
                                    modifier = Modifier
                                        .align(Alignment.BottomEnd)
                                        .padding(8.dp)
                                        .background(Color.Black.copy(alpha = 0.7f), RoundedCornerShape(6.dp))
                                        .padding(horizontal = 10.dp, vertical = 3.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = restaurant.rating,
                                        fontFamily = FontFamily(Font(R.font.comfortaa)),
                                        fontSize = 14.sp,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            // Название ресторана
                            Text(
                                text = restaurant.name,
                                fontSize = 22.sp,
                                fontFamily = FontFamily(Font(R.font.comfortaa)),
                                color = Color.Black
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            // Информация о доставке
                            Text(
                                text = restaurant.deliveryInfo,
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.comfortaa)),
                                color = Color.Gray
                            )
                        }
                    }
                }

                // Фиксированная кнопка корзины
                Icon(
                    painter = painterResource(id = R.drawable.basket), // Картинка корзины
                    contentDescription = "Корзина",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .align(Alignment.TopEnd) // Фиксируем в правом верхнем углу
                        .padding(top = 240.dp)
                        .size(48.dp)
                        .clickable { navController.navigate("basket")}
                )
            }
        }



    }
}

data class Restaurant(
    val name: String,
    val imageRes: Int,
    val rating: String,
    val deliveryInfo: String
)

