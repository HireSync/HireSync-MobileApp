package pe.edu.hiresync_mobileapp.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.hiresync_mobileapp.ui.screens.HomeScreen
import pe.edu.hiresync_mobileapp.ui.screens.LoginScreen
import pe.edu.hiresync_mobileapp.ui.screens.SignUpScreen
import pe.edu.hiresync_mobileapp.ui.viewModel.LoginViewModel

@Composable
fun AppNavigation(viewModel: LoginViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SignInScreen.route ) {

        composable(route = AppScreens.SignUpScreen.route) {
            SignUpScreen(navController,viewModel)
        }
        composable(route = AppScreens.SignInScreen.route) {
            LoginScreen(navController, viewModel)
        }

        composable(route=AppScreens.HomeScreen.route){
            HomeScreen()
        }


    }
}


