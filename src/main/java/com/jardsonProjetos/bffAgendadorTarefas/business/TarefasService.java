package com.jardsonProjetos.bffAgendadorTarefas.business;

import com.jardsonProjetos.bffAgendadorTarefas.business.dto.in.TarefasDTORequest;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.out.TarefasDTOResponse;
import com.jardsonProjetos.bffAgendadorTarefas.business.enuns.StatusNotificacaoEnum;
import com.jardsonProjetos.bffAgendadorTarefas.infrastructure.TarefaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefaClient tarefaClient;


    public TarefasDTOResponse gravarTarefa(String token,
                                           TarefasDTORequest dto) {
        return tarefaClient.gravarTarefas(dto, token);

    }

    public List<TarefasDTOResponse> buscarTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                                     LocalDateTime dataFinal,
                                                                     String token){

        return tarefaClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
        }

    public List<TarefasDTOResponse> buscarTarefaPorEmail(String token){
        return tarefaClient.buscartarefasPorEmail(token);
        }

    public void deletaTarefaPorId (String id, String token){
        tarefaClient.deletaTarefaPorid(id, token);
        }

    public TarefasDTOResponse alteraStatus (StatusNotificacaoEnum status, String id, String token){
        return tarefaClient.alterarStatusNotificacao(status, id, token);
        }

    public TarefasDTOResponse updateTarefa (TarefasDTORequest dto, String id, String token){
        return tarefaClient.updateTarefas(dto, id, token);
        }
    }
