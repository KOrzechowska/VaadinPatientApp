package eu.telm.view;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.data.validator.NullValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import eu.telm.controller.PatientController;
import eu.telm.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.sql.Date;

@SpringView(name = DefaultView.VIEW_NAME)
public class DefaultView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "";
    private PatientDao patientDao;
    private OperacjeDao operacjeDao;
    private BadaniaDao badaniaDao;
    private Button searchPatientButton;
    private Button editPatientButton;
    private UI ui;
    private SearchPatientSubWindow subWindow;
    private Patient patient;
    private PatientController patientController;
    private TextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12;
    private Grid tabelaBadan, tabelaZabiegow;

    @Autowired
    public DefaultView(PatientDao patientDao, OperacjeDao operacjeDao, BadaniaDao badaniaDao, UI ui){
        this.patientDao = patientDao;
        this.operacjeDao = operacjeDao;
        this.badaniaDao = badaniaDao;
        this.ui = ui;
        this.searchPatientButton = new Button("Szukaj", FontAwesome.SEARCH);
        this.editPatientButton = new Button("Edytuj", FontAwesome.EDIT);
        patient = new Patient();
        subWindow = new SearchPatientSubWindow(patientDao);
         patientController = new PatientController(subWindow,patient, this );
    }
    @PostConstruct
    void init() {
        VerticalLayout form = new VerticalLayout();
        //CssLayout cssLayout = new CssLayout();
        form.setSpacing(true);
        form.setMargin(true);
        Panel patientDataPanel = new Panel("Dane Pacjenta");
        patientDataPanel.setSizeFull();
        form.addComponent(patientDataPanel);
        VerticalLayout patientData = new VerticalLayout();
        patientData.setMargin(true);
        HorizontalLayout row1 = new HorizontalLayout();
         tf1 = new TextField("Imię");
        tf1.setEnabled(false);

        row1.addComponent(tf1);
        row1.setSpacing(true);

         tf2 = new TextField("Nazwisko");
        tf2.setEnabled(false);

        row1.addComponent(tf2);
        row1.setSizeFull();
        HorizontalLayout row2 = new HorizontalLayout();
         tf3 = new TextField("Pesel");
        tf3.setEnabled(false);
        row2.addComponent(tf3);

         tf4 = new TextField("Data ur");
        tf4.setEnabled(false);
        row2.addComponent(tf4);
        tf5 = new TextField("Płeć");
        tf5.setEnabled(false);
        row2.addComponent(tf5);
        row2.setSpacing(true);
        row2.setWidth("100%");
        HorizontalLayout row3 = new HorizontalLayout();

        tf6 = new TextField("Ulica");
        tf6.setEnabled(false);
        row3.addComponent(tf6);

        tf7 = new TextField("Miasto");
        tf7.setEnabled(false);
        row3.addComponent(tf7);

        tf8 = new TextField("Nr domu");
        tf8.setEnabled(false);
        row3.addComponent(tf8);
        row3.setSpacing(true);
        row3.setSizeFull();

        HorizontalLayout row4 = new HorizontalLayout();
        tf9 = new TextField("Kod pocztowy");
        tf9.setEnabled(false);
        row4.addComponent(tf9);

        tf10 = new TextField("Nr tel");
        tf10.setEnabled(false);
        row4.addComponent(tf10);

        tf11 = new TextField("E-mail");
        tf7.setEnabled(false);
        row4.addComponent(tf11);
        row4.setSpacing(true);
        row4.setSizeFull();

        HorizontalLayout row5 = new HorizontalLayout();
        tf12 = new TextField("Czy ubezp");
        tf12.setEnabled(false);
        row5.addComponent(tf12);
        row5.setSpacing(true);

        patientData.addComponent(row1);
        patientData.addComponent(row2);
        patientData.addComponent(row3);
        patientData.addComponent(row4);
        patientData.addComponent(row5);

        HorizontalLayout row6 = new HorizontalLayout();
        row6.setSpacing(true);
        row6.addComponent(editPatientButton);
        row6.addComponent(searchPatientButton);
        row6.setSizeFull();
        row6.setComponentAlignment(editPatientButton, Alignment.MIDDLE_RIGHT);
        row6.setComponentAlignment(searchPatientButton, Alignment.MIDDLE_RIGHT);
        patientData.addComponent(row6);

        patientDataPanel.setContent(patientData);

        /*TextField tf3 = new TextField("Postal code");
        tf3.setIcon(FontAwesome.ENVELOPE);
        tf3.addValidator(new IntegerRangeValidator("Doh!", 1, 99999));

        form.addComponent(tf3);*/
        //form.addComponent(cssLayout);
        addComponent(form);
        searchPatientButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                ui.addWindow(subWindow);

                subWindow.setClickController(patientController);


            }
        });

        tabelaBadan = new Grid();
        tabelaBadan.setColumns("nazwa", "data", "wynik", "uwagi");
        tabelaBadan.setSizeFull();
        tabelaBadan.setHeight(300, Unit.PIXELS);
        //VerticalLayout mainLayout = new VerticalLayout(form, tabelaBadan);
        form.addComponent(tabelaBadan);

        tabelaZabiegow = new Grid("Zabiegi");
        tabelaZabiegow.setColumns("nazwa","data", "wynik", "uwagi");
        tabelaZabiegow.setSizeFull();
        tabelaZabiegow.setHeight(300, Unit.PIXELS);
        form.addComponent(tabelaZabiegow);
       /// mainLayout.setMargin(true);
        //mainLayout.setSpacing(true);



    }

    public TextField getTextFieldImie(){
        return tf1;
    }
    public TextField getTextFieldNazwisko(){
        return tf2;
    }
    public TextField getTextFieldPesel(){return tf3;}
    public TextField getTextFieldDataUr(){return tf4;}
    public TextField getTextFieldPlec(){return tf5;}
    public TextField getTextFieldUlica(){return tf6;}
    public TextField getTextFieldMiasto(){return tf7;}
    public TextField getTextFieldNrDomu(){return tf8;}
    public TextField getTextFieldKodPocztowy(){return tf9;}
    public TextField getTextFieldNrTel(){return tf10;}
    public TextField getTextFieldEmail(){return tf11;}
    public TextField getTextFieldCzyUbezp(){return tf12;}
    public Grid getTabelaBadan(){return tabelaBadan;}

    public BadaniaDao getBadaniaDao(){return badaniaDao;}
    public OperacjeDao getOperacjeDao(){return operacjeDao;}

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}