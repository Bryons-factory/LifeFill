package com.example.myapplication2222;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

public class UpdatePersonalFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_personal, container, false);

        Spinner phoneNumberTypeSpinner = view.findViewById(R.id.phone_number_type);
        ArrayAdapter<CharSequence> phoneAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.phone_number_types, android.R.layout.simple_spinner_item);
        phoneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        phoneNumberTypeSpinner.setAdapter(phoneAdapter);

        Spinner stateSpinner = view.findViewById(R.id.state_spinner);
        ArrayAdapter<CharSequence> stateAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.states_array, android.R.layout.simple_spinner_item);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(stateAdapter);

        // Pre-load the data
        TextInputEditText firstName = view.findViewById(R.id.first_name);
        firstName.setText(R.string.sample_first_name);

        TextInputEditText middleName = view.findViewById(R.id.middle_name);
        middleName.setText(R.string.sample_middle_name);

        TextInputEditText lastName = view.findViewById(R.id.last_name);
        lastName.setText(R.string.sample_last_name);

        TextInputEditText dob = view.findViewById(R.id.date_of_birth);
        dob.setText(R.string.sample_dob);

        TextInputEditText ssn = view.findViewById(R.id.social_security_number);
        ssn.setText(R.string.sample_ssn);

        TextInputEditText phoneNumber = view.findViewById(R.id.phone_number);
        phoneNumber.setText(R.string.sample_phone);

        // Set spinner selections
        String[] phoneTypes = getResources().getStringArray(R.array.phone_number_types);
        for (int i = 0; i < phoneTypes.length; i++) {
            if (phoneTypes[i].equals(getString(R.string.sample_phone_type))) {
                phoneNumberTypeSpinner.setSelection(i);
                break;
            }
        }

        TextInputEditText email = view.findViewById(R.id.email_address);
        email.setText(R.string.sample_email);

        TextInputEditText address = view.findViewById(R.id.address);
        address.setText(R.string.sample_address);

        TextInputEditText city = view.findViewById(R.id.city);
        city.setText(R.string.sample_city);

        String[] states = getResources().getStringArray(R.array.states_array);
        for (int i = 0; i < states.length; i++) {
            if (states[i].equals(getString(R.string.sample_state))) {
                stateSpinner.setSelection(i);
                break;
            }
        }

        TextInputEditText zip = view.findViewById(R.id.zip);
        zip.setText(R.string.sample_zip);

        Button submitButton = view.findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle form submission here
                Toast.makeText(getContext(), "Form updated", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
