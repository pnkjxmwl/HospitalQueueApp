package com.example.hospitalqueueapp.presentation.home_sc.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hospitalqueueapp.R


@Composable
fun DoctorSpecialitySection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Header Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Doctor Speciality",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = "See All",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Specialities List
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(specialities) { speciality ->
                SpecialityItem(speciality)
            }
        }
    }
}

// SpecialityItem Composable
@Composable
fun SpecialityItem(speciality: Speciality) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Icon background
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(Color.LightGray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            // Icon Image
            Image(
                painter = painterResource(id = speciality.iconRes),
                contentDescription = speciality.name,
                modifier = Modifier.size(32.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Speciality Name
        Text(
            text = speciality.name,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

// Data class for Speciality
data class Speciality(
    val name: String,
    val iconRes: Int
)

// Sample data
val specialities = listOf(
    Speciality("Dentist", R.drawable.ic_dentist),
    Speciality("Cardiologist", R.drawable.ic_cardiologist),
    Speciality("Orthopaedist", R.drawable.ic_orthopaedist),
    Speciality("Neurologist", R.drawable.ic_neurologist),

    )