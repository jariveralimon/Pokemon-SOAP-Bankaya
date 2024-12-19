# Pokemon-SOAP-Bankaya

Este es un servicio SOAP que consume la API REST de [PokeAPI](https://pokeapi.co/) para obtener información sobre los Pokémon y exponerla mediante SOAP. El servicio permite consultar datos como habilidades, experiencia base, objetos retenidos, y más.

## Repositorio

Puedes acceder al repositorio del proyecto en GitHub desde la siguiente URL:

**[Pokemon-SOAP-Bankaya](https://github.com/jariveralimon/Pokemon-SOAP-Bankaya.git)**

## Requisitos

- **Java 17** o superior
- **Maven** para la construcción del proyecto
- **Podman** o **Docker** para contenedores

## Instalación

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/jariveralimon/Pokemon-SOAP-Bankaya.git
   cd Pokemon-SOAP-Bankaya
   ```

2. **Construye el proyecto**:
   Si tienes Maven instalado, usa el siguiente comando para compilar y empaquetar el proyecto:
   ```bash
   ./mvnw clean package
   ```

3. **Ejecuta el servicio**:
   Para correr el servicio en un contenedor, utiliza Podman o Docker.

   - **Usando Podman**:
     ```bash
     podman build -t pokemon-soap-service .
     podman run -d -p 8080:8080 --name pokemon-soap-container pokemon-soap-service
     ```

   - **Usando Docker**:
     ```bash
     docker build -t pokemon-soap-service .
     docker run -d -p 8080:8080 --name pokemon-soap-container pokemon-soap-service
     ```

4. **Accede al WSDL**:
   El WSDL estará disponible en `http://localhost:8080/ws/pokemon.wsdl`.

## Estrategia de Branching

### **Main Branch (`main`)**
- La rama `main` siempre debe contener la versión estable y funcional del proyecto.
- Solo se debe realizar un merge a `main` desde ramas de `develop` o `hotfix`.

### **Rama de Desarrollo (`develop`)**
- La rama `develop` es el espacio principal para integrar nuevas características antes de enviarlas a `main`.
- Todos los desarrollos deben pasar por esta rama para pruebas de integración.

### **Ramas de Equipo (`team`)**
- Las ramas de equipo permiten a los diferentes equipos trabajar en paralelo en características relacionadas.
- Convención de nombres:
  ```
  team/<nombre-del-equipo>
  ```

### **Ramas de Características (`feature`)**
- Cada nueva característica debe desarrollarse en una rama `feature` basada en `team`.
- Convención de nombres:
  ```
  feature/<nombre-descriptivo-de-la-característica>
  ```

- Ejemplo:
  ```bash
  git checkout -b feature/consumir-pokeapi
  ```

### **Ramas de Tareas (`task`)**
- Estas ramas son específicas para tareas pequeñas o ajustes basada en `feature`.
- Convención de nombres:
  ```
  task/<nombre-descriptivo-de-la-tarea>
  ```

- Ejemplo:
  ```bash
  git checkout -b task/corregir-mensaje-log
  ```

### **Ramas de Corrección de Errores Productivos (`hotfix`)**
- Si se detecta un error crítico en producción, se crea una rama `hotfix` basada en `main`.
- Convención de nombres:
  ```
  hotfix/<nombre-del-error>
  ```

- Ejemplo:
  ```bash
  git checkout -b hotfix/corrige-error-wsdl
  ```

- Una vez corregido, se hace merge a `main` y a `develop` para mantener la consistencia.

## Pruebas

### **Pruebas Unitarias**

- Se utilizan pruebas unitarias para asegurar que el código funcione como se espera. Puedes ejecutar las pruebas con Maven:

  ```bash
  ./mvnw test
  ```

### **Pruebas SOAP**

- Usa SoapUI para realizar pruebas de la API SOAP en `http://localhost:8080/ws/pokemon.wsdl`.

---

