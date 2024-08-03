package com.example.appbar2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Formulario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    /*    TextInputLayout tilCorreo = (TextInputLayout) findViewById(R.id.tilCorreo);
        TextInputEditText tietCorreo = (TextInputEditText) findViewById(R.id.tietCorreo);
        Button btnEnvMensaje = (Button) findViewById(R.id.btnEnvMensaje);

        btnEnvMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  receiver = tietCorreo.toString();
                sendEmail(receiver,"Hola");
            }
        });*/


    }

   /* private void sendEmail(final String Receiver, final String Message)
    {

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    GMailSender sender = new GMailSender("cnavarro@uabc.edu.mx","2023Chxanaco22mX");
                  //  sender.sendMail("Titulo", "<b>"+"Message"+"</b>", sender, Receiver);
                    sender.sendMail("subject","body",sender.toString(),"cnavarr0@hotmail.com");
                 //   makeAlert();

                } catch (Exception e) {
                    //Log.e("SendMail", e.getMessage(), e);
                }
            }

        }).start();
    }*/
/*    private void makeAlert(){
        this.runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(MainActivity.this, "Mail Sent", Toast.LENGTH_SHORT).show();
            }
        });
    }*/
}