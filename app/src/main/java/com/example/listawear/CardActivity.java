package com.example.listawear;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CardActivity extends Activity {
    private TextView titulo;
    private TextView descripcion;
    private Button cerrar;
    private Button enrolar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card);

        titulo = (TextView) findViewById(R.id.txtTitulo);
        descripcion = (TextView) findViewById(R.id.txtDescripcion);
        cerrar = (Button) findViewById(R.id.btnCerrar);
        enrolar = (Button) findViewById(R.id.btnEnrolar);

        Bundle extras = getIntent().getExtras();
        if( extras != null){
            titulo.setText(extras.getString("titulo"));
            descripcion.setText(extras.getString("descripcion"));
        }

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        enrolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CardActivity.this,
                        "Te enrolaste",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

}
