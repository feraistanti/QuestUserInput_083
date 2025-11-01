package com.example.questuserinput_083

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.unit.sp



@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun FormDataDiri(modifier: Modifier = Modifier) {
    // --- STATE ---
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val genderOptions = listOf("Laki-laki", "Perempuan")
    val statusOptions = listOf("Janda", "Lajang", "Duda")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Formulir Pendaftaran",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFB388FF)
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // === CARD FORM ===
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = MaterialTheme.shapes.large,
                border = BorderStroke(1.dp, Color(0xFFB39DDB)),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF5EEFF)),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Top
                ) {
                    // === NAMA ===
                    Text(
                        text = "NAMA LENGKAP",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    OutlinedTextField(
                        value = textNama,
                        onValueChange = { textNama = it },
                        placeholder = { Text("Isian nama lengkap") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF7E57C2),
                            unfocusedBorderColor = Color.Gray
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // === JENIS KELAMIN ===
                    Text(
                        text = "JENIS KELAMIN",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    genderOptions.forEach { jenisKelamin ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = (textJK == jenisKelamin),
                                    onClick = { textJK = jenisKelamin }
                                )
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (textJK == jenisKelamin),
                                onClick = { textJK = jenisKelamin }
                            )
                            Text(text = jenisKelamin)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // === STATUS PERKAWINAN ===
                    Text(
                        text = "STATUS PERKAWINAN",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    statusOptions.forEach { s ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = (textStatus == s),
                                    onClick = { textStatus = s }
                                )
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (textStatus == s),
                                onClick = { textStatus = s }
                            )
                            Text(text = s)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // === ALAMAT ===
                    Text(
                        text = "ALAMAT",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    OutlinedTextField(
                        value = textAlamat,
                        onValueChange = { textAlamat = it },
                        placeholder = { Text("Alamat lengkap") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF7E57C2),
                            unfocusedBorderColor = Color.Gray
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // === TOMBOL SUBMIT ===
                    Button(
                        onClick = {
                            nama = textNama
                            jenis = textJK
                            status = textStatus
                            alamat = textAlamat
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF7E57C2)
                        ),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text("Submit", color = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // === CARD HASIL ===
            if (nama.isNotEmpty()) {
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                    modifier = Modifier
                        .height(100.dp)
                        .width(300.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Nama : $nama", color = Color.White)
                        Text(text = "Gender : $jenis", color = Color.White)
                        Text(text = "Status : $status", color = Color.White)
                        Text(text = "Alamat : $alamat", color = Color.White)
                    }
                }
            }
        }
    }
}