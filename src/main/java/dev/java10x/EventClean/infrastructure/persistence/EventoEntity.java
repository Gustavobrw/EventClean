package dev.java10x.EventClean.infrastructure.persistence;

import dev.java10x.EventClean.core.enuns.TipoEvento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "evento")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventoEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String descricao;
    @Column(nullable = false, unique = true)
    private String identificador;
    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;
    @Column(name = "data_fim", nullable = false)
    private LocalDateTime dataFim;
    @Column(name = "local_evento", nullable = false)
    private String localEvento;
    @Column(nullable = false)
    private Integer capacidade;
    @Column(nullable = false)
    private String organizador;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEvento tipo;
}
