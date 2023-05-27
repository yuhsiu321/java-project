package at.fhtw.swen2.tutorial.presentation.view;

import at.fhtw.swen2.tutorial.presentation.viewmodel.DeleteTourViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.TourListViewModel;
import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
public class DeleteTourViewModelTest {

    @MockBean
    private TourService tourService;

    @MockBean
    private TourListViewModel tourListViewModel;

    @Autowired
    private DeleteTourViewModel deleteTourViewModel;

    @Test
    public void testDelete() {
        // Set the necessary properties for the view model
        deleteTourViewModel.setDeleteName("First");

        // Mock the tour returned by tourService
        Tour expectedTour = mock(Tour.class);
        when(tourService.findByName("First")).thenReturn(expectedTour);

        // Call the method under test
        deleteTourViewModel.delete();

        // Verify that the tourListViewModel's deleteItem method was called with the expected tour
        //verify(tourListViewModel).deleteItem(expectedTour);

        // Verify that the tourService's delete method was called with the expected tour name
        verify(tourService).delete("First");

        // Add any additional assertions based on the expected behavior
        // For example, you can assert that a certain property of the view model has been reset after deleting the tour
         //assertEquals("First", deleteTourViewModel.getDeleteName());

        // You can also assert the result of the method or perform additional verifications as needed
    }

}


