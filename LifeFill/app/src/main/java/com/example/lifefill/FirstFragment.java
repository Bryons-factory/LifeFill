package com.example.lifefill;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lifefill.data.LifeFillDataModule;
import com.example.lifefill.databinding.FragmentFirstBinding;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment {

    private static final String TAG = "FHIR_DEMO";

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(v -> fetchDemoEhrData());
    }

    private void fetchDemoEhrData() {
        String testPatientId = "87a339d0-8cae-418e-89c7-8651e6aab3c6";
        binding.textviewFirst.setText("Fetching data...");

        LifeFillDataModule.getFhirClient().getApi().getPatientMedications(testPatientId)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            String data = response.body().toString();
                            Log.d(TAG, "Success: " + data);
                            binding.textviewFirst.setText(data);
                        } else {
                            Log.e(TAG, "Failed: " + response.code());
                            binding.textviewFirst.setText("Failed to fetch data: " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                        Log.e(TAG, "Network Error: " + t.getMessage());
                        binding.textviewFirst.setText("Network Error: " + t.getMessage());
                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}