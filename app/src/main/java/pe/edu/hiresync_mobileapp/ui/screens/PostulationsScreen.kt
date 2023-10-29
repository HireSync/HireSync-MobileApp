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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import pe.edu.hiresync_mobileapp.data.model.Postulation
import pe.edu.hiresync_mobileapp.ui.viewModel.LoginViewModel
import pe.edu.hiresync_mobileapp.ui.viewModel.PostulationViewModel

@Composable
fun PostulationsScreen(viewModel: PostulationViewModel) {

    val postulations: List<Postulation> by viewModel.postulations.observeAsState(listOf())
    viewModel.getAll()
    LazyColumn {
        items(postulations) { postulation ->
            CharacterCard(postulation)
        }
    }
}

@Composable
fun CharacterCard(postulation: Postulation) {
    Card(modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(8.dp)
        ) {
            Column(modifier = Modifier.weight(5f)) {
                Text(text = "Name: "+postulation.name)
                Text(text = "Description: "+postulation.id.toString())
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
