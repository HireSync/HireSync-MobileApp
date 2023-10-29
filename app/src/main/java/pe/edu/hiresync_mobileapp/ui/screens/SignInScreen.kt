package pe.edu.hiresync_mobileapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun LoginScreen(navController: NavController, viewModel: LoginViewModel){
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)){
        Login(Modifier.align(Alignment.Center),navController,viewModel)
    }

}

@Composable
fun Login(modifier: Modifier,navController: NavController, viewModel: LoginViewModel) {
    val email : String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial ="")
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)


    if(isLoading){
        Box(Modifier.fillMaxSize()){
            CircularProgressIndicator(Modifier.align(Alignment.Center))

        }

    }else{

        Column( horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier= modifier) {

            HeaderImage(Modifier.align((Alignment.CenterHorizontally)))
            Spacer(modifier = Modifier.padding(32.dp))
            Signtext(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))
            EmailField(email) { viewModel.onLoginChanged(it, password) }
            Spacer(modifier = Modifier.padding(4.dp))
            PasswordField(password) { viewModel.onLoginChanged(email, it) }
            Spacer(modifier = Modifier.padding(8.dp))
            ForgotPassword(Modifier.align(Alignment.End))
            Spacer(modifier = Modifier.padding(16.dp))
            LoginButton(navController,viewModel)
            Spacer(modifier = Modifier.padding(32.dp))
            Register(navController,Modifier.align(Alignment.CenterHorizontally))

        }

    }

}
@Composable
fun Register(navController: NavController,modifier : Modifier){

    Text(
        text = "Don't have account?",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color= Color(0xFF090A0A)

    )
    Text(
        text = "Sign up",
        modifier = modifier.clickable {navController.navigate(route = AppScreens.SignUpScreen.route) },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color= Color(0xFF3172D4)
    )

}
@Composable
fun LoginButton(navController: NavController, viewModel: LoginViewModel) {


    Button(
        onClick = { navController.navigate(route = AppScreens.HomeScreen.route)},
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3172D4),
            disabledContainerColor = Color(0xFF3172D4),
            contentColor = Color.White
        )
    ) {
        Text(text = "Login in")
    }

}


@Composable
fun Signtext(modifier : Modifier ){
    Text(
        text = "Sign In",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color= Color(0xFF3172D4)
    )
}
@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot Password?",
        modifier = modifier.clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color= Color(0xFF3172D4)
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Password") },
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



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(email:String,onTextFieldChanged:(String)->Unit) {

    TextField(
        value = email, onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email")},
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun HeaderImage(modifier: Modifier ) {
    Image(painter = painterResource(id = R.drawable.logo_2) ,
        contentDescription = "Header",modifier= modifier)

}



