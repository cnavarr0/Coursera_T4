package com.example.appbar2.db;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.appbar2.R;
import com.example.appbar2.pojo.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {

    private static final Integer LIKE = 1;
    private Context context;

    public ConstructorContactos(Context context){
        this.context = context;

    }

    public ArrayList<Contacto> obtenerDatos(){
     /*   ArrayList<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto(R.mipmap.perro1_foreground,"Christian", "6461234567", "christian@hotmail.com", 5));
        contactos.add(new Contacto(R.mipmap.perro2_foreground,"Luis", "6461111111", "luis@hotmail.com",3));
        contactos.add(new Contacto(R.mipmap.perro3_foreground,"Dario", "6462222222", "dario@hotmail.com",8));
        contactos.add(new Contacto(R.mipmap.perro4_foreground,"Alberto", "6463333333", "alberto@hotmail.com",9));
        contactos.add(new Contacto(R.mipmap.perro5_foreground,"Xavier", "646777777", "xavi@hotmail.com",1));

        return contactos;*/

        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodosLosContactos();
        //return contactos;

    }

    public  void insertarTresContactos(BaseDatos db){
        //Log.i("TAG_Entro a Tres contactos", "entro bd");

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Christian");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "6461234567");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "christian@hotmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.mipmap.perro1_foreground);
        db.insertarContacto(contentValues);


        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Luis");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "6461111111");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "luis@hotmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.mipmap.perro2_foreground);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Dario");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "6462222222");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "dario@hotmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.mipmap.perro3_foreground);
        db.insertarContacto(contentValues);


    }

    public void darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);

    }

}
