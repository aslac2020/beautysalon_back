package com.salaohair.api.controller;

import com.salaohair.api.dto.request.UsuarioRequest;
import com.salaohair.api.dto.response.UsuarioResponse;
import com.salaohair.api.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAllUsers(){
        return new ResponseEntity<>(usuarioService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> createUser(@RequestBody UsuarioRequest request){
        return new ResponseEntity<>(usuarioService.createUser(request), HttpStatus.OK);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioResponse>  findUserById(@PathVariable Long usuarioId){
        return new ResponseEntity<>(usuarioService.findUserById(usuarioId), HttpStatus.OK);
    }

    @PutMapping("/{usuarioId}")
    public ResponseEntity<UsuarioResponse> updateUser(@RequestBody UsuarioRequest request, @PathVariable Long usuarioId ){
        return new ResponseEntity<>(usuarioService.updateUser(usuarioId, request), HttpStatus.OK);
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long usuarioId ){
        usuarioService.deleteUser(usuarioId);
        return ResponseEntity.noContent().build();
    }

}
