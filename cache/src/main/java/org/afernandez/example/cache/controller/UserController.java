package org.afernandez.example.cache.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador que gestiona usuarios utilizando caché.
 */
@RestController
@RequestMapping("/users")
@CacheConfig(cacheNames = "users") // Define el nombre de la caché
class UserController {
    private final Map<Integer, String> userDatabase = new HashMap<>();

    /**
     * Obtiene un usuario por su ID. Usa caché para evitar llamadas repetitivas.
     *
     * @param id ID del usuario
     * @return Nombre del usuario
     */
    @GetMapping("/{id}")
    @Cacheable(key = "#id") // Si el usuario ya está en caché, se devuelve sin ejecutar el método
    public String getUser(@PathVariable("id") Integer id) {
        simulateSlowService(); // Simula una llamada lenta a base de datos
        return userDatabase.getOrDefault(id, "Usuario no encontrado");
    }

    /**
     * Agrega o actualiza un usuario en la base de datos y lo almacena en caché.
     *
     * @param id   ID del usuario
     * @param name Nombre del usuario
     * @return Mensaje de confirmación
     */
    @PostMapping("/{id}")
    @CachePut(key = "#id") // Actualiza la caché con el nuevo valor
    public String addUser(@PathVariable("id") Integer id, @RequestParam("name") String name) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }
        userDatabase.put(id, name);
        return "Usuario " + name + " agregado exitosamente.";
    }

    /**
     * Simula una operación lenta, como una consulta a base de datos.
     */
    private void simulateSlowService() {
        try {
            Thread.sleep(3000); // Simula un retraso de 3 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
