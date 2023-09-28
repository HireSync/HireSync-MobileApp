package pe.edu.hiresync_mobileapp.ui.navigation

sealed class AppScreens(val route: String){
    object SignUpScreen: AppScreens("sing_up_screen")
    object SignInScreen: AppScreens("sign_in_screen")

    object HomeScreen: AppScreens("home_screen")

    object PostulationScreen: AppScreens("postulation_screen")

    object ProfileScreen: AppScreens("profile_screen")
}
