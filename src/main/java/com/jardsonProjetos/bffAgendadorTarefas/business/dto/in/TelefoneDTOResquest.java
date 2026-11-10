package com.jardsonProjetos.bffAgendadorTarefas.business.dto.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDTOResquest {

    private String numero;
    private String ddd;

}
