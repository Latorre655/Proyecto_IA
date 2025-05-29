package co.unab.johanyandrey.proyectoia2


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.*

@Composable
fun AplicacionPrediccionDepresion() {
    var edad by remember { mutableIntStateOf(20) }
    var presionAcademica by remember { mutableFloatStateOf(3f) }
    var presionLaboral by remember { mutableFloatStateOf(2f) }
    var cgpa by remember { mutableFloatStateOf(3.5f) }
    var satisfaccionEstudios by remember { mutableFloatStateOf(3f) }
    var satisfaccionTrabajo by remember { mutableFloatStateOf(3f) }
    var duracionSueno by remember { mutableFloatStateOf(7f) }
    var habitosAlimenticios by remember { mutableFloatStateOf(3f) }
    var pensamientosSuicidas by remember { mutableIntStateOf(0) }
    var horasTrabajoEstudio by remember { mutableFloatStateOf(8f) }
    var estresFinanciero by remember { mutableFloatStateOf(2f) }
    var historialFamiliar by remember { mutableIntStateOf(0) }

    // Lógica de predicción inline
    val resultadoPrediccion = remember(
        edad, presionAcademica, presionLaboral, cgpa, satisfaccionEstudios,
        satisfaccionTrabajo, duracionSueno, habitosAlimenticios, pensamientosSuicidas,
        horasTrabajoEstudio, estresFinanciero, historialFamiliar
    ) {
        // Comenzar con riesgo base
        var puntuacionRiesgo = -2.0
        var factoresRiesgo = 0
        var factoresProtectores = 0

        // Factores de riesgo críticos
        if (pensamientosSuicidas == 1) {
            puntuacionRiesgo += 3.0
            factoresRiesgo++
        }
        if (historialFamiliar == 1) {
            puntuacionRiesgo += 1.2
            factoresRiesgo++
        }

        // Presión académica y laboral
        if (presionAcademica > 3.5) {
            puntuacionRiesgo += (presionAcademica - 3.5) * 0.8
            factoresRiesgo++
        }
        if (presionLaboral > 3.5) {
            puntuacionRiesgo += (presionLaboral - 3.5) * 0.7
            factoresRiesgo++
        }

        // Estrés financiero
        if (estresFinanciero > 3.0) {
            puntuacionRiesgo += (estresFinanciero - 3.0) * 0.6
            factoresRiesgo++
        }

        // Problemas de sueño
        if (duracionSueno < 6) {
            puntuacionRiesgo += (6 - duracionSueno) * 0.4
            factoresRiesgo++
        } else if (duracionSueno > 9) {
            puntuacionRiesgo += (duracionSueno - 9) * 0.3
            factoresRiesgo++
        }

        // Exceso de trabajo
        if (horasTrabajoEstudio > 12) {
            puntuacionRiesgo += (horasTrabajoEstudio - 12) * 0.2
            factoresRiesgo++
        }

        // Factores protectores
        if (satisfaccionEstudios >= 4.0) {
            puntuacionRiesgo -= (satisfaccionEstudios - 4.0) * 0.8
            factoresProtectores++
        }
        if (satisfaccionTrabajo >= 4.0) {
            puntuacionRiesgo -= (satisfaccionTrabajo - 4.0) * 0.7
            factoresProtectores++
        }
        if (habitosAlimenticios >= 4.0) {
            puntuacionRiesgo -= (habitosAlimenticios - 4.0) * 0.5
            factoresProtectores++
        }
        if (cgpa >= 3.5) {
            puntuacionRiesgo -= (cgpa - 3.5) * 0.6
            factoresProtectores++
        }
        if (duracionSueno >= 7 && duracionSueno <= 8) {
            puntuacionRiesgo -= 0.5
            factoresProtectores++
        }

        // Factor edad
        if (edad > 25) {
            puntuacionRiesgo += (edad - 25) * 0.05
        }

        // Aplicar sigmoide
        val probabilidad = 1.0 / (1.0 + exp(-puntuacionRiesgo))

        Triple(probabilidad.coerceIn(0.0, 1.0), factoresRiesgo, factoresProtectores)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
            .padding(16.dp)
            .systemBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Tarjeta Principal
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFFD4A574),
                                    Color(0xFF5DADE2)
                                )
                            )
                        )
                        .padding(24.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Text(
                                text = "SALUD MENTAL",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "IA/AM",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(
                            text = "Riesgo de Depresión",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "${(resultadoPrediccion.first * 100).roundToInt()}%",
                            color = Color.White,
                            fontSize = 42.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )


                    }
                }
            }

            // Fila de Estadísticas
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Tarjeta Factores de Riesgo
                Card(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF2A2A2A))
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Factores de Riesgo",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )

                        Text(
                            text = "+${resultadoPrediccion.second}",
                            color = Color(0xFF4ECDC4),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        Color(0xFF4ECDC4).copy(alpha = 0.2f),
                                        RoundedCornerShape(4.dp)
                                    )
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = "Alto Impacto",
                                    color = Color(0xFF4ECDC4),
                                    fontSize = 10.sp
                                )
                            }

                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = Color(0xFF4ECDC4),
                                modifier = Modifier.size(12.dp)
                            )
                        }
                    }
                }

                // Tarjeta Factores Protectores
                Card(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF2A2A2A))
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Factores Protectores",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )

                        Text(
                            text = "-${resultadoPrediccion.third}",
                            color = Color(0xFFFF6B6B),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        Color(0xFFFF6B6B).copy(alpha = 0.2f),
                                        RoundedCornerShape(4.dp)
                                    )
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = "Bajo Impacto",
                                    color = Color(0xFFFF6B6B),
                                    fontSize = 10.sp
                                )
                            }

                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = null,
                                tint = Color(0xFFFF6B6B),
                                modifier = Modifier.size(12.dp)
                            )
                        }
                    }
                }
            }

            // Controles de Entrada
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF2A2A2A))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Parámetros de Evaluación",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )

                    // Control Deslizante Edad
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Edad",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                            Text(
                                text = edad.toString(),
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }

                        Slider(
                            value = edad.toFloat(),
                            onValueChange = { edad = it.toInt() },
                            valueRange = 18f..30f,
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF5DADE2),
                                activeTrackColor = Color(0xFF5DADE2),
                                inactiveTrackColor = Color(0xFF404040)
                            )
                        )
                    }

                    // Control Deslizante Presión Académica
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Presión Académica",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                            Text(
                                text = String.format("%.1f", presionAcademica),
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }

                        Slider(
                            value = presionAcademica,
                            onValueChange = { presionAcademica = it },
                            valueRange = 0f..5f,
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF5DADE2),
                                activeTrackColor = Color(0xFF5DADE2),
                                inactiveTrackColor = Color(0xFF404040)
                            )
                        )
                    }

                    // Control Deslizante Presión Laboral
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Presión Laboral",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                            Text(
                                text = String.format("%.1f", presionLaboral),
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }

                        Slider(
                            value = presionLaboral,
                            onValueChange = { presionLaboral = it },
                            valueRange = 0f..5f,
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF5DADE2),
                                activeTrackColor = Color(0xFF5DADE2),
                                inactiveTrackColor = Color(0xFF404040)
                            )
                        )
                    }

                    // Control Deslizante CGPA
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "CGPA",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                            Text(
                                text = String.format("%.1f", cgpa),
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }

                        Slider(
                            value = cgpa,
                            onValueChange = { cgpa = it },
                            valueRange = 0f..4f,
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF5DADE2),
                                activeTrackColor = Color(0xFF5DADE2),
                                inactiveTrackColor = Color(0xFF404040)
                            )
                        )
                    }

                    // Control Deslizante Satisfacción con Estudios
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Satisfacción con Estudios",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                            Text(
                                text = String.format("%.1f", satisfaccionEstudios),
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }

                        Slider(
                            value = satisfaccionEstudios,
                            onValueChange = { satisfaccionEstudios = it },
                            valueRange = 0f..5f,
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF5DADE2),
                                activeTrackColor = Color(0xFF5DADE2),
                                inactiveTrackColor = Color(0xFF404040)
                            )
                        )
                    }

                    // Control Deslizante Satisfacción Laboral
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Satisfacción Laboral",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                            Text(
                                text = String.format("%.1f", satisfaccionTrabajo),
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }

                        Slider(
                            value = satisfaccionTrabajo,
                            onValueChange = { satisfaccionTrabajo = it },
                            valueRange = 0f..5f,
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF5DADE2),
                                activeTrackColor = Color(0xFF5DADE2),
                                inactiveTrackColor = Color(0xFF404040)
                            )
                        )
                    }

                    // Control Deslizante Duración del Sueño
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Duración del Sueño (horas)",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                            Text(
                                text = String.format("%.1f", duracionSueno),
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }

                        Slider(
                            value = duracionSueno,
                            onValueChange = { duracionSueno = it },
                            valueRange = 4f..12f,
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF5DADE2),
                                activeTrackColor = Color(0xFF5DADE2),
                                inactiveTrackColor = Color(0xFF404040)
                            )
                        )
                    }

                    // Control Deslizante Hábitos Alimenticios
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Hábitos Alimenticios",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                            Text(
                                text = String.format("%.1f", habitosAlimenticios),
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }

                        Slider(
                            value = habitosAlimenticios,
                            onValueChange = { habitosAlimenticios = it },
                            valueRange = 0f..5f,
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF5DADE2),
                                activeTrackColor = Color(0xFF5DADE2),
                                inactiveTrackColor = Color(0xFF404040)
                            )
                        )
                    }

                    // Control Deslizante Horas de Trabajo/Estudio
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Horas de Trabajo/Estudio",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                            Text(
                                text = String.format("%.1f", horasTrabajoEstudio),
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }

                        Slider(
                            value = horasTrabajoEstudio,
                            onValueChange = { horasTrabajoEstudio = it },
                            valueRange = 4f..16f,
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF5DADE2),
                                activeTrackColor = Color(0xFF5DADE2),
                                inactiveTrackColor = Color(0xFF404040)
                            )
                        )
                    }

                    // Control Deslizante Estrés Financiero
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Estrés Financiero",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                            Text(
                                text = String.format("%.1f", estresFinanciero),
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }

                        Slider(
                            value = estresFinanciero,
                            onValueChange = { estresFinanciero = it },
                            valueRange = 0f..5f,
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF5DADE2),
                                activeTrackColor = Color(0xFF5DADE2),
                                inactiveTrackColor = Color(0xFF404040)
                            )
                        )
                    }

                    // Interruptor Pensamientos Suicidas
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Pensamientos Suicidas",
                            color = Color.White,
                            fontSize = 14.sp
                        )

                        Switch(
                            checked = pensamientosSuicidas == 1,
                            onCheckedChange = { pensamientosSuicidas = if (it) 1 else 0 },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color(0xFF5DADE2),
                                checkedTrackColor = Color(0xFF5DADE2).copy(alpha = 0.5f),
                                uncheckedThumbColor = Color.Gray,
                                uncheckedTrackColor = Color(0xFF404040)
                            )
                        )
                    }

                    // Interruptor Historial Familiar
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Historial Familiar",
                            color = Color.White,
                            fontSize = 14.sp
                        )

                        Switch(
                            checked = historialFamiliar == 1,
                            onCheckedChange = { historialFamiliar = if (it) 1 else 0 },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color(0xFF5DADE2),
                                checkedTrackColor = Color(0xFF5DADE2).copy(alpha = 0.5f),
                                uncheckedThumbColor = Color.Gray,
                                uncheckedTrackColor = Color(0xFF404040)
                            )
                        )
                    }
                }
            }

            // Botones de Acción
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Botón Obtener Apoyo
                Card(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF2A2A2A)),
                    onClick = { /* Manejar acción de apoyo */ }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )

                        Text(
                            text = "Obtener Apoyo",
                            color = Color.White,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                // Botón Ver Detalles
                Card(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF2A2A2A)),
                    onClick = { /* Manejar acción de detalles */ }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )

                        Text(
                            text = "Ver Detalles",
                            color = Color.White,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}