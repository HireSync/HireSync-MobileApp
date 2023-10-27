package pe.edu.hiresync_mobileapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Postulation(
    val name: String,
    val description: String,
    var isApplied: Boolean,
    val applicationDate: String,
    val location: String,
    val salary: String,
    val contractType: String,
)

@Composable
fun PostulationList() {
    val postulations = getSamplePostulations()

    LazyColumn {
        items(postulations) { postulation ->
            PostulationCard(postulation)
        }
    }
}

fun getSamplePostulations(): List<Postulation> {
    return listOf(
        Postulation(
            name = "A Company",
            description = "Description of a company",
            isApplied = true,
            applicationDate = "04/02/2023 11:00 AM",
            location = "City, Country",
            salary = "$50,000 per year",
            contractType = "Full-time"
        ),
        Postulation(
            name = "Another Company",
            description = "Description of a another company",
            isApplied = false,
            applicationDate = "08/03/2023 5:00 PM",
            location = "City, Country",
            salary = "$30,000 per year",
            contractType = "Part-time"
        ),
    )
}

@Composable
fun PostulationCard(postulation: Postulation) {
    val isApplied = remember { mutableStateOf(false) }
    isApplied.value = postulation.isApplied

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White)
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
            //.clickable {  }
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
            Row (modifier = Modifier.padding(top = 8.dp)){
                // Si no hay más detalles, se puede eliminar el botón "View Details"
                Button(onClick = { /* Acción para ver más detalles */ }) {
                    Text(text = "View Details")
                }
                TextButton(
                    onClick = {
                        if (!isApplied.value) {
                            isApplied.value = true
                        }
                    }
                ) {
                    Text(text = "Apply")
                }

            }
        }
    }
}

