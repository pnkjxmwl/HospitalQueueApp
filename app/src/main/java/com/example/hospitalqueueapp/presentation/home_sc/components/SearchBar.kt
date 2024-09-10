package com.example.hospitalqueueapp.presentation.home_sc.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hospitalqueueapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var query by remember { mutableStateOf("") }

    OutlinedTextField(
        value = query,
        onValueChange = { query = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp, start = 16.dp, bottom = 16.dp, end = 16.dp),
        placeholder = { Text(text = "Search") },  // Placeholder text
        singleLine = true,
        leadingIcon = {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.ic_search),  // Search icon as leading icon
                contentDescription = null,
                tint = Color.Gray
            )
        },
        trailingIcon = {
            IconButton(onClick = { /* Filter action */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.filter_ic),  // Filter icon as trailing icon
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        },
        shape = RoundedCornerShape(8.dp),  // Rounded corners
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.LightGray
        )
    )
}