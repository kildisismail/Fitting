package com.example.fitting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NavUtils;

public class Endeks extends MainActivity {

    private EditText editText;
    private TextView txtBoyu,kilo_tv,kiloSonuc,durumSonuc;
    private SeekBar seekBar;
    private RadioGroup radioGroup;
    private boolean erkekmi = true;
    private double boy=1.75;
    private int kilo=75;
    private RadioGroup.OnCheckedChangeListener radioGroupOlayIsleyicisi = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            if (checkedId==R.id.radioBay)
                erkekmi=true;
            else if (checkedId==R.id.radioBayan)
                erkekmi=false;
            guncelle();
        }
    };
    private SeekBar.OnSeekBarChangeListener seekBarOlayIsleyicisi = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            kilo=45+progress;
            guncelle();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private TextWatcher editTextOlayIsleyicisi = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try {
                boy=Double.parseDouble(s.toString())/100.0;

            }catch (NumberFormatException e){

                boy=0.0;
            }
            guncelle();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endeks);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editText =(EditText) findViewById(R.id.editText);
        txtBoyu =(TextView) findViewById(R.id.txtBoyu);
        kilo_tv =(TextView) findViewById(R.id.kilo_tv);
        kiloSonuc =(TextView) findViewById(R.id.kiloSonuc);
        durumSonuc =(TextView) findViewById(R.id.durumSonuc);
        radioGroup =(RadioGroup) findViewById(R.id.radioGrup);
        seekBar =(SeekBar) findViewById(R.id.seekBar);

        editText.addTextChangedListener(editTextOlayIsleyicisi);
        seekBar.setOnSeekBarChangeListener(seekBarOlayIsleyicisi);
        radioGroup.setOnCheckedChangeListener(radioGroupOlayIsleyicisi);

        guncelle();

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

    private void guncelle() {



        kilo_tv.setText(String.valueOf(kilo)+"kg");
        txtBoyu.setText(String.valueOf(boy)+" m");
        double vki=kilo/(boy*boy);

        int idealKiloBay= (int) (50+2.3*(boy*100*0.4-60));
        int idealKiloBayan= (int) (45.5+2.3*(boy*100*0.4-60));

        if(erkekmi){
            //erkek için
            kiloSonuc.setText(String.valueOf(idealKiloBay));
            if(17.5<vki&& vki<=20.7){
                durumSonuc.setBackgroundResource(R.color.zayif);
                durumSonuc.setText(R.string.zayif);
            }
            else if(20.7<vki&& vki<=26.4){
                durumSonuc.setBackgroundResource(R.color.ideal);
                durumSonuc.setText("Normal Kilodasınız");
            }
            else if(26.4<vki&& vki<=27.8){
                durumSonuc.setBackgroundResource(R.color.idealden_fazla);
                durumSonuc.setText("Normalden Fazla!");
            }
            else if(27.8<vki&& vki<=31.1){
                durumSonuc.setBackgroundResource(R.color.kilolu);
                durumSonuc.setText("Kilolusunuz!!");
            }
            else if(31.1<vki&& vki<=34.9){
                durumSonuc.setBackgroundResource(R.color.obez);
                durumSonuc.setText("Obezsiniz!!!");
            }
            else{
                durumSonuc.setBackgroundResource(R.color.doktora);
                durumSonuc.setText("Doktora Gidiniz!!!!");
            }
        }else {
            //bayan için
            kiloSonuc.setText(String.valueOf(idealKiloBayan));
            if(14.5<vki&& vki<=19.1){
                durumSonuc.setBackgroundResource(R.color.zayif);
                durumSonuc.setText(R.string.zayif);
            }
            else if(19.1<vki&& vki<=25.8){
                durumSonuc.setBackgroundResource(R.color.ideal);
                durumSonuc.setText("Normal Kilodasınız");
            }
            else if(25.8<vki&& vki<=27.3){
                durumSonuc.setBackgroundResource(R.color.idealden_fazla);
                durumSonuc.setText("Normalden Fazla!");
            }
            else if(27.3<vki&& vki<=32.3){
                durumSonuc.setBackgroundResource(R.color.kilolu);
                durumSonuc.setText("Kilolusunuz!!");
            }
            else if(32.3<vki&& vki<=34.9){
                durumSonuc.setBackgroundResource(R.color.obez);
                durumSonuc.setText("Obezsiniz!!!");
            }
            else{
                durumSonuc.setBackgroundResource(R.color.doktora);
                durumSonuc.setText("Doktora Gidiniz!!!!");
            }
        }
    }
}
