package eu.telm.view;

import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.data.validator.NullValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import eu.telm.model.Patient;
import eu.telm.model.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringView(name = DefaultView.VIEW_NAME)
public class DefaultView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "";
    private PatientDao patientDao;
    private Button searchPatientButton;
    private UI ui;

    @Autowired
    public DefaultView(PatientDao patientDao, UI ui){
        this.patientDao = patientDao;
        this.ui = ui;
        this.searchPatientButton = new Button("New user", FontAwesome.SEARCH);
    }
    @PostConstruct
    void init() {
        VerticalLayout form = new VerticalLayout();
        CssLayout cssLayout = new CssLayout();

        TextField tf1 = new TextField("Imię");
        tf1.setEnabled(false);
        cssLayout.addComponent(tf1);

        TextField tf2 = new TextField("Nazwisko");
        tf1.setEnabled(false);
        cssLayout.addComponent(tf2);

        TextField tf3 = new TextField("Miasto");
        tf1.setEnabled(false);
        cssLayout.addComponent(tf3);

        TextField tf4 = new TextField("Ulica");
        tf1.setEnabled(false);
        cssLayout.addComponent(tf4);
        /*TextField tf3 = new TextField("Postal code");
        tf3.setIcon(FontAwesome.ENVELOPE);
        tf3.addValidator(new IntegerRangeValidator("Doh!", 1, 99999));

        form.addComponent(tf3);*/
        form.addComponent(cssLayout);
        addComponent(form);
        form.addComponent(searchPatientButton);
        searchPatientButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                /*Window subWindow = new Window("Sub-window");
                VerticalLayout subContent = new VerticalLayout();
                subContent.setMargin(true);
                subWindow.setContent(subContent);

                // Put some components in it
                subContent.addComponent(new Label("Meatball sub"));
                subContent.addComponent(new Button("Awlright"));

                // Center it in the browser window
                subWindow.center();
                subWindow.setModal(true);
                ui.addWindow(subWindow);*/
                // Open it in the UI
                //addWindow(subWindow);
                Patient patient = new Patient();
                patient.setImie("Anna");
                patient.setNazwisko("Kowal");
                patientDao.save(patient);

                SearchPatientSubWindow subWindow = new SearchPatientSubWindow(patientDao);
                ui.addWindow(subWindow);
            }
        });


    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}