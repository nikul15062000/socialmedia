package in.eratech.socialmediamarketingpostmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import in.eratech.socialmediamarketingpostmaker.Adapter.TempletAdapter;

public class TempletCategaryActivity extends AppCompatActivity {

    RecyclerView rece_templet,templetrecycleview,templet2recycleview,templet3recycleview,templet4recycleview;

    int[] img = new int[]{R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.imageeeee};
    int[] img1 = new int[]{R.drawable.image2, R.drawable.imageeeee, R.drawable.image2, R.drawable.image1};
    int[] img2 = new int[]{R.drawable.imageeeee, R.drawable.image3, R.drawable.image1, R.drawable.image2};
    int[] img3 = new int[]{R.drawable.image1, R.drawable.imageeeee, R.drawable.image2, R.drawable.image3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templet_categary);
        getSupportActionBar().hide();
        templetrecycleview=findViewById(R.id.templetrecycleview);
        templet2recycleview=findViewById(R.id.templet2recycleview);
        templet3recycleview=findViewById(R.id.templet3recycleview);
        templet4recycleview=findViewById(R.id.templet4recycleview);

        TempletAdapter templetAdapter=new TempletAdapter(TempletCategaryActivity.this,img);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(TempletCategaryActivity.this,RecyclerView.HORIZONTAL,false);
        templetrecycleview.setAdapter(templetAdapter);
        templetrecycleview.setLayoutManager(manager);


        TempletAdapter templetAdapter1=new TempletAdapter(TempletCategaryActivity.this,img1);
        RecyclerView.LayoutManager manager1=new LinearLayoutManager(TempletCategaryActivity.this,RecyclerView.HORIZONTAL,false);
        templet2recycleview.setAdapter(templetAdapter1);
        templet2recycleview.setLayoutManager(manager1);


        TempletAdapter templetAdapter2=new TempletAdapter(TempletCategaryActivity.this,img2);
        RecyclerView.LayoutManager manager2=new LinearLayoutManager(TempletCategaryActivity.this,RecyclerView.HORIZONTAL,false);
        templet3recycleview.setAdapter(templetAdapter2);
        templet3recycleview.setLayoutManager(manager2);


        TempletAdapter templetAdapter4=new TempletAdapter(TempletCategaryActivity.this,img3);
        RecyclerView.LayoutManager manager4=new LinearLayoutManager(TempletCategaryActivity.this,RecyclerView.HORIZONTAL,false);
        templet4recycleview.setAdapter(templetAdapter4);
        templet4recycleview.setLayoutManager(manager4);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateInAndOut(TempletCategaryActivity.this);
        finish();
    }
}