package pe.edu.hiresync_mobileapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pe.edu.hiresync_mobileapp.data.model.Postulation
import pe.edu.hiresync_mobileapp.ui.viewModel.PostulationViewModel

@Composable
fun PostulationsScreen(navController: NavController, viewModel: PostulationViewModel) {

    val postulations: List<Postulation> by viewModel.postulations.observeAsState(listOf())
    viewModel.getAll()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)

        ) {
            NavBar(navController)
        }
        Column{
            LazyColumn {
                items(postulations) { postulation ->
                    PostulationCard(postulation, navController)
                }
            }
        }
    }

}

@Composable
fun PostulationCard(postulation: Postulation, navController: NavController) {
    val isApplied = remember { mutableStateOf(false) }
    isApplied.value = postulation.isApplied
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.White)
                .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
                //.clickable { }
                .shadow(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = postulation.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    if (isApplied.value) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Applied",
                            tint = Color.Green
                        )
                    }
                }
                Text(text = postulation.description, fontSize = 14.sp, color = Color.Gray)
                Text(
                    text = "Application Date: ${postulation.applicationDate}",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                // Detalles adicionales
                Text(text = "Location: ${postulation.location}", fontSize = 12.sp, color = Color.Gray)
                Text(text = "Salary: ${postulation.salary}", fontSize = 12.sp, color = Color.Gray)
                Text(
                    text = "Contract Type: ${postulation.contractType}",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(Color(0xFF3172D4))
                    ) {
                        Text(text = "View Details", color = Color.White) // Color del texto en blanco
                    }

                    TextButton(
                        onClick = {
                            if (!isApplied.value) {
                                isApplied.value = true
                            }
                        },
                        colors = ButtonDefaults.textButtonColors(contentColor = Color(0xFF3172D4))
                    ) {
                        Text(text = "Apply", color = Color(0xFF3172D4))
                    }
                }
            }
        }
    }
}

/*
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
}*/
