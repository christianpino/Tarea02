package com.example.tarea02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtcliente, edtdni, edtcostoservicio, edtcostoinstalacion, edtdescuento,et1,et2,et3;
    private TextView tvtotal;
    private RadioGroup radiogroup;
    private RadioButton rbtnduo, rbtntrio, rbtncamara, rbtnrobo, rbtnincendio, rbtncercos;
    private Button btnimprimir, btncalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtcliente=findViewById(R.id.edtCliente);
        edtdni=findViewById(R.id.edtDni);
        radiogroup=findViewById(R.id.RadioGroup);
        rbtnduo=findViewById(R.id.rbtnDuo);
        rbtntrio=findViewById(R.id.rbtnTrio);
        rbtncamara=findViewById(R.id.rbtnCamaras);
        rbtnrobo=findViewById(R.id.rbtnRobo);
        rbtnincendio=findViewById(R.id.rbtnIncendio);
        rbtncercos=findViewById(R.id.rbtnCercos);
        btncalcular=findViewById(R.id.btnCalcular);
        btnimprimir=findViewById(R.id.btnImprimir);
        edtcostoservicio=findViewById(R.id.edtCostoServicio);
        edtcostoinstalacion=findViewById(R.id.edtCostoInstalacion);
        edtdescuento=findViewById(R.id.edtDescuento);


        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = findViewById(i);
                if(rbtnduo.getId()==radioButton.getId()){
                    edtcostoservicio.setText("200");
                    edtcostoinstalacion.setText("50");
                }
                if(rbtntrio.getId()==radioButton.getId()){
                    edtcostoservicio.setText("300");
                    edtcostoinstalacion.setText("100");
                }
                if(rbtncamara.getId()==radioButton.getId()){
                    edtcostoservicio.setText("100");
                    edtcostoinstalacion.setText("100");
                }
                if(rbtnrobo.getId()==radioButton.getId()){
                    edtcostoservicio.setText("80");
                    edtcostoinstalacion.setText("30");
                }
                if(rbtnincendio.getId()==radioButton.getId()){
                    edtcostoservicio.setText("80");
                    edtcostoinstalacion.setText("30");
                }
                if(rbtncercos.getId()==radioButton.getId()){
                    edtcostoservicio.setText("250");
                    edtcostoinstalacion.setText("100");
                }
            }
        });


        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    et1=(EditText)findViewById(R.id.edtCostoServicio);
                    et2=(EditText)findViewById(R.id.edtCostoInstalacion);
                    et3=(EditText)findViewById(R.id.edtDescuento);
                    tvtotal=(TextView)findViewById(R.id.tvTotal);

                    int n1,n2,n3,opera;
                    n1=Integer.parseInt(et1.getText().toString());
                    n2=Integer.parseInt(et2.getText().toString());
                    n3=Integer.parseInt(et3.getText().toString());

                    opera=(n1+n2)-n3;
                    tvtotal.setText(""+opera);

            }
        });


        btnimprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplication(), ActivityImprimir.class);
                intent.putExtra("cliente", edtcliente.getText().toString());
                intent.putExtra("dni", edtdni.getText().toString());
                intent.putExtra("servicio", radiogroup.getId());
                intent.putExtra("costoServicio", edtcostoservicio.getText().toString());
                intent.putExtra("costoInstalacion", edtcostoinstalacion.getText().toString());
                intent.putExtra("descuento", edtdescuento.getText().toString());
                intent.putExtra("totalpagar", tvtotal.getText().toString());

                startActivity(intent);







            }
        });




    }
}