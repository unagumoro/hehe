package br.edu.up.planner.ui.screens.faq

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.planner.ui.screens.util.PlannerTopBar

@Composable
fun TelaFAQ(drawerState: DrawerState) {

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
                    text = "Escolha sua infração\n" +
                            "Selecione o código da sua infração e em seguida clique em \"Prosseguir\"\n",
                    Modifier.padding(30.dp),
                    fontSize = 15.sp
                )
                Text(
                    text = "Escolha sua infração\n" +
                            "Selecione o código da sua infração e em seguida clique em \"Prosseguir\"\n",
                    Modifier.padding(30.dp),
                    fontSize = 15.sp
                )
                Text(
                    text = "Escolha sua infração\n" +
                            "Selecione o código da sua infração e em seguida clique em \"Prosseguir\"\n",
                    Modifier.padding(30.dp),
                    fontSize = 15.sp
                )
            }
        }
    )
}

