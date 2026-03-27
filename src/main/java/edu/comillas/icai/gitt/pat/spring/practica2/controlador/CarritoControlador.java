package edu.comillas.icai.gitt.pat.spring.practica2.controlador;

import edu.comillas.icai.gitt.pat.spring.practica2.modelo.Carrito;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/carritos")
public class CarritoControlador {
    private final Map<Integer, Carrito> carritos = new HashMap<>();

    @GetMapping
    public Collection<Carrito> getCarritos() {
        return carritos.values();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carrito creaCarrito(@RequestBody Carrito carrito) {
        if (carritos.containsKey(carrito.getIdCarrito())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El carrito ya existe");
        }
        carritos.put(carrito.getIdCarrito(), carrito);
        return carrito;
    }

    @GetMapping("/{idCarrito}")
    public Carrito getCarrito(@PathVariable int idCarrito) {
        Carrito carrito = carritos.get(idCarrito);
        if (carrito == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado");
        }
        return carrito;
    }

    @DeleteMapping("/{idCarrito}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarrito(@PathVariable int idCarrito) {
        if (!carritos.containsKey(idCarrito)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado");
        }
        carritos.remove(idCarrito);
    }

    @PutMapping("/{idCarrito}")
    public Carrito modificarCarrito(@PathVariable int idCarrito, @RequestBody Carrito carrito) {
        if (!carritos.containsKey(idCarrito)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado");
        }
        carrito.setIdCarrito(idCarrito);
        carritos.put(idCarrito, carrito);
        return carrito;
    }
}