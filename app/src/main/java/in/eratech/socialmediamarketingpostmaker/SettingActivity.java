package in.eratech.socialmediamarketingpostmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().hide();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateInAndOut(SettingActivity.this);
        finish();
    }


    public void myproject(View view) {
        Intent intent=new Intent(this,SaveimageActivity.class);
        startActivity(intent);
        finish();
    }

    public void shareapp(View view) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "https://play.google.com/store/apps/details?id=app.poster.maker.postermaker.flyer.designer";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "App link");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share App Link Via :"));
    }

    public void moreaapp(View view) {
        Intent i = new Intent(android.content.Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://play.google.com/store/search?q=pub%3A%20EraTech&c=apps&hl=en_IN"));
        startActivity(i);
    }

    public void exitapp(View view) {
        onBackPressed();

    }
}