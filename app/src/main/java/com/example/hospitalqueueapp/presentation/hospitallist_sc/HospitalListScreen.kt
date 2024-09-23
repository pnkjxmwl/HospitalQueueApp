package com.example.hospitalqueueapp.presentation.hospitallist_sc

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hospitalqueueapp.R
import com.example.hospitalqueueapp.presentation.home_sc.components.Hospital
import com.example.hospitalqueueapp.presentation.home_sc.components.HospitalCard

data class Hospital(
    val name: String,
    val address: String,
    val rating: Double,
    val reviewsCount: Int,
    val walkingDistance: String,
    val image:Int
)


@Composable
fun HospitalList(hospitals: List<Hospital>) {
    LazyColumn {
        items(hospitals) { hospital ->
            HospitalCard(hospital = hospital)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospitalScreen(hospitals: List<com.example.hospitalqueueapp.presentation.home_sc.components.Hospital>) {
    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        TopAppBar(
            title = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Nearby Hospitals", style = MaterialTheme.typography.headlineSmall)
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
        Spacer(modifier = Modifier.height(10.dp))
        ChipList(
            categories = sampleCategories,
            onSelectedChanged = {  }
        )
        Spacer(modifier = Modifier.height(10.dp))
        HospitalList(hospitals = hospitals)
    }
}
val sampleCategories = listOf(
    Category(name = "All", isSelected = true),
    Category(name = "Dentist"),
    Category(name = "Cardiologist"),
    Category(name = "Skin Care")
)

data class Category(
    val name: String,
    val isSelected: Boolean = false
)

@Composable
fun ChipList(
    categories: List<Category>,
    onSelectedChanged: (Category) -> Unit
) {
    LazyRow(
        contentPadding = PaddingValues( start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            SelectableChip(category = category, onSelectedChanged = onSelectedChanged)
        }
    }
}
@Composable
fun SelectableChip(
    category: Category,
    onSelectedChanged: (Category) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = if (category.isSelected) Color.DarkGray else Color.White,
        border = BorderStroke(1.dp, Color.LightGray),
        modifier = Modifier
            .padding(end = 8.dp)
            .clickable { onSelectedChanged(category) }
    ) {
        Text(
            text = category.name,
            modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 6.dp, bottom = 6.dp),
            color = if (category.isSelected) Color.White else Color.Black
        )
    }
}


@Preview
@Composable
fun PreviewHospitalScreen() {
    val hospitalsList = listOf(
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

    HospitalScreen(hospitals = hospitalsList)
}
