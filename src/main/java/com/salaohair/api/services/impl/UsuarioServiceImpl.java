package com.salaohair.api.services.impl;

import com.salaohair.api.dto.request.UsuarioRequest;
import com.salaohair.api.dto.response.UsuarioResponse;
import com.salaohair.api.models.Usuario;
import com.salaohair.api.repository.UsuarioRepository;
import com.salaohair.api.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    private final ModelMapper mapper;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository, ModelMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UsuarioResponse findUserById(Long usuarioId) {
        Usuario usuario = repository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        return mapper.map(usuario, UsuarioResponse.class);
    }

    @Override
    public List<UsuarioResponse> findAllUsers() {
        List<Usuario> usuarios = repository.findAll();
        return usuarios.stream()
                .map(usuario -> mapper.map(usuario, UsuarioResponse.class)).toList();
    }

    @Override
    public UsuarioResponse createUser(UsuarioRequest request) {
        Usuario usuario = mapper.map(request, Usuario.class);
        usuario = repository.save(usuario);
        return mapper.map(usuario, UsuarioResponse.class);
    }

    @Override
    public UsuarioResponse updateUser(Long usuarioId, UsuarioRequest request) {
        Usuario usuario = repository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());
        usuario.setDataCriacao(request.getDataCriacao());
        usuario.setTipoUsuario(request.getTipoUsuario());

        usuario = repository.save(usuario);
        return mapper.map(usuario, UsuarioResponse.class);
    }

    @Override
    public void deleteUser(Long usuarioId) {

        if(!repository.existsById(usuarioId)){
            throw new RuntimeException("Usuario não encontrado");
        }

        repository.deleteById(usuarioId);

    }
}
