package br.edu.up.planner.ui.screens.tarefas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.edu.up.planner.R // Importando o recurso de imagem
import br.edu.up.planner.ui.screens.util.PlannerTopBar
import br.edu.up.planner.ui.screens.util.TelaUmBottomBar

@Composable
fun TelaProsseguir(
    drawerState: DrawerState,
    navCtrlBottomNav: NavController
) {
    // Scaffold com TopAppBar
    Scaffold(
        topBar = {
            PlannerTopBar(drawerState)
        },
        content = { paddingValues ->
            // Layout principal dentro do Scaffold
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Variáveis de estado
                var expanded by remember { mutableStateOf(false) }
                var selectedText by remember { mutableStateOf("Selecione o código da infração") }

                // Imagem (Adicionada novamente)
                Image(
                    painter = painterResource(id = R.drawable.sete), // Substitua pelo nome do seu arquivo de imagem
                    contentDescription = "Imagem de multa",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                        .padding(bottom = 16.dp)
                )

                // Botão para abrir o menu suspenso (Dropdown)
                Button(onClick = { expanded = true }) {
                    Text(text = selectedText)
                }

                // DropdownMenu (Menu suspenso)
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    // Item 1 do Dropdown
                    DropdownMenuItem(
                        text = { Text("167") },
                        onClick = {
                            selectedText = "167"
                            expanded = false
                        }
                    )
                    // Item 2 do Dropdown
                    DropdownMenuItem(
                        text = { Text("172") },
                        onClick = {
                            selectedText = "172"
                            expanded = false
                        }
                    )
                }

                // Botão para prosseguir
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { /* Ação ao clicar em Prosseguir */ }) {
                    Text(text = "Prosseguir")
                }
            }
        },
        bottomBar = { TelaUmBottomBar(navCtrlBottomNav) }
    )
}
