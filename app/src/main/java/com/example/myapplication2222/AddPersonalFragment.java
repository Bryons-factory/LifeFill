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

public class AddPersonalFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_personal, container, false);

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

        Button submitButton = view.findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle form submission here
                Toast.makeText(getContext(), "Form submitted", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
