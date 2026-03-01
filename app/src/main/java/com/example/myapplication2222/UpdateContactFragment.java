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

public class UpdateContactFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_contact, container, false);

        Spinner relationshipSpinner = view.findViewById(R.id.relationship_spinner);
        ArrayAdapter<CharSequence> relationshipAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.relationship_types, android.R.layout.simple_spinner_item);
        relationshipAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        relationshipSpinner.setAdapter(relationshipAdapter);

        Spinner phoneNumberTypeSpinner = view.findViewById(R.id.phone_number_type);
        ArrayAdapter<CharSequence> phoneAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.phone_number_types, android.R.layout.simple_spinner_item);
        phoneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        phoneNumberTypeSpinner.setAdapter(phoneAdapter);

        // Pre-load the data
        TextInputEditText firstName = view.findViewById(R.id.first_name);
        firstName.setText(R.string.sample_contact_first_name);

        TextInputEditText lastName = view.findViewById(R.id.last_name);
        lastName.setText(R.string.sample_contact_last_name);

        String[] relationships = getResources().getStringArray(R.array.relationship_types);
        for (int i = 0; i < relationships.length; i++) {
            if (relationships[i].equals(getString(R.string.sample_contact_relationship))) {
                relationshipSpinner.setSelection(i);
                break;
            }
        }

        TextInputEditText phoneNumber = view.findViewById(R.id.phone_number);
        phoneNumber.setText(R.string.sample_contact_phone);

        String[] phoneTypes = getResources().getStringArray(R.array.phone_number_types);
        for (int i = 0; i < phoneTypes.length; i++) {
            if (phoneTypes[i].equals(getString(R.string.sample_contact_phone_type))) {
                phoneNumberTypeSpinner.setSelection(i);
                break;
            }
        }

        TextInputEditText email = view.findViewById(R.id.email_address);
        email.setText(R.string.sample_contact_email);

        Button submitButton = view.findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle form submission here
                Toast.makeText(getContext(), "Contact updated", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
