package com.jardsonProjetos.bffAgendadorTarefas.business;

import com.jardsonProjetos.bffAgendadorTarefas.business.dto.in.EnderecoDTORequest;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.in.LoginRequestDTO;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.in.TelefoneDTOResquest;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.in.UsuarioDTORequest;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.out.EnderecoDTOResponse;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.out.TelefoneDTOResponse;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.out.UsuarioDTOResponse;
import com.jardsonProjetos.bffAgendadorTarefas.infrastructure.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvarUsuario(UsuarioDTORequest usuarioDTO) {

        return usuarioClient.salvarUsuario(usuarioDTO);

    }

   public String loginUsuario(LoginRequestDTO usuarioDTO){
        return usuarioClient.login(usuarioDTO);
   }


    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token){

        return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token){
        usuarioClient.deletaUsuarioPorEmail(email, token);

    }

    public UsuarioDTOResponse atualizadoDadosUsuario(String token, UsuarioDTORequest dto){

        return usuarioClient.atualizarUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizarEndereco(Long idEndereco, EnderecoDTORequest dto, String token){

        return usuarioClient.atualizarEndereco(dto, idEndereco, token);

    }

    public TelefoneDTOResponse atualizarTelefone(Long idTelefone, TelefoneDTOResquest
            dto, String token){
        return usuarioClient.atualizarTelefone(dto, idTelefone, token);
    }

    public EnderecoDTOResponse cadastrarEndereco(String token, EnderecoDTORequest dto){

        return usuarioClient.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastroTelefone(String token, TelefoneDTOResquest dto) {

        return usuarioClient.cadastraTelefone(dto, token);
    }
}
