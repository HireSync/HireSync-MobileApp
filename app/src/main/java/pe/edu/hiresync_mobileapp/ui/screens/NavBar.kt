package pe.edu.hiresync_mobileapp.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

@Composable
fun NavBar(navController: NavController){

    var expanded by remember { mutableStateOf(false) }

    val options = listOf(
        "Home",
        "Profile",
        "Postulations",
        "Log Out"
    )

    IconButton(onClick = { expanded =!expanded}) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = null,
            tint = androidx.compose.ui.graphics.Color.White
        )
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }) {

        options.forEach{ option->
            DropdownMenuItem(
                text = { Text(text = option) },
                onClick = {
                    when (option){
                        "Home" -> navController.navigate("home_screen")
                        "Profile" -> navController.navigate("profile_screen")
                        "Postulations" -> navController.navigate("postulation_screen")
                        "Log Out" -> navController.navigate("sign_in_screen")
                    }
                    expanded = false}
            )

        }
    }
}
