package at.fhtw.swen2.tutorial.persistence;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.persistence.entities.TourLogEntity;
import at.fhtw.swen2.tutorial.persistence.repositories.TourLogRepository;
import at.fhtw.swen2.tutorial.persistence.repositories.TourRepository;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseInitializer implements InitializingBean {

    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private TourLogRepository tourLogRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<TourEntity> tourList = new ArrayList<>();
        tourList.add(TourEntity.builder().id(5L).name("First").tourDescription("1").from("here").to("there").build());
        tourList.add(TourEntity.builder().id(7L).name("Second").tourDescription("2").from("here").to("there").build());
        tourList.add(TourEntity.builder().id(11L).name("Third").tourDescription("3").from("here").to("there").build());
        tourList.add(TourEntity.builder().id(13L).name("Last").tourDescription("4").from("there").to("here").build());
        tourRepository.deleteAll();
        tourRepository.saveAll(tourList);

        TourLogEntity first = TourLogEntity.builder().id(13L).time(12.0).comment("123456").tourEntity(tourRepository.findByName("Second")).build();

        tourLogRepository.deleteAll();
        tourLogRepository.save(first);


    }
}
