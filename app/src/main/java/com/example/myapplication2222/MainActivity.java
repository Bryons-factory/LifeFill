package com.example.myapplication2222;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private final PersonalFragment personalFragment = new PersonalFragment();
    private final HomeFragment homeFragment = new HomeFragment();
    private final MedicalFragment medicalFragment = new MedicalFragment();
    private final InsuranceFragment insuranceFragment = new InsuranceFragment();
    private final ContactsFragment contactsFragment = new ContactsFragment();
    private final FragmentManager fm = getSupportFragmentManager();
    private Fragment active = homeFragment;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        BottomNavigationView navView = findViewById(R.id.bottom_navigation);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Add all fragments and hide them initially
        fm.beginTransaction().add(R.id.nav_host_fragment, insuranceFragment, "3").hide(insuranceFragment).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, medicalFragment, "2").hide(medicalFragment).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, homeFragment, "1").hide(homeFragment).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, personalFragment, "4").hide(personalFragment).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, contactsFragment, "5").hide(contactsFragment).commit();

        // Set Home as the default selected item
        navView.setSelectedItemId(R.id.navigation_home);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // Clear back stack if any fragments were added
            if (fm.getBackStackEntryCount() > 0) {
                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
            if (item.getItemId() == R.id.navigation_personal) {
                fm.beginTransaction().hide(active).show(personalFragment).commit();
                active = personalFragment;
                toolbarTitle.setText(R.string.title_personal);
                return true;
            } else if (item.getItemId() == R.id.navigation_medical) {
                fm.beginTransaction().hide(active).show(medicalFragment).commit();
                active = medicalFragment;
                toolbarTitle.setText(R.string.title_medical);
                return true;
            } else if (item.getItemId() == R.id.navigation_home) {
                fm.beginTransaction().hide(active).show(homeFragment).commit();
                active = homeFragment;
                toolbarTitle.setText(R.string.title_home);
                return true;
            } else if (item.getItemId() == R.id.navigation_insurance) {
                fm.beginTransaction().hide(active).show(insuranceFragment).commit();
                active = insuranceFragment;
                toolbarTitle.setText(R.string.title_insurance);
                return true;
            } else if (item.getItemId() == R.id.navigation_contacts) {
                fm.beginTransaction().hide(active).show(contactsFragment).commit();
                active = contactsFragment;
                toolbarTitle.setText(R.string.title_contacts);
                return true;
            }
            return false;
        }
    };
}