# Práctica 2: API REST Carrito de Compra

## Requisitos del Recurso
Cada objeto Carrito cuenta con las siguientes propiedades:
* idCarrito: Identificador único (Long).
* idArticulo: Identificador del artículo (String).
* descripcion: Texto descriptivo.
* unidades: Cantidad de artículos.
* precioFinal: Importe calculado/proporcionado.

## Documentación de la API
| Método | Ruta | Cuerpo (JSON) | Descripción | Posibles Respuestas |
| :--- | :--- | :--- | :--- | :--- |
| **GET** | `/api/carritos` | No | Lista todos los carritos en memoria. | `200 OK` |
| **GET** | `/api/carritos/{id}` | No | Obtiene los datos de un carrito por su ID. | `200 OK`, `404 Not Found` |
| **POST** | `/api/carritos` | Sí | Crea un nuevo carrito. | `201 Created` |
| **PUT** | `/api/carritos/{id}` | Sí | Actualiza un artículo de un carrito existente. | `200 OK`, `404 Not Found` |
| **DELETE** | `/api/carritos/{id}` | No | Elimina un carrito del sistema. | `204 No Content`, `404 Not Found` |

## Ejemplo de Cuerpo de Petición (JSON)
Para los métodos POST y PUT, se debe enviar un objeto con la siguiente estructura:

```json
{
"idCarrito": 1,
"idArticulo": "1",
"descripcion": "Camiseta",
"unidades": 10,
"precioFinal": 100
}
```

## Instrucciones para ejecutar
1. Clonar el repositorio.
2. Ejecutar con Maven: ./mvnw spring-boot:run o desde el IDE (IntelliJ).
3. La API estará disponible en http://localhost:8080.