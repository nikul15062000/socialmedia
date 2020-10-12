package in.eratech.socialmediamarketingpostmaker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.robertlevonyan.views.chip.Chip;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import in.eratech.socialmediamarketingpostmaker.Adapter.CustomAdapter;
import in.eratech.socialmediamarketingpostmaker.Adapter.CustomChipsAdapter;


public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] name = new String[]{"poster", "dPoster"};
    int[] image = new int[]{R.drawable.smileydemo, R.drawable.fooddemo};
    RecyclerView chipsrecyclerview;
    String[] chipsname = new String[]{"#Offer Sale", "#Facebook Cover", "#Food", "#Tour and Travels", "#Status", "#Instagram", "#Birthday", "#Certificate", "#Coronavirus", "#Flyer", "#Fitness", "#Electronics", "#Logo", "#Invitation", "#Spa", "#Wedding", "#Jewellery"};

    String[] permission = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private Chip cancel, exit;
    LinearLayout setting,user;
    ImageButton postersize;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Objects.requireNonNull(getSupportActionBar()).hide();
        //getSupportActionBar().hide();
        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(permission, 0);
        }

        recyclerView = findViewById(R.id.recycleview);
        setting=findViewById(R.id.setting);
        user=findViewById(R.id.user);
        postersize=findViewById(R.id.postersize);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent=new Intent(HomeActivity.this,SettingActivity.class);
               startActivity(intent);
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,SaveimageActivity.class);
                startActivity(intent);
            }
        });

        postersize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,PostresizeActivity.class);
                startActivity(intent);
            }
        });
        //chips recycle button
        chipsrecyclerview = findViewById(R.id.chipsrecyclerview);
        CustomChipsAdapter customChipsAdapter = new CustomChipsAdapter(HomeActivity.this, chipsname);
        RecyclerView.LayoutManager manager1 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
        chipsrecyclerview.setLayoutManager(manager1);
        chipsrecyclerview.setAdapter(customChipsAdapter);

        CustomAdapter customAdapter = new CustomAdapter(HomeActivity.this, name, image);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(customAdapter);

//        //add
//        AdView adView = new AdView(this);
//        adView.setAdSize(AdSize.BANNER);
//        adView.setAdUnitId(getResources().getString(R.string.Banner_ad));
//        adView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);

    }

    @Override
    public void onBackPressed() {
             final Dialog dialog = new Dialog(HomeActivity.this,R.style.dilogstyle);
             dialog.setContentView(R.layout.exitapp_dilog);
             cancel = dialog.findViewById(R.id.cancel1);
             exit = dialog.findViewById(R.id.exit);
             dialog.show();
             cancel.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     dialog.dismiss();
                 }
             });
             exit.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     finish();
                 }
             });

    }

    public void share(View view) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "https://play.google.com/store/apps/details?id=app.poster.maker.postermaker.flyer.designer";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "App link");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share App Link Via :"));
    }

    public void webmoreapp(View view) {
        Intent i = new Intent(android.content.Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://play.google.com/store/search?q=pub%3A%20EraTech&c=apps&hl=en_IN"));
        startActivity(i);
    }

    public void templetcategary(View view) {
        Intent intent = new Intent(HomeActivity.this,TempletCategaryActivity.class);
        startActivity(intent);

    }



}