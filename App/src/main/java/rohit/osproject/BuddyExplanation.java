package rohit.osproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BuddyExplanation extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddy_explanation);


        tv=(TextView)findViewById(R.id.btn);

        tv.setText("When allocating, and choosing among nodes of the same size, I always choose the left-most. Of course, this is not an essential of the algorithm.\n" +
                "\n" +
                "It's all HTML with heavy uses of style sheets; It looks good in Firefox, but I don't have time to try IE just now.\n" +
                "\n" +
                "Suppose we have 16K to manage. It starts as one large block:\n" +
                "\n" +
                "16K (free)\n" +
                "\n" +
                "Now, we have a request A for a block of 3.6k. We round up to 4K and perform two splits to create such a block.\n" +
                "\n" +
                "4K (A)\n" +
                "\n" +
                "4K (free)\n" +
                "\n" +
                "8K (free)\n" +
                "\n" +
                "Next, handle request B for 1.5K. This rounds up to 2, requiring another split:\n" +
                "\n" +
                "4K (A)\n" +
                "\n" +
                "2K (B)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "8K (free)\n" +
                "\n" +
                "Now service allocations of 1.2K (C), 1.9K (D) and 2.7K (E):\n" +
                "\n" +
                "4K (A)\n" +
                "\n" +
                "2K (B)\n" +
                "\n" +
                "2K (C)\n" +
                "\n" +
                "2K (D)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "4K (E)\n" +
                "\n" +
                "Of course, nodes are merged when possible. Suppose the C allocation is freed:\n" +
                "\n" +
                "4K (A)\n" +
                "\n" +
                "2K (B)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "2K (D)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "4K (E)\n" +
                "\n" +
                "Then, if B is also freed, the buddies are merged back into a larger node.\n" +
                "\n" +
                "4K (A)\n" +
                "\n" +
                "4K (free)\n" +
                "\n" +
                "2K (D)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "4K (E)\n" +
                "\n" +
                "However, it is only possible to join nodes which were previously split. For instance, suppose we process two more allocations, for 1.5K (F) and 1.6K (G), which will cause another split:\n" +
                "\n" +
                "4K (A)\n" +
                "\n" +
                "2K (G)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "2K (D)\n" +
                "\n" +
                "2K (F)\n" +
                "\n" +
                "4K (E)\n" +
                "\n" +
                "Then perhaps that D is freed:\n" +
                "\n" +
                "4K (A)\n" +
                "\n" +
                "2K (G)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "2K (F)\n" +
                "\n" +
                "4K (E)\n" +
                "\n" +
                "Now, even though there are two adjacent free blocks of the same size, they cannot be merged because they were not the result of splitting a larger block.\n" +
                "\n" +
                "Now suppose A is released:\n" +
                "\n" +
                "4K (free)\n" +
                "\n" +
                "2K (G)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "2K (F)\n" +
                "\n" +
                "4K (E)\n" +
                "\n" +
                "If G is then freed, it results in two merges.\n" +
                "\n" +
                "8K (free)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "2K (F)\n" +
                "\n" +
                "4K (E)\n" +
                "\n" +
                "And some more operations: allocate 6.8K (H), release E, allocate 850 bytes (I):\n" +
                "\n" +
                "8K (H)\n" +
                "\n" +
                "1K (I)\n" +
                "\n" +
                "1K (free)\n" +
                "\n" +
                "2K (F)\n" +
                "\n" +
                "4K (free)\n" +
                "\n" +
                "Allocate 610 bytes (J); allocate 1.6K (K); allocate 750 bytes (L); release H.\n" +
                "\n" +
                "8K (free)\n" +
                "\n" +
                "1K (I)\n" +
                "\n" +
                "1K (J)\n" +
                "\n" +
                "2K (F)\n" +
                "\n" +
                "2K (K)\n" +
                "\n" +
                "1K (L)\n" +
                "\n" +
                "1K (free)\n" +
                "\n" +
                "Allocate 3.9K (M); allocate (N) 1.7K; release L; release F;\n" +
                "\n" +
                "4K (M)\n" +
                "\n" +
                "2K (N)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "1K (I)\n" +
                "\n" +
                "1K (J)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "2K (K)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "Release K; allocate 670 bytes (P); release I.\n" +
                "\n" +
                "4K (M)\n" +
                "\n" +
                "2K (N)\n" +
                "\n" +
                "1K (P)\n" +
                "\n" +
                "1K (free)\n" +
                "\n" +
                "1K (free)\n" +
                "\n" +
                "1K (J)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "4K (free)\n" +
                "\n" +
                "Release N; release J.\n" +
                "\n" +
                "4K (M)\n" +
                "\n" +
                "2K (free)\n" +
                "\n" +
                "1K (P)\n" +
                "\n" +
                "1K (free)\n" +
                "\n" +
                "8K (free)\n");

    }
}
