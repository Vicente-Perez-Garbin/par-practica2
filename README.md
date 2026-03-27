# Práctica 2: API REST Carrito de Compra

## Requisitos del Recurso

Cada objeto Carrito cuenta con las siguientes propiedades:

* idCarrito: Identificador único (int).
* idArticulo: Identificador del artículo (int).
* descripcion: Texto descriptivo.
* unidades: Cantidad de artículos.
* precioFinal: Importe calculado/proporcionado.

## Documentación de la API

| Método          | Ruta                          | Cuerpo (JSON) | Descripción                               | Posibles Respuestas                   |
| :--------------- | :---------------------------- | :------------ | :----------------------------------------- | :------------------------------------ |
| **GET**    | `/api/carritos`             | No            | Lista todos los carritos en memoria.       | `200 OK`                            |
| **GET**    | `/api/carritos/{idCarrito}` | No            | Obtiene los datos de un carrito por su ID. | `200 OK`, `404 Not Found`         |
| **POST**   | `/api/carritos`             | Sí           | Crea un nuevo carrito.                     | `201 Created`, `409 Conflict`      |
| **PUT**    | `/api/carritos/{idCarrito}` | Sí           | Actualiza un carrito existente.            | `200 OK`, `404 Not Found`         |
| **DELETE** | `/api/carritos/{idCarrito}` | No            | Elimina un carrito del sistema.            | `204 No Content`, `404 Not Found` |

## Ejemplo de Cuerpo de Petición (JSON)

Para los métodos POST y PUT, se debe enviar un objeto con la siguiente estructura:

```json
{
"idCarrito": 1,
"idArticulo": 1,
"descripcion": "Camiseta",
"unidades": 10,
"precioFinal": 100
}
```
