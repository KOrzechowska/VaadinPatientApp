package eu.telm.controller;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import eu.telm.model.Badanie;
import eu.telm.model.Operacja;
import eu.telm.model.Patient;
import eu.telm.view.DefaultView;
import eu.telm.view.SearchPatientSubWindow;

import java.util.List;

/**
 * Created by kasia on 13.11.16.
 */
public class PatientController implements Button.ClickListener{
    private SearchPatientSubWindow subWindow;
    private DefaultView defaultView;
    private Patient model;

    public PatientController(SearchPatientSubWindow subWindow, Patient model , DefaultView defaultView){
        this. subWindow = subWindow;
        this.defaultView = defaultView;
        this. model = model;
    }

    public void updatePatient(){
        model.setId(subWindow.getSelectedPatient().getId());
        System.out.println(model.getId());
        model.setImie(subWindow.getSelectedPatient().getImie());
        model.setNazwisko(subWindow.getSelectedPatient().getNazwisko());
        model.setPesel(subWindow.getSelectedPatient().getPesel());
        model.setPlec(subWindow.getSelectedPatient().getPlec());
        model.setEmail(subWindow.getSelectedPatient().getEmail());
        model.setNrTel(subWindow.getSelectedPatient().getNrTel());
        model.setDataUr(subWindow.getSelectedPatient().getDataUr());
        model.setUlica(subWindow.getSelectedPatient().getUlica());
        model.setMiasto(subWindow.getSelectedPatient().getMiasto());
        model.setNrDomu(subWindow.getSelectedPatient().getNrDomu());
        model.setKodPocztowy(subWindow.getSelectedPatient().getKodPocztowy());
        //System.out.println(model.getImie());
    }


    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {
        Object source = clickEvent.getSource();

        if(source == subWindow.getGetSelectedPatientButton()){
            updatePatient();
            subWindow.close();
            defaultView.getTextFieldImie().setValue(model.getImie());
            defaultView.getTextFieldNazwisko().setValue(model.getNazwisko());
            defaultView.getTextFieldPesel().setValue(model.getPesel());
            defaultView.getTextFieldPlec().setValue(model.getPlec());
            defaultView.getTextFieldUlica().setValue(model.getUlica());
            defaultView.getTextFieldMiasto().setValue(model.getMiasto());
            defaultView.getTextFieldDataUr().setValue(model.getDataUr().toString());
            defaultView.getTextFieldKodPocztowy().setValue(model.getKodPocztowy());
            //System.out.println(model.getId());
            List<Badanie> badanieList= defaultView.getBadaniaDao().findByPatient_Id( model.getId());
            defaultView.getTabelaBadan().setContainerDataSource(
                    new BeanItemContainer(Badanie.class, defaultView.getBadaniaDao().findByPatient_Id( model.getId())));

        }
    }
}
