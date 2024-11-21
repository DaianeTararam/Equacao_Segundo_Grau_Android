/*
*@author: Daiane Tararam
*RA: 1110482322003
*/
package com.example.equacao;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etA;
    private EditText etB;
    private EditText etC;
    private Button btnCalcular;
    private TextView tvResposta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etA = findViewById(R.id.etA);
        etA.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etB = findViewById(R.id.etB);
        etB.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etC = findViewById(R.id.etC);
        etC.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        tvResposta = findViewById(R.id.tvResposta);
        tvResposta.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(op -> equacaoCalculo());
    }

    private void equacaoCalculo(){
        double a =  Integer.parseInt(etA.getText().toString());
        double b =  Integer.parseInt(etB.getText().toString());
        double c =  Integer.parseInt(etC.getText().toString());
        double delta = (b* b) - (4 * a * c);

        if (delta > 0){
            String resp = "Há duas raízes!!!\n";
            double x1 = (-b + Math.sqrt(delta))/(2*a);
            double x2 = (-b - Math.sqrt(delta))/(2*a);
            String resX1 = getString(R.string.x1) + " " + x1 + "\n";
            String resX2 = getString(R.string.x2)+ " " + x2;
            tvResposta.append(resp + resX1 + resX2);
        }else if(delta == 0){
            String resp = "Há apenas uma raíz!!!\n";
            double x1 = -b / (2*a);
            String resX1 = getString(R.string.x1) + " " + x1;
            tvResposta.append(resp + resX1);
        }else{
            tvResposta.setText(getString(R.string.sem_raizes));
        }
    }
}
