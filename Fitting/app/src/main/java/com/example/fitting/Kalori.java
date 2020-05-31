package com.example.fitting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NavUtils;

public class Kalori extends  MainActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalori);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


}
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            Intent intentGeri= new Intent(getApplicationContext(),MainActivity.class);
            NavUtils.navigateUpTo(this,intentGeri);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
