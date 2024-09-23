package com.example.hospitalqueueapp.presentation.doctordetail_sc

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip

data class Doctor(
    val name: String,
    val specialty: String,
    val location: String,
    val patients: String,
    val experience: String,
    val rating: String,
    val reviews: String,
    val about: String,
    val workingHours: Map<String, String>
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorDetailsScreen(doctor: Doctor) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TopAppBar(
            title = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Doctor Details", style = MaterialTheme.typography.headlineSmall)
                }

            },
            navigationIcon = {
                Surface(
                    shape = CircleShape,
                    border = BorderStroke(1.dp, Color.Gray),
                    modifier = Modifier
                        .padding(8.dp)
                        .size(45.dp), // Size of the circular icon button
                    color = Color.Transparent
                ) {
                    IconButton(onClick = { /* Handle back */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            },
            actions = {
                Surface(
                    shape = CircleShape,
                    border = BorderStroke(1.dp, Color.Gray),
                    modifier = Modifier
                        .padding(8.dp)
                        .size(45.dp), // Size of the circular icon button
                    color = Color.Transparent
                ) {
                    IconButton(onClick = { /* Handle search */ }) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share"
                        )
                    }
                }
                Surface(
                    shape = CircleShape,
                    border = BorderStroke(1.dp, Color.Gray),
                    modifier = Modifier
                        .padding(8.dp)

                        .size(45.dp), // Size of the circular icon button
                    color = Color.Transparent
                ) {
                    IconButton(onClick = { /* TODO: Handle share */ }) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Favourite"
                        )
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Placeholder for Doctor Image
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            )
            Spacer(modifier = Modifier.width(20.dp))

            Column {
                Text(
                    text = doctor.name,
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 20.sp
                )
                Text(
                    text = doctor.specialty,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Place,
                        contentDescription = "Location",
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = doctor.location,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Divider(modifier = Modifier.padding(horizontal = 16.dp))

        Spacer(modifier = Modifier.height(16.dp))

        // Stats Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            StatisticItem(
                Icons.Default.Share, doctor.patients,
                "Patients"
            )
            StatisticItem(
                Icons.Default.Search,
                doctor.experience,
                "Years Exp."
            )
            StatisticItem(
                Icons.Default.Star,
                doctor.rating,
                "Rating"
            )
            StatisticItem(
                Icons.Default.Search,
                doctor.reviews,
                "Review"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

//        Divider()

        Spacer(modifier = Modifier.height(8.dp))

        // About Section
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "About",
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = doctor.about,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.DarkGray.copy(alpha = .6f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Working Hours Section
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Working Hours",
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 18.sp
            )
            Divider(modifier = Modifier.padding(horizontal = 1.dp))
            Spacer(modifier = Modifier.height(16.dp))
            doctor.workingHours.forEach { (day, hours) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = day,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 20.sp,
                        color = Color.DarkGray.copy(alpha = .4f)
                    )
                    Text(
                        text = hours,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 20.sp,
                        color = Color.DarkGray.copy(alpha = .4f)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Book Appointment Button
        Button(
            onClick = { /* TODO: Book Appointment logic */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text(
                text = "Book Appointment",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun StatisticItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    stat: String,
    label: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = Color.Gray,
            modifier = Modifier.size(40.dp)
        )
        Text(
            text = stat,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
        )
        Text(text = label, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDoctorDetailsScreen() {
    val doctor = Doctor(
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

    DoctorDetailsScreen(doctor = doctor)
}
