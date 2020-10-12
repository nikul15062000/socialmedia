package in.eratech.socialmediamarketingpostmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.robertlevonyan.views.chip.Chip;
import com.theartofdev.edmodo.cropper.CropImageActivity;

import yuku.ambilwarna.AmbilWarnaDialog;

public class GradientBackgroundActivity extends AppCompatActivity {

    public static Bitmap gradiant_img;
    Boolean checkarrow =  false;
    Chip fast_color,second_color;
    int currentColor1 = Color.RED,currentColor = Color.GREEN;
    RelativeLayout background;
    int coorf,coorss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradient_background);
        getSupportActionBar().hide();
        fast_color=findViewById(R.id.fast_color);
        second_color=findViewById(R.id.second_color);
        background=findViewById(R.id.backgound);

        setGradientDemo();

        fast_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(false);
            }
        });
        second_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog1(false);
            }
        });

    }

    public void g_back(View view) {

    }
    private void openDialog(boolean supportAlpha) {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, currentColor, supportAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                currentColor = color;
                fast_color.setChipBackgroundColor(color);
                setGradientDemo();
            }
        });
        dialog.show();
    }
    private void openDialog1(boolean supportAlpha) {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, currentColor1, supportAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                currentColor1 = color;
                second_color.setChipBackgroundColor(color);
                setGradientDemo();
            }
        });
        dialog.show();
    }

    public void setGradientDemo(){
        if (checkarrow == false) {
            GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{currentColor, currentColor1});
            background.setBackgroundDrawable(drawable);
        } else {
            GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{currentColor1, currentColor});
            background.setBackgroundDrawable(drawable);
        }
    }

    public void arrow(View view) {
         coorf=fast_color.getChipBackgroundColor();
         coorss=second_color.getChipBackgroundColor();
         if (checkarrow == false){
             checkarrow = true;
         } else {
             checkarrow = false;
         }
        setGradientDemo();
         fast_color.setChipBackgroundColor(coorss);
        second_color.setChipBackgroundColor(coorf);
    }

    public void done(View view) {

        background.setDrawingCacheEnabled(true);
        gradiant_img = Bitmap.createBitmap(background.getDrawingCache());
        startActivity(new Intent(GradientBackgroundActivity.this, BackgroundCropActivity.class));

    }
}