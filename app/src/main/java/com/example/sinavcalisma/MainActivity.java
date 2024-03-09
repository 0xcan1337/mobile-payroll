package com.example.sinavcalisma;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText isim, cocuksayisi;
    Spinner spinner;
    DatabaseHelper dbHelper;

    Integer unvanmaas=0, tabanmaas=1000, medeniek=0, ikametucret=0;
    TextView sonuc;
    Button button;

    Integer cocukdegeri=0, yanacidil=0;
    Integer fakesonuc;
    RadioGroup radiogroup, ikamet;
    RadioButton evli, bekar, dul, kira, kendievi;
    CheckBox ingilizce, turkce, almanca;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isim=findViewById(R.id.isim);
        sonuc=findViewById(R.id.sonuc);
        spinner=findViewById(R.id.spinner);
        radiogroup=findViewById(R.id.radiogroup);
        evli=findViewById(R.id.evli);
        bekar=findViewById(R.id.bekar);
        dul=findViewById(R.id.dul);
        ikamet=findViewById(R.id.ikamet);
        kira=findViewById(R.id.kira);
        kendievi=findViewById(R.id.kendievi);
        cocuksayisi=findViewById(R.id.cocuksayisi);
        ingilizce=findViewById(R.id.ingilizce);
        turkce=findViewById(R.id.turkce);
        almanca=findViewById(R.id.almanca);
        button=findViewById(R.id.button);
        dbHelper = DatabaseHelper.getInstance(this);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("Range")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedValue = parent.getItemAtPosition(position).toString();

                if (selectedValue.equals("Hizmetli")) {

                    SQLiteDatabase db = dbHelper.getReadableDatabase();
                    Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_UNVANLAR + " WHERE ID = 1", null);


                    if (cursor.moveToFirst()) {

                        unvanmaas = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.UNVAN_MAAS));


                    }

                    cursor.close();
                    db.close();
                }


                if (selectedValue.equals("Memur")) {

                    SQLiteDatabase db = dbHelper.getReadableDatabase();
                    Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_UNVANLAR + " WHERE ID = 2", null);


                    if (cursor.moveToFirst()) {

                        unvanmaas = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.UNVAN_MAAS));


                    }

                    cursor.close();
                    db.close();
                }
                if (selectedValue.equals("Şef")) {

                    SQLiteDatabase db = dbHelper.getReadableDatabase();
                    Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_UNVANLAR + " WHERE ID = 3", null);


                    if (cursor.moveToFirst()) {

                        unvanmaas = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.UNVAN_MAAS));


                    }

                    cursor.close();
                    db.close();
                }
                if (selectedValue.equals("Müdür")) {

                    SQLiteDatabase db = dbHelper.getReadableDatabase();
                    Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_UNVANLAR + " WHERE ID = 4", null);


                    if (cursor.moveToFirst()) {

                        unvanmaas = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.UNVAN_MAAS));


                    }

                    cursor.close();
                    db.close();
                }

            }





            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("Range")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(evli.isChecked()){

                    SQLiteDatabase db = dbHelper.getReadableDatabase();
                    Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_MEDENI + " WHERE ID = 1", null);

                    if (cursor.moveToFirst()) {
                        medeniek = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.MEDENI_EK));


                    }
                    Integer cocuk= Integer.parseInt(cocuksayisi.getText().toString());
                    if (cocuk<=3){

                        cocukdegeri=cocuk*30;
                    }

                    cursor.close();
                    db.close();
                }

                if(bekar.isChecked()){
                    SQLiteDatabase db = dbHelper.getReadableDatabase();
                    Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_MEDENI + " WHERE ID = 2", null);

                    if (cursor.moveToFirst()) {
                        medeniek = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.MEDENI_EK));


                    }


                    cursor.close();
                    db.close();
                }
                if(dul.isChecked()){
                    SQLiteDatabase db = dbHelper.getReadableDatabase();
                    Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_MEDENI + " WHERE ID = 3", null);
                    Integer cocuk= Integer.parseInt(cocuksayisi.getText().toString());
                    if (cocuk<=3){

                        cocukdegeri=cocuk*30;
                    }
                    if (cursor.moveToFirst()) {
                        medeniek = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.MEDENI_EK));


                    }

                    cursor.close();
                    db.close();
                }
                }

        });

        ikamet.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("Range")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (kira.isChecked()){
                    SQLiteDatabase db = dbHelper.getReadableDatabase();
                    Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_IKAMET + " WHERE ID = 1", null);

                    if (cursor.moveToFirst()) {
                        ikametucret = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.IKAMET_UCRET));


                    }

                    cursor.close();
                    db.close();
                }
                if (kendievi.isChecked()){
                    SQLiteDatabase db = dbHelper.getReadableDatabase();
                    Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_IKAMET + " WHERE ID = 2", null);

                    if (cursor.moveToFirst()) {
                        ikametucret = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.IKAMET_UCRET));


                    }


                    cursor.close();
                    db.close();
                }
                }

        });

        ingilizce.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                yanacidil=yanacidil+30;
            }

        });
        turkce.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                yanacidil=yanacidil+30;
            }

        });
        almanca.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                yanacidil=yanacidil+30;
            }

        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fakesonuc=tabanmaas+unvanmaas+medeniek+ikametucret+yanacidil+cocukdegeri;
                sonuc.setText("Maasiniz"+fakesonuc);
            }
        });



    }
}