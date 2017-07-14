package rohit.osproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BuddyCode extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddy_code);

        tv=(TextView)findViewById(R.id.btn);
        tv.setText("import java.util.Scanner;\n" +
                "\n" +
                "\n" +
                "public class Buddy {\n" +
                "//  BUDDY SYSTEM CODE\n" +
                "\n" +
                "\n" +
                "int tree[]=new int[2050];\n" +
                "int i,j,k;\n" +
                "\n" +
                "\n" +
                "\n" +
                "void segmentalloc(int totsize,int request)\n" +
                "{\n" +
                "int flevel=0,size;\n" +
                "              size=totsize;\n" +
                "if(request>totsize)\n" +
                "{\n" +
                "\tSystem.out.println(\"%c  R E S U L T  :  \"+2);\n" +
                "\tSystem.out.println(\"*  The system don't have enough free memory\");\n" +
                "\n" +
                "return;\n" +
                "}\n" +
                "while(true)\n" +
                "{\n" +
                "if(request<size && request>(size/2))\n" +
                "break;\n" +
                "else\n" +
                "{\n" +
                "size/=2;\n" +
                "flevel++;\n" +
                "}\n" +
                "}\n" +
                "for(i=power(2,flevel)-1;i<=(power(2,flevel+1)-2);i++)\n" +
                "if(tree[i]==0 && place(i))\n" +
                "{\n" +
                "tree[i]=request;\n" +
                "makedivided(i);\n" +
                "System.out.println(\"Result    :     Successful Allocation\");\n" +
                "break;\n" +
                "}\n" +
                "if(i==power(2,flevel+1)-1)\n" +
                "{\n" +
                "\tSystem.out.println(\"\t%c    Result  :  \");\n" +
                "\tSystem.out.println(\"*  The system don't have enough free memory\");\n" +
                "\tSystem.out.println(\"*  Suggession  :  Go for VIRTUAL Memory Mode\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "void makedivided(int node)\n" +
                "{\n" +
                "while(node!=0)\n" +
                "{\n" +
                "node=node%2==0?(node-1)/2:node/2;\n" +
                "tree[node]=1;\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "Boolean place(int node)\n" +
                "{\n" +
                "while(node!=0)\n" +
                "{\n" +
                "node=node%2==0?(node-1)/2:node/2;\n" +
                "if(tree[node]>1)\n" +
                "return false;\n" +
                "}\n" +
                "return true;\n" +
                "}\n" +
                "\n" +
                "void makefree(int request)\n" +
                "{\n" +
                "int node=0;\n" +
                "while(true) //edited\n" +
                "{\n" +
                "if(tree[node]==request)\n" +
                "break;\n" +
                "else\n" +
                "node++;\n" +
                "}\n" +
                "tree[node]=0;\n" +
                "while(node!=0)\n" +
                "{\n" +
                "if(tree[node%2==0?node-1:node+1]==0 && tree[node]==0)\n" +
                "{\n" +
                "tree[node%2==0?(node-1)/2:node/2]=0;\n" +
                "node=node%2==0?(node-1)/2:node/2;\n" +
                "}\n" +
                "else break;\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "int power(int x,int y)\n" +
                "{\n" +
                "int z,ans;\n" +
                "if(y==0) return 1;\n" +
                "ans=x;\n" +
                "for(z=1;z<y;z++)\n" +
                "ans*=x;\n" +
                "return ans;\n" +
                "}\n" +
                "\n" +
                "void printing(int totsize,int node)\n" +
                "{\n" +
                "int permission=0,llimit,ulimit,tab;\n" +
                "if(node==0)\n" +
                "permission=1;\n" +
                "else if(node%2==0)\n" +
                "permission=tree[(node-1)/2]==1?1:0;\n" +
                "else\n" +
                "permission=tree[node/2]==1?1:0;\n" +
                "if(permission==1)\n" +
                "{\n" +
                "llimit=ulimit=tab=0;\n" +
                "while(true)\n" +
                "{\n" +
                "if(node>=llimit && node<=ulimit)\n" +
                "break;\n" +
                "else\n" +
                "{\n" +
                "tab++;\n" +
                "System.out.println(\"       \");\n" +
                "llimit=ulimit+1;\n" +
                "ulimit=2*ulimit+2;\n" +
                "}\n" +
                "}\n" +
                "System.out.println(\"  \"+totsize/power(2,tab));\n" +
                "if(tree[node]>1)\n" +
                "\tSystem.out.println(\"---> Allocated %d\"+tree[node]);\n" +
                "else if(tree[node]==1)\n" +
                "\tSystem.out.println(\"---> Divided\");\n" +
                "else System.out.println(\"---> Free\");\n" +
                "printing(totsize,2*node+1);\n" +
                "printing(totsize,2*node+2);\n" +
                "}\n" +
                "}\n" +
                "\tpublic Buddy() {\n" +
                "\t\t// TODO Auto-generated constructor stub\n" +
                "\t}\n" +
                "\tpublic static void main(String args[]){\n" +
                "\t\tBuddy b=new Buddy();\n" +
                "\t\tint totsize,cho,req,i;\n" +
                "\t\tScanner sc=new Scanner(System.in);\n" +
                "\t\tfor(i=0;i<80;i++) ///* System.out.println(5) */ \n" +
                "\t\t\t;\n" +
                "\t\tSystem.out.println(\" B U D D Y   S Y S T E M  R E Q U I R E M E N TS\");\n" +
                "\t\tfor(i=0;i<80;i++) /* System.out.println(\"\"+5) */ ;\n" +
                "\t\tSystem.out.println(\"*  Enter the Size of the memory  :  \");\n" +
                "\t\ttotsize=sc.nextInt();\n" +
                "\t\t\n" +
                "\t\twhile(true)\n" +
                "\t\t{\n" +
                "\t\tfor(i=0;i<80;i++) /* System.out.println(5) */;\n" +
                "\t\tSystem.out.println(\"   B U D D Y   S Y S T E M\");\n" +
                "\t\tfor(i=0;i<80;i++) /* System.out.println(5) */;\n" +
                "\t\tSystem.out.println(\"*  1)   Locate the process into the Memory\");\n" +
                "\t\tSystem.out.println(\"*  2)   Remove the process from Memory\");\n" +
                "\t\tSystem.out.println(\"*  3)   Tree structure for Memory allocation Map\");\n" +
                "\t\tSystem.out.println(\"*  4)   Exit\");\n" +
                "\t\tfor(i=0;i<80;i++) /* System.out.println(5) */;\n" +
                "\t\tSystem.out.println(\"*  Enter your choice  :  \");\n" +
                "\t\tcho=sc.nextInt();\n" +
                "\t\tswitch(cho)\n" +
                "\t\t{\n" +
                "\t\tcase 1:\n" +
                "\t\t\n" +
                "\t\t\tSystem.out.println(\"\");\n" +
                "\t\tfor(i=0;i<80;i++) /* System.out.println(5) */;\n" +
                "\t\tSystem.out.println(\"\");\n" +
                "\t\tSystem.out.println(\"M E M O R Y   A L L O C A T I O N\");\n" +
                "\t\tfor(i=0;i<80;i++) /* System.out.println(5) */;\n" +
                "\t\tSystem.out.println(\"*  Enter the Process size  : \");\n" +
                "\t\treq=sc.nextInt();\n" +
                "\t\tb.segmentalloc(totsize,req);\n" +
                "\t\tbreak;\n" +
                "\t\tcase 2:\n" +
                "\t\tSystem.out.println(\"\");\n" +
                "\t\tSystem.out.println(\"\");\n" +
                "\t\tSystem.out.println(\"M E M O R Y   D E A L L O C A T I ON\");\n" +
                "\t\tfor(i=0;i<80;i++) /* System.out.println(5) */;\n" +
                "\t\tSystem.out.println(\"*  Enter the process size  :  \");\n" +
                "\t\treq=sc.nextInt();\n" +
                "\t\tb.makefree(req);\n" +
                "\t\tbreak;\n" +
                "\t\tcase 3:\n" +
                "\t\t\n" +
                "\t\t\tSystem.out.println(\"\");\n" +
                "\t\tfor(i=0;i<80;i++) /* System.out.println(5) */;\n" +
                "\t\tSystem.out.println(\"M E M O R Y   A L L O C A T I O N   M A P\");\n" +
                "\t\tfor(i=0;i<80;i++) /* System.out.println(5) */;\n" +
                "\t\tSystem.out.println(\"\");\n" +
                "\t\tb.printing(totsize,0);\n" +
                "\t\tSystem.out.println(\"\");\n" +
                "\t\tfor(i=0;i<80;i++) /* System.out.println(5) */;\n" +
                "\t\tbreak;\n" +
                "\t\tdefault:\n" +
                "\t\treturn;\n" +
                "\t\t}\n" +
                "\t\t}\n" +
                "\t\t}\n" +
                "\n" +
                "\t}\n" +
                "\n" +
                "\n");

    }
}
