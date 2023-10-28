package pe.edu.hiresync_mobileapp.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class PostulationDetail(
    val name: String,
    val description: String,
    var isApplied: Boolean,
    val applicationDate: String,
    val location: String,
    val salary: String,
    val contractType: String,
)
@Composable
fun PostulateDetail() {

    var postulation = PostulationDetail(
        name = "A Company",
        description = "Description of a company",
        isApplied = true,
        applicationDate = "04/02/2023 11:00 AM",
        location = "City, Country",
        salary = "$50,000 per year",
        contractType = "Full-time"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Postulation Detail",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.medium)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Name: ${postulation.name}", fontSize = 18.sp)
                Text(text = "Description: ${postulation.description}", fontSize = 14.sp, color = Color.Gray)
                Text(text = "Application Date: ${postulation.applicationDate}", fontSize = 12.sp, color = Color.Gray)
                Text(text = "Location: ${postulation.location}", fontSize = 12.sp, color = Color.Gray)
                Text(text = "Salary: ${postulation.salary}", fontSize = 12.sp, color = Color.Gray)
                Text(text = "Contract Type: ${postulation.contractType}", fontSize = 12.sp, color = Color.Gray)
            }
        }


        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Requirements:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            fontSize = 14.sp,
            color = Color.Gray
        )
        Text(
            text = "Suspendisse ultricies, felis eget suscipit cursus.",
            fontSize = 14.sp,
            color = Color.Gray
        )


        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Contact Information:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Email: contact@example.com",
            fontSize = 14.sp,
            color = Color.Gray
        )
        Text(
            text = "Phone: +123 456 7890",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0xFF3172D4))
        ) {
            Text(text = "Apply")
        }
    }
}
