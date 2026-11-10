package com.jardsonProjetos.bffAgendadorTarefas.controller;

import com.jardsonProjetos.bffAgendadorTarefas.business.UsuarioService;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.in.EnderecoDTORequest;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.in.LoginRequestDTO;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.in.TelefoneDTOResquest;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.in.UsuarioDTORequest;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.out.EnderecoDTOResponse;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.out.TelefoneDTOResponse;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.out.UsuarioDTOResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name="Usuario", description = "cadastro e login e usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Salvar Usuario", description = "Cria um novo usuario")
    @ApiResponse(responseCode = "200", description = "Usuario salvo com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuario cadastrado")
    @ApiResponse(responseCode ="500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> salvarUsuario(@RequestBody UsuarioDTORequest usuarioDTO){
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "Login Usuario", description = "Login do usuario")
    @ApiResponse(responseCode = "200", description = "Usuario logado comsucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    @ApiResponse(responseCode ="500", description = "Erro de servidor")
    public String login(@RequestBody LoginRequestDTO usuarioTDO){
        return usuarioService.loginUsuario(usuarioTDO);
    }

    @GetMapping
    @Operation(summary = "Buscar dados de usuarios por email", description = "Buscar dados do usuario")
    @ApiResponse(responseCode = "200", description = "Usuario encontrado")
    @ApiResponse(responseCode = "404", description = "Usuario nao cadastrado")
    @ApiResponse(responseCode ="500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> buscaUsuarioPorEmail(@RequestParam("email") String email,
                                                                   @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email, token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deleta Usuario por id", description = "Deleta usuario")
    @ApiResponse(responseCode = "200", description = "Usuario deletado")
    @ApiResponse(responseCode = "400", description = "Usuario nao encontrado")
    @ApiResponse(responseCode ="500", description = "Erro de servidor")
    public ResponseEntity<Void> deletaUsuarioPorEmail(@PathVariable String email,
                                                      @RequestHeader("Authorization") String token){
        usuarioService.deletaUsuarioPorEmail(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualizar dados de Usuario", description = "Cria um novo usuario")
    @ApiResponse(responseCode = "200", description = "Usuario atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuario  nao cadastrado")
    @ApiResponse(responseCode ="500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> atualizarUsuario(@RequestBody UsuarioDTORequest dto,
                                                               @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.atualizadoDadosUsuario(token, dto));
    }

    @PutMapping("/endereco")
    @Operation(summary = "Atualizar endereco do Usuario", description = "Atualiza endereco do usuario")
    @ApiResponse(responseCode = "200", description = "endereco atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuario nao encontrado cadastrado")
    @ApiResponse(responseCode ="500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDTOResponse> atualizarEndereco(@RequestBody EnderecoDTORequest dto,
                                                                 @RequestParam ("id") Long id,
                                                                 @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.atualizarEndereco(id,dto, token));
    }

    @PutMapping("/telefone")
    @Operation(summary = "Atualizar telefone do Usuario", description = "Atualizar telefone do usuario")
    @ApiResponse(responseCode = "200", description = "Telefone atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuario nao encontrado")
    @ApiResponse(responseCode ="500", description = "Erro de servidor")
    public ResponseEntity<TelefoneDTOResponse> atualizarTelefone(@RequestBody TelefoneDTOResquest dto,
                                                                 @RequestParam ("id") Long id,
                                                                 @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.atualizarTelefone(id,dto, token));
    }

    @PostMapping("/endereco")
    @Operation(summary = "Salvar endereco do Usuario", description = "Salva endereco do usuario")
    @ApiResponse(responseCode = "200", description = "Endereco salvo com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuario nao encontrado")
    @ApiResponse(responseCode ="500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDTOResponse> cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                                                @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.cadastrarEndereco(token,dto));
    }

    @PostMapping("/telefone")
    @Operation(summary = "Salvar telefone do Usuario", description = "Salva telefone do usuario")
    @ApiResponse(responseCode = "200", description = "Telefone salvo com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuario nao encontrado")
    @ApiResponse(responseCode ="500", description = "Erro de servidor")
    public ResponseEntity<TelefoneDTOResponse> cadastraTelefone(@RequestBody TelefoneDTOResquest dto,
                                                                @RequestHeader ("Authorization") String token){
        return ResponseEntity.ok(usuarioService.cadastroTelefone(token, dto));
    }


}
