package com.salaohair.api.services;


import com.salaohair.api.dto.request.UsuarioRequest;
import com.salaohair.api.dto.response.UsuarioResponse;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UsuarioService {

    UsuarioResponse findUserById(Long usuarioId);
    List<UsuarioResponse> findAllUsers();
    UsuarioResponse createUser(UsuarioRequest request);
    UsuarioResponse updateUser(Long usuarioId, UsuarioRequest request);
    void deleteUser(Long usuarioId);


}
