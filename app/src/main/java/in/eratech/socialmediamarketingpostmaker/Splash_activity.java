package in.eratech.socialmediamarketingpostmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.robertlevonyan.views.chip.Chip;
import com.valdesekamdem.library.mdtoast.MDToast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Splash_activity extends AppCompatActivity {
    private Chip cancel, exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        Button button = (Button) findViewById(R.id.button);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button.startAnimation(myAnim);

    }


    public void didTapButton(View view) {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            connected = true;
            Intent intent = new Intent(Splash_activity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            connected = false;
            onBackPressed();
           // Toast.makeText(this, "network not open", Toast.LENGTH_SHORT).show();
            MDToast mdToast = MDToast.makeText(Splash_activity.this, "No Internet Connection",2000,3);
            mdToast.show();

        }
    }
    @Override
    public void onBackPressed() {
        final Dialog dialog = new Dialog(Splash_activity.this,R.style.dilogstyle);
        dialog.setContentView(R.layout.nointernet_dilog);
        cancel = dialog.findViewById(R.id.cancel1);
        exit = dialog.findViewById(R.id.exit);
        dialog.show();
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
