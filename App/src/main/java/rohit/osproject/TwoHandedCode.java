package rohit.osproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TwoHandedCode extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_handed_code);

        tv=(TextView)findViewById(R.id.btn);
        tv.setText("import java.util.Scanner;\n" +
                "\n" +
                "public class Second {\n" +
                "\tint pgfaultcnt=0;\n" +
                "\t\n" +
                "\tint p[]=new int[50];\n" +
                "\tint n,nf,i;\n" +
                "\tint in[]=new int[50];\n" +
                "\t int least[]=new int[50];\n" +
                "\n" +
                "\t int max,repindex,hitindex,min;\n" +
                "\t Boolean hit;\n" +
                "\t int j,k;\n" +
                "\t \n" +
                "\tvoid getData()\n" +
                "\t{\n" +
                "\t\tScanner sc=new Scanner(System.in);\n" +
                "\t    System.out.println(\"\\nEnter length of page reference sequence:\");\n" +
                "\t    n=sc.nextInt();\n" +
                "\t    System.out.println(\"\\nEnter the page reference sequence:\");\n" +
                "\t    for(i=0; i<n; i++)\n" +
                "\t\tin[i]=sc.nextInt();\n" +
                "\t    System.out.println(\"\\nEnter no of frames:\");\n" +
                "\t    nf=sc.nextInt();\n" +
                "\t}\n" +
                "\n" +
                "\tvoid initialize()\n" +
                "\t{\n" +
                "\t    pgfaultcnt=0;\n" +
                "\t    for(i=0; i<nf; i++)\n" +
                "\t\tp[i]=9999;\n" +
                "\t}\n" +
                "\tBoolean isHit(int data)\n" +
                "\t{\n" +
                "\t    hit=false;\n" +
                "\t    for(j=0; j<nf; j++)\n" +
                "\t    {\n" +
                "\t\tif(p[j]==data)\n" +
                "\t\t{\n" +
                "\t\t    hit=true;\n" +
                "\t\t    break;\n" +
                "\t\t}\n" +
                "\n" +
                "}\n" +
                "\n" +
                "\t    return hit;\n" +
                "\t}\n" +
                "\tint getHitIndex(int data)\n" +
                "\t{\n" +
                "\t    int hitind=0;\n" +
                "\t    for(k=0; k<nf; k++)\n" +
                "\t    {\n" +
                "\t\tif(p[k]==data)\n" +
                "\t\t{\n" +
                "\t\t    hitind=k;\n" +
                "\t\t    break;\n" +
                "\t\t}\n" +
                "\t    }\n" +
                "\t    return hitind;\n" +
                "\t}\n" +
                "\n" +
                "\tvoid dispPages()\n" +
                "\t{\n" +
                "\t    for (k=0; k<nf; k++)\n" +
                "\t    {\n" +
                "\t\tif(p[k]!=9999)\n" +
                "\t\t\tSystem.out.println(\" \"+p[k]);\n" +
                "\t    }\n" +
                "\n" +
                "\t}\n" +
                "\n" +
                "\tvoid dispPgFaultCnt()\n" +
                "\t{\n" +
                "\t\tSystem.out.println(\"\\nTotal no of page faults:\"+pgfaultcnt);\n" +
                "\t}\n" +
                "\tvoid secondchance()\n" +
                "\t{\n" +
                "\t    int usedbit[]=new int[50];\n" +
                "\t    int victimptr=0;\n" +
                "\t    initialize();\n" +
                "\t    for(int i=0; i<nf; i++)\n" +
                "\t        usedbit[i]=0;\n" +
                "\t    for(i=0; i<n; i++)\n" +
                "\t    {\n" +
                "\t    \tSystem.out.println(\"\\nFor :\"+in[i]);\n" +
                "\t        if(isHit(in[i]))\n" +
                "\t        {\n" +
                "\t        \tSystem.out.println(\"No page fault!\");\n" +
                "\t            int hitindex=getHitIndex(in[i]);\n" +
                "\t            if(usedbit[hitindex]==0)\n" +
                "\t                usedbit[hitindex]=1;\n" +
                "\t        }\n" +
                "\t        else\n" +
                "\t        {\n" +
                "\t            pgfaultcnt++;\n" +
                "\t            if(usedbit[victimptr]==1)\n" +
                "\t            {\n" +
                "\t                do\n" +
                "\t                {\n" +
                "\t                    usedbit[victimptr]=0;\n" +
                "\t                    victimptr++;\n" +
                "\t                    if(victimptr==nf)\n" +
                "\t                        victimptr=0;\n" +
                "\t                }\n" +
                "\t                while(usedbit[victimptr]!=0);\n" +
                "\t            }\n" +
                "\t            if(usedbit[victimptr]==0)\n" +
                "\t            {\n" +
                "\t                p[victimptr]=in[i];\n" +
                "\t                usedbit[victimptr]=1;\n" +
                "\t                victimptr++;\n" +
                "\t            }\n" +
                "\t            dispPages();\n" +
                "\t \n" +
                "\t        }\n" +
                "\t        if(victimptr==nf)\n" +
                "\t            victimptr=0;\n" +
                "\t    }\n" +
                "\t    dispPgFaultCnt();\n" +
                "\t}\n" +
                "\n" +
                "\tpublic Second() {\n" +
                "\t\t// TODO Auto-generated constructor stub\n" +
                "\n" +
                "\t}\n" +
                "\n" +
                "\tpublic static void main(String[] args) {\n" +
                "\t\tSecond sc=new Second();\n" +
                "\t\tsc.initialize();\n" +
                "\t\tsc.getData();\n" +
                "\t\tsc.secondchance();\n" +
                "\t   \n" +
                "\n" +
                "\t}\n" +
                "}\n");


    }
}
