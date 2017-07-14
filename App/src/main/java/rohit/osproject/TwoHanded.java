package rohit.osproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TwoHanded extends AppCompatActivity {

    EditText edtSeq, edtLen, edtFrames;
    Button submit;
    TextView textView;
    String s2=new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_handed);

        edtSeq = (EditText) findViewById(R.id.edt_seq);
        edtLen = (EditText) findViewById(R.id.edt_len);
        edtFrames = (EditText) findViewById(R.id.edt_frames);

        Button btnAbout=(Button)findViewById(R.id.btn_about);
        Button btnCodet=(Button)findViewById(R.id.btn_code);
        Button btnExplt=(Button)findViewById(R.id.btn_explain);
        Button btnSim=(Button)findViewById(R.id.simulation);

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TwoHanded.this,About.class);

                startActivity(i);
            }
        });

        btnCodet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TwoHanded.this,TwoHandedCode.class);

                startActivity(i);
            }
        });

        btnExplt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TwoHanded.this,TwoHandedExplanation.class);

                startActivity(i);
            }
        });

        btnSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TwoHanded.this,TwoHandedSimulation.class);

                startActivity(i);
            }
        });


        //textView=(TextView)findViewById(R.id.txt_view);

        submit = (Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Second s=new Second();
                s.secondchance();
                Intent i = new Intent(TwoHanded.this,TwoHandedOutput.class);
                i.putExtra("s",s2);
                startActivity(i);

            }
        });
    }

    class Second {
        //StringBuffer s=new StringBuffer();

        int pgfaultcnt = 0;

        int p[] = new int[50];
        int n, nf, i;
        int in[] = new int[50];
        int least[] = new int[50];

        int max, repindex, hitindex, min;
        Boolean hit;
        int j, k;

        /*void getData() {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter length of page reference sequence:");
            n = sc.nextInt();
            System.out.println("\nEnter the page reference sequence:");


            for (i = 0; i < n; i++)
                in[i] = sc.nextInt();
            System.out.println("\nEnter no of frames:");
            nf = sc.nextInt();
        }
*/
        void initialize() {

            pgfaultcnt = 0;
            for (i = 0; i < nf; i++)
                p[i] = 9999;

            n = Integer.parseInt(edtLen.getText().toString());
            nf = Integer.parseInt(edtFrames.getText().toString());
            String text = edtSeq.getText().toString();
            i = 0;
            for (String ret : text.split(" ")) {
                in[i] = Integer.parseInt(ret);
                i++;
            }


        }

        Boolean isHit(int data) {
            hit = false;
            for (j = 0; j < nf; j++) {
                if (p[j] == data) {
                    hit = true;
                    break;
                }

            }

            return hit;
        }

        int getHitIndex(int data) {
            int hitind = 0;
            for (k = 0; k < nf; k++) {
                if (p[k] == data) {
                    hitind = k;
                    break;
                }
            }
            return hitind;
        }

        void dispPages() {
            for (k = 0; k < nf; k++) {
                if (p[k] != 9999)
                    //System.out.println(" " + p[k]);
                s2+="\n | " + p[k]+ " | ";
            }

        }

        void dispPgFaultCnt() {
            //System.out.println("\nTotal no of page faults:" + pgfaultcnt);
            s2+="\nTotal no of page faults:" + pgfaultcnt;
        }

        void secondchance() {

            int usedbit[] = new int[50];
            int victimptr = 0;
            initialize();
            for (int i = 0; i < nf; i++)
                usedbit[i] = 0;
            for (i = 0; i < n; i++) {
                //System.out.println("\nFor :" + in[i]);
                s2+= "\nFor :"+ in[i] ;
                if (isHit(in[i])) {
                    System.out.println("No page fault!");
                    s2+= "\nNo page fault!" ;
                    int hitindex = getHitIndex(in[i]);
                    if (usedbit[hitindex] == 0)
                        usedbit[hitindex] = 1;
                } else {
                    pgfaultcnt++;
                    if (usedbit[victimptr] == 1) {
                        do {
                            usedbit[victimptr] = 0;
                            victimptr++;
                            if (victimptr == nf)
                                victimptr = 0;
                        }
                        while (usedbit[victimptr] != 0);
                    }
                    if (usedbit[victimptr] == 0) {
                        p[victimptr] = in[i];
                        usedbit[victimptr] = 1;
                        victimptr++;
                    }
                    dispPages();

                }
                if (victimptr == nf)
                    victimptr = 0;
            }
            dispPgFaultCnt();
            //textView.setText(s2);
        }

        public Second() {
            // TODO Auto-generated constructor stub

        }
/*
        public void main(String[] args) {
            Second sc = new Second();
            sc.initialize();
            //sc.getData();
            sc.secondchance();


        }*/
    }
}
