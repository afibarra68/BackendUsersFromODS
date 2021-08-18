package com.example.UserResting.Web.Rest;

import com.example.UserResting.Service.Dto.UserDTO;
import com.example.UserResting.Service.IUserService;
import com.example.UserResting.Service.error.ObjectNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final IUserService userService;

    public UserResource(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> create(@Valid @RequestBody  UserDTO usersDTO, BindingResult result){
        UserDTO dto = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()){
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(e -> "Error en el campo " + e.getField() + ": " + e.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("error", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }try
        {
            dto = userService.create(usersDTO);
        } catch (DataAccessException err) {
            response.put("message", "user hasn't been saved");
            response.put("Message Err", err.getMessage() + ": " +
                    err.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Has been created correctly");
        response.put("New User", dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/user")
    public Page<UserDTO> read(@PathParam("pageSize") Integer pageSize,
                              @PathParam("pageNumber") Integer pageNumber) {
        return userService.read(pageSize, pageNumber);
    }

    @PutMapping("/user")
    public UserDTO update(@RequestBody UserDTO userDTO){
        return userService.update(userDTO);
    }

    @GetMapping("/get-only/user/{idUser}")
    public ResponseEntity<UserDTO> getById(@PathVariable Integer idUser) {
        return new ResponseEntity<>(userService.getById(idUser), HttpStatus.OK);
    }
}
