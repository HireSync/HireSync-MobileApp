package pe.edu.hiresync_mobileapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pe.edu.hiresync_mobileapp.R
import pe.edu.hiresync_mobileapp.ui.navigation.AppScreens
import pe.edu.hiresync_mobileapp.ui.viewModel.LoginViewModel

@Composable
fun SignUpScreen(navController: NavController, viewModel: LoginViewModel){

       Box(
           Modifier
               .fillMaxSize()
               .padding(5.dp)
       ) {
          LazyColumn (modifier = Modifier.fillMaxSize() ){
              item {
                  SignUp(Modifier.align(Alignment.Center), navController, viewModel)
              }
          }
       }

}

@Composable
fun SignUp(modifier: Modifier,navController: NavController, viewModel: LoginViewModel) {

            val email: String by viewModel.email.observeAsState(initial = "")
            val password: String by viewModel.password.observeAsState(initial = "")
            val newpassword: String by viewModel.newpassword.observeAsState(initial = "")
            val name: String by viewModel.name.observeAsState(initial = "")
            val signupEnable: Boolean by viewModel.signupEnable.observeAsState(initial = false)
            var isCandidateSelected by remember { mutableStateOf(false) }
            var isRecluterSelected by remember { mutableStateOf(false) }

            if (signupEnable) {
                Box(Modifier.fillMaxSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))

                }

            } else {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier
                ) {

                    HImage(Modifier.align((Alignment.CenterHorizontally)))
                    Spacer(modifier = Modifier.padding(12.dp))

                    SignUptext(Modifier.align(Alignment.CenterHorizontally))
                    Spacer(modifier = Modifier.padding(16.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,


                    ) {
                        rolpost(Modifier,
                            isCandidateSelected,
                            onClick = {
                                isCandidateSelected = true
                                isRecluterSelected = false
                            })
                        rolreclut(Modifier,
                            isRecluterSelected,
                            onClick = {
                                isRecluterSelected = true
                                isCandidateSelected = false
                            })
                    }

                    Spacer(modifier = Modifier.padding(8.dp))
                    Namefield(name){viewModel.onSignUpChanged(it, newpassword)}
                    Spacer(modifier = Modifier.padding(8.dp))
                    EmailField(email) { viewModel.onLoginChanged(it, password) }
                    Spacer(modifier = Modifier.padding(8.dp))
                    PasswordField(password) { viewModel.onLoginChanged(email, it) }
                    NewPassword(newpassword){viewModel.onSignUpChanged(name, it)}
                    Spacer(modifier = Modifier.padding(16.dp))
                    SingUpButton(navController)
                    Spacer(modifier = Modifier.padding(16.dp))
                    TextFinal(navController, Modifier.align(Alignment.CenterHorizontally))

                }

            }

}





@Composable
fun rolpost(
    modifier: Modifier,
    isCandidateSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(35.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isCandidateSelected) Color(0xFF3172D4) else Color(0xFF9E9E9E),
            disabledContainerColor = if (isCandidateSelected) Color(0xFF3172D4) else Color(0xFF9E9E9E),
            contentColor = Color.White
        )
    ) {
        Text(text = "Candidate")
    }
}


@Composable
fun rolreclut(
    modifier: Modifier,
    isRecluterSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(35.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isRecluterSelected) Color(0xFF3172D4) else Color(0xFF9E9E9E),
            disabledContainerColor = if (isRecluterSelected) Color(0xFF3172D4) else Color(0xFF9E9E9E),
            contentColor = Color.White
        )
    ) {
        Text(text = "Recluter")
    }
}

@Composable
fun TextFinal(navController: NavController,modifier : Modifier){

    Text(
        text = "I have already an account?",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color= Color(0xFF090A0A)
    )
    Text(
        text = "Sign in",
        modifier = modifier.clickable {navController.navigate(route = AppScreens.SignInScreen.route) },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color= Color(0xFF3172D4)
    )


}
@Composable
fun SingUpButton(navController: NavController) {
    Button(
        onClick = { navController.navigate(route = AppScreens.SignUpScreen.route)},
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3172D4),
            disabledContainerColor = Color(0xFF3172D4),
            contentColor = Color.White
        )
    ) {
        Text(text = "Sign up")

    }
}
@Composable
fun SignUptext(modifier : Modifier ){
    Text(
        text = "Sign Up",
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color= Color(0xFF080809)
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Namefield(name:String,onTextFieldChanged:(String)->Unit){
    TextField(
        value = name, onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Name")},
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPassword(newpassword: String, onTextFieldChanged: (String) -> Unit) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    TextField(
        value = newpassword,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 20.dp), // Ajusta el ancho máximo según tu preferencia
        placeholder = {
            Text(
                text = "Confirm Password",
                style = TextStyle(
                    color = Color(0xFF636262),
                    fontSize = 16.sp
                )
            )
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            IconButton(
                onClick = { isPasswordVisible = !isPasswordVisible },
            ) {
                Icon(
                    imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = if (isPasswordVisible) "Hide Password" else "Show Password",
                    tint = Color.Gray
                )
            }
        }

    )
}
@Composable
fun HImage(modifier: Modifier ) {
    Image(painter = painterResource(id = R.drawable.logo_2) ,
        contentDescription = "Header",modifier= modifier)

}





