package com.example.lifefill;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TestDataFragment extends Fragment {

    private DataViewModel viewModel;
    private DataAdapter adapter;
    private RecyclerView recyclerView;
    private TextView emptyView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_data, container, false);
        
        viewModel = new ViewModelProvider(requireActivity()).get(DataViewModel.class);
        
        recyclerView = view.findViewById(R.id.recycler_view_data);
        emptyView = view.findViewById(R.id.empty_view);
        
        setupRecyclerView();
        observeViewModel();
        
        return view;
    }

    private void setupRecyclerView() {
        adapter = new DataAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void observeViewModel() {
        // Observe all data types and refresh the adapter when any change
        viewModel.getPatients().observe(getViewLifecycleOwner(), patients -> updateUI());
        viewModel.getAllergies().observe(getViewLifecycleOwner(), allergies -> updateUI());
        viewModel.getInsuranceList().observe(getViewLifecycleOwner(), insurance -> updateUI());
    }

    private void updateUI() {
        boolean hasData = (viewModel.getPatients().getValue() != null && !viewModel.getPatients().getValue().isEmpty()) ||
                         (viewModel.getAllergies().getValue() != null && !viewModel.getAllergies().getValue().isEmpty()) ||
                         (viewModel.getInsuranceList().getValue() != null && !viewModel.getInsuranceList().getValue().isEmpty());

        if (!hasData) {
            recyclerView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
            adapter.setData(
                viewModel.getPatients().getValue(),
                viewModel.getAllergies().getValue(),
                viewModel.getInsuranceList().getValue()
            );
        }
    }
}