package com.example.lifefill;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.lifefill.core.model.Allergy;
import com.example.lifefill.core.model.Patient;
import java.util.List;

public class AutofillDemoFragment extends Fragment {

    private DataViewModel viewModel;
    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_autofill_demo, container, false);
        
        viewModel = new ViewModelProvider(requireActivity()).get(DataViewModel.class);
        webView = view.findViewById(R.id.web_view);
        
        setupWebView();
        
        return view;
    }

    private void setupWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectData();
            }
        });
        webView.loadUrl("file:///android_asset/autofill_demo.html");
    }

    private void injectData() {
        List<Patient> patients = viewModel.getPatients().getValue();
        if (patients != null && !patients.isEmpty()) {
            Patient p = patients.get(0);
            String js = String.format("javascript:autofill({" +
                    "firstName: '%s'," +
                    "lastName: '%s'," +
                    "dob: '%s'," +
                    "mrn: '%s'," +
                    "insurance: 'Blue Cross'," +
                    "allergies: 'Peanuts'" +
                    "})", p.getFirstName(), p.getLastName(), p.getDateOfBirth(), p.getMrn());
            webView.evaluateJavascript(js, null);
        }
    }
}