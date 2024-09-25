package br.edu.up.planner.ui.screens.tarefas

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object TelaUm {
    val TELA_AFAZERES_ROUTE = "t1a"
    val TELA_PROSSEGUIR_ROUTE = "t1b"
    val TELA_FINALIZAR_ROUTE = "t1c"
}

@Composable
fun TarefasNavHost(drawerState: DrawerState) {

    val navCtrlBottonNav = rememberNavController()
    NavHost(
        navController = navCtrlBottonNav,
        startDestination = TelaUm.TELA_AFAZERES_ROUTE
    ) {
        composable(TelaUm.TELA_AFAZERES_ROUTE) {
            TelaAfazeres(drawerState, navCtrlBottonNav)
        }
        composable(TelaUm.TELA_PROSSEGUIR_ROUTE) {
            TelaProsseguir(drawerState, navCtrlBottonNav)
        }
        composable(TelaUm.TELA_FINALIZAR_ROUTE) {
            TelaFinalizar(drawerState, navCtrlBottonNav)
        }
    }
}



