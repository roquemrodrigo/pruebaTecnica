package com.tbp.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tbp.crud.entity.User;
import com.tbp.crud.service.UserService;
import com.tbp.crud.util.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Api(tags = "API DOCUMENTADO")

//@RequestMapping("/use")
public class UserController {
	@Autowired
	private UserService userService;

        @ApiOperation(value = "REGISTRO DE USUARIO")
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.createUser(user);
	}

        @ApiOperation(value = "REGISTRO DE VARIOS USUARIOS")
	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users) {
		return userService.createUsers(users);
	}

        @ApiOperation(value = "BUSCAR POR ID")
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id) {
            try {
                Map<String, Object> res= new HashMap<String, Object>();
                
                User usuario = userService.getUserById(id);
                res.put("mensaje", Constant.MSJ_EXITO);
                res.put("User", usuario);
                return new ResponseEntity<>(usuario, HttpStatus.OK);
                
            }catch (Exception e) {
                e.printStackTrace();
                HashMap<String,String> response = new HashMap<String,String>() ;
                response.put("mensaje", e.getMessage());
                return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
            }
	}

        @ApiOperation(value = "LISTAR TODOS LOS USUARIOS")
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getUsers();
	}
	
        @ApiOperation(value = "ACTUALIZAR USUARIO")
	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

        @ApiOperation(value = "ELIMINAR USUARIO")
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUserById(id);
	}
}
