package pe.edu.hiresync_mobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.hiresync_mobileapp.ui.navigation.AppNavigation
import pe.edu.hiresync_mobileapp.ui.theme.HireSyncMobileAppTheme
import pe.edu.hiresync_mobileapp.ui.viewModel.LoginViewModel
import pe.edu.hiresync_mobileapp.ui.viewModel.PostulationViewModel
import pe.edu.hiresync_mobileapp.ui.viewModel.ViewModelLogin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HireSyncMobileAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(LoginViewModel(), PostulationViewModel(), ViewModelLogin())
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HireSyncMobileAppTheme {
        AppNavigation(LoginViewModel(),PostulationViewModel(), ViewModelLogin())
    }
}

