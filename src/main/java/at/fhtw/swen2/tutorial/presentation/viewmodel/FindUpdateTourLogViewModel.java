package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.service.TourLogService;
import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import javafx.beans.property.SimpleStringProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FindUpdateTourLogViewModel {
    @Autowired
    private TourLogService tourLogService;
    @Autowired
    private TourLogListViewModel tourLogListViewModel;

    private final SimpleStringProperty findUpdateComment = new SimpleStringProperty();

    public String getFindUpdateName() {
        return findUpdateComment.get();
    }

    public void setFindUpdateName(String findUpdateName) {
        this.findUpdateComment.set(findUpdateName);
    }

    public SimpleStringProperty findUpdateNameProperty() {
        return findUpdateComment;
    }

    public SimpleStringProperty FindUpdateNameProperty() {
        return findUpdateComment;
    }

    public TourLog findUpdate() {
        TourLog tourLog = tourLogService.findByComment(getFindUpdateName());

        System.out.println(tourLog);

        return tourLog;

        //show tour detail

    }

}
