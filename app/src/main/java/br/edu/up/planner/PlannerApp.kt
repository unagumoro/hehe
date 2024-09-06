package br.edu.up.planner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

@Preview(
    device = Devices.PIXEL
)
//@Preview(
//    device = Devices.NEXUS_10
//)
@Composable
fun PlannerApp(){

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