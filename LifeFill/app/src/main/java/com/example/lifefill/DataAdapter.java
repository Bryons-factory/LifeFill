package com.example.lifefill;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lifefill.core.model.Allergy;
import com.example.lifefill.core.model.Insurance;
import com.example.lifefill.core.model.Patient;
import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_PATIENT = 1;
    private static final int TYPE_ALLERGY = 2;
    private static final int TYPE_INSURANCE = 3;

    private List<Object> items = new ArrayList<>();

    public void setData(List<Patient> patients, List<Allergy> allergies, List<Insurance> insurance) {
        items.clear();
        if (patients != null && !patients.isEmpty()) {
            items.add("Patients");
            items.addAll(patients);
        }
        if (allergies != null && !allergies.isEmpty()) {
            items.add("Allergies");
            items.addAll(allergies);
        }
        if (insurance != null && !insurance.isEmpty()) {
            items.add("Insurance");
            items.addAll(insurance);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        Object item = items.get(position);
        if (item instanceof String) return TYPE_HEADER;
        if (item instanceof Patient) return TYPE_PATIENT;
        if (item instanceof Allergy) return TYPE_ALLERGY;
        if (item instanceof Insurance) return TYPE_INSURANCE;
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == TYPE_HEADER) {
            return new HeaderViewHolder(inflater.inflate(R.layout.item_header, parent, false));
        } else if (viewType == TYPE_PATIENT) {
            return new PatientViewHolder(inflater.inflate(R.layout.item_patient, parent, false));
        }
        return new ItemViewHolder(inflater.inflate(R.layout.item_data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object item = items.get(position);
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).textHeader.setText((String) item);
        } else if (holder instanceof PatientViewHolder) {
            PatientViewHolder pHolder = (PatientViewHolder) holder;
            Patient p = (Patient) item;
            pHolder.textName.setText(p.getFirstName() + " " + p.getLastName());
            pHolder.textMrn.setText(p.getMrn());
            pHolder.textDob.setText(p.getDateOfBirth());
            pHolder.textEmail.setText(p.getEmail());
            pHolder.textPhone.setText(p.getPhone());
        } else if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemHolder = (ItemViewHolder) holder;
            if (item instanceof Allergy) {
                Allergy a = (Allergy) item;
                itemHolder.textTitle.setText(a.getSubstance() + " (" + a.getPatientName() + ")");
                itemHolder.textSubtitle.setText("Reaction: " + a.getReaction());
            } else if (item instanceof Insurance) {
                Insurance i = (Insurance) item;
                itemHolder.textTitle.setText(i.getPayerName());
                itemHolder.textSubtitle.setText("ID: " + i.getMemberId());
            }
        }
    }

    @Override
    public int getItemCount() { return items.size(); }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView textHeader;
        HeaderViewHolder(View itemView) { super(itemView); textHeader = itemView.findViewById(R.id.text_header); }
    }

    static class PatientViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textMrn, textDob, textEmail, textPhone;
        PatientViewHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.text_patient_name);
            textMrn = itemView.findViewById(R.id.text_patient_mrn);
            textDob = itemView.findViewById(R.id.text_patient_dob);
            textEmail = itemView.findViewById(R.id.text_patient_email);
            textPhone = itemView.findViewById(R.id.text_patient_phone);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle, textSubtitle;
        ItemViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_title);
            textSubtitle = itemView.findViewById(R.id.text_subtitle);
        }
    }
}