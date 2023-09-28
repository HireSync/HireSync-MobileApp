package pe.edu.hiresync_mobileapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pe.edu.hiresync_mobileapp.ui.viewModel.LoginViewModel

@Composable
fun PostulationsScreen(navController: NavController, viewModel: LoginViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F9FF))
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)

        ) {
            NavBar(navController)
        }
        PostulationsContent()
    }
}

@Composable
fun PostulationsContent() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Recruitments",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(5.dp)
        )
        Text(
            text = "Click in the list to see details",
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier.padding(5.dp)
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp, vertical = 4.dp)
                    .background(Color.White, shape = RoundedCornerShape(20.dp)),


                ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "Filter by",
                        modifier = Modifier
                            .wrapContentWidth(),
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        null,
                        modifier = Modifier.padding(4.dp),
                        tint = Color.Black
                    )
                }
            }
            Box(modifier = Modifier.weight(1f)) {
                Text(
                    text = "See past recruitments",
                    modifier = Modifier
                        .wrapContentWidth()
                        .background(Color.White, shape = RoundedCornerShape(20.dp))
                        .padding(horizontal = 15.dp, vertical = 4.dp),
                )
            }
        }
        CompanyCard(
            name = "HireSync",
            description = "2023-Business Administration UPC Internship Program Recruitment",
            recruitmentStatus = "Interview",
            applicationDate = "04/02/2023 11:00 AM"
        )
        CompanyCard(
            name = "Mercado Libre",
            description = "IT Support Mercado Libre Trainee Program",
            recruitmentStatus = "Application Date",
            applicationDate = "24/06/2023 1:30 PM"
        )
    }
}

@Composable
fun CompanyCard(
    name: String,
    description: String,
    recruitmentStatus: String,
    applicationDate: String
) {
    Card(
        modifier = Modifier.padding(20.dp),
        shape = RectangleShape,
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(
                    text = "Company: $name",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp)
                )
                Icon(
                    Icons.Default.KeyboardArrowDown,
                    null,
                    modifier = Modifier.padding(4.dp),
                    tint = Color.Black
                )
            }
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF3172D4)),
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
                    .height(65.dp)
            ) {
                Column {
                    Text(
                        text = "Description:",
                        color = Color.White,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 1.dp)
                    )
                    Text(
                        text = description,
                        color = Color.White,
                        fontSize = 15.sp,
                        lineHeight = 15.sp,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 1.dp)
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF3172D4)),
                    modifier = Modifier
                        .padding(4.dp)
                        .height(50.dp)
                ) {
                    Column{
                        Text(
                            text = "Recruitment Status:",
                            color = Color.White,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 1.dp)
                        )
                        Text(
                            text = recruitmentStatus,
                            color = Color.White,
                            fontSize = 15.sp,
                            lineHeight = 15.sp,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 1.dp)
                        )
                    }
                }
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF3172D4)),
                    modifier = Modifier
                        .padding(4.dp)
                        .height(50.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Application Date:",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 1.dp)
                        )
                        Text(
                            text = applicationDate,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            lineHeight = 15.sp,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 1.dp)
                        )
                    }
                }
            }
        }
    }
}