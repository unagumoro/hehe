package br.edu.up.planner.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.planner.ui.screens.util.PlannerTopBar

@Composable
fun TelaUmA(
    drawerState: DrawerState,
    navCtrlBottomNav: NavController
) {

    var afazeres = mutableListOf(
        Afazer(
            titulo = "Comprar um carro",
            descricao = "Visitar concessionárias",
            id = 1
        ),
        Afazer(
            titulo = "Lavar roupas",
            descricao = "Lavar roupas pela manhã",
            id = 2
        )
    )

    Scaffold(
        topBar = { PlannerTopBar(drawerState) },
        content = { padding ->  padding


            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                items(afazeres) { afazer ->
                    Text(
                        text = afazer.titulo,
                        Modifier.padding(padding),
                        fontSize = 40.sp
                    )
                }
            }
        },
        floatingActionButton = { FloatButton() },
        bottomBar = { BottomAppBarMinima(navCtrlBottomNav) }
    )
}

data class Afazer(
    var titulo: String,
    var descricao: String,
    var concluido: Boolean = false,
    var id: Int? = null
)


@Composable
private fun FloatButton() {
    FloatingActionButton(onClick = { }) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "+"
        )
    }
}


@Composable
private fun BottomAppBarMinima(navController: NavController) {
    NavigationBar(containerColor = Color(0xFF98D2FF)) {
        NavigationBarItem(
            selected = true,
            onClick = {
                navController.navigate(TelaUm.TELA_UM_A_ROUTE)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "A",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text(text = "Tela A") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(TelaUm.TELA_UM_B_ROUTE)
            }, icon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "B",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text(text = "Tela B") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(TelaUm.TELA_UM_C_ROUTE)
            }, icon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "C",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text(text = "Tela C") }
        )
    }
}
