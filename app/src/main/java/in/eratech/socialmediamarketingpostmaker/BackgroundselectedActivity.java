package in.eratech.socialmediamarketingpostmaker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import in.eratech.socialmediamarketingpostmaker.Adapter.CustomBackgroundAdapter;
import yuku.ambilwarna.AmbilWarnaDialog;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class BackgroundselectedActivity extends AppCompatActivity {

    public static Bitmap bmp;
    RecyclerView background_rece;
    ImageView back;
    LinearLayout color, gallery, gradient;
    int[] img = new int[]{R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.imageeeee, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.imageeeee, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.imageeeee};

     int currentColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backgroundselected);
        getSupportActionBar().hide();
        background_rece = findViewById(R.id.background_rece);
        back = findViewById(R.id.back);
        color = findViewById(R.id.color);
        gallery = findViewById(R.id.gallery);
        gradient = findViewById(R.id.gradient);

        CustomBackgroundAdapter customBackgroundAdapter = new CustomBackgroundAdapter(BackgroundselectedActivity.this, img);
        RecyclerView.LayoutManager manager = new GridLayoutManager(BackgroundselectedActivity.this, 3);
        background_rece.setLayoutManager(manager);
        background_rece.setAdapter(customBackgroundAdapter);

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(false);
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
//        startActivityForResult(intent, 1);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        gradient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BackgroundselectedActivity.this,GradientBackgroundActivity.class);
                startActivity(intent);
            }
        });
    }

    private void openDialog(boolean supportAlpha) {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, currentColor, supportAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                currentColor = color;
                bmp=Bitmap.createBitmap(400,800, Bitmap.Config.ARGB_8888);
                Canvas canvas=new Canvas(bmp);
                canvas.drawColor(color);
                Intent intent = new Intent(BackgroundselectedActivity.this, CropimageActivity.class);
//               intent.putExtra("color",color);
                intent.putExtra("check",3);
                startActivity(intent);
                //layoutcolor.setBackgroundColor(color);
            }
        });
        dialog.show();
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) ;
        {
            if (requestCode == 1) {
                Uri uri = data.getData();
                Intent intent = new Intent(BackgroundselectedActivity.this, BackgroundCropActivity.class);
                intent.putExtra("backgroundimage", uri.toString());
                intent.putExtra("checks",2);
                startActivity(intent);
                finish();
                // Glide.with(EditImageActivity.this).load(uri).into(ic_saveimage);
                // ic_saveimage.setOnTouchListener(new MultiTouchListener());
            }
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}