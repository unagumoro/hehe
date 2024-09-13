package br.edu.up.planner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import br.edu.up.planner.ui.screens.TelaDois
import br.edu.up.planner.ui.screens.TelaTres
import br.edu.up.planner.ui.screens.TelaUm

@Preview(
    device = Devices.PIXEL
)
@Composable
fun PlannerApp(){

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed)

    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent()
        },
        content = {
            TelaUm(drawerState)
        }
    )
}

@Composable
private fun DrawerContent() {
    Column(
        modifier = Modifier
            .width(300.dp)
            .background(Color.White)
            .padding(30.dp)
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Text(text = "Item 1", fontSize = 30.sp)
        Text(text = "Item 2", fontSize = 30.sp)
        Text(text = "Item 3", fontSize = 30.sp)
    }
}