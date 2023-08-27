package edu.tyss.carapp.Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.carapp.model.Car;

public class CarController {

	public EntityManager makeEntityManagerConnection() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("car");
		EntityManager em = emf.createEntityManager();
		return em;
	}

	public void addCar(Car car) {
		EntityManager em = makeEntityManagerConnection();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(car);
		et.commit();
	}

	public Car findCarByCarId(int carId) {
		EntityManager em = makeEntityManagerConnection();
		Car car = em.find(Car.class, carId);
		return car;
	}

	public boolean updateCarById(int carId, int uPrice) {
		Car c = findCarByCarId(carId);
		if (c != null) {
			EntityManager em = makeEntityManagerConnection();
			EntityTransaction et = em.getTransaction();
			c.setCarPrice(uPrice);
			et.begin();
			em.merge(c);
			et.commit();
			return true;
		}
		return false;
	}

	public boolean deleteCarById(int carId) {

		EntityManager em = makeEntityManagerConnection();
		EntityTransaction et = em.getTransaction();
		Car c = em.find(Car.class, carId);
//		Car c = findCarByCarId(carId);
		//Life Cycle of HiberNate
		if (c != null) {
			et.begin();
			em.remove(c);
			et.commit();
			return true;
		}
		return false;

	}

}
