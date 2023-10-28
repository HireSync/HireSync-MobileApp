package pe.edu.hiresync_mobileapp.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.hiresync_mobileapp.data.model.Postulation
import pe.edu.hiresync_mobileapp.ui.screens.HomeScreen
import pe.edu.hiresync_mobileapp.ui.screens.LoginScreen
import pe.edu.hiresync_mobileapp.ui.screens.PostulationsScreen
import pe.edu.hiresync_mobileapp.ui.screens.ProfileScreen
import pe.edu.hiresync_mobileapp.ui.screens.SignUpScreen
import pe.edu.hiresync_mobileapp.ui.viewModel.LoginViewModel
import pe.edu.hiresync_mobileapp.ui.viewModel.PostulationViewModel

@Composable
fun AppNavigation(viewModel: LoginViewModel, viewModel2: PostulationViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SignInScreen.route) {

        composable(route = AppScreens.SignUpScreen.route) {
            SignUpScreen(navController,viewModel)
        }
        composable(route = AppScreens.SignInScreen.route) {
            LoginScreen(navController, viewModel)
        }

        composable(route=AppScreens.HomeScreen.route){
            HomeScreen(navController,viewModel)
        }

        composable(route=AppScreens.PostulationScreen.route){
            PostulationsScreen(navController, viewModel2)
        }

        composable(route=AppScreens.ProfileScreen.route){
            ProfileScreen(navController, viewModel)
        }
    }
}


