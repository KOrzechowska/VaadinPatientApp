package eu.telm.view;


import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import eu.telm.controller.PatientController;
import eu.telm.model.Patient;
import eu.telm.model.PatientDao;
import org.springframework.util.StringUtils;

import java.awt.event.ActionListener;

/**
 * Created by kasia on 13.11.16.
 */
public class SearchPatientSubWindow extends Window {
    private final PatientDao repo;
    private final Grid grid;
    private final TextField filter;
    private final Button getSelectedPatientButton;
    private Patient patient;

    public SearchPatientSubWindow(PatientDao patientDao) {
        super("Subs on Sale"); // Set window caption
        center();
        setModal(true);


        grid = new Grid();
        getSelectedPatientButton = new Button("Wybierz", FontAwesome.HAND_GRAB_O);
        getSelectedPatientButton.setVisible(false);
        filter = new TextField();
        this.repo = patientDao;
        HorizontalLayout actions = new HorizontalLayout(filter, getSelectedPatientButton);
        VerticalLayout mainLayout = new VerticalLayout(actions, grid);
        setContent(mainLayout);

        // Configure layouts and components
        actions.setSpacing(true);
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        grid.setHeight(300, Unit.PIXELS);
        grid.setWidth(100,Unit.PERCENTAGE);
        grid.setColumns("id", "nazwisko", "imie", "pesel", "email");

        filter.setInputPrompt("Filter by email");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        filter.addTextChangeListener(e -> listCustomers(e.getText()));

        // Connect selected Customer to editor or hide if none is selected
        grid.addSelectionListener(e -> {
            if (e.getSelected().isEmpty()) {
                getSelectedPatientButton.setVisible(false);
            } else {
                getSelectedPatientButton.setVisible(true);
            }
        });

        /*getSelectedPatientButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                //patient = (Patient) grid.getSelectedRow();
                //System.out.println(patient.getImie());

                close();
            }
        });*/


    }

    public void setClickController(Button.ClickListener ac){
        this.getSelectedPatientButton.addClickListener(ac);
    }

    public Button getGetSelectedPatientButton(){
        return this.getSelectedPatientButton;
    }
    public Patient getSelectedPatient(){
        return (Patient) grid.getSelectedRow();
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

