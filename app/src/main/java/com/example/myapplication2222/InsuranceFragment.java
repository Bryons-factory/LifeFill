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

public class InsuranceFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insurance, container, false);

        view.findViewById(R.id.add_insurance_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, new AddInsuranceFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        view.findViewById(R.id.view_insurance_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, new ViewInsuranceFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        view.findViewById(R.id.delete_insurance_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, new DeleteInsuranceFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        view.findViewById(R.id.update_insurance_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, new UpdateInsuranceFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        view.findViewById(R.id.import_insurance_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Import clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}