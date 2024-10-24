package project.app.sale_crm.dashboard

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import project.app.sale_crm.ui.theme.bluegradient

@Composable
fun Dashboard() {
    // State to manage the visibility of additional FABs
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bluegradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(vertical = 40.dp)
                .padding(bottom = 20.dp),
            verticalArrangement = Arrangement.SpaceAround, // Align elements at the top
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Card for "Upcoming Contacts"
            Card(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp)) // Rounded corners
                    .width(280.dp)
                    .height(80.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF00008B) // Card background color
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp // Adjusted elevation for shadow
                )
            ) {
                // Using Box to center the text
                Box(
                    contentAlignment = Alignment.Center, // Center the text inside the box
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Upcoming Contacts",
                        color = Color.White, // Text color
                        fontSize = 16.sp, // Text size
                        fontWeight = FontWeight.Bold, // Make text bold
                        textAlign = TextAlign.Center // Align the text to center
                    )
                }
            }

            // Progress bar for daily targets
            SemiCircularProgressBarScreen()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Card(
                    modifier = Modifier
                        .height(240.dp)
                        .width(140.dp)
                ) {
                    // Add content here
                }
                Card(
                    modifier = Modifier
                        .height(190.dp)
                        .width(140.dp)
                ) {
                    // Add content here
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Card(
                    modifier = Modifier
                        .width(200.dp)
                        .height(100.dp)
                ) {
                    // Add content here
                }
            }

            // Column to hold additional FABs and main FAB
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(10.dp) // Space between buttons
            ) {
                // Show additional FABs if expanded
                if (isExpanded) {
                    FloatingActionButton(
                        onClick = { Log.d("FAB", "First additional FAB clicked.") },
                        modifier = Modifier.size(56.dp) // Set size for additional FABs
                    ) {
                        Icon(Icons.Filled.Add, "First additional button.")
                    }

                    FloatingActionButton(
                        onClick = { Log.d("FAB", "Second additional FAB clicked.") },
                        modifier = Modifier.size(56.dp) // Set size for additional FABs
                    ) {
                        Icon(Icons.Filled.Add, "Second additional button.")
                    }
                }

                // Main FAB
                FloatingActionButton(
                    onClick = { isExpanded = !isExpanded } // Toggle visibility of additional buttons
                ) {
                    Icon(Icons.Filled.Add, "Main floating action button.")
                }
            }
        }
    }
}
