package org.itsimulator.germes.app.persistence.repository.hibernate;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsimulator.germes.app.model.entity.geography.City;
import org.itsimulator.germes.app.persistence.hibernate.SessionFactoryBuilder;
import org.itsimulator.germes.app.persistence.repository.CityRepository;

public class HibernateCityRepository implements CityRepository{

	private final SessionFactory sessionFactory;

	@Inject
	public HibernateCityRepository(SessionFactoryBuilder builder) {
		sessionFactory = builder.getSessionFactory();
	}

	@Override
	public void save(City city) {

		try (Session session = sessionFactory.openSession()) {
			session.saveOrUpdate(city);
		}
	}

	@Override
	public City findById(int cityId) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(City.class, cityId);
		}
	}

	@Override
	public void delete(int cityId) {
		try (Session session = sessionFactory.openSession()) {
			City city = session.get(City.class, cityId);
			if (city != null) {
				session.delete(city);
			}
		}
	}

	@Override
	public List<City> findAll() {
		try (Session session = sessionFactory.openSession()) {
			return session.createCriteria(City.class).list();
		}
	}
}
