package dev.java10x.EventClean.infrastructure.gateway;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.exception.ValidationException;
import dev.java10x.EventClean.infrastructure.mapper.EventoEntityMapper;
import dev.java10x.EventClean.infrastructure.persistence.EventoEntity;
import dev.java10x.EventClean.infrastructure.persistence.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class EventoRepositoryGateway implements EventoGateway {

    private final EventoRepository eventoRepository;
    private final EventoEntityMapper mapper;

    @Override
    public Evento criarEvento(Evento evento) {
        EventoEntity entity = mapper.toEntity(evento);
        String identificador = generateRandomIndentificador();
        entity.setIdentificador(identificador);
        EventoEntity novoEvento = eventoRepository.save(entity);
        return mapper.toDomain(novoEvento);
    }

    @Override
    public List<Evento> buscarEvento() {
        return eventoRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Boolean existsByIdentificador(String identificador) {
        return eventoRepository.findEventoByIdentificador(identificador).isPresent();
    }

    @Override
    public Evento buscarEventoPorId(Long id) {
        EventoEntity evento = eventoRepository.findById(id).orElseThrow(() -> new ValidationException("Evento não encontrado"));
        return mapper.toDomain(evento);
    }

    @Override
    public Optional<Evento> filtrarIdentificadorEvento(String identificador) {
        return eventoRepository.findEventoByIdentificador(identificador);
    }

    @Override
    public String generateRandomIndentificador() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros= "0123456789";
        Random random = new Random();

        List<Character> caracteres = new ArrayList<>();
        for(int i = 0 ; i < 3 ; i++){
            int index = random.nextInt(letras.length());
            caracteres.add(letras.charAt(index));
        }
        for(int i = 0 ; i < 3 ; i++){
            int index = random.nextInt(numeros.length());
            caracteres.add(numeros.charAt(index));
        }

        Collections.shuffle(caracteres, random);

        StringBuilder generate = new StringBuilder();
        for (char c : caracteres) {
            generate.append(c);
        }

        return generate.toString();
    }
}
