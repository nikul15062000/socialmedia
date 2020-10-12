package in.eratech.socialmediamarketingpostmaker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class CropimageActivity extends AppCompatActivity {
    CropImageView mCropImageView;
    Uri imageUri;
    public static Bitmap cropped;
    ImageButton done;
    private static Bitmap b;
    private static Canvas c;
    private Bitmap textBitmap;
    LinearLayout layout;
    int[] img = new int[]{R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.imageeeee,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.imageeeee,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.imageeeee};
    private StickerView mCurrentView;


    @RequiresApi
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cropimage);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        mCropImageView = findViewById(R.id.mCropImageView);
        done = findViewById(R.id.done);
        layout = findViewById(R.id.layout);

        Intent intent = getIntent();
        int str=intent.getIntExtra("check",0);
//        if (str==0){
//            imageUri = Uri.parse(getIntent().getStringExtra("pass"));
//            mCropImageView.setImageUriAsync(imageUri);
//        }
//        if (str==1){
//            int i=intent.getIntExtra("imagedata",0);
//            mCropImageView.setImageResource(img[i]);
//        }

         if (str==2){
            imageUri = Uri.parse(getIntent().getStringExtra("pass"));
            mCropImageView.setImageUriAsync(imageUri);
//            CropImage.activity(imageUri)
//                    .setMinCropResultSize(100,100)
//                    .setMaxCropResultSize(1000,1000)
//                    .start(this);

        }
        else if(str==3) {
            int i = intent.getIntExtra("color", 0);
            mCropImageView.setImageBitmap(BackgroundselectedActivity.bmp);
        } else {
//            mCropImageView.setImageBitmap(GradientBackgroundActivity.gradiant_img);
        }
     //   final   StickerView stickerView = new StickerView(CropimageActivity.this);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cropped = mCropImageView.getCroppedImage();
                // mCropImageView.setImageBitmap(cropped);
//            stickerView.setImageBitmap(cropped);
//           final StickerView stickerView =new StickerView(CropimageActivity.this);
//            stickerView.setImageBitmap(cropped);
//            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
//            EditImageActivity.fream_stic.addView(stickerView, params);
//            setCurrentEdit(stickerView);
//            stickerView.setOperationListener(new StickerView.OperationListener() {
//                @Override
//                public void onDeleteClick() {
//                    EditImageActivity.fream_stic.removeView(stickerView);
//                }
//                @Override
//                public void onEdit(StickerView stickerView) {
//                    Stickermatirialadapter.mCurrentView.setInEdit(false);
//                    Stickermatirialadapter.mCurrentView = stickerView;
//                    Stickermatirialadapter.mCurrentView.setInEdit(true);
//                }
//                @Override
//                public void onTop(StickerView stickerView) {
//
//                }
//            });
                Intent intent = new Intent(CropimageActivity.this, EditImageActivity.class);
                startActivity(intent);
                onBackPressed();
////                ImageView imageView1 = new ImageView(CropimageActivity.this);
////               // textview.buildDrawingCache();
////               // Bitmap bitmap = textview.getDrawingCache();
////                imageView1.setImageBitmap(cropped);
////                textBitmap = loadBitmapFromView(imageView1);
////                textBitmap = CropBitmapTransparency(textBitmap);
////
////                ((InputMethodManager) CropimageActivity.this.getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(EditImageActivity.ic_saveimage.getWindowToken(), 0);
////                final CustomTextView stickerTextView = new CustomTextView(CropimageActivity.this);
////                stickerTextView.setBitmap(textBitmap);
////                FrameLayout.LayoutParams lp1 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER);
////                EditImageActivity.fream_stic.addView(stickerTextView, lp1);
////                setCurrentEdit(stickerTextView);
////                stickerTextView.setOperationListener(new CustomTextView.OperationListener() {
////                    @Override
////                    public void onDeleteClick() {
////                        EditImageActivity.fream_stic.removeView(stickerTextView);
////                    }
////                    @Override
////                    public void onEdit(CustomTextView CustomTextView) {
////                        cCurrentView.setInEdit(false);
////                        cCurrentView = CustomTextView;
////                        cCurrentView.setInEdit(true);
////                    }
////                    @Override
////                    public void onTop(CustomTextView CustomTextView) {
////
////                    }
////                });
////                setResult(RESULT_OK);
////                finish();
            }
        });
    }
    private void setCurrentEdit(StickerView stickerView) {
        if (mCurrentView != null) {
            mCurrentView.setInEdit(false);
        }
        mCurrentView = stickerView;
        stickerView.setInEdit(true);
    }
    public void onCropImageClick(View view) {

    }
    public void cropback(View view) {
        Intent intent = new Intent(CropimageActivity.this, EditImageActivity.class);
        startActivity(intent);
        onBackPressed();
        finish();
    }
    @Override
    public void onBackPressed() {
        Animatoo.animateZoom(CropimageActivity.this);
        finish();
    }

//    private void setCurrentEdit(StickerView CustomTextView) {
//        if (cCurrentView != null) {
//            cCurrentView.setInEdit(false);
//        }
//        cCurrentView = CustomTextView;
//        CustomTextView.setInEdit(true);
//    }

    Bitmap CropBitmapTransparency(Bitmap sourceBitmap) {
        int minX = sourceBitmap.getWidth();
        int minY = sourceBitmap.getHeight();
        int maxX = -1;
        int maxY = -1;
        for (int y = 0; y < sourceBitmap.getHeight(); y++) {
            for (int x = 0; x < sourceBitmap.getWidth(); x++) {
                int alpha = (sourceBitmap.getPixel(x, y) >> 24) & 255;
                if (alpha > 0)   // pixel is not 100% transparent
                {
                    if (x < minX)
                        minX = x;
                    if (x > maxX)
                        maxX = x;
                    if (y < minY)
                        minY = y;
                    if (y > maxY)
                        maxY = y;
                }
            }
        }
        if ((maxX < minX) || (maxY < minY))
            return null; // Bitmap is entirely transparent

        // crop bitmap to non-transparent area and return:
        return Bitmap.createBitmap(sourceBitmap, minX, minY, (maxX - minX) + 1, (maxY - minY) + 1);
    }

    public static Bitmap loadBitmapFromView(View v) {
        if (v.getMeasuredHeight() <= 0) {
            v.measure(-2, -2);
            b = Bitmap.createBitmap(v.getMeasuredWidth(), v.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            c = new Canvas(b);
            v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
            v.draw(c);
            return b;
        }
        b = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(c);
        return b;
    }
}