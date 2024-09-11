package br.edu.up.planner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.planner.ui.screens.PrimeiraTela
import br.edu.up.planner.ui.screens.SegundaTela
import br.edu.up.planner.ui.theme.CorDoTitulo
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    device = Devices.PIXEL
)
//@Preview(
//    device = Devices.NEXUS_10
//)
@Composable
fun PlannerApp(){

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerContent() },
        content = { TarefasScreen(drawerState) }
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

@Composable
private fun TarefasScreen(drawerState: DrawerState) {
    Scaffold(
        topBar = { TopBarMinina(drawerState) },
        content = { padding -> ConteudoPrincipal(padding) },
        floatingActionButton = { FloatButton() },
        bottomBar = { BottomAppBarMinima() }
    )
}

@Composable
private fun BottomAppBarMinima() {
    BottomAppBar(
        containerColor = Color(0xFF98D2FF)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "c",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(40.dp))
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "f",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(40.dp))
            Icon(
                imageVector = Icons.Default.Build,
                contentDescription = "b",
                modifier = Modifier.size(40.dp)
            )
        }

    }
}

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
private fun ConteudoPrincipal(padding: PaddingValues) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Conteúdo",
            Modifier.padding(padding),
            fontSize = 40.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarMinina(drawerState: DrawerState){

    val escopo = rememberCoroutineScope()

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                escopo.launch {
                    drawerState.open()
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "=",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp))
            }
        },
        title = {Text(text = "Planner", fontSize = 40.sp,
            color = Color.White,
            fontWeight = FontWeight(600))},
        colors = TopAppBarDefaults.topAppBarColors(CorDoTitulo)
    )
}






@Composable
fun PlannerAppManual(){

    val tela = remember { mutableStateOf(1) }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth()
                    .background(Color(0xFF2196F3))
            ){
                Text(text = "Planner",
                    fontSize = 40.sp,
                    fontWeight = FontWeight(800),
                    color = Color.White
                )
            }
            Row (modifier = Modifier.weight(1f)){
                when(tela.value){
                    1 -> PrimeiraTela()
                    2 -> SegundaTela()
                }
            }

            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth()
                    .background(Color(0xFF2196F3))
            ){
                Button(onClick = {
                    tela.value = 1
                }) {
                    Text("Tela 1", fontSize = 30.sp)
                }
                Button(onClick = {
                    tela.value = 2
                }) {
                    Text("Tela 2", fontSize = 30.sp)
                }
            }

        }


    }
}