package in.eratech.socialmediamarketingpostmaker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.robertlevonyan.views.chip.Chip;

import java.util.ArrayList;
import java.util.List;

import in.eratech.socialmediamarketingpostmaker.Adapter.FontPattrenAdapter;
import in.eratech.socialmediamarketingpostmaker.Adapter.FontStyleAdapter;
import in.eratech.socialmediamarketingpostmaker.Modalclass.PATTERN;

public class TextEditActivity extends AppCompatActivity {
    private Button back_text;
    private FrameLayout text;
    private TextView frame;
    private ImageView size;
    private FrameLayout seekbarframe;
    private SeekBar seekbar;
    private Chip seekbar_done;
    private FrameLayout frame_fontstyle;
    private ImageView liner_style;
    private GridView grid_fontstyle;
    int p[] = new int[]{R.drawable.pattern_01, R.drawable.pattern_02, R.drawable.pattern_03, R.drawable.pattern_04, R.drawable.pattern_05,
            R.drawable.pattern_06, R.drawable.pattern_07, R.drawable.pattern_08, R.drawable.pattern_09, R.drawable.pattern_10};
    List<PATTERN> list = new ArrayList<>();
    private ImageView pattern;
    private FrameLayout frame_pattren;
    private GridView grid_pattern;
    private ImageView liner_blur;
    private FrameLayout frame_blur;
    private String text123;
    private GridView grid_color;
    private ImageView liner_color;
    private int Selectedcolor = Color.WHITE;
    private FrameLayout frame_color;
    private Button done;
    private static Bitmap b;
    private static Canvas c;
    private Bitmap textBitmap;
    private int i;
    private Bitmap bitmap;
    private Typeface typeface;
    private Shader shader;
    ArrayList<View> mViews = new ArrayList<>();
    public static CustomTextView cCurrentView;
    private int flag;
    private Chip blurdone,colordone,fontstyle_done,pattren_done;

    public static int HSVColor(float hue, float saturation, float black) {
        int color = Color.HSVToColor(255, new float[]{hue, saturation, black});
        return color;
    }
    public static ArrayList HSVColors() {
        ArrayList<Integer> colors = new ArrayList<>();

        // Loop through hue channel, saturation and light full
        for (int h = 0; h <= 360; h += 20) {
            colors.add(HSVColor(h, 1, 1));
        }

        // Loop through hue channel, different saturation and light full
        for (int h = 0; h <= 360; h += 20) {
            colors.add(HSVColor(h, .25f, 1));
            colors.add(HSVColor(h, .5f, 1));
            colors.add(HSVColor(h, .75f, 1));
        }

        // Loop through hue channel, saturation full and light different
        for (int h = 0; h <= 360; h += 20) {
            //colors.add(createColor(h, 1, .25f));
            colors.add(HSVColor(h, 1, .5f));
            colors.add(HSVColor(h, 1, .75f));
        }

        // Loop through the light channel, no hue no saturation
        // It will generate gray colors
        for (float b = 0; b <= 1; b += .10f) {
            colors.add(HSVColor(0, 0, b));
        }
        return colors;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_edit);
        getSupportActionBar().hide();
        final ArrayList colors = HSVColors();

        //font style
        frame_fontstyle = (FrameLayout) findViewById(R.id.frame_fontstyle);
        liner_style = (ImageView) findViewById(R.id.liner_style);
        grid_fontstyle = (GridView) findViewById(R.id.grid_fontstyle);

        liner_style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frame_fontstyle.getVisibility() == View.GONE) {
                    frame_fontstyle.setVisibility(View.VISIBLE);
                    seekbarframe.setVisibility(View.GONE);
                    frame_pattren.setVisibility(View.GONE);
                    frame_blur.setVisibility(View.GONE);
                    frame_color.setVisibility(View.GONE);
                } else {
                    frame_fontstyle.setVisibility(View.GONE);
                }
                FontStyleAdapter adapter = new FontStyleAdapter(TextEditActivity.this);
                grid_fontstyle.setAdapter(adapter);
            }
        });

        //Pattren
        pattern = (ImageView) findViewById(R.id.pattern);
        frame_pattren = (FrameLayout) findViewById(R.id.frame_pattren);
        grid_pattern = (GridView) findViewById(R.id.grid_pattern);
        pattern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frame_pattren.getVisibility() == View.GONE) {
                    frame_pattren.setVisibility(View.VISIBLE);
                    seekbarframe.setVisibility(View.GONE);
                    frame_fontstyle.setVisibility(View.GONE);
                    frame_blur.setVisibility(View.GONE);
                    frame_color.setVisibility(View.GONE);
                } else {
                    frame_pattren.setVisibility(View.GONE);
                }
                setPattren();
                FontPattrenAdapter adapter = new FontPattrenAdapter(TextEditActivity.this, list);
                grid_pattern.setAdapter(adapter);
            }

        });

        //back
        back_text = (Button) findViewById(R.id.back_text);
        back_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(TextEditActivity.this, EditImageActivity.class);
//                startActivity(intent);
//                finish();
                onBackPressed();
                finish();
            }
        });

        //text size
        size = (ImageView) findViewById(R.id.size);

        seekbarframe = (FrameLayout) findViewById(R.id.seekbarframe);
        size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seekbarframe.getVisibility() == View.GONE) {
                    seekbarframe.setVisibility(View.VISIBLE);
                    frame_fontstyle.setVisibility(View.GONE);
                    frame_pattren.setVisibility(View.GONE);
                    frame_blur.setVisibility(View.GONE);
                    frame_color.setVisibility(View.GONE);
                } else {
                    seekbarframe.setVisibility(View.GONE);
                }
                seekbar = (SeekBar) findViewById(R.id.seekbar);
                seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    int p = 0;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        p = progress;
                        frame.setTextSize(p);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        if (p < 30) {
                            p = 30;
                            seekbar.setProgress(p);
                        }
                    }
                });
            }
        });
        seekbar_done = (Chip) findViewById(R.id.seekbar_done);
        seekbar_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seekbarframe.getVisibility() == View.GONE) {
                    seekbarframe.setVisibility(View.VISIBLE);
                } else {
                    seekbarframe.setVisibility(View.GONE);
                }
            }
        });
        pattren_done = (Chip) findViewById(R.id.pattren_done);
        pattren_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frame_pattren.getVisibility() == View.GONE) {
                    frame_pattren.setVisibility(View.VISIBLE);
                } else {
                    frame_pattren.setVisibility(View.GONE);
                }
            }
        });


        //color
        frame_color = (FrameLayout) findViewById(R.id.frame_color);
        grid_color = (GridView) findViewById(R.id.grid_color);

        liner_color = (ImageView) findViewById(R.id.liner_color);
        colordone = (Chip) findViewById(R.id.colordone);
        colordone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frame_color.getVisibility() == View.GONE) {
                    frame_color.setVisibility(View.VISIBLE);
                } else {
                    frame_color.setVisibility(View.GONE);
                }
            }
        });
        liner_color.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (frame_color.getVisibility() == View.GONE) {
                    frame_color.setVisibility(View.VISIBLE);
                    seekbarframe.setVisibility(View.GONE);
                    frame_fontstyle.setVisibility(View.GONE);
                    frame_pattren.setVisibility(View.GONE);
                    frame_blur.setVisibility(View.GONE);
                } else {
                    frame_color.setVisibility(View.GONE);
                }
                ArrayAdapter adapter = new ArrayAdapter(TextEditActivity.this, R.layout.items, colors) {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        convertView = getLayoutInflater().inflate(R.layout.items, parent, false);
                        int color = (int) colors.get(position);
                        convertView.setBackgroundColor(color);
                        AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                        params.width = 80;
                        params.height = 80;
                        convertView.setLayoutParams(params);
                        return convertView;
                    }
                };
                grid_color.setAdapter(adapter);
                grid_color.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String text = frame.getText().toString();
                        Selectedcolor = (int) colors.get(position);
                        frame.setTextColor(Selectedcolor);

                    }
                });
            }
        });

        //Blur
        liner_blur = (ImageView) findViewById(R.id.liner_blur);
        frame_blur = (FrameLayout) findViewById(R.id.frame_blur);
        liner_blur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frame_blur.getVisibility() == View.GONE) {
                    frame_blur.setVisibility(View.VISIBLE);
                    seekbarframe.setVisibility(View.GONE);
                    frame_fontstyle.setVisibility(View.GONE);
                    frame_pattren.setVisibility(View.GONE);

                    frame_color.setVisibility(View.GONE);
                } else {
                    frame_blur.setVisibility(View.GONE);
                }
            }
        });
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        blurdone = (Chip) findViewById(R.id.blurdone);
        fontstyle_done = (Chip) findViewById(R.id.fontstyle_done);
        fontstyle_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (frame_fontstyle.getVisibility() == View.GONE) {
                    frame_fontstyle.setVisibility(View.VISIBLE);
                } else {
                    frame_fontstyle.setVisibility(View.GONE);
                }
            }
        });
        blurdone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frame_blur.getVisibility() == View.GONE) {
                    frame_blur.setVisibility(View.VISIBLE);
                } else {
                    frame_blur.setVisibility(View.GONE);
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.noblur) {
                    frame.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                    frame.getPaint().setMaskFilter(null);
                    flag = 0;
                }
                if (checkedId == R.id.innerblur) {
                    applyBlurMaskFilter(frame, BlurMaskFilter.Blur.INNER);
                    flag = 1;
                }
                if (checkedId == R.id.normalblur) {
                    applyBlurMaskFilter(frame, BlurMaskFilter.Blur.NORMAL);
                    flag = 2;
                }
                if (checkedId == R.id.outerblur) {
                    applyBlurMaskFilter(frame, BlurMaskFilter.Blur.OUTER);
                    flag = 3;
                }
                if (checkedId == R.id.solidblur) {
                    applyBlurMaskFilter(frame, BlurMaskFilter.Blur.SOLID);
                    flag = 4;
                }
            }
        });

        final TextView textview = (TextView) findViewById(R.id.textview);
        done = (Button) findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st = frame.getText().toString();
                textview.setText(st);
                textview.setTextColor(Selectedcolor);

                textview.setTypeface(typeface);

                textview.getPaint().setShader(shader);

                if (flag == 0) {
                    textview.getPaint().setMaskFilter(null);
                }
                if (flag == 1) {
                    applyBlurMaskFilter(textview, BlurMaskFilter.Blur.INNER);
                }
                if (flag == 2) {
                    applyBlurMaskFilter(textview, BlurMaskFilter.Blur.NORMAL);
                }
                if (flag == 3) {
                    applyBlurMaskFilter(textview, BlurMaskFilter.Blur.OUTER);
                }
                if (flag == 4) {
                    applyBlurMaskFilter(textview, BlurMaskFilter.Blur.SOLID);
                }

                ImageView imageView1 = new ImageView(TextEditActivity.this);
                textview.buildDrawingCache();
                Bitmap bitmap = textview.getDrawingCache();
                imageView1.setImageBitmap(bitmap);
                textBitmap = loadBitmapFromView(imageView1);
                textBitmap = CropBitmapTransparency(textBitmap);


                ((InputMethodManager) TextEditActivity.this.getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(frame.getWindowToken(), 0);
                final CustomTextView stickerTextView = new CustomTextView(TextEditActivity.this);
                stickerTextView.setBitmap(textBitmap);
                FrameLayout.LayoutParams lp1 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER);
                EditImageActivity.fream_stic.addView(stickerTextView, lp1);
                setCurrentEdit(stickerTextView);
                stickerTextView.setOperationListener(new CustomTextView.OperationListener() {
                    @Override
                    public void onDeleteClick() {
                        mViews.remove(stickerTextView);
                        EditImageActivity.fream_stic.removeView(stickerTextView);
                    }

                    @Override
                    public void onEdit(CustomTextView CustomTextView) {
                        cCurrentView.setInEdit(false);
                        cCurrentView = CustomTextView;
                        cCurrentView.setInEdit(true);

                    }

                    @Override
                    public void onTop(CustomTextView CustomTextView) {

                    }
                });
                setResult(RESULT_OK);
                finish();
            }
        });

    }
    private void setCurrentEdit(CustomTextView CustomTextView) {
        if (cCurrentView != null) {
            cCurrentView.setInEdit(false);
        }
        cCurrentView = CustomTextView;
        CustomTextView.setInEdit(true);
    }

    private void applyBlurMaskFilter(TextView frame, BlurMaskFilter.Blur inner) {
        float radius = frame.getTextSize() / 10;
        BlurMaskFilter filter = new BlurMaskFilter(radius, inner);
        frame.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        frame.getPaint().setMaskFilter(filter);

    }

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

    private void setPattren() {
        for (int i = 0; i < 10; i++) {
            PATTERN pattern = new PATTERN();
            pattern.setImg(p[i]);
            list.add(pattern);
        }

    }

    public void open(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.custom_dialog_text, null);
        final EditText alert_edittext = (EditText) view1.findViewById(R.id.alert_edittext);
        Button alert_done = (Button) view1.findViewById(R.id.alert_done);

        final Dialog alert = new Dialog(this);
        alert.setContentView(view1);
        alert.setTitle("Add Text");
        alert_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text123 = alert_edittext.getText().toString();

                alert.cancel();
                frame = (TextView) findViewById(R.id.frame);
                frame.setText(text123);
            }
        });

        alert.show();

    }

    public void Pattren(int postion) {
        switch (postion) {

            case 0:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_01);
                shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                frame.setText(text123);
                frame.getPaint().setShader(shader);
                break;

            case 1:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_02);
                shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                frame.setText(text123);
                frame.getPaint().setShader(shader);
                break;

            case 2:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_03);
                shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                frame.setText(text123);
                frame.getPaint().setShader(shader);
                break;

            case 3:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_04);
                shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                frame.setText(text123);
                frame.getPaint().setShader(shader);
                break;

            case 4:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_05);
                shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                frame.setText(text123);
                frame.getPaint().setShader(shader);
                break;

            case 5:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_06);
                shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                frame.setText(text123);
                frame.getPaint().setShader(shader);
                break;

            case 6:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_07);
                shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                frame.setText(text123);
                frame.getPaint().setShader(shader);
                break;

            case 7:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_08);
                shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                frame.setText(text123);
                frame.getPaint().setShader(shader);
                break;

            case 8:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_09);
                shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                frame.setText(text123);
                frame.getPaint().setShader(shader);
                break;

            case 9:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_10);
                shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                frame.setText(text123);
                frame.getPaint().setShader(shader);
                break;

        }

    }

    public void TextStyle(int postion) {
        switch (postion) {

            case 0:
                typeface = Typeface.createFromAsset(getAssets(), "font/font1.ttf");
                frame.setTypeface(typeface);
                break;

            case 1:
                typeface = Typeface.createFromAsset(getAssets(), "font/font2.ttf");
                frame.setTypeface(typeface);
                break;

            case 2:
                typeface = Typeface.createFromAsset(getAssets(), "font/font3.ttf");
                frame.setTypeface(typeface);
                break;

            case 3:
                typeface = Typeface.createFromAsset(getAssets(), "font/font4.TTF");
                frame.setTypeface(typeface);
                break;

            case 4:
                typeface = Typeface.createFromAsset(getAssets(), "font/font5.ttf");
                frame.setTypeface(typeface);
                break;

            case 5:
                typeface = Typeface.createFromAsset(getAssets(), "font/font6.TTF");
                frame.setTypeface(typeface);
                break;

            case 6:
                typeface = Typeface.createFromAsset(getAssets(), "font/font7.ttf");
                frame.setTypeface(typeface);
                break;

            case 7:
                typeface = Typeface.createFromAsset(getAssets(), "font/font8.ttf");
                frame.setTypeface(typeface);
                break;

            case 8:
                typeface = Typeface.createFromAsset(getAssets(), "font/font9.ttf");
                frame.setTypeface(typeface);
                break;

            case 9:
                typeface = Typeface.createFromAsset(getAssets(), "font/font10.TTF");
                frame.setTypeface(typeface);
                break;

            case 10:
                typeface = Typeface.createFromAsset(getAssets(), "font/font11.ttf");
                frame.setTypeface(typeface);
                break;

            case 11:
                typeface = Typeface.createFromAsset(getAssets(), "font/font12.ttf");
                frame.setTypeface(typeface);
                break;

            case 12:
                typeface = Typeface.createFromAsset(getAssets(), "font/font14.TTF");
                frame.setTypeface(typeface);
                break;

            case 13:
                typeface = Typeface.createFromAsset(getAssets(), "font/font16.TTF");
                frame.setTypeface(typeface);
                break;

            case 14:
                typeface = Typeface.createFromAsset(getAssets(), "font/font17.ttf");
                frame.setTypeface(typeface);
                break;

            case 15:
                typeface = Typeface.createFromAsset(getAssets(), "font/font18.ttf");
                frame.setTypeface(typeface);
                break;

            case 16:
                typeface = Typeface.createFromAsset(getAssets(), "font/font19.ttf");
                frame.setTypeface(typeface);
                break;

            case 17:
                typeface = Typeface.createFromAsset(getAssets(), "font/font20.ttf");
                frame.setTypeface(typeface);
                break;

            case 18:
                typeface = Typeface.createFromAsset(getAssets(), "font/font21.ttf");
                frame.setTypeface(typeface);
                break;

        }

    }
}