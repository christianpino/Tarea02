package com.example.tarea02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityImprimir extends AppCompatActivity {

    private TextView tvcliente, tvdni, tvservicio, tvcostoservicio, tvcostoinstalacion, tvdescuento, tvtotalpagar;
    private Button btnvolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imprimir);

        tvcliente=findViewById(R.id.tvCliente);
        tvdni=findViewById(R.id.tvDni);
        tvservicio=findViewById(R.id.tvServicio);
        tvcostoservicio=findViewById(R.id.tvCostoServicio);
        tvcostoinstalacion=findViewById(R.id.tvCostoInstalacion);
        tvdescuento=findViewById(R.id.tvDescuento);
        tvtotalpagar=findViewById(R.id.tvTotalPagar);
        btnvolver=findViewById(R.id.btnVolver);

        Bundle datos= this.getIntent().getExtras();
        tvcliente.setText("cliente: "+datos.getString("cliente"));
        tvdni.setText("dni: "+datos.getString("dni"));
        tvservicio.setText("servicio: "+datos.getString("servicio"));
        tvcostoservicio.setText("Costo servicio: "+datos.getString("costoServicio"));
        tvcostoinstalacion.setText("Costo Instalacion: "+datos.getString("costoInstalacion"));
        tvdescuento.setText("Descuento: "+datos.getString("descuento"));
        tvtotalpagar.setText("Total pagar: "+datos.getString("totalpagar"));



        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(getApplication(), MainActivity.class);
                startActivity(intent);

            }
        });


    }



}