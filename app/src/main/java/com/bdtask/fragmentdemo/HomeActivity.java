package com.bdtask.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 *      created by AkterUzzaman
 *      3/15/2020
 */

public class HomeActivity extends AppCompatActivity {

    Button contactBtn,notesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        //change status bar color
        if (Build.VERSION.SDK_INT >= 21){
            getWindow().setStatusBarColor(ContextCompat.getColor(this ,R.color.colorPrimaryDark));

        }


        // initialize Contact Fragment as homepage
        loadFragment(new ContactFragment());


        contactBtn   = findViewById(R.id.contactBtn);
        notesBtn     = findViewById(R.id.noteBtn);


        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //load Contact Fragment
                loadFragment(new ContactFragment());

            }
        });


        notesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //load Note Fragment
                loadFragment(new NoteFragment());

            }
        });


    }

    public void loadFragment(Fragment fragment){

        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout,fragment)
                    .addToBackStack(null)
                    .commit();


        }

    }
}
