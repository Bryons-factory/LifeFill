package com.example.lifefill;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lifefill.databinding.ActivityMainBinding;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {

    public interface TemporaryFhirApi {
        @Headers("Accept: application/fhir+json")
        @GET("MedicationRequest")
        Call<JsonObject> getMedications(@Query("patient") String patientId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // --- EMERGENCY LOGS ---
        Log.e("FHIR_TEST", "STARTING TEST NOW");
        Toast.makeText(this, "!!! API TEST START !!!", Toast.LENGTH_LONG).show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://r4.smarthealthit.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TemporaryFhirApi api = retrofit.create(TemporaryFhirApi.class);
        api.getMedications("87a339d0-8cae-418e-89c7-8651e6aab3c6").enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.e("FHIR_TEST", "RESPONSE RECEIVED: " + (response.isSuccessful() ? "SUCCESS" : "FAIL " + response.code()));
                if (response.body() != null) {
                    Log.e("FHIR_TEST", "DATA: " + response.body().toString().substring(0, Math.min(100, response.body().toString().length())));
                }
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("FHIR_TEST", "FAILURE: " + t.getMessage());
            }
        });
        // --- END EMERGENCY LOGS ---

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
