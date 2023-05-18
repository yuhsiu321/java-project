package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UpdateTourViewModel {

    @Autowired
    private TourService tourService;

    @Autowired
    private DeleteTourViewModel deleteTourViewModel;
    private SimpleStringProperty updateName = new SimpleStringProperty();

    private SimpleStringProperty tourDescription = new SimpleStringProperty();


    public String getTourDescription() {
        return tourDescription.get();
    }

    public SimpleStringProperty tourDescriptionProperty() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription.set(tourDescription);
    }

    public String getFrom() {
        return from.get();
    }

    public SimpleStringProperty fromProperty() {
        return from;
    }

    public void setFrom(String from) {
        this.from.set(from);
    }

    public String getTo() {
        return to.get();
    }

    public SimpleStringProperty toProperty() {
        return to;
    }

    public void setTo(String to) {
        this.to.set(to);
    }

    public String getTransportType() {
        return transportType.get();
    }

    public ObjectProperty<String> transportTypeProperty() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType.set(transportType);
    }

    private SimpleStringProperty from = new SimpleStringProperty();

    private SimpleStringProperty to = new SimpleStringProperty();

    private ObjectProperty<String> transportType = new SimpleObjectProperty<>();

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
        //Tour tour = tourService.findByName(getUpdateName());
        //System.out.println(tour);

        Tour tour = Tour.builder().name(getUpdateName()).tourDescription(getTourDescription()).from(getFrom()).to(getTo()).transportType(getTransportType()).build();

        tour = tourService.updateTour(tour);

        //update tour detail

    }
}
