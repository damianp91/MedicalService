
# 🏥 Sistema de Gestión de Pacientes
**Clínica "UTN-Medical Center"**
**⚠️ Requisitos Técnicos: El proyecto debe ser desarrollado en Java utilizando JavaFX para la interfaz gráfica, y seguir estrictamente el patrón de diseño MVC (Modelo – Vista – Controlador).**


## 🎯 Objetivo General
Desarrollar una aplicación de escritorio para la gestión de pacientes y turnos médicos en una clínica. La aplicación debe ser modular, eficiente y seguir buenas prácticas de desarrollo incluyendo:
- Lenguaje: **Java**
- Interfaz: **JavaFX**
- Arquitectura: **MVC (Modelo–Vista–Controlador)**
- Persistencia: Archivos `.json`


## 🧱 Estructura del Proyecto (Formato MVC)

### Modelo (`model`)
Contiene las clases que representan los datos y la lógica del negocio:
- `Paciente`
- `Turno`
- `Clinica`
- Clases utilitarias para validaciones y cálculo de montos.

### Vista (`view`)
Interfaz gráfica construida con **JavaFX**:
- Pantallas para alta de pacientes, turnos, atención, cobro, informes, etc.
- Elementos visuales (FXML, controllers de vistas, etc.)
- Inputs validados visualmente (edad, obra social, nombre, etc.)

### Controlador (`controller`)
Maneja la lógica de interacción entre modelo y vista:
- Recibe eventos desde la vista (por ejemplo, click en "Alta paciente").
- Valida y procesa datos con ayuda de las clases del modelo.
- Actualiza la vista según resultados.


## 📋 Entidades y atributos

### 🧍 Clase `Paciente`
- `id`: autoincremental, único
- `nombre`, `apellido` (solo letras, máx. 30)
- `dni`: único
- `edad` (18–90)
- `fechaRegistro`
- `obraSocial`: Swiss Medical, Apres, PAMI, Particular

### 🗓️ Clase `Turno`
- `id`: autoincremental, único
- `idPaciente`: debe existir en el sistema
- `especialidad`: entre las opciones válidas
- `montoAPagar`: calculado automáticamente
- `estado`: “Activo”, “Finalizado”, “Pagado”

### 🏢 Clase `Clinica`
- `razonSocial` (string)
- `pacientes` (lista)
- `turnos` (lista)
- `especialidades` (diccionario)
- `obrasSocialesValidas` (diccionario)
- `recaudacion` (float)
- `hayPacientesSinAtencion` (booleano)


## 🧠 Validaciones importantes
- **Edad**: numérica entre 18 y 90.
- **Obra social según edad**:
  - ≥ 60: solo PAMI
  - < 60: PAMI no disponible
- **Especialidades**: Médico Clínico, Odontología, Psicología, Traumatología.
- **Estado inicial del turno**: “Activo”.
- **Monto base del turno**: $4000, con ajustes:

| Obra Social   | Descuento/Recargo     | Condición Adicional                      |
|---------------|------------------------|-------------------------------------------|
| Swiss Medical | -40%                   | Edad 18-60: -10% extra                    |
| Apres         | -25%                   | Edad 26-59: -3% extra                     |
| PAMI          | -60%                   | Edad ≥ 80: -3% extra                      |
| Particular    | +5%                    | Edad 40-60: +15% extra                    |


## 🧭 Funcionalidades del Menú (GUI JavaFX)
1. **Alta paciente**
2. **Alta turno**
3. **Ordenar turnos**
   - Por Obra Social ASC
   - Por Monto DESC
4. **Mostrar pacientes en espera**
5. **Atender pacientes**
   - Cambia estado de “Activo” a “Finalizado” (máx. 2 por vez)
6. **Cobrar atenciones**
   - Cambia estado de “Finalizado” a “Pagado”
   - Suma el monto a `recaudacion`
7. **Cerrar caja**
   - Si no hay turnos pendientes, guarda pacientes y turnos en JSON
   - Caso contrario, mostrar mensaje
8. **Mostrar informe** (elegido según último dígito de tu DNI):
   - Monto total obtenido de pacientes Swiss Medical mayores de 21 años
9. **Salir**


## 💾 Persistencia
- Al iniciar, se debe cargar `configs.json` con:
  - Especialidades
  - Obras sociales válidas
  - Pacientes y turnos previos (si existen)
- Al cerrar caja, se deben sobrescribir los archivos JSON con los datos actuales del sistema.


## 🧱 Requisitos Técnicos Detallados
- Lenguaje: **Java**
- GUI: **JavaFX** (FXML opcional pero recomendable)
- Arquitectura: **MVC obligatoria**
- Uso de:
  - Estructuras de control
  - Bucles
  - Funciones propias (validaciones)
  - Clases y objetos (POO: encapsulamiento, herencia, polimorfismo, abstracción)
  - Ordenamientos
  - `filter`, `map`, lambdas (`Streams` en Java 8+)
- Código limpio y documentado
- Modularización en paquetes:
  - `model`, `view`, `controller`, `utils` (opcional)
