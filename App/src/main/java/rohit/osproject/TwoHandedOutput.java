package rohit.osproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TwoHandedOutput extends AppCompatActivity {
    Button submit;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_handed_output);

        Bundle extras = getIntent().getExtras();

            String name = extras.getString("s");


        Button btnAbout=(Button)findViewById(R.id.btn_about);
        Button btnCodet=(Button)findViewById(R.id.btn_code);
        Button btnExplt=(Button)findViewById(R.id.btn_explain);
       // Button btnSim=(Button)findViewById(R.id.simulation);

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TwoHandedOutput.this,About.class);

                startActivity(i);
            }
        });

        btnCodet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TwoHandedOutput.this,TwoHandedCode.class);

                startActivity(i);
            }
        });

        btnExplt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TwoHandedOutput.this,TwoHandedExplanation.class);

                startActivity(i);
            }
        });




        textView=(TextView)findViewById(R.id.txt_view);
        textView.setText(name);

        submit = (Button) findViewById(R.id.simulation);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(TwoHandedOutput.this, TwoHandedSimulation.class);
               // i.setData("https://www.google.com");
              //Intent.createChooser(i,"Select browser");
                startActivity(i);

            }
        });
    }
    }

