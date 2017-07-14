package rohit.osproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnCodet=(Button)findViewById(R.id.buddy);
        Button btnExplt=(Button)findViewById(R.id.sec);
        // Button btnSim=(Button)findViewById(R.id.simulation);

        btnCodet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,BuddyAlgo.class);

                startActivity(i);
            }
        });

        btnExplt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,TwoHanded.class);

                startActivity(i);
            }
        });

    }
}
