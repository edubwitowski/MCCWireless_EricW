package net.androidbootcamp.mccwireless_ericw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double moneyEntered;
    double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText price = findViewById(R.id.dataPlanPrice);
        final RadioButton data1 = findViewById(R.id.dataPlan50);
        final RadioButton data2 = findViewById(R.id.dataPlan25);
        final RadioButton data3 = findViewById(R.id.dataPlan15);
        final RadioButton data4 = findViewById(R.id.dataPlanShared);
        final RadioButton data5 = findViewById(R.id.dataPlanAdd);
        final TextView result= findViewById(R.id.txtNewResult);
        Button convert= findViewById(R.id.btnConvert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moneyEntered = Double.parseDouble(price.getText().toString());
                DecimalFormat tenth= new DecimalFormat("#.#");
                if(data1.isChecked()) {

                    total = moneyEntered * .90;
                    result.setText("$"+tenth.format(total));


                }

                if(data2.isChecked()){
                    if(moneyEntered<= 500){
                        total= moneyEntered*.80;
                        result.setText("$"+ tenth.format(total));


                    }
                    else{
                        Toast.makeText(MainActivity.this,"Plan Price 2",Toast.LENGTH_LONG).show();
                    }
                }
                if(data3.isChecked()) {
                    if (moneyEntered <= 300) {
                        total = moneyEntered * .75;
                        result.setText("$"+ tenth.format(total));

                    }else{
                        Toast.makeText(MainActivity.this,"Plan Price 2",Toast.LENGTH_LONG).show();
                    }
                }
                if (data4. isChecked()){
                    if (moneyEntered <= 200) {
                        total = moneyEntered - 5;
                        result.setText("$" + tenth.format(total));
                    }else{
                        Toast.makeText(MainActivity.this, "Plan Price 3", Toast.LENGTH_SHORT).show();

                    }
                }
                if (data5. isChecked()) {
                    if (moneyEntered <= 100) {
                        total = moneyEntered + 10;
                        result.setText("$" + tenth.format(total));
                    } else {
                        Toast.makeText(MainActivity.this, "This Adds 10 Gigs of Data to your plan", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }


}

