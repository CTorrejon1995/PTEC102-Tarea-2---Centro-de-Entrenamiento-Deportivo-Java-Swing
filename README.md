# Sistema de Gestión de Rutinas Deportivas
## Aplicación desarrollada en Java Swing

## 📖 Descripción

Este proyecto consiste en el desarrollo de una aplicación de escritorio orientada a la gestión de rutinas deportivas para un centro de entrenamiento.  
El sistema fue desarrollado utilizando **Java** y **Java Swing**, aplicando **programación orientada a objetos** y **programación orientada a eventos**.

La aplicación permite:
- Cargar ejercicios desde archivos externos.
- Generar rutinas según restricciones definidas por el usuario.
- Revisar rutinas previamente creadas.
- Visualizar estadísticas asociadas tanto a ejercicios como rutinas.

Además, el sistema implementa una **arquitectura modular** basada en frontend y backend, separando adecuadamente la lógica del programa de la interfaz gráfica.

---

## 🛠️ Tecnologías Utilizadas

- Java
- Java Swing
- Programación Orientada a Objetos (POO)
- Programación Orientada a Eventos
- UML

---

## 🚀 Funcionalidades Principales

- Carga de ejercicios desde archivos `.csv`
- Generación de rutinas deportivas
- Validación automática de restricciones
- Navegación entre ejercicios de una rutina
- Visualización de estadísticas y resúmenes
- Validación de datos ingresados por el usuario
- Persistencia de información en memoria

---

## 📏 Reglas de Negocio Implementadas

- No se pueden repetir ejercicios para un mismo cliente en semanas consecutivas.
- No se puede generar una rutina duplicada para un mismo cliente en una misma semana.
- Se verifica la factibilidad de la rutina antes de ser creada.
- Los ejercicios son discriminados automáticamente según restricciones previas.
- El sistema valida correctamente los datos ingresados por el usuario.
- La carga de archivos valida formato y consistencia de datos.
- La navegación entre ejercicios mantiene correctamente el estado de la interfaz.

---

## 📂 Formato del Archivo CSV

El sistema trabaja con archivos `.csv` separados por comas y con encabezado.

### Ejemplo de estructura:

```csv
codigo,nombre,tipo,nivel,tiempo,descripcion,atributoExtra
1,Trote,Cardiovascular,Bajo,15,Trote suave,Caminadora
2,Press banca,Fuerza,Alto,20,Pecho y triceps,Pectorales
```

**Consideraciones:**
- El archivo debe incluir encabezado.
- Los datos deben estar separados por comas.
- Los identificadores deben ser únicos.
- Los valores deben respetar el formato esperado por el sistema.

---

## 🏗️ Arquitectura del Proyecto

El proyecto se encuentra dividido en dos grandes bloques:

### Backend
Encargado de:
- Lógica de negocio
- Validaciones
- Persistencia de datos
- Procesamiento de información

**Clases principales:**
- Ejercicio  
- EjercicioCardiovascular  
- EjercicioFuerza  
- Rutina  
- ColeccionEjercicio  
- ColeccionRutina  
- LecturaArchivo  
- ProcesamientoDatos  
- Orquestador  

### Frontend
Encargado de:
- Interacción con el usuario
- Ventanas del sistema
- Manejo de eventos
- Visualización de información

**Ventanas principales:**
- VentanaPrincipal  
- VentanaArchivo  
- VentanaGenerarRutina  
- VentanaBuscarRutina  
- VentanaRevisarRutina  
- VentanaResumenRutina  

---

## 📁 Estructura del Repositorio

```
├── src/
│   ├── backend/
│   ├── frontend/
│
├── docs/
│   ├── Informe_Principal.pdf
│   ├── Ficha_Tecnica.pdf
│   ├── Diagrama UML
│
├── README.md
```

---

## ▶️ Ejecución del Programa

### Requisitos Previos

Para ejecutar correctamente el sistema es necesario contar con:

- Java JDK 17 o superior.
- Un IDE compatible con Java, por ejemplo:
  - IntelliJ IDEA
  - NetBeans
  - Eclipse

---

### Clonar el Repositorio

```bash
git clone https://github.com/CTorrejon1995/PTEC102-Tarea-2---Centro-de-Entrenamiento-Deportivo-Java-Swing.git
```
---

### 💻 Ejecución desde el IDE

1. Abrir el proyecto en el IDE de preferencia.
2. Localizar la clase principal del sistema (`Main.java`).
3. Ejecutar el método `main`.

---

### 🚀 Uso General

Una vez iniciado el programa:

1. Cargar correctamente el archivo `.csv`.
2. Esperar la validación automática de los datos.
3. Utilizar las funcionalidades disponibles:
   - Generar Rutina
   - Buscar Rutina
   - Revisar Rutinas
   - Visualizar Resumen

---

### ⚠️ Consideraciones

- El sistema requiere cargar un archivo válido antes de habilitar las funcionalidades principales.
- El archivo debe respetar el formato `.csv` separado por comas y con encabezado.
- El programa valida automáticamente:
  - errores de formato
  - datos inválidos
  - restricciones lógicas del sistema
 
---

## 📑 Documentación

El repositorio incluye:
- Informe principal del proyecto
- Ficha técnica del sistema
- Diagramas UML
- Código fuente completo

---

## 🎯 Objetivos del Proyecto

- Implementar programación orientada a objetos en Java.  
- Aplicar programación orientada a eventos mediante Java Swing.  
- Diseñar una arquitectura modular basada en frontend y backend.  
- Gestionar correctamente la persistencia y validación de datos.  
- Construir una aplicación funcional y cercana a un entorno real.  

---

## 👥 Autor

Proyecto desarrollado para la asignatura **PTEC102**.

- Christopher Torrejón. 21.774.845-3
- Ingeniería Civil Industrial.
- Ingeniería Civil Informática.

---

## 📝 Observaciones

El sistema fue desarrollado con fines académicos como una introducción práctica al desarrollo de aplicaciones gráficas, modularización de software y diseño orientado a objetos utilizando Java Swing.
