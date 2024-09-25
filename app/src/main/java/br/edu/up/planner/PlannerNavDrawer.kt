package br.edu.up.planner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.edu.up.planner.ui.screens.contato.TelaContato
import br.edu.up.planner.ui.screens.faq.TelaFAQ
import br.edu.up.planner.ui.screens.tarefas.TarefasNavHost
import kotlinx.coroutines.launch

object PlannerRotas {
    val TELA_TAREFAS_ROTA = "tela_um"
    val TELA_FAQ_ROTA = "tela_dois"
    val TELA_CONTATO_ROTA = "tela_tres"
}


@Preview(
    device = Devices.PIXEL
)
@Composable
fun PlannerNavDrawer(){

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed)

    val navCtrlDrawer = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navCtrlDrawer, drawerState)
        },
        content = {
            NavHost(
                navController = navCtrlDrawer,
                startDestination = PlannerRotas.TELA_TAREFAS_ROTA)
            {
                composable(PlannerRotas.TELA_TAREFAS_ROTA) {
                    TarefasNavHost(drawerState)
                }
                composable(PlannerRotas.TELA_FAQ_ROTA) {
                    TelaFAQ(drawerState)
                }
                composable(PlannerRotas.TELA_CONTATO_ROTA) {
                    TelaContato(drawerState)
                }
            }
        }
    )
}

@Composable
private fun DrawerContent(
    navController: NavController,
    drawerState: DrawerState
    ) {

    val coroutineScope = rememberCoroutineScope()

    val currentBack by navController.currentBackStackEntryAsState()
    val rotaAtual = currentBack?.destination?.route ?: PlannerRotas.TELA_TAREFAS_ROTA

    val ehRotaUm = rotaAtual == PlannerRotas.TELA_TAREFAS_ROTA
    val ehRotaDois = rotaAtual == PlannerRotas.TELA_FAQ_ROTA
    val ehRotaTres = rotaAtual == PlannerRotas.TELA_CONTATO_ROTA

    Column(
        modifier = Modifier
            .width(300.dp)
            .background(Color.White)
            .padding(30.dp)
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(70.dp))

        TextButton(
            colors = ButtonDefaults.buttonColors(
                containerColor = getColorMenu(ehRotaUm)
            ),
            onClick = {
                navController.navigate(PlannerRotas.TELA_TAREFAS_ROTA)
                coroutineScope.launch {
                    drawerState.close()
                }
            }) {
            Icon(
                //imageVector = Icons.Default.Call,
                painter = painterResource(id = R.drawable.checklist),
                contentDescription = "c",
                modifier = Modifier.size(40.dp),
                tint = getColorTexto(ehRotaUm)
            )
            Text(text = "Início", fontSize = 30.sp,
                color = getColorTexto(ehRotaUm))
        }

        TextButton(
            colors = ButtonDefaults.buttonColors(
                containerColor = getColorMenu(ehRotaDois)
            ),
            onClick = {
                navController.navigate(PlannerRotas.TELA_FAQ_ROTA)
                coroutineScope.launch {
                    drawerState.close()
                }
            }) {
            Icon(
                //imageVector = Icons.Default.Call,
                painter = painterResource(id = R.drawable.checklist),
                contentDescription = "c",
                modifier = Modifier.size(40.dp),
                tint = getColorTexto(ehRotaDois)
            )
            Text(text = "FAQ", fontSize = 30.sp,
                color = getColorTexto(ehRotaDois))
        }

        TextButton(
            colors = ButtonDefaults.buttonColors(
                containerColor = getColorMenu(ehRotaTres)
            ),
            onClick = {
                navController.navigate(PlannerRotas.TELA_CONTATO_ROTA)
                coroutineScope.launch {
                    drawerState.close()
                }
            }) {
            Icon(
                //imageVector = Icons.Default.Call,
                painter = painterResource(id = R.drawable.checklist),
                contentDescription = "c",
                modifier = Modifier.size(40.dp),
                tint = getColorTexto(ehRotaTres)
            )
            Text(text = "Contato", fontSize = 30.sp,
                color = getColorTexto(ehRotaTres))
        }
    }
}

fun getColorMenu(estaSelecionada: Boolean): Color {
    if (estaSelecionada){
        return Color.Yellow
    } else {
        return Color.Transparent
    }
}

fun getColorTexto(estaSelecionada: Boolean): Color {
    if (estaSelecionada){
        return Color.Black
    } else {
        return Color.DarkGray
    }
}
