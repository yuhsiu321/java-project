package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import javafx.beans.property.SimpleStringProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateTourViewModel {

    @Autowired
    private TourService tourService;
    @Autowired
    private TourListViewModel tourListViewModel;
    private SimpleStringProperty updateName = new SimpleStringProperty();


    public String getUpdateName() {
        return updateName.get();
    }

    public SimpleStringProperty UpdateNameProperty() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName.set(updateName);
    }

    public void update() {
        Tour tour = tourService.findByName(getUpdateName());
        System.out.println(tour);


        //update tour detail

    }
}
