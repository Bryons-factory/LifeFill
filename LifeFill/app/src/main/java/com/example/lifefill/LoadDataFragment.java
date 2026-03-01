package com.example.lifefill;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class LoadDataFragment extends Fragment {

    private DataViewModel viewModel;
    private Button btnFetch;
    private ProgressBar progressBar;
    private TextView statusText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_load_data, container, false);
        
        viewModel = new ViewModelProvider(requireActivity()).get(DataViewModel.class);
        
        btnFetch = view.findViewById(R.id.btn_fetch_data);
        progressBar = view.findViewById(R.id.progress_bar);
        statusText = view.findViewById(R.id.status_text);
        
        btnFetch.setOnClickListener(v -> fetchData());
        
        return view;
    }

    private void fetchData() {
        btnFetch.setEnabled(false);
        progressBar.setVisibility(View.VISIBLE);
        statusText.setText("Fetching data from API...");
        
        // Simulate API call delay
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            viewModel.loadMockData();
            progressBar.setVisibility(View.GONE);
            statusText.setText("Data loaded successfully!");
            btnFetch.setEnabled(true);
        }, 2000);
    }
}