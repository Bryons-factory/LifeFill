package com.example.myapplication2222;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewPersonalFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_personal, container, false);

        // You can fetch and populate the data from your data source here.
        // For now, I'm just populating with some sample data.

        TextView firstNameView = view.findViewById(R.id.first_name_view);
        firstNameView.setText(R.string.sample_first_name);

        TextView middleNameView = view.findViewById(R.id.middle_name_view);
        middleNameView.setText(R.string.sample_middle_name);

        TextView lastNameView = view.findViewById(R.id.last_name_view);
        lastNameView.setText(R.string.sample_last_name);

        TextView dobView = view.findViewById(R.id.date_of_birth_view);
        dobView.setText(R.string.sample_dob);

        TextView ssnView = view.findViewById(R.id.social_security_number_view);
        ssnView.setText(R.string.sample_ssn);

        TextView phoneView = view.findViewById(R.id.phone_number_view);
        phoneView.setText(R.string.sample_phone);

        TextView phoneTypeView = view.findViewById(R.id.phone_number_type_view);
        phoneTypeView.setText(R.string.sample_phone_type);

        TextView emailView = view.findViewById(R.id.email_address_view);
        emailView.setText(R.string.sample_email);

        TextView addressView = view.findViewById(R.id.address_view);
        addressView.setText(R.string.sample_address);

        TextView cityView = view.findViewById(R.id.city_view);
        cityView.setText(R.string.sample_city);

        TextView stateView = view.findViewById(R.id.state_view);
        stateView.setText(R.string.sample_state);

        TextView zipView = view.findViewById(R.id.zip_view);
        zipView.setText(R.string.sample_zip);

        return view;
    }
}
