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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hospitalqueueapp.R

@Composable
fun UpcomingSchedule() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Top Section - Title and "See All"
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Upcoming Schedule",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Number of schedules
                Text(
                    text = "8", // Placeholder for schedule count
                    color = Color.White,
                    modifier = Modifier
                        .background(Color.Gray, CircleShape)
                        .padding(8.dp),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "See All",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Schedule Card
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.DarkGray,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(), // Adjust to wrap content height based on its children
            shape = RoundedCornerShape(10.dp),
            // Assuming this should be a gray card background
        ) {
            Column( // Ensure the content of the card is in a column to stack rows vertically
                modifier = Modifier.padding(16.dp)
            ) {
                // First row: Doctor and call icon
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Left side: Profile picture and doctor info
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Profile Picture Placeholder
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(Color.LightGray, shape = CircleShape)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        // Doctor Information
                        Column {
                            Text(
                                text = "Dr. Alana Rueter",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = "Dentist Consultation",
                                color = Color.LightGray,
                                fontSize = 14.sp
                            )
                        }
                    }

                    // Right side: Call Icon
                    IconButton(onClick = { /* Action for calling */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.circle), // Use painterResource for PNG images
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp),
                            colorFilter = ColorFilter.tint(Color.White) // Optional: Tint the image if needed
                        )
                    }
                }
                Spacer(modifier = Modifier.height(18.dp))
                // Second row: Date and Time
                Row(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.LightGray)
                        .padding(8.dp), // Adds some space between the rows
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_calendar), // Use painterResource for PNG images
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp),
                            colorFilter = ColorFilter.tint(Color.White) // Optional: Tint the image if needed
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Monday, 26 July",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_clock), // Use painterResource for PNG images
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp),
                            colorFilter = ColorFilter.tint(Color.White) // Optional: Tint the image if needed
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "09:00 - 10:00",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}