package org.itsimulator.germes.app.config;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.itsimulator.germes.app.persistence.hibernate.SessionFactoryBuilder;
import org.itsimulator.germes.app.persistence.repository.CityRepository;
import org.itsimulator.germes.app.persistence.repository.inmemory.InMemoryCityRepository;
import org.itsimulator.germes.app.service.GeographicService;
import org.itsimulator.germes.app.service.impl.GeographicServiceImpl;
import org.itsimulator.germes.app.service.transform.Transformer;
import org.itsimulator.germes.app.service.transform.impl.SimpleDTOTransformer;

/**
 * Binds bean implementations and implemented interfaces
 * @author Morenets
 *
 */
public class ComponentBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(InMemoryCityRepository.class).to(CityRepository.class).in(Singleton.class);
        bind(SimpleDTOTransformer.class).to(Transformer.class).in(Singleton.class);
        bind(GeographicServiceImpl.class).to(GeographicService.class).in(Singleton.class);
        bind(SessionFactoryBuilder.class).to(SessionFactoryBuilder.class).in(Singleton.class);
    }
}