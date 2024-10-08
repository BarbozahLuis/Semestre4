package com.example.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manutencao {
    private String id;
    private long maquinaID;
    private LocalDate data;
    private String tipo;
    private String pecasTrocadas;
    private long tempoDeParada;
    private String tecnicoID;
    private String observacoes;
}
