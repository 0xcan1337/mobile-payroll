package com.example.sinavcalisma;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper instance;
    public static final String DATABASE_NAME = "maasBordrosu1";
    public static final int DATABASE_VERSION = 3;
    public static final String TABLE_UNVANLAR = "unvanlar";

    public static final String UNVANLAR_ID = "id";
    public static final String UNVANLAR_ISIM = "isim";
    public static final String UNVAN_MAAS = "maas";
    public static final String TABLE_MEDENI = "medenihal";

    public static final String MEDENI_ID = "id";
    public static final String MEDENI_DURUM = "isim";
    public static final String MEDENI_EK = "ek";

    public static final String TABLE_IKAMET = "ikamet";

    public static final String IKAMET_ID = "id";
    public static final String IKAMET_TURU = "ikametturu";
    public static final String IKAMET_UCRET = "ucret";

    public DatabaseHelper(MainActivity  context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public static synchronized DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper((MainActivity) context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_UNVANLAR + " (" +
                UNVANLAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                UNVANLAR_ISIM + " TEXT, " +
                UNVAN_MAAS + " INTEGER) ";
        db.execSQL(createTableQuery);


        db.execSQL("INSERT INTO " + TABLE_UNVANLAR + " (" +
                UNVANLAR_ID + ", " +
                UNVANLAR_ISIM + ", " +
                UNVAN_MAAS + ") VALUES ('1', 'Hizmeti', '130')");

        db.execSQL("INSERT INTO " + TABLE_UNVANLAR + " (" +
                UNVANLAR_ID + ", " +
                UNVANLAR_ISIM + ", " +
                UNVAN_MAAS + ") VALUES ('2', 'Memur', '170')");
        db.execSQL("INSERT INTO " + TABLE_UNVANLAR + " (" +
                UNVANLAR_ID + ", " +
                UNVANLAR_ISIM + ", " +
                UNVAN_MAAS + ") VALUES ('3', 'Şef', '210')");
        db.execSQL("INSERT INTO " + TABLE_UNVANLAR + " (" +
                UNVANLAR_ID + ", " +
                UNVANLAR_ISIM + ", " +
                UNVAN_MAAS + ") VALUES ('4', 'Müdür', '250')");


            String createTableMedeni = "CREATE TABLE " + TABLE_MEDENI + " (" +
                    MEDENI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    MEDENI_DURUM + " TEXT, " +
                    MEDENI_EK + " INTEGER) ";
            db.execSQL(createTableMedeni);


            db.execSQL("INSERT INTO " + TABLE_MEDENI + " (" +
                    MEDENI_ID + ", " +
                    MEDENI_DURUM + ", " +
                    MEDENI_EK + ") VALUES ('1', 'Evli', '75')");

        db.execSQL("INSERT INTO " + TABLE_MEDENI + " (" +
                MEDENI_ID + ", " +
                MEDENI_DURUM + ", " +
                MEDENI_EK + ") VALUES ('2', 'Bekar', '0')");
        db.execSQL("INSERT INTO " + TABLE_MEDENI + " (" +
                MEDENI_ID + ", " +
                MEDENI_DURUM + ", " +
                MEDENI_EK + ") VALUES ('3', 'Dul', '0')");


        String createTableIkamet = "CREATE TABLE " + TABLE_IKAMET + " (" +
                IKAMET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                IKAMET_TURU + " TEXT, " +
                IKAMET_UCRET + " INTEGER) ";
        db.execSQL(createTableIkamet);


        db.execSQL("INSERT INTO " + TABLE_IKAMET + " (" +
                IKAMET_ID + ", " +
                IKAMET_TURU + ", " +
                IKAMET_UCRET + ") VALUES ('1', 'Kira', '50')");

        db.execSQL("INSERT INTO " + TABLE_IKAMET + " (" +
                IKAMET_ID + ", " +
                IKAMET_TURU + ", " +
                IKAMET_UCRET + ") VALUES ('2', 'Kendi Evi', '0')");


    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UNVANLAR);
        onCreate(db);
    }


}