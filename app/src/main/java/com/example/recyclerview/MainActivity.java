package com.example.recyclerview;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;

 ArrayList<String> lists=new  ArrayList<>();
    BottomNavigationView bottomNavigationView;
    MenuItem menuItem ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    for(int i=0; i<20 ;i++){
        lists.add("elemnt"+i);
    }


        recyclerView=findViewById(R.id.r);
        Adpater adapter=new Adpater(getApplicationContext(),lists);
      //  Adapter ad=  new Adpater(getApplicationContext(),lists);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lists.add("element"+lists.size());
                adapter.notifyDataSetChanged();
                adapter.notifyItemRangeChanged(0, lists.size());
                recyclerView.smoothScrollToPosition(lists.size());

            }

        });
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.point,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, " home selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:
                Toast.makeText(this, " uplode selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item3:
                Toast.makeText(this, " delete selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item4:
                Toast.makeText(this, " add selected", Toast.LENGTH_LONG).show();
                break;
            default:                return super.onOptionsItemSelected(item);



        }
        return super.onOptionsItemSelected(item);

    }
}