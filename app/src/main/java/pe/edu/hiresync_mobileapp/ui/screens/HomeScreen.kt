package pe.edu.hiresync_mobileapp.ui.screens

import android.app.DatePickerDialog
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pe.edu.hiresync_mobileapp.ui.viewModel.LoginViewModel
import java.util.Calendar


@Composable
fun HomeScreen(navController: NavController, viewModel: LoginViewModel) {

    val cornerShape: Shape = CutCornerShape(16.dp) // Radio de esquina de 16dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF_F5F9FF))
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)

        ) {
            NavBar(navController)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Good morning, Natalia",
                fontSize = 24.sp,
                modifier = Modifier.padding(4.dp),
            )
            Text(
                text = "LET'S START!",
                fontSize = 12.sp,
                modifier = Modifier.padding(6.dp),
                fontWeight = FontWeight.Bold,
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier
                    .width(350.dp)
                    .padding(16.dp)
                    .wrapContentSize()

            ) {
                Row (horizontalArrangement =  Arrangement.Center, modifier = Modifier.fillMaxWidth()){
                    Icon(
                        Icons.Default.List,
                        null,
                        modifier = Modifier.padding(4.dp)
                    )
                    Text(
                        text = "Today's schedule",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
                ScheduleCard(
                    "HireSync",
                    "Psychometric test pending",
                    "Deadline 2023/04/15 11:59pm",
                    color = Color(0xFFEA614E)
                )

                ScheduleCard(
                    "Interview Mercadolibre",
                    "Today 5:00pm",
                    color = Color(0xFF9747FF)
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier
                    .width(350.dp)
                    .padding(horizontal = 16.dp)
                    .wrapContentSize()

            ) {
                Row (horizontalArrangement =  Arrangement.Center, modifier= Modifier.fillMaxWidth()) {
                    Icon(
                        Icons.Default.Email,
                        null,
                        modifier = Modifier.padding(4.dp)
                    )
                    Text(
                        text = "Active Jobs Recruitments",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
                ActiveJobsCard(
                    "HireSync",
                    "Test Phase",
                    color = Color(0xFFEA614E)
                )
                ActiveJobsCard(
                    "Mercadolibre Program",
                    "Interview Phase",
                    color = Color(0xFF9747FF)
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier
                    .size(width = 350.dp, height = 150.dp)
                    .padding(16.dp)

            ) {
                Row (horizontalArrangement =  Arrangement.Center, modifier= Modifier.fillMaxWidth()) {
                    Icon(
                        Icons.Default.DateRange,
                        null,
                        modifier = Modifier.padding(4.dp)
                    )
                    Text(
                        text = "Calendar",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(4.dp)

                    )
                }
                Row (horizontalArrangement =  Arrangement.Center, modifier= Modifier.fillMaxWidth()) {
                    DatePicker()
                }
            }
        }
    }
}

@Composable
fun ScheduleCard(
    vararg texts: String,
    color: Color = Color.Red
) {

    val whiteTextStyle = TextStyle(
        color = Color.White,
        fontSize = 13.sp,
        fontWeight = FontWeight.Normal
    )

    Card(
        colors = CardDefaults.cardColors(containerColor = color),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 3.dp)
            .wrapContentHeight()
    ) {
        Column {
            texts.forEach { text ->
                Text(
                    text = text,
                    style = whiteTextStyle,
                    modifier = Modifier.padding(horizontal = 25.dp, vertical = 2.dp),
                )
            }
        }
    }
}

@Composable
fun ActiveJobsCard(
    text1: String = "",
    text2: String = "",
    color: Color = Color.Red
) {

    val whiteTextStyle = TextStyle(
        color = Color.White,
        fontSize = 13.sp,
        fontWeight = FontWeight.Normal
    )

    Card(
        colors = CardDefaults.cardColors(containerColor = color),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 3.dp)
            .wrapContentHeight()
    ) {
        Column {
            Text(
                text = text1,
                fontSize = 13.sp,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 25.dp, vertical = 2.dp)
            )
            Text(
                text = text2,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 25.dp, vertical = 2.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePicker() {
    var date by rememberSaveable {
        mutableStateOf("")
    }
    val year: Int
    val month: Int
    val day: Int
    val mCalendar = Calendar.getInstance()
    year = mCalendar.get(Calendar.YEAR)
    month = mCalendar.get(Calendar.MONTH)
    day = mCalendar.get(Calendar.DAY_OF_MONTH)

    val mDatePickerDialog = DatePickerDialog(
        LocalContext.current,
        {
                _, year:Int, month: Int, day: Int ->
            date = "$day/${month+1}/$year"
        },year,month,day
    )
    Box(modifier = Modifier.fillMaxWidth()){
        Row (modifier = Modifier.align(Alignment.Center)){
            OutlinedTextField(
                value = date,
                onValueChange = {date=it},
                readOnly = true,
                label={ Text(text = "Select Date") }
            )
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(4.dp)
                    .clickable {
                        mDatePickerDialog.show()
                    }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
/*
    HomeScreen()
*/
}
