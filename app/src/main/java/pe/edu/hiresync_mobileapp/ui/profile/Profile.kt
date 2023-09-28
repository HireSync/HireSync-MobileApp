package pe.edu.hiresync_mobileapp.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.hiresync_mobileapp.R

@Composable
fun Profile(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.profilepicture),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        )
        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .wrapContentWidth()
                .background(
                    Color(0xFF6650a4),
                    shape = CircleShape
                ),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White
            ),
        ) {
            Text(text = "Change profile picture")
        }
        Text(
            text = "Natalia Gomez",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6650a4),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}