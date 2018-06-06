package com.example.user.emailcreate;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText to,subject,text;
    Button submit;
    String tostring,subjectstring,textstring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        to=(EditText)findViewById(R.id.toedit);
        subject=(EditText)findViewById(R.id.editsubject);
        text=(EditText)findViewById(R.id.edittext);
        submit=(Button)findViewById(R.id.button);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tostring=to.getText().toString();

                subjectstring=subject.getText().toString();
                textstring=text.getText().toString();
                if(tostring.equals("") || subjectstring.equals("")|| textstring.equals("") )
                {
                    Toast.makeText(MainActivity.this, "Something wrong. Fill all the information", Toast.LENGTH_SHORT).show();
                    to.setText("");
                    subject.setText("");
                    text.setText("");
                }
                else {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("to", tostring);
                    intent.putExtra("subject", subjectstring);
                    intent.putExtra("text", textstring);
                    startActivity(intent);
                }
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.about)
        {
            Intent intent2=new Intent(MainActivity.this,Main3Activity.class);
            startActivity(intent2);
        }
        else if(id==android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override

    public void onBackPressed()
    {
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return  true;
    }
}
