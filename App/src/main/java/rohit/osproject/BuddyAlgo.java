package rohit.osproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuddyAlgo extends AppCompatActivity {
    String s3 = new String();
    Buddy b = new Buddy();
    int code = -1;


    TextView txtLen, txtInsert, txtRemove, txtAllocation;
    EditText edtLen, edtInsert, edtRemove ;

    Button btnRun, btnInsert, btnRemove, btnAllocate, btnSimulate,btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddy_algo);

        txtLen = (TextView) findViewById(R.id.txt_len);
        txtInsert = (TextView) findViewById(R.id.txt_insert);
        txtRemove = (TextView) findViewById(R.id.txt_remove);
        txtAllocation = (TextView) findViewById(R.id.txt_allocation);


        edtLen = (EditText) findViewById(R.id.edt_len);
        edtInsert = (EditText) findViewById(R.id.edt_insert);
        // edtAllocation=(EditText)findViewById(R.id.edt_allocation);
        edtRemove = (EditText) findViewById(R.id.edt_remove);

        btnRun = (Button) findViewById(R.id.btn_submit);
        btnInsert = (Button) findViewById(R.id.btn_insert);
        btnRemove = (Button) findViewById(R.id.btn_remove);
        btnAllocate = (Button) findViewById(R.id.btn_allocation);
        btnSimulate = (Button) findViewById(R.id.simulation);
        btnMenu=(Button)findViewById(R.id.btn_menu);


        Button btnAbout=(Button)findViewById(R.id.btn_about);
        Button btnCodet=(Button)findViewById(R.id.btn_code);
        Button btnExplt=(Button)findViewById(R.id.btn_explain);
       // Button btnSim=(Button)findViewById(R.id.simulation);

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BuddyAlgo.this,About.class);

                startActivity(i);
            }
        });

        btnCodet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BuddyAlgo.this,BuddyCode.class);

                startActivity(i);
            }
        });

        btnExplt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BuddyAlgo.this,BuddyExplanation.class);

                startActivity(i);
            }
        });



        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (code == -1) {
                    b.init();

                    btnAllocate.setVisibility(View.VISIBLE);
                    btnInsert.setVisibility(View.VISIBLE);
                    btnRemove.setVisibility(View.VISIBLE);
                    btnSimulate.setVisibility(View.VISIBLE);
                    btnRun.setVisibility(View.GONE);

                    edtLen.setVisibility(View.GONE);
                    txtLen.setVisibility(View.GONE);
                } else if (code == 1) {
                    b.insert();
                    btnAllocate.setVisibility(View.VISIBLE);
                    btnInsert.setVisibility(View.VISIBLE);
                    btnRemove.setVisibility(View.VISIBLE);
                    btnSimulate.setVisibility(View.VISIBLE);
                    btnMenu.setVisibility(View.GONE);
                    btnRun.setVisibility(View.GONE);

                    edtInsert.setVisibility(View.GONE);
                    edtRemove.setVisibility(View.GONE);
                    txtAllocation.setVisibility(View.GONE);
                    txtRemove.setVisibility(View.GONE);
                    txtInsert.setVisibility(View.GONE);



                } else if (code == 2) {
                    b.remove();
                    btnAllocate.setVisibility(View.VISIBLE);
                    btnInsert.setVisibility(View.VISIBLE);
                    btnRemove.setVisibility(View.VISIBLE);
                    btnSimulate.setVisibility(View.VISIBLE);
                    btnMenu.setVisibility(View.GONE);
                    btnRun.setVisibility(View.GONE);

                    edtInsert.setVisibility(View.GONE);
                    edtRemove.setVisibility(View.GONE);
                    txtAllocation.setVisibility(View.GONE);
                    txtRemove.setVisibility(View.GONE);
                    txtInsert.setVisibility(View.GONE);
                } else {

                }
                code = 0;
                btnMenu.setVisibility(View.GONE);
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                code = 1;

                btnAllocate.setVisibility(View.GONE);
                btnInsert.setVisibility(View.GONE);
                btnRemove.setVisibility(View.GONE);
                btnSimulate.setVisibility(View.GONE);
                edtInsert.setVisibility(View.VISIBLE);
                txtInsert.setVisibility(View.VISIBLE);
                btnRun.setVisibility(View.VISIBLE);
                btnMenu.setVisibility(View.VISIBLE);
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = 2;

                btnAllocate.setVisibility(View.GONE);
                btnInsert.setVisibility(View.GONE);
                btnRemove.setVisibility(View.GONE);
                btnSimulate.setVisibility(View.GONE);
                txtRemove.setVisibility(View.VISIBLE);
                edtRemove.setVisibility(View.VISIBLE);
                btnRun.setVisibility(View.VISIBLE);
                btnMenu.setVisibility(View.VISIBLE);
            }
        });

        btnAllocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(code==-1) {
                    Toast.makeText(BuddyAlgo.this, "Insert a process first!", Toast.LENGTH_SHORT).show();
                    return;
                }
                s3="";
                b.allocate();

                btnAllocate.setVisibility(View.GONE);
                btnInsert.setVisibility(View.GONE);
                btnRemove.setVisibility(View.GONE);
                btnSimulate.setVisibility(View.GONE);
                txtRemove.setVisibility(View.GONE);
                edtRemove.setVisibility(View.GONE);
                btnRun.setVisibility(View.GONE);
                btnMenu.setVisibility(View.VISIBLE);


                txtAllocation.setVisibility(View.VISIBLE);
                txtAllocation.setText(s3);



            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAllocate.setVisibility(View.VISIBLE);
                btnInsert.setVisibility(View.VISIBLE);
                btnRemove.setVisibility(View.VISIBLE);
                btnSimulate.setVisibility(View.VISIBLE);
                btnMenu.setVisibility(View.GONE);
                btnRun.setVisibility(View.GONE);

                edtInsert.setVisibility(View.GONE);
                edtRemove.setVisibility(View.GONE);
                txtAllocation.setVisibility(View.GONE);
                txtRemove.setVisibility(View.GONE);
                txtInsert.setVisibility(View.GONE);

            }
        });
        btnSimulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sandbox.mc.edu/~bennet/cs404/outl/buddy.html"));
                // i.setData("https://www.google.com");
                //Intent.createChooser(i,"Select browser");
                startActivity(i);
            }
        });

    }



    class Buddy {
//  BUDDY SYSTEM CODE


        int tree[] = new int[2050];
        int i, j, k;
        int totsize,req;



        void segmentalloc(int totsize, int request) {
            int flevel = 0, size;
            size = totsize;
          //  Toast.makeText(BuddyAlgo.this, "Insert:1 tot size "+totsize+" request: "+request, Toast.LENGTH_SHORT).show();

            if (request > size) {
             //   Toast.makeText(BuddyAlgo.this, "Insert: 2 tot size "+totsize+" request: "+request, Toast.LENGTH_SHORT).show();
                // System.out.println("%c  R E S U L T  :  "+2);
                //s3 += "\n  R E S U L T  :";
                //System.out.println("*  The system doesn't have enough free memory");
                //s3 += "\n  The system doesn't have enough free memory";
                Toast.makeText(BuddyAlgo.this, "The system doesn't have enough free memory", Toast.LENGTH_SHORT).show();

                return;
            }
            while (true) {
                if (request < size && request > (size / 2))
                    break;
                else {
                    size /= 2;
                    flevel++;
                }
            }
            for (i = power(2, flevel) - 1; i <= (power(2, flevel + 1) - 2); i++)
                if (tree[i] == 0 && place(i)) {
                    tree[i] = request;
                    makedivided(i);
                    // s3 += "\nResult  \n  :     Successful Allocation";
                    //System.out.println("Result    :     Successful Allocation");
                    Toast.makeText(BuddyAlgo.this, "Result    :     Successful Allocation", Toast.LENGTH_SHORT).show();
                    break;
                }
            if (i == power(2, flevel + 1) - 1) {
                //System.out.println("	    Result  :  ");
                //System.out.println("*  The system doesn't have enough free memory");
                // s3 += "\n     Result  : \n  The system doesn't have enough free memory";
                //System.out.println("*  Suggession  :  Go for VIRTUAL Memory Mode");
                Toast.makeText(BuddyAlgo.this, "The system doesn't have enough free memory", Toast.LENGTH_SHORT).show();
            }
        }

        void makedivided(int node) {
            while (node != 0) {
                node = node % 2 == 0 ? (node - 1) / 2 : node / 2;
                tree[node] = 1;
            }
        }

        Boolean place(int node) {
            while (node != 0) {
                node = node % 2 == 0 ? (node - 1) / 2 : node / 2;
                if (tree[node] > 1)
                    return false;
            }
            return true;
        }

        void makefree(int request) {
            int node = 0;
            while (true) //edited
            {
                if (tree[node] == request)
                    break;
                else
                    node++;
            }
            tree[node] = 0;
            while (node != 0) {
                if (tree[node % 2 == 0 ? node - 1 : node + 1] == 0 && tree[node] == 0) {
                    tree[node % 2 == 0 ? (node - 1) / 2 : node / 2] = 0;
                    node = node % 2 == 0 ? (node - 1) / 2 : node / 2;
                } else break;
            }
        }

        int power(int x, int y) {
            int z, ans;
            if (y == 0) return 1;
            ans = x;
            for (z = 1; z < y; z++)
                ans *= x;
            return ans;
        }

        void printing(int totsize, int node) {
            int permission = 0, llimit, ulimit, tab;
            if (node == 0)
                permission = 1;
            else if (node % 2 == 0)
                permission = tree[(node - 1) / 2] == 1 ? 1 : 0;
            else
                permission = tree[node / 2] == 1 ? 1 : 0;
            if (permission == 1) {
                llimit = ulimit = tab = 0;
                while (true) {
                    if (node >= llimit && node <= ulimit)
                        break;
                    else {
                        tab++;
                        System.out.println("       ");
                        llimit = ulimit + 1;
                        ulimit = 2 * ulimit + 2;
                    }
                }
                System.out.println("  " + totsize / power(2, tab));
                if (tree[node] > 1)
                    s3 += "\n---> Allocated " + tree[node];
                    // System.out.println("---> Allocated %d" + tree[node]);

                else if (tree[node] == 1) {


                    s3 += "\n---> Divided";
                } else s3 += "\n---> Free";
                printing(totsize, 2 * node + 1);
                printing(totsize, 2 * node + 2);
            }
        }

        public Buddy() {
            // TODO Auto-generated constructor stub
        }

        void insert() {
           /* System.out.println("");
            for (i = 0; i < 80; i++) *//* System.out.println(5) *//* ;
            System.out.println("");
            System.out.println("M E M O R Y   A L L O C A T I O N");
            for (i = 0; i < 80; i++) *//* System.out.println(5) *//* ;
            System.out.println("*  Enter the Process size  : ");*/
            req = Integer.parseInt(edtInsert.getText().toString());
            //req = sc.nextInt();
            segmentalloc(totsize, req);

        }

        void remove() {
            /*System.out.println("");
            System.out.println("");
            System.out.println("M E M O R Y   D E A L L O C A T I ON");
            for (i = 0; i < 80; i++) *//* System.out.println(5) *//* ;
            System.out.println("*  Enter the process size  :  ");*/
            //  req = sc.nextInt();
            req = Integer.parseInt(edtRemove.getText().toString());
           // Toast.makeText(BuddyAlgo.this, "Remove: tot size "+totsize+" request: "+req, Toast.LENGTH_SHORT).show();
            makefree(req);
            Toast.makeText(BuddyAlgo.this, "Process removed successfully", Toast.LENGTH_SHORT).show();
            // break;
        }

        void allocate() {
           /* System.out.println("");
            for (i = 0; i < 80; i++) *//* System.out.println(5) *//* ;
            System.out.println("M E M O R Y   A L L O C A T I O N   M A P");
            for (i = 0; i < 80; i++) *//* System.out.println(5) *//* ;
            System.out.println("");
            b.printing(totsize, 0);
            System.out.println("");
            for (i = 0; i < 80; i++) *//* System.out.println(5) *//* ;
            break;*/
            s3 += "MEMORY ALLOCATION MAP\n";
            printing(totsize, 0);
        }

        void init() {
            totsize = Integer.parseInt(edtLen.getText().toString());
        //    Toast.makeText(BuddyAlgo.this, "Init : tot size "+totsize, Toast.LENGTH_SHORT).show();

        }

        //Scanner sc=new Scanner(System.in);
            /*for (i = 0; i < 80; i++) //*//* System.out.println(5) *//*
                ;*/
        //System.out.println(" B U D D Y   S Y S T E M  R E Q U I R E M E N TS");
        // for (i = 0; i < 80; i++) /* System.out.println(""+5) */ ;
        //System.out.println("*  Enter the Size of the memory  :  ");

        //totsize = sc.nextInt();

           /* while (true) {*/
        // for (i = 0; i < 80; i++) /* System.out.println(5) */ ;
        // System.out.println("   B U D D Y   S Y S T E M");
              /*  for (i = 0; i < 80; i++) *//* System.out.println(5) *//* ;
                System.out.println("*  1)   Locate the process into the Memory");
                System.out.println("*  2)   Remove the process from Memory");
                System.out.println("*  3)   Tree structure for Memory allocation Map");
                System.out.println("*  4)   Exit");
                for (i = 0; i < 80; i++) *//* System.out.println(5) *//* ;
                System.out.println("*  Enter your choice  :  ");*/
        // cho = sc.nextInt();
               /* switch (cho) {
                    case 1:*/

                    /*    System.out.println("");
                        for (i = 0; i < 80; i++) *//* System.out.println(5) *//* ;
                        System.out.println("");
                        System.out.println("M E M O R Y   A L L O C A T I O N");
                        for (i = 0; i < 80; i++) *//* System.out.println(5) *//* ;
                        System.out.println("*  Enter the Process size  : ");
                        req = sc.nextInt();
                        b.segmentalloc(totsize, req);
                        break;*/
                    /*case 2:
                        System.out.println("");
                        System.out.println("");
                        System.out.println("M E M O R Y   D E A L L O C A T I ON");
                        for (i = 0; i < 80; i++) *//* System.out.println(5) *//* ;
                        System.out.println("*  Enter the process size  :  ");
                        req = sc.nextInt();
                        b.makefree(req);
                        break;*/
                    /*case 3:

                        System.out.println("");
                        for (i = 0; i < 80; i++) *//* System.out.println(5) *//* ;
                        System.out.println("M E M O R Y   A L L O C A T I O N   M A P");
                        for (i = 0; i < 80; i++) *//* System.out.println(5) *//* ;
                        System.out.println("");
                        b.printing(totsize, 0);
                        System.out.println("");
                        for (i = 0; i < 80; i++) *//* System.out.println(5) *//* ;
                        break;
                    default:
                        return;*/
    }
}






