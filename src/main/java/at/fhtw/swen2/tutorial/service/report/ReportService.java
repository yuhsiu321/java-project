package at.fhtw.swen2.tutorial.service.report;

import at.fhtw.swen2.tutorial.persistence.repositories.TourLogRepository;
import at.fhtw.swen2.tutorial.persistence.repositories.TourRepository;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ReportService {

    // Autowire necessary dependencies (e.g., TourRepository, TourLogRepository)
    @Autowired
    TourRepository tourRepository;

    @Autowired
    TourLogRepository tourLogRepository;

    public void generateTourReport(Tour tour) {
        // Retrieve tour logs for the given tour from the repository
        List<TourLog> tourLogs = tourLogRepository.findByTour(tour);

        // Prepare the data for the tour-report template
        Context context = new Context();
        context.setVariable("tour", tour);
        context.setVariable("tourLogs", tourLogs);

        // Generate the tour-report HTML
        String html = templateEngine.process("tour-report", context);

        // Convert HTML to PDF
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(25, 700);

            for (String line : html.split("\n")) {
                contentStream.showText(line);
                contentStream.newLineAtOffset(0, -15);
            }

            contentStream.endText();
        } catch (IOException e) {
            // Handle the exception
        }

        // Save the generated PDF to a file (e.g., tour-report.pdf)
        try {
            document.save("tour-report.pdf");
        } catch (IOException e) {
            // Handle the exception
        } finally {
            try {
                document.close();
            } catch (IOException e) {
                // Handle the exception
            }
        }
    }

    /*public void generateSummarizeReport(List<Tour> tours) {
        // Perform necessary calculations (e.g., average time, distance, rating) for each tour

        // Prepare the summarized data for the summarize-report template
        List<Summary> summaries = // Calculate summaries for each tour

                // Prepare the data for the summarize-report template
                Context context = new Context();
        context.setVariable("summaries", summaries);

        // Generate the summarize-report HTML
        String html = templateEngine.process("summarize-report", context);

        // Convert HTML to PDF
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(25, 700);

            for (String line : html.split("\n")) {
                contentStream.showText(line);
                contentStream.newLineAtOffset(0, -15);
            }

            contentStream.endText();
        } catch (IOException e) {
            // Handle the exception
        }

        // Save the generated PDF to a file (e.g., summarize-report.pdf)
        try {
            document.save("summarize-report.pdf");
        } catch (IOException e) {
            // Handle the exception
        } finally {
            try {
                document.close();
            } catch (IOException e) {
                // Handle the exception
            }*/
        }


