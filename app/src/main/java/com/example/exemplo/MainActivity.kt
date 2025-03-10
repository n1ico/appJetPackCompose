package com.example.appexemplo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.exemplo.ui.theme.ExemploTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.exemplo.ui.theme.preto
import com.example.exemplo.ui.theme.verde
import com.example.exemplo.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExemploTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    produtoItem()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun produtoItem() {
    Column(
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            preto, verde
                        )
                    )
                )
        )
        {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Foto perfil kurt cobain",
                modifier = Modifier
                    .offset(y = (40).dp)
                    .size(130.dp)
                    .aspectRatio(1f)
                    .clip(shape = CircleShape)
                    .align(Alignment.BottomCenter)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))

        var nome by remember { mutableStateOf("") }
        var endereco by remember { mutableStateOf("") }
        var curso by remember { mutableStateOf("") }
        var serie by remember { mutableStateOf("") }

        OutlinedTextField(
            value = nome,
            label = { Text("Nome") },
            onValueChange = { nome = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = endereco,
            label = { Text("Endereço") },
            onValueChange = { endereco = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = curso,
            label = { Text("Curso") },
            onValueChange = { curso = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = serie,
            label = { Text("Série") },
            onValueChange = { serie = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(25.dp))
        Button(onClick = {},
            modifier = Modifier
                .height(50.dp)
                .width(135.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = verde)
        ) {
            Text("Enviar")
        }
    }
}