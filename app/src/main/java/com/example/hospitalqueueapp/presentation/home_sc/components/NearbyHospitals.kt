package com.example.hospitalqueueapp.presentation.home_sc.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hospitalqueueapp.R


@Composable
fun NearbyHospitals() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Nearby Hospital",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = "See All",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow {
            items(hospitalsList) { hospital ->
                HospitalCard(hospital = hospital)
            }
        }
    }
}

@Composable
fun HospitalCard(
    hospital: Hospital
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp)),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .width(260.dp)// Set a fixed height for all images
            ) {
                Image(
                    painter = painterResource(id = hospital.image), // Replace with your image resource ID
                    contentDescription = "Hospital Image",
                    contentScale = ContentScale.Crop, // Crop the image to fill the box
                    modifier = Modifier.fillMaxSize() // Fill the entire box with the image
                )
                Card(
                    modifier = Modifier
                        .align(Alignment.BottomEnd) // Align to the bottom end (right)
                        .padding(12.dp)
                    , shape = RoundedCornerShape(
                        topStart = 6.dp,  // 2dp for the top left corner
                        topEnd = 6.dp,    // 6dp for the top right corner
                        bottomEnd = 0.dp, // You can adjust these as needed
                        bottomStart = 6.dp // You can adjust these as needed
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star), // Replace with your star icon resource ID
                            contentDescription = "Rating Star",
                            tint = Color(0xFFFFC107),
                            modifier = Modifier.size(20.dp)
                        )
                        Text(text = hospital.rating.toString())
                    }

                }


            }


            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.padding(10.dp)) {
                // Hospital Name and Navigation Icon
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = hospital.name,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                // Location
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_location), // Replace with your location icon
                        contentDescription = "Location",
                        tint = Color(0xFF9E9E9E), // Gray color
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = hospital.address,
                        color = Color(0xFF757575), // Darker gray
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                // Distance and Category
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_walk), // Replace with your walk icon
                            contentDescription = "Distance",
                            tint = Color(0xFF9E9E9E), // Gray color
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "3.5 km/50min",
                            color = Color(0xFF757575), // Darker gray
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                }
            }
        }
    }
}

data class Hospital(
    val name: String,
    val address: String,
    val rating: Double,
    val reviewsCount: Int,
    val walkingDistance: String,
    val image:Int
)


val hospitalsList = listOf(
    Hospital(
        name = "ElevateDental",
        address = "123 Main St. Springfield",
        rating = 4.8,
        reviewsCount = 120,
        walkingDistance = "2.3 km/30min",
        image= R.drawable.hospital1
    ),
    Hospital(
        name = "DentaCare Clinic",
        address = "456 Elm St. Springfield",
        rating = 4.5,
        reviewsCount = 85,
        walkingDistance = "3.1 km/40min",
        image= R.drawable.hospital2
    ),
    Hospital(
        name = "SmileHub",
        address = "789 Oak St. Springfield",
        rating = 4.7,
        reviewsCount = 110,
        walkingDistance = "1.8 km/25min",
        image= R.drawable.hospital3
    )
)