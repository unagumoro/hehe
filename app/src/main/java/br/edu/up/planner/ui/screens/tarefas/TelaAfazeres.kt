package br.edu.up.planner.ui.screens.tarefas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.edu.up.planner.ui.screens.util.PlannerTopBar
import br.edu.up.planner.ui.screens.util.TelaUmBottomBar



@Composable
fun TelaAfazeres(
    drawerState: DrawerState,
    navCtrlBottomNav: NavController
) {

    Scaffold(
        topBar = {
            PlannerTopBar(drawerState)
        },
        content = { iPad ->
            iPad
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "RecurSê",
                    Modifier.padding(30.dp),
                    fontSize = 100.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Black
                )
                Text(
                    text = "Não se preocupe, fazemos seu recurso para você!",
                    Modifier.padding(30.dp),
                    fontSize = 20.sp,
                    color = Color.Blue
                )
            }
        },
        bottomBar = { TelaUmBottomBar(navCtrlBottomNav) }
    )
}

