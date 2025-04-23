package com.example.ProvaBack2.Controller;

import com.example.ProvaBack2.Dto.UsuarioDto;
import com.example.ProvaBack2.Entity.Usuario;
import com.example.ProvaBack2.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> created(@RequestBody UsuarioDto usuarioDto){
        UsuarioDto usuario = usuarioService.saveDto(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping
    public List<Usuario> getAll(@RequestParam(required = false) String nome, @RequestParam(required = false) String cpf ){

        if(nome != null && !nome.isEmpty()){
            return usuarioService.getByNome(nome);
        }if(nome != null && !nome.isEmpty() && cpf != null && !cpf.isEmpty()){
            return usuarioService.getByCpf(cpf);
        }if(cpf != null && !cpf.isEmpty()){
            return usuarioService.getByCpf(cpf);
        }
        else{
            return usuarioService.getAll();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getById(@PathVariable Long id){
        Optional<UsuarioDto> usuarioDTO = usuarioService.getById(id);
        if(usuarioDTO.isPresent()){
            return ResponseEntity.ok(usuarioDTO.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> updateGeral(@PathVariable Long id, @RequestBody UsuarioDto usuarioDTO){
        Optional<UsuarioDto> usuarioDtoOptional = usuarioService.updateUsuario(id, usuarioDTO);
        if (usuarioDtoOptional.isPresent()){
            return ResponseEntity.ok(usuarioDtoOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/senha/{id}")
    public ResponseEntity<UsuarioDto> updateSenha(@PathVariable Long id, @RequestBody UsuarioDto usuarioDTO){
        Optional<UsuarioDto> usuarioDtoOptional = usuarioService.updateSenha(id, usuarioDTO);
        if (usuarioDtoOptional.isPresent()){
            return ResponseEntity.ok(usuarioDtoOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(usuarioService.delete(id)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
