# 🧠💙 Aplicación de Predicción de Depresión

Una aplicación móvil Android desarrollada en **Kotlin con Jetpack Compose** que utiliza algoritmos de inteligencia artificial para evaluar el riesgo de depresión, basándose en múltiples factores psicosociales. Este proyecto forma parte de un **sistema integral de detección temprana de depresión** en estudiantes universitarios.

---

## 🎯 Objetivo del Proyecto

**Objetivo General:**  
Desarrollar un modelo de inteligencia artificial para predecir la **presencia e intensidad de la depresión en estudiantes**, facilitando su detección temprana mediante aplicaciones accesibles y herramientas de análisis.

---

## 🧩 Problema a Solucionar

La depresión es un problema creciente en el ámbito académico, afectando el desempeño y bienestar de los estudiantes. Sin embargo, la falta de herramientas de detección temprana dificulta su prevención y tratamiento oportuno.

Este proyecto busca proporcionar una **solución basada en IA** que permita identificar patrones asociados a la depresión y ofrecer una evaluación preliminar del estado emocional de los estudiantes.

---

## 🔬 Alcances del Proyecto

- **Desarrollo de modelo ML:** Algoritmos de *machine learning* con `scikit-learn` para predicción.
- **Interfaz móvil moderna:** Hecha en Android con Jetpack Compose.
- **Análisis de factores relevantes:** Datos asociados a la salud mental.
- **Detección temprana:** Predicciones para identificación e intervención.
- **Evaluación de intensidad:** No solo detecta presencia, sino también el grado de afectación.
- **Limitaciones:** No reemplaza un diagnóstico clínico profesional.

---

## 📱 Características Principales

- **Interfaz Moderna:** Diseño oscuro y elegante con gradientes personalizados.
- **Evaluación en Tiempo Real:** Cálculo instantáneo del riesgo.
- **Múltiples Parámetros:** Basado en 12 factores distintos.
- **Algoritmo de IA:** Función sigmoide para la predicción.
- **Visualización Intuitiva:** Riesgos y factores protectores mostrados gráficamente.
- **Controles Interactivos:** Sliders y switches ajustables.

---

## 🎯 Funcionalidades

### Parámetros de Evaluación

- **Edad:** 18-30 años  
- **Presión Académica:** 0-5  
- **Presión Laboral:** 0-5  
- **CGPA:** 0-4  
- **Satisfacción con Estudios:** 0-5  
- **Satisfacción Laboral:** 0-5  
- **Duración del Sueño:** 4-12 horas  
- **Hábitos Alimenticios:** 0-5  
- **Carga Horaria Diaria:** 4-16 horas  
- **Estrés Financiero:** 0-5  
- **Pensamientos Suicidas:** Sí/No  
- **Historial Familiar de Depresión:** Sí/No  

### Resultados

- **Porcentaje de Riesgo:** 0-100%  
- **Factores de Riesgo:** Conteo de factores negativos  
- **Factores Protectores:** Conteo de factores positivos  

---

## 🛠️ Tecnologías Utilizadas

### Aplicación Móvil

- **Lenguaje:** Kotlin  
- **Framework UI:** Jetpack Compose  
- **Arquitectura:** Compose State Management  
- **Diseño:** Material 3  
- **Iconografía:** Material Icons  

### Ecosistema del Proyecto

- **Machine Learning:** scikit-learn (Python)  
- **Interfaz Web (pruebas):** Streamlit  
- **Análisis de Datos:** Google Colab  
- **Control de Versiones:** Git / GitHub  

---

## 📋 Dependencias (Gradle)

```kotlin
// Jetpack Compose BOM
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
