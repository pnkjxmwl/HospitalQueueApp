package com.example.hospitalqueueapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hospitalqueueapp.presentation.availabledoctor_sc.Doctor
import com.example.hospitalqueueapp.presentation.availabledoctor_sc.SpecialistScreen
import com.example.hospitalqueueapp.presentation.doctordetail_sc.DoctorDetailsScreen
import com.example.hospitalqueueapp.presentation.home_sc.MainScreen
import com.example.hospitalqueueapp.presentation.hospitallist_sc.Hospital
import com.example.hospitalqueueapp.presentation.hospitallist_sc.HospitalScreen
//import com.example.hospitalqueueapp.presentation.patientdetail_sc.PatientDetailsScreen
import com.example.hospitalqueueapp.ui.theme.HospitalQueueAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HospitalQueueAppTheme {
//                MainScreen()
//                HospitalScreen(hospitals = sampleHospitals)
//                SpecialistScreen(doctors = doctors)
                DoctorDetailsScreen(doctor = doctor)
//            PatientDetailsScreen()
            }
        }
    }
}
val doctor = com.example.hospitalqueueapp.presentation.doctordetail_sc.Doctor(
    name = "Dr. Jonny Wilson",
    specialty = "Dentist",
    location = "New York, United States",
    patients = "7,500+",
    experience = "10+",
    rating = "4.9+",
    reviews = "4,956",
    about = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    workingHours = mapOf(
        "Monday" to "00:00 - 00:00",
        "Tuesday" to "00:00 - 00:00",
        "Wednesday" to "00:00 - 00:00",
        "Thursday" to "00:00 - 00:00",
        "Friday" to "00:00 - 00:00",
        "Saturday" to "00:00 - 00:00",
        "Sunday" to "Closed"
    )
)


val doctors = listOf(
    Doctor(name = "Dr. Jane Cooper", specialty = "Dentist", rating = 4.8, reviews = 49),
    Doctor(name = "Dr. Guy Hawkins", specialty = "Dentist", rating = 4.8, reviews = 49),
    Doctor(name = "Dr. Jacob Jones", specialty = "Dentist", rating = 4.8, reviews = 49)
)

val sampleHospitals = listOf(
    com.example.hospitalqueueapp.presentation.home_sc.components.Hospital(
        name = "ElevateDental",
        address = "123 Main St. Springfield",
        rating = 4.8,
        reviewsCount = 120,
        walkingDistance = "2.3 km/30min",
        image = R.drawable.hospital1
    ),
    com.example.hospitalqueueapp.presentation.home_sc.components.Hospital(
        name = "DentaCare Clinic",
        address = "456 Elm St. Springfield",
        rating = 4.5,
        reviewsCount = 85,
        walkingDistance = "3.1 km/40min",
        image = R.drawable.hospital2
    ),
    com.example.hospitalqueueapp.presentation.home_sc.components.Hospital(
        name = "SmileHub",
        address = "789 Oak St. Springfield",
        rating = 4.7,
        reviewsCount = 110,
        walkingDistance = "1.8 km/25min",
        image = R.drawable.hospital3
    )
)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HospitalQueueAppTheme {
        Greeting("Android")
    }
}