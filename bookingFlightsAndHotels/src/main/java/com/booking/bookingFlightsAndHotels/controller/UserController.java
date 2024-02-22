package com.booking.bookingFlightsAndHotels.controller;

import com.booking.bookingFlightsAndHotels.model.Hotel;
import com.booking.bookingFlightsAndHotels.model.User;
import com.booking.bookingFlightsAndHotels.service.IUserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userServ;
    @GetMapping("/{id}")
    public User getUserId(@PathVariable Long id){
        return userServ.findUser(id);
    }
    @GetMapping("/getAll")
    public List<User> getPersonas() {
        return userServ.getUsers();
    }

    @PostMapping("/add")
    public String saveUser(@RequestBody User user) {
        userServ.saveUser(user);
        return "Successfully created person";
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteUser (@PathVariable Long id) {
        userServ.deleteUser(id);
        return "Person successfully removed";
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La operación se ejecutó correctamente"),
            @ApiResponse(responseCode = "201", description = "Recurso creado exitosamente"),
            @ApiResponse(responseCode = "204", description = "La operación se ejecutó correctamente pero no hay contenido para devolver"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "401", description = "No autorizado"),
            @ApiResponse(responseCode = "403", description = "Prohibido, no tiene los permisos necesarios"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping ("/edit/{id}")
    public ResponseEntity<User> editUser (@PathVariable Long id,
                                @RequestParam ("name") String nameModif,
                                @RequestParam ("last_name") String last_nameModif,
                                @RequestParam ("age") int ageModif) {

        User user = userServ.findUser(id);
        //buscamos la persona en cuestión
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            user.setName(nameModif);
            user.setLast_name(last_nameModif);
            user.setAge(ageModif);

            userServ.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);

        }

    }

    @GetMapping("/find/{name}/{age}")
    public List<User>getRepository(@PathVariable String name, @PathVariable Integer age){
        return userServ.findByName(name, age);
    }

}
