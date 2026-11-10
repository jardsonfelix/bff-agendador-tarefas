package com.jardsonProjetos.bffAgendadorTarefas.infrastructure;


import com.jardsonProjetos.bffAgendadorTarefas.business.dto.in.TarefasDTORequest;
import com.jardsonProjetos.bffAgendadorTarefas.business.dto.out.TarefasDTOResponse;
import com.jardsonProjetos.bffAgendadorTarefas.business.enuns.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name="agendador-tarefa", url="${agendador-tarefas.url}")
public interface TarefaClient {


    @PostMapping
    TarefasDTOResponse gravarTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestHeader("Authorization") String token);

    @GetMapping("/eventos")
    List<TarefasDTOResponse> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);


    @GetMapping
    List<TarefasDTOResponse> buscartarefasPorEmail(@RequestHeader("Authorization") String token);


    @DeleteMapping
    void deletaTarefaPorid(@RequestParam("id") String id, @RequestHeader("Authorization") String token);


    @PatchMapping
    TarefasDTOResponse alterarStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                                @RequestParam("id") String id,
                                                @RequestHeader("Authorization") String token);



    @PutMapping
    TarefasDTOResponse updateTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestParam("id") String id,
                                     @RequestHeader("Authorization") String token);

}

