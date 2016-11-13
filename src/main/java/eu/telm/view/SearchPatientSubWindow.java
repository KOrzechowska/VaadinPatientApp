package eu.telm.view;


import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.*;
import eu.telm.model.Patient;
import eu.telm.model.PatientDao;
import org.springframework.util.StringUtils;

/**
 * Created by kasia on 13.11.16.
 */
public class SearchPatientSubWindow extends Window {
    private final PatientDao repo;
    private final Grid grid;
    private final TextField filter;
    private final Button addNewBtn;
    public SearchPatientSubWindow(PatientDao patientDao) {
        super("Subs on Sale"); // Set window caption
        center();
        setModal(true);

        grid = new Grid();
        addNewBtn = new Button();
        filter = new TextField();
        this.repo = patientDao;
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        VerticalLayout mainLayout = new VerticalLayout(actions, grid);
        setContent(mainLayout);

        // Configure layouts and components
        actions.setSpacing(true);
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        grid.setHeight(300, Unit.PIXELS);
        grid.setWidth(80, Unit.PERCENTAGE);
        grid.setColumns("id", "nazwisko", "imie");

        filter.setInputPrompt("Filter by email");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        filter.addTextChangeListener(e -> listCustomers(e.getText()));


    }

    private void listCustomers(String text) {

        if (StringUtils.isEmpty(text)) {
            grid.setContainerDataSource(
                    new BeanItemContainer(Patient.class, repo.findAll()));
        } else {
            grid.setContainerDataSource(new BeanItemContainer(Patient.class,
                    repo.findByNazwiskoStartsWithIgnoreCase(text)));
        }
    }
}

