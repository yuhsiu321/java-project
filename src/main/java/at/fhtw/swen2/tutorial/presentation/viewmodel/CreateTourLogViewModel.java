package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.persistence.repositories.TourRepository;
import at.fhtw.swen2.tutorial.service.TourLogService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CreateTourLogViewModel {
    @Autowired
    private TourLogService tourLogService;

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TourLogListViewModel tourLogListViewModel;

    private SimpleLongProperty id = new SimpleLongProperty();

    private SimpleDoubleProperty time = new SimpleDoubleProperty();
    private SimpleStringProperty comment = new SimpleStringProperty();
    private SimpleStringProperty difficulty = new SimpleStringProperty();
    private SimpleDoubleProperty totalTime = new SimpleDoubleProperty();
    private SimpleStringProperty rating = new SimpleStringProperty();
    private SimpleStringProperty tourName = new SimpleStringProperty();
    private TourEntity tourEntity;

    public TourEntity getTourEntity() {
        return tourEntity;
    }

    public void setTourEntity(String tourName) {
        this.tourEntity = tourRepository.findByName(tourName);
    }

    public TourLogService getTourLogService() {
        return tourLogService;
    }

    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public void setTourLogService(TourLogService tourLogService) {
        this.tourLogService = tourLogService;
    }

    public TourLogListViewModel getTourLogListViewModel() {
        return tourLogListViewModel;
    }

    public void setTourLogListViewModel(TourLogListViewModel tourLogListViewModel) {
        this.tourLogListViewModel = tourLogListViewModel;
    }

    public double getTime() {
        return time.get();
    }

    public SimpleDoubleProperty timeProperty() {
        return time;
    }

    public void setTime(double time) {
        this.time.set(time);
    }

    public String getComment() {
        return comment.get();
    }

    public SimpleStringProperty commentProperty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment.set(comment);
    }

    public String getDifficulty() {
        return difficulty.get();
    }

    public SimpleStringProperty difficultyProperty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty.set(difficulty);
    }

    public double getTotalTime() {
        return totalTime.get();
    }

    public SimpleDoubleProperty totalTimeProperty() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime.set(totalTime);
    }

    public String getRating() {
        return rating.get();
    }

    public SimpleStringProperty ratingProperty() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating.set(rating);
    }

    public String getTourName() {
        return tourName.get();
    }

    public SimpleStringProperty tourNameProperty() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName.set(tourName);
    }

    private TourLog tourLog;

    public CreateTourLogViewModel() {

    }

    public CreateTourLogViewModel(TourLog tourLog) {
        this.tourLog = tourLog;
        this.id = new SimpleLongProperty(tourLog.getId());
        this.time = new SimpleDoubleProperty(tourLog.getTime());
        this.comment = new SimpleStringProperty(tourLog.getComment());
        this.difficulty = new SimpleStringProperty(tourLog.getDifficulty());
        this.rating = new SimpleStringProperty(tourLog.getRating());
        this.totalTime = new SimpleDoubleProperty(tourLog.getTotalTime());
    }

    public void addNewTourLog() throws IOException {
        setTourEntity(getTourName());
        TourLog tourLog = TourLog.builder().comment(getComment()).time(getTime()).difficulty(getDifficulty()).rating(getRating()).totalTime(getTotalTime()).tourEntity(getTourEntity()).build();
        //System.out.println(tour);
        tourLog = tourLogService.addnew(tourLog);
        tourLogListViewModel.addItem(tourLog);
        //System.out.println(tour);
    }
}
