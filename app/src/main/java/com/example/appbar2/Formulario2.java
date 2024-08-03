package com.example.appbar2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Formulario2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario2);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextInputLayout tilCorreo = (TextInputLayout) findViewById(R.id.tilCorreo);
        TextInputEditText tietCorreo = (TextInputEditText) findViewById(R.id.tietCorreo);
        TextInputLayout tilMensaje = (TextInputLayout) findViewById(R.id.tilMensaje);
        TextInputEditText tietMensaje = (TextInputEditText) findViewById(R.id.tietMensaje);
        Button btnEnvMensaje = (Button) findViewById(R.id.btnEnvMensaje);

        btnEnvMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String  receiver = tietCorreo.getText().toString();
                String[] receiver = {"cnavarr0@hotmail.com"};

                String mensaje = tietMensaje.getText().toString();

                Log.i("TAG_Va el dato", "receiver: "+receiver);
                Log.i("TAG_Va el dato", "mensaje: "+mensaje);


                //   sendEmail(sender,senderPass,receiver,title,message);a
             //   sendEmail("cnavarro@uabc.edu.mx","2023","cnavarr0@hotmail.com","title","message");

                Intent intent = new Intent(Intent.ACTION_SEND);
               // intent.setData(Uri.parse("mailto:"));
                 intent.putExtra(Intent.EXTRA_EMAIL,receiver);

                intent.putExtra(Intent.EXTRA_SUBJECT,"Asunto3");
                intent.putExtra(Intent.EXTRA_TEXT,mensaje);

                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"Elije un aplicación"));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    private void sendEmail(final String Sender,final String Password,final String Receiver,final String Title,final String Message)
    {

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                //    GMailSender sender = new GMailSender(Sender,Password);
              //      sender.sendMail(Title, "<b>"+Message+"</b>", sender, Receiver);

                    GMailSender sender = new GMailSender("cnavarro@uabc.edu.mx","2023");

                    //sender.sendMail("Titulo", "<b>"+"Message"+"</b>", sender, Receiver);
                    sender.sendMail("subject","<b>"+Message+"</b>",sender.toString(),"cnavarr0@hotmail.com");
                       makeAlert();

                } catch (Exception e) {
                    Log.i("SendMail", e.getMessage(), e);
                   Log.i("TAG_Entro al catch", "Entro al catch para enviar mensaje ");
                }
            }

        }).start();
    }

    private void makeAlert(){
        this.runOnUiThread(new Runnable() {
            public void run() {
                Log.i("TAG_Entro a makeAlert", "Entro al try para enviar mensaje ");

                //Toast.makeText(this, "Mail Sent", Toast.LENGTH_SHORT).show();
            }
        });
    }
}