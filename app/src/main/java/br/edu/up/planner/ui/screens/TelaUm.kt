package br.edu.up.planner.ui.screens

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object TelaUm {
    val TELA_UM_A_ROUTE = "t1a"
    val TELA_UM_B_ROUTE = "t1b"
    val TELA_UM_C_ROUTE = "t1c"
}

@Composable
fun TelaUm(drawerState: DrawerState) {

    val navCtrlBottonNav = rememberNavController()
    NavHost(
        navController = navCtrlBottonNav,
        startDestination = TelaUm.TELA_UM_A_ROUTE
    ) {
        composable(TelaUm.TELA_UM_A_ROUTE) {
            TelaUmA(drawerState, navCtrlBottonNav)
        }
        composable(TelaUm.TELA_UM_B_ROUTE) {
            TelaUmB(drawerState, navCtrlBottonNav)
        }
        composable(TelaUm.TELA_UM_C_ROUTE) {
            TelaUmC(drawerState, navCtrlBottonNav)
        }
    }
}



