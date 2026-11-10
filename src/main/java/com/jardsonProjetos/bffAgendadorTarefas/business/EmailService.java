package com.jardsonProjetos.bffAgendadorTarefas.business;

import com.jardsonProjetos.bffAgendadorTarefas.business.dto.out.TarefasDTOResponse;
import com.jardsonProjetos.bffAgendadorTarefas.infrastructure.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;


    public void enviaEmail(TarefasDTOResponse dto){
        emailClient.enviarEmail(dto);

    }


    }
