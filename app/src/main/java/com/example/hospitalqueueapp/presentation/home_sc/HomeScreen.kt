package com.example.hospitalqueueapp.presentation.home_sc


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Scaffold
import com.example.hospitalqueueapp.presentation.home_sc.components.DoctorSpecialitySection
import com.example.hospitalqueueapp.presentation.home_sc.components.NearbyHospitals
import com.example.hospitalqueueapp.presentation.home_sc.components.SearchBar
import com.example.hospitalqueueapp.presentation.home_sc.components.TopSection
import com.example.hospitalqueueapp.presentation.home_sc.components.UpcomingSchedule

@Composable
fun MainScreen() {
    Scaffold(
        topBar = { TopSection() },
    ) { contentPadding ->
        Content(contentPadding)
    }
}

@Composable
fun Content(paddingValues: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        item { SearchBar() }
        item { UpcomingSchedule() }
        item { DoctorSpecialitySection() }
        item { NearbyHospitals() }
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
