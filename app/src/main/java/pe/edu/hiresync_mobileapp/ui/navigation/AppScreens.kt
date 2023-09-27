package pe.edu.hiresync_mobileapp.ui.navigation

sealed class AppScreens(val route: String){
    object SignUpScreen: AppScreens("sing_up_screen")
    object SignInScreen: AppScreens("sing_in_screen")

    object HomeScreen: AppScreens("home_screen")
}
