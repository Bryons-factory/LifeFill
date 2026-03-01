package com.example.lifefill;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private PersonalFragment personalFragment;
    private HomeFragment homeFragment;
    private MedicalFragment medicalFragment;
    private InsuranceFragment insuranceFragment;
    private ContactsFragment contactsFragment;

    private final FragmentManager fm = getSupportFragmentManager();
    private Fragment active;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        BottomNavigationView navView = findViewById(R.id.bottom_navigation);
        navView.setOnItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            // First time initialization
            personalFragment = new PersonalFragment();
            homeFragment = new HomeFragment();
            medicalFragment = new MedicalFragment();
            insuranceFragment = new InsuranceFragment();
            contactsFragment = new ContactsFragment();
            active = homeFragment;

            FragmentTransaction tr = fm.beginTransaction();
            tr.add(R.id.nav_host_fragment, insuranceFragment, "3").hide(insuranceFragment);
            tr.add(R.id.nav_host_fragment, medicalFragment, "2").hide(medicalFragment);
            tr.add(R.id.nav_host_fragment, homeFragment, "1"); // Home is visible by default
            tr.add(R.id.nav_host_fragment, personalFragment, "4").hide(personalFragment);
            tr.add(R.id.nav_host_fragment, contactsFragment, "5").hide(contactsFragment);
            tr.commit();

            navView.setSelectedItemId(R.id.navigation_home);
            toolbarTitle.setText(R.string.title_home);
        } else {
            // Restore existing fragments after rotation
            insuranceFragment = (InsuranceFragment) fm.findFragmentByTag("3");
            medicalFragment = (MedicalFragment) fm.findFragmentByTag("2");
            homeFragment = (HomeFragment) fm.findFragmentByTag("1");
            personalFragment = (PersonalFragment) fm.findFragmentByTag("4");
            contactsFragment = (ContactsFragment) fm.findFragmentByTag("5");

            // Logic to determine which one was active
            active = homeFragment; // You can improve this by saving 'active' tag in outState
        }
    }

    private final NavigationBarView.OnItemSelectedListener mOnNavigationItemSelectedListener
            = new NavigationBarView.OnItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment nextFragment = null;
            int titleResId = 0;

            int itemId = item.getItemId();
            if (itemId == R.id.navigation_personal) {
                nextFragment = personalFragment;
                titleResId = R.string.title_personal;
            } else if (itemId == R.id.navigation_medical) {
                nextFragment = medicalFragment;
                titleResId = R.string.title_medical;
            } else if (itemId == R.id.navigation_home) {
                nextFragment = homeFragment;
                titleResId = R.string.title_home;
            } else if (itemId == R.id.navigation_insurance) {
                nextFragment = insuranceFragment;
                titleResId = R.string.title_insurance;
            } else if (itemId == R.id.navigation_contacts) {
                nextFragment = contactsFragment;
                titleResId = R.string.title_contacts;
            }

            if (nextFragment != null && nextFragment != active) {
                fm.beginTransaction().hide(active).show(nextFragment).commit();
                active = nextFragment;
                toolbarTitle.setText(titleResId);
                return true;
            }
            return false;
        }
    };
}