# Spring Boot Cache - Repositorio de Ejemplo para Entrevistas

Este repositorio es un ejemplo práctico de uso de **Spring Boot Cache**, pensado para entrevistas técnicas. Implementa un microservicio básico con cacheo en memoria utilizando la anotación `@Cacheable` y `@CachePut` de Spring Boot.

## 🚀 Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Boot Cache**
- **Maven**
- **Postman** (para pruebas de API)

## 📌 Cómo Levantar la Aplicación
### Prerrequisitos
Asegúrate de tener instalado:
- **Java 17**
- **Maven**

### Pasos
1. Clona el repositorio:
   ```sh
   git clone https://github.com/tu-usuario/springboot-cache-demo.git
   cd springboot-cache-demo
   ```
2. Compila y ejecuta el proyecto:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
3. La aplicación estará corriendo en: `http://localhost:8080`

## 🔥 Pruebas con Postman
Puedes probar los endpoints con Postman o `curl`:

### Agregar un usuario
```sh
  curl -X POST "http://localhost:8080/users/1?name=Juan"
```
_Response:_
```json
"Usuario Juan agregado exitosamente."
```

### Obtener un usuario (con caché habilitada)
```sh
  curl -X GET "http://localhost:8080/users/1"
```
_Response:_
```json
"Juan"
```

## 🎯 ¿Qué se puede mejorar?
- **Implementar Redis:** Para manejar la caché de manera más eficiente.
- **Agregar `@CacheEvict`** para eliminar elementos de la caché cuando sea necesario.
- **Crear un sistema de expiración de caché** con `@Scheduled`.
- **Manejo de errores más robusto**.

## 🎤 Preguntas Frecuentes en Entrevistas Técnicas
### 1. ¿Qué es `@Cacheable` en Spring Boot?
`@Cacheable` almacena en caché el resultado de un método para evitar recalcularlo innecesariamente.

### 2. ¿Qué diferencia hay entre `@Cacheable` y `@CachePut`?
`@Cacheable` almacena el valor solo si no existe en caché, mientras que `@CachePut` fuerza la actualización en caché.

### 3. ¿Cómo invalidar un elemento en la caché?
Se usa `@CacheEvict`, que permite eliminar un elemento de la caché manualmente.

### 4. ¿Qué ventajas tiene Redis frente a la caché en memoria?
Redis permite persistencia, replicación, mayor escalabilidad y control sobre la expiración de la caché.

### 5. ¿Cómo habilitar la caché en Spring Boot?
Basta con añadir `@EnableCaching` en la clase principal y usar anotaciones como `@Cacheable` en los métodos.

## 📜 Licencia
Este proyecto está bajo la **Licencia MIT**. Puedes utilizarlo libremente para aprender y mejorar en entrevistas técnicas.

---
📌 **¡Cualquier mejora o PR es bienvenido!** 💡

