package com.example.user.emailcreate;

import android.content.Intent;
import android.drm.DrmStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        about=(TextView)findViewById(R.id.aboutme);
        about.setText("This app is developed by G R Talukder \n\n");
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {


        int id=item.getItemId();

        if(id==android.R.id.home)
        {
            Intent intent=new Intent(Main3Activity.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
