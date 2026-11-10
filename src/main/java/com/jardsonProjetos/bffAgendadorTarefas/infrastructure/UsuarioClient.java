package com.jardsonProjetos.bffAgendadorTarefas.infrastructure;


import com.jardsonProjetos.bffAgendadorTarefas.business.dto.in.EnderecoDTORequest;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.in.LoginRequestDTO;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.in.TelefoneDTOResquest;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.in.UsuarioDTORequest;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.out.EnderecoDTOResponse;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.out.TelefoneDTOResponse;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="usuario", url="${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);


    @PostMapping
    UsuarioDTOResponse salvarUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO usuarioTDO);


    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizarUsuario(@RequestBody UsuarioDTORequest dto,
                                        @RequestHeader("Authorization") String token);


    @PutMapping("/endereco")
    EnderecoDTOResponse atualizarEndereco(@RequestBody EnderecoDTORequest dto,
                                          @RequestParam ("id") Long id,
                                          @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizarTelefone(@RequestBody TelefoneDTOResquest dto,
                                          @RequestParam ("id") Long id,
                                          @RequestHeader("Authorization") String token);


    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestHeader("Authorization") String token);


    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTOResquest dto,
                                         @RequestHeader ("Authorization") String token);

}
