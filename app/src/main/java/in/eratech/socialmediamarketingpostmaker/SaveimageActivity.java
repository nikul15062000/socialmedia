package in.eratech.socialmediamarketingpostmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.io.File;
import java.util.ArrayList;

import in.eratech.socialmediamarketingpostmaker.Adapter.Save_listAdapter;

public class SaveimageActivity extends AppCompatActivity {

    private ArrayList<String> images;
    ArrayList file;
    RecyclerView recycleviewsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saveimage);
        getSupportActionBar().hide();
        file = new ArrayList();

        recycleviewsave=findViewById(R.id.recycleviewsave);
        getvideo(Environment.getExternalStorageDirectory().getAbsolutePath()+"/SocialMediaPost/".toString());
        Save_listAdapter save_listAdapter=new Save_listAdapter(this, file);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recycleviewsave.setLayoutManager(manager);
        recycleviewsave.setAdapter(save_listAdapter);
    }
    void getvideo(String path) {
        File f = new File(path);
        File[] f1 = f.listFiles();

        for (int i = 0; i < f1.length; i++) {
            if (f1[i].isFile()) {
                if (f1[i].getAbsolutePath().toString().endsWith(".png")||f1[i].getAbsolutePath().toString().endsWith(".jpg")) {
                    file.add(f1[i].getAbsolutePath());

                }
            }

        }

    }
        @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateInAndOut(SaveimageActivity.this);

        finish();
    }
}