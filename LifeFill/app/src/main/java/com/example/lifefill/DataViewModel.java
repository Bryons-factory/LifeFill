package com.example.lifefill;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.lifefill.core.model.Allergy;
import com.example.lifefill.core.model.Insurance;
import com.example.lifefill.core.model.Patient;
import java.util.ArrayList;
import java.util.List;

public class DataViewModel extends ViewModel {
    private final MutableLiveData<List<Patient>> patients = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<List<Allergy>> allergies = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<List<Insurance>> insuranceList = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<Patient>> getPatients() { return patients; }
    public LiveData<List<Allergy>> getAllergies() { return allergies; }
    public LiveData<List<Insurance>> getInsuranceList() { return insuranceList; }

    public void loadMockData() {
        // Mock Patients
        List<Patient> pList = new ArrayList<>();
        pList.add(new Patient("1", "John", "Doe", "1990-01-01", "MRN123", "john@example.com", "555-0101"));
        pList.add(new Patient("2", "Jane", "Smith", "1985-05-15", "MRN456", "jane@example.com", "555-0202"));
        patients.setValue(pList);

        // Mock Allergies
        List<Allergy> aList = new ArrayList<>();
        aList.add(new Allergy("a1", "Peanuts", "Anaphylaxis", "High", "John Doe"));
        aList.add(new Allergy("a2", "Penicillin", "Hives", "Medium", "Jane Smith"));
        allergies.setValue(aList);

        // Mock Insurance
        List<Insurance> iList = new ArrayList<>();
        iList.add(new Insurance("i1", "Blue Cross", "MBR999", "GRP100"));
        iList.add(new Insurance("i2", "Aetna", "MBR888", "GRP200"));
        insuranceList.setValue(iList);
    }

    public void clearData() {
        patients.setValue(new ArrayList<>());
        allergies.setValue(new ArrayList<>());
        insuranceList.setValue(new ArrayList<>());
    }
}