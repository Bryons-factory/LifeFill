package com.example.myapplication2222;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ContactsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        view.findViewById(R.id.add_contacts_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, new AddContactFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        view.findViewById(R.id.view_contacts_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, new ViewContactsFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        view.findViewById(R.id.delete_contacts_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, new DeleteContactFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        view.findViewById(R.id.update_contacts_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, new UpdateContactFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        view.findViewById(R.id.import_contacts_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Import clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}