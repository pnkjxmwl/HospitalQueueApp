package com.example.hospitalqueueapp.presentation.availabledoctor_sc

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hospitalqueueapp.R
import com.example.hospitalqueueapp.presentation.home_sc.components.Hospital
import com.example.hospitalqueueapp.presentation.home_sc.components.HospitalCard
import com.example.hospitalqueueapp.presentation.hospitallist_sc.Category
import com.example.hospitalqueueapp.presentation.hospitallist_sc.SelectableChip


data class Doctor(
    val name: String,
    val specialty: String,
    val rating: Double,
    val reviews: Int
)

@Composable
fun DoctorCard(doctor: Doctor) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White // Light background color
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(16.dp)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Top row: doctor info with the heart icon and badge
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Placeholder for doctor image
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(Color.LightGray.copy(alpha = 0.5f))
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Column {
                        // Professional Doctor badge
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(bottom = 4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Professional Doctor",
                                tint = Color.Gray,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Professional Doctor",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.Gray
                            )
                        }

                        // Doctor's name and specialty
                        Text(
                            text = doctor.name,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = doctor.specialty,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                        // Rating and review count
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Rating",
                                tint = Color.Yellow,
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = doctor.rating.toString(),
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                            Text(
                                text = " • ${doctor.reviews} Reviews",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.Gray,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
                // Favorite icon
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
            }




            // Appointment button
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /* TODO: Add appointment logic */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Make Appointment", color = Color.Gray)
            }
        }
    }
}


@Composable
fun DoctorList(doctors: List<Doctor>) {
    LazyColumn(
        modifier = Modifier.fillMaxHeight()
            .background(color = Color.LightGray)
    ) {
        items(doctors) { doctor ->
            DoctorCard(doctor = doctor)
        }
    }
}

@Composable
fun ChipList(
    categories: List<Category>,
    onSelectedChanged: (Category) -> Unit
) {
    LazyRow(
        modifier = Modifier.background(color = Color.LightGray),
        contentPadding = PaddingValues( start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            SelectableChip(category = category, onSelectedChanged = onSelectedChanged)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.LightGray // Set your desired color here
        ),
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Available Doctors", style = MaterialTheme.typography.headlineSmall)
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
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                }
            }
        }
    )
}
@Composable
fun SpecialistScreen(doctors: List<Doctor>) {
    Column {
        TopBar()
        ChipList(
            categories = sampleCategories,
            onSelectedChanged = {  }
        )
        DoctorList(doctors = doctors)
    }
}
val sampleCategories = listOf(
    Category(name = "All", isSelected = true),
    Category(name = "Dentist"),
    Category(name = "Cardiologist"),
    Category(name = "Skin Care")
)
@Preview
@Composable
fun PreviewSpecialistScreen() {
    val doctors = listOf(
        Doctor(name = "Dr. Jane Cooper", specialty = "Dentist", rating = 4.8, reviews = 49),
        Doctor(name = "Dr. Guy Hawkins", specialty = "Dentist", rating = 4.8, reviews = 49),
        Doctor(name = "Dr. Jacob Jones", specialty = "Dentist", rating = 4.8, reviews = 49)
    )
    SpecialistScreen(doctors = doctors)
}
