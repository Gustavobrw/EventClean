package dev.java10x.EventClean.infrastructure.configuration;

import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoUseCase criarEventoUseCase(EventoGateway eventoGateway) {
        return new CriarEventoUseCaseImpl(eventoGateway);
    }

    @Bean
    public BuscarEventoUseCase buscarEventoCase(EventoGateway eventoGateway) {
        return new BuscarEventoUseCaseImpl(eventoGateway);
    }

    @Bean
    public BuscarEventoPorIdUseCase buscarEventoPorIdUseCase(EventoGateway eventoGateway) {
        return new BuscarEventoPorIdUseCaseImpl(eventoGateway);
    }

    @Bean
    public FiltrarIdentificadorEventoUseCase filtrarIdentificadorEventoUseCase(EventoGateway eventoGateway) {
        return new FiltrarIdentificadorEventoUseCaseImpl(eventoGateway);
    }
}
