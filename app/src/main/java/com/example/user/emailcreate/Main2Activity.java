package com.example.user.emailcreate;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    String receiveto,receivesubject,receivetext;
    TextView fia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        fia=(TextView)findViewById(R.id.allemail);
        Intent intent=getIntent();
        receiveto=intent.getStringExtra("to");
        receivesubject=intent.getStringExtra("subject");
        receivetext= intent.getStringExtra("text");
        fia.setText("To \n \n"+receiveto+"\n\n\n"+"Subject\n\n"+receivesubject+"\n\n\nText\n\n"+receivetext+"\n");
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.icon)
        {
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("messAGE/RFC822");
            startActivity(intent.createChooser(intent,"Select a email client"));
        }
        else if(id==android.R.id.home)
        {
            Intent intent2=new Intent(Main2Activity.this,MainActivity.class);
            startActivity(intent2);
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu2,menu);
        return  true;
    }
}
