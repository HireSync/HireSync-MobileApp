package pe.edu.hiresync_mobileapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import pe.edu.hiresync_mobileapp.R
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pe.edu.hiresync_mobileapp.data.model.UserRequest
import pe.edu.hiresync_mobileapp.ui.viewModel.LoginViewModel
import pe.edu.hiresync_mobileapp.ui.viewModel.ViewModelLogin

@Composable
fun ProfileScreen(navController: NavController, viewModel: ViewModelLogin){
    var receiveNews by remember { mutableStateOf(false) }

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
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3172D4),
                disabledContainerColor = Color(0xFF3172D4),
                contentColor = Color.White
            )
        ) {
            Text(text = "Change profile picture")
        }
        Text(
            text = "Elizabeth James",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6650a4),
            modifier = Modifier.padding(top = 8.dp)
        )
        ProfileUpdateCard(viewModel)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = receiveNews,
                onCheckedChange = { isChecked ->
                    receiveNews = isChecked
                },
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "I want to receive news from HireSync via email",
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Handle Profile Settings click */ },
                modifier = Modifier
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3172D4),
                    disabledContainerColor = Color(0xFF3172D4),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Profile Settings")
            }
            Button(
                onClick = { /* Handle App Settings click */ },
                modifier = Modifier
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3172D4),
                    disabledContainerColor = Color(0xFF3172D4),
                    contentColor = Color.White
                )
            ) {
                Text(text = "App Settings")
            }
        }
    }
}

@Composable
fun ProfileUpdateCard(viewModel: ViewModelLogin) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("")}
    var confirmpass by remember { mutableStateOf("")}
    var currentpass by remember { mutableStateOf("")}
    var newpass by remember { mutableStateOf("")}
    var phone by remember { mutableStateOf("")}
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "Name:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black
                )
                BasicTextField(
                    value = name,
                    onValueChange = { newName ->
                        name = newName
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .border(1.dp, Color.Black)
                )
                Text(
                    text = "Email:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black
                )
                BasicTextField(
                    value = email,
                    onValueChange = { Email ->
                        email = Email
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .border(1.dp, Color.Black)
                )

                Text(
                    text = "Confirm Password:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black
                )
                BasicTextField(
                    value = confirmpass,
                    onValueChange = { Confirm ->
                        confirmpass = Confirm
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .border(1.dp, Color.Black)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "Current Password:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black
                )
                BasicTextField(
                    value = currentpass,
                    onValueChange = { Current ->
                        currentpass = Current
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .border(1.dp, Color.Black)
                )
                Text(
                    text = "New Password:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black
                )
                BasicTextField(
                    value = newpass,
                    onValueChange = { NewPass ->
                        newpass = NewPass
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .border(1.dp, Color.Black)
                )
                Text(
                    text = "Phone Number:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black

                )
                BasicTextField(
                    value = phone,
                    onValueChange = { newPhone ->
                        // Validar que el nuevo valor ingresado sea numérico
                        if (newPhone.all { it.isDigit() }) {
                            phone = newPhone
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .border(1.dp, Color.Black),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    )
                )

            }
        }
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally) // Centrar horizontalmente
        ) {
            Button(
                onClick = {
                    val updatedProfile = UserRequest(
                        firstName = name,
                        password = email,
                        email = confirmpass,
                        // Otros campos según sea necesario (confirmpass, currentpass, newpass, phone)
                    )
                    viewModel.editProfile(updatedProfile)
                },
                modifier = Modifier
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3172D4),
                    disabledContainerColor = Color(0xFF3172D4),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Save Changes",
                    color = Color.White
                )
            }
        }

    }
}
