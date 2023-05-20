package at.fhtw.swen2.tutorial.persistence;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.persistence.entities.TourLogEntity;
import at.fhtw.swen2.tutorial.persistence.repositories.TourLogRepository;
import at.fhtw.swen2.tutorial.persistence.repositories.TourRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class TourPersistenceTests {

	@Autowired
	private TourRepository tourRepository;
	@Autowired
	private TourLogRepository tourLogRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	void testPersonRepository() {
		TourEntity first = TourEntity.builder().id(5L).name("First").tourDescription("1").from("here").to("there").build();
		tourRepository.save(first);
		/*TourLogEntity second = TourLogEntity.builder()
				.tourEntity(first)
				.build();
		tourLogRepository.save(second);
		tourRepository.findAll().forEach(System.out::println);*/
		//tourLogRepository.findAll().forEach(System.out::println);
		// Eagerly fetch the tourLogSet collection
		entityManager.flush();
		entityManager.clear();

		tourRepository.findAll().forEach(System.out::println);
	}

}
