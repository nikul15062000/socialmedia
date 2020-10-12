package in.eratech.socialmediamarketingpostmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.theartofdev.edmodo.cropper.CropImageView;

public class BackgroundCropActivity extends AppCompatActivity {
    CropImageView mCropImageView;
    Uri imageUri,backgroundimages;
    public static Bitmap croppedback;
    ImageButton done;
    LinearLayout layout;
    int[] img = new int[]{R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.imageeeee,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.imageeeee,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.imageeeee};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_crop);
        getSupportActionBar().hide();
        mCropImageView = findViewById(R.id.mCropImageView);
        done = findViewById(R.id.done);
        layout = findViewById(R.id.layout);
        Intent intent = getIntent();
        int str=intent.getIntExtra("checks",0);
        if (str==1){
            imageUri = Uri.parse(getIntent().getStringExtra("passd"));
            mCropImageView.setImageUriAsync(imageUri);
        }
        else if (str==2){
            backgroundimages=Uri.parse(getIntent().getStringExtra("backgroundimage"));
            mCropImageView.setImageUriAsync(backgroundimages);
        }
        else if(str==3){
//            int i=intent.getIntExtra("color",0);
            mCropImageView.setImageBitmap(EditImageActivity.bmp);
        }
        else if (str==4){
            int i=intent.getIntExtra("imagedata",0);
            mCropImageView.setImageResource(img[i]);
        }
        else {
            mCropImageView.setImageBitmap(GradientBackgroundActivity.gradiant_img);
        }
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                croppedback = mCropImageView.getCroppedImage();
                Intent intent = new Intent(BackgroundCropActivity.this, EditImageActivity.class);
                startActivity(intent);
                onBackPressed();
            }
        });
    }
    public void cropback(View view) {
        Animatoo.animateZoom(BackgroundCropActivity.this);
        finish();
    }
}