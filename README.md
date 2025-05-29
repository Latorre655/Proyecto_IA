Aplicación de Predicción de Depresión 🧠💙
Una aplicación móvil Android desarrollada en Kotlin con Jetpack Compose que utiliza algoritmos de inteligencia artificial para evaluar el riesgo de depresión basándose en múltiples factores psicosociales. Este proyecto forma parte de un sistema integral de detección temprana de depresión en estudiantes universitarios.
🎯 Objetivo del Proyecto
Objetivo General: Desarrollar un modelo de inteligencia artificial para predecir la presencia e intensidad de la depresión en estudiantes, facilitando su detección temprana mediante aplicaciones accesibles y herramientas de análisis.
Problema a Solucionar
La depresión es un problema creciente en el ámbito académico, afectando el desempeño y bienestar de los estudiantes. Sin embargo, la falta de herramientas de detección temprana dificulta su prevención y tratamiento oportuno. Este proyecto busca proporcionar una solución basada en IA que permita identificar patrones asociados a la depresión y ofrecer una evaluación preliminar del estado emocional de los estudiantes.
🔬 Alcances del Proyecto

Desarrollo de modelo ML: Utiliza algoritmos de machine learning basados en scikit-learn para predicción de depresión
Interfaz móvil moderna: Implementación en Android con Jetpack Compose para facilitar la interacción
Análisis de factores relevantes: Uso de datos que permiten analizar factores asociados a la salud mental en estudiantes
Detección temprana: Generación de predicciones que ayuden a la identificación temprana y posibles intervenciones
Evaluación de intensidad: No solo detecta presencia, sino que evalúa la intensidad de la condición
Limitaciones: Basado en datos recolectados; no reemplaza el diagnóstico clínico profesional

📱 Características Principales

Interfaz Moderna: Diseño oscuro y elegante con gradientes personalizados
Evaluación en Tiempo Real: Cálculo instantáneo del riesgo de depresión
Múltiples Parámetros: Evaluación basada en 12 factores diferentes
Algoritmo de IA: Implementación de función sigmoide para predicción
Visualización Intuitiva: Mostrar factores de riesgo y protectores
Controles Interactivos: Sliders y switches para ajustar parámetros

🎯 Funcionalidades
Parámetros de Evaluación

Datos Demográficos: Edad (18-30 años)
Presión Académica: Nivel de estrés en estudios (0-5)
Presión Laboral: Estrés relacionado con el trabajo (0-5)
CGPA: Promedio académico (0-4)
Satisfacción con Estudios: Nivel de satisfacción (0-5)
Satisfacción Laboral: Satisfacción en el trabajo (0-5)
Duración del Sueño: Horas de sueño diarias (4-12)
Hábitos Alimenticios: Calidad de la alimentación (0-5)
Horas de Trabajo/Estudio: Carga horaria diaria (4-16)
Estrés Financiero: Nivel de preocupación económica (0-5)
Pensamientos Suicidas: Presencia (Sí/No)
Historial Familiar: Antecedentes familiares (Sí/No)

Resultados

Porcentaje de Riesgo: Probabilidad de depresión (0-100%)
Factores de Riesgo: Contador de elementos que aumentan el riesgo
Factores Protectores: Contador de elementos que reducen el riesgo

🛠️ Tecnologías Utilizadas
Aplicación Móvil

Lenguaje: Kotlin
Framework UI: Jetpack Compose
Arquitectura: Compose State Management
Material Design: Material 3
Iconografía: Material Icons

Ecosistema del Proyecto

Machine Learning: scikit-learn (Python)
Interfaz Web: Streamlit
Análisis de Datos: Google Colab
Versionado: Git/GitHub

📋 Dependencias
kotlin// Jetpack Compose BOM
implementation 'androidx.compose:compose-bom:2023.10.01'

// Compose Core
implementation 'androidx.compose.ui:ui'
implementation 'androidx.compose.ui:ui-tooling-preview'
implementation 'androidx.compose.material3:material3'

// Activity Compose
implementation 'androidx.activity:activity-compose:1.8.1'

// Icons
implementation 'androidx.compose.material:material-icons-core'
implementation 'androidx.compose.material:material-icons-extended'
🚀 Instalación y Configuración
Requisitos Previos

Android Studio Arctic Fox o superior
SDK de Android 21+ (Android 5.0)
Kotlin 1.8+
