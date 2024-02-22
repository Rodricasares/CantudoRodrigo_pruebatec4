Proyecto de Reserva de Hoteles y Vuelos

Este proyecto ofrece una API para la reserva de hoteles y vuelos. Para realizar pruebas, es necesario registrarse con el usuario 'admin' y la contraseña '1234' proporcionados por la administración.

Usuarios

La gestión de usuarios permite agregar nuevos usuarios para realizar consultas. Se pueden agregar usuarios mediante el método POST sin necesidad de iniciar sesión:

Agregar usuario: http://localhost:8080/user/add
Obtener todos los usuarios: http://localhost:8080/user/getAll
Obtener usuario por ID: http://localhost:8080/user/1
Eliminar usuario por ID: http://localhost:8080/user/delete/1
Hoteles

Es necesario ingresar la información de los hoteles antes de añadir habitaciones. Las operaciones relacionadas con hoteles incluyen:

Agregar hotel: http://localhost:8080/hotel/add
Obtener todos los hoteles: http://localhost:8080/hotel/getAll
Obtener hotel por ID: http://localhost:8080/hotel/1
Eliminar hotel por ID: http://localhost:8080/hotel/delete/1
Habitaciones

Primero, se deben ingresar las habitaciones y luego asignarlas a un hotel. Las operaciones relacionadas con habitaciones son:

Agregar habitación: http://localhost:8080/room/add
Obtener habitación por ID: http://localhost:8080/room/1
Eliminar habitación por ID: http://localhost:8080/room/delete/1
Asignar habitación a un hotel (requiere autenticación): http://localhost:8080/room/addRoom/1
Reserva de Habitaciones

Para realizar reservas de habitaciones, se utiliza el método POST con la asignación de la ID:

Reservar habitación: http://localhost:8080/room/reserve/1
Ver habitaciones disponibles: http://localhost:8080/room/available
Ver disponibilidad por fechas: http://localhost:8080/room/availableByDate
Obtener todas las habitaciones: http://localhost:8080/room/getAll
Vuelos

La gestión de vuelos requiere autenticación como administrador (usuario 'admin', contraseña '1234'). Las operaciones relacionadas con vuelos son:

Agregar vuelo: http://localhost:8080/flight/add
Obtener vuelo por ID: http://localhost:8080/flight/1
Eliminar vuelo por ID: http://localhost:8080/flight/delete/1
Reserva de Vuelos

Las reservas de vuelos se realizan mediante el método POST con la asignación de la ID:

Reservar vuelo: http://localhost:8080/flight/reserve/1
Ver vuelos disponibles: http://localhost:8080/flight/available
Obtener todos los vuelos: http://localhost:8080/flight/getAll
Filtrar vuelos por origen y destino: http://localhost:8080/flight/departures/{origin}/{destination}/{isBooked}
Filtrar llegadas por destino y estado de reserva: http://localhost:8080/flight/arrivals/{destination}/{isBooked}
Filtrar salidas por origen y estado de reserva: http://localhost:8080/flight/departures/{origin}/{isBooked}
