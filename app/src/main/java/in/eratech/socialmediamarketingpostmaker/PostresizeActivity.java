package in.eratech.socialmediamarketingpostmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import in.eratech.socialmediamarketingpostmaker.Adapter.CustomSizeAdapter;

public class PostresizeActivity extends AppCompatActivity {
RecyclerView customsizerec;
    int[] imagesize =new int[]{R.drawable.poster_1_1,R.drawable.poster_1_1,R.drawable.poster_16_9,R.drawable.poster_facebook_cover,R.drawable.poster_facebook_ad,R.drawable.instagram,R.drawable.poster_instagram_story,R.drawable.poster_whatsapp_story,R.drawable.poster_logo};
 String[] sizestexts=new String[]{"Custom","(1.1)","(16.9)","Facebook Cover","Facebook Ad","Instagram","Instagram Story","Whatsapp Story","Logo"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postresize);
        getSupportActionBar().hide();

        customsizerec=findViewById(R.id.ic_recyclesize);
        CustomSizeAdapter customSizeAdapter=new CustomSizeAdapter(this,imagesize,sizestexts);
        RecyclerView.LayoutManager manager=new GridLayoutManager(this,3);
        customsizerec.setLayoutManager(manager);
        customsizerec.setAdapter(customSizeAdapter);
    }

    public void backsizetohome(View view) {
        onBackPressed();
        finish();
    }

}