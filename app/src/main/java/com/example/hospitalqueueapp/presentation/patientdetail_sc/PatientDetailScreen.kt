//package com.example.hospitalqueueapp.presentation.patientdetail_sc
//
//package com.example.hospitalqueueapp.presentation.patientdetailscreen
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun PatientDetailsScreen() {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Patient Details") },
//                navigationIcon = {
//                    IconButton(onClick = { /* Handle back button click */ }) {
//                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
//                    }
//                }
//            )
//        },
//        content = { innerPadding ->
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(innerPadding)
//                    .padding(16.dp),
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Column(
//                    modifier = Modifier.fillMaxWidth(),
//                    verticalArrangement = Arrangement.spacedBy(16.dp)
//                ) {
//                    DropdownField(label = "Booking for", options = listOf("Self", "Someone else"))
//                    DropdownField(label = "Gender", options = listOf("Male", "Female", "Other"))
//                    DropdownField(label = "Your Age", options = (18..100).map { "$it Years" })
//                    ProblemTextField()
//                }
//                Button(
//                    onClick = { /* Handle Next button click */ },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(56.dp)
//                ) {
//                    Text("Next", fontSize = 18.sp)
//                }
//            }
//        }
//    )
//}
//
//@Composable
//fun DropdownField(label: String, options: List<String>) {
//    var expanded by remember { mutableStateOf(false) }
//    var selectedOption by remember { mutableStateOf(options[0]) }
//
//    Column {
//        Text(label, style = MaterialTheme.typography.bodyMedium)
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.LightGray.copy(alpha = 0.5f))
//                .padding(8.dp)
//                .clickable { expanded = true }
//        ) {
//            Text(selectedOption)
//        }
//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false }
//        ) {
//            options.forEach { option ->
//                DropdownMenuItem(
//                    onClick = {
//                        selectedOption = option
//                        expanded = false
//                    }) {
//                    Text(option)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun ProblemTextField() {
//    var text by remember { mutableStateOf("") }
//
//    Column {
//        Text("Write Your Problem", style = MaterialTheme.typography.bodyLarge)
//        BasicTextField(
//            value = text,
//            onValueChange = { text = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(150.dp)
//                .background(Color.LightGray.copy(alpha = 0.5f))
//                .padding(8.dp),
//            maxLines = 5,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewPatientDetailsScreen() {
//    PatientDetailsScreen()
//}
