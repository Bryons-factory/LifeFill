package com.example.myapplication2222;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewContactsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_contact, container, false);

        TextView firstNameView = view.findViewById(R.id.first_name_view);
        firstNameView.setText(R.string.sample_contact_first_name);

        TextView lastNameView = view.findViewById(R.id.last_name_view);
        lastNameView.setText(R.string.sample_contact_last_name);

        TextView relationshipView = view.findViewById(R.id.relationship_view);
        relationshipView.setText(R.string.sample_contact_relationship);

        TextView phoneView = view.findViewById(R.id.phone_number_view);
        phoneView.setText(R.string.sample_contact_phone);

        TextView phoneTypeView = view.findViewById(R.id.phone_number_type_view);
        phoneTypeView.setText(R.string.sample_contact_phone_type);

        TextView emailView = view.findViewById(R.id.email_address_view);
        emailView.setText(R.string.sample_contact_email);

        return view;
    }
}
