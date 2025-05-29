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
```

## 🧮 Algoritmo de Predicción

La aplicación utiliza un algoritmo basado en **regresión logística** con **función sigmoide**:

### 📐 Fórmula Principal

Probabilidad = 1 / (1 + e^(-puntuación_riesgo))


---

### 🔺 Factores de Riesgo (Aumentan la puntuación)

- **Pensamientos Suicidas:** +3.0 puntos  
- **Historial Familiar:** +1.2 puntos  
- **Alta Presión Académica:** `(valor - 3.5) × 0.8`  
- **Alta Presión Laboral:** `(valor - 3.5) × 0.7`  
- **Estrés Financiero:** `(valor - 3.0) × 0.6`  
- **Problemas de Sueño:** *Variable según duración*  
- **Exceso de Trabajo:** `(horas - 12) × 0.2`  

---

### 🛡️ Factores Protectores (Reducen la puntuación)

- **Alta Satisfacción con Estudios:** `(valor - 4.0) × -0.8`  
- **Alta Satisfacción Laboral:** `(valor - 4.0) × -0.7`  
- **Buenos Hábitos Alimenticios:** `(valor - 4.0) × -0.5`  
- **Buen Rendimiento Académico (CGPA):** `(cgpa - 3.5) × -0.6`  
- **Sueño Óptimo (7-8 hrs):** `-0.5 puntos`  

---

## ⚠️ Consideraciones Importantes

### 🔒 Limitaciones

- **No es un diagnóstico médico:** Esta aplicación es solo para fines educativos.  
- **Consulta profesional:** Siempre busca ayuda de profesionales de la salud mental.  
- **Algoritmo simplificado:** Basado en factores generales, no en modelos clínicos.

---

### 📝 Descargo de Responsabilidad

Esta aplicación **no reemplaza** la evaluación profesional de salud mental.  
El modelo está limitado a la predicción basada en datos recolectados y **no constituye un diagnóstico clínico profesional**.  
Si experimentas síntomas de depresión, consulta con un profesional calificado en salud mental.

---

## 👨‍💻 Autores

- **Johan Andrés Latorre**  
- **Andrey David Morales**  

### 🎓 Universidad

**UNAB** – Universidad Autónoma de Bucaramanga  
📚 Proyecto de Inteligencia Artificial  

- 🌐 GitHub: `https://github.com/Latorre655/Proyecto_IA`  
- 📊 Google Colab: `https://colab.research.google.com/drive/1hJ8nfP1df4SKBU4eR9kdYNI-zMpAkVPB?usp=sharing`

---

## 🔗 Recursos Relacionados

Este proyecto forma parte de un ecosistema más amplio de herramientas para la detección de depresión:

- 🧠 **Modelo ML en Python:** Desarrollo del algoritmo base usando `scikit-learn`  
- 📱 **Aplicación Móvil:** Implementación en Android/Kotlin para uso cotidiano  
- 📓 **Notebook de Investigación:** Análisis y experimentación en Google Colab

