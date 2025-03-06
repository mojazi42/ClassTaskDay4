package com.example.classtaskday4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Main Activity - Entry point of the app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Set the main UI content to ProfileScreen Composable
            ProfileScreen()
        }
    }
}

// Composable function to create a Profile Screen UI
@Composable
fun ProfileScreen() {
    // State to track whether the user is following or not
    var isFollowing by remember { mutableStateOf(false) }
    // State to track the number of followers
    var followerCount by remember { mutableStateOf(100) }

    // Main Column Layout for arranging UI elements vertically
    Column(
        modifier = Modifier
            .fillMaxSize()  // Fill the entire screen
            .background(Color(0xFFF5F5F5)) // Light gray background color
            .padding(16.dp), // Padding around the content
        horizontalAlignment = Alignment.CenterHorizontally // Center align the content
    ) {
        // Profile Picture
        Image(
            painter = painterResource(id = R.drawable.profile), // Loads profile image from drawable
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(100.dp) // Image size
                .clip(CircleShape) // Apply circular shape to the image
        )

        Spacer(modifier = Modifier.height(16.dp)) // Space between elements

        // Name Text
        Text(
            text = "Mohammed Alharbi", // Display name
            fontSize = 22.sp, // Font size
            fontWeight = FontWeight.Bold // Bold font
        )

        Spacer(modifier = Modifier.height(8.dp)) // Space

        // Bio Text
        Text(
            text = "Backend Developer | Java | ASP.NET | SQL", // Short bio
            fontSize = 16.sp, // Font size
            color = Color.Gray // Gray color for text
        )

        Spacer(modifier = Modifier.height(16.dp)) // Space

        // Followers Count Text
        Text(
            text = "$followerCount Followers", // Display follower count
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp)) // Space

        // Follow Button
        Button(
            onClick = {
                isFollowing = !isFollowing // Toggle follow state
                followerCount += if (isFollowing) 1 else -1 // Increase or decrease follower count
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isFollowing) Color.Gray else Color.Blue // Change button color based on follow state
            )
        ) {
            // Button Text
            Text(
                text = if (isFollowing) "Following" else "Follow", // Change button text based on state
                color = Color.White, // White text color
                fontSize = 16.sp
            )
        }
    }
}

// Preview function to display UI in Android Studio Preview mode
@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen() // Calls the ProfileScreen Composable for preview
}
