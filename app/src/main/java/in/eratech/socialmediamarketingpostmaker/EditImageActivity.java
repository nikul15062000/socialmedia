package in.eratech.socialmediamarketingpostmaker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.robertlevonyan.views.chip.Chip;
import com.theartofdev.edmodo.cropper.CropImageActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import in.eratech.socialmediamarketingpostmaker.Adapter.Artadapter;
import in.eratech.socialmediamarketingpostmaker.Adapter.Artmatirialadapter;
import in.eratech.socialmediamarketingpostmaker.Adapter.Backgroundadapter;
import in.eratech.socialmediamarketingpostmaker.Adapter.FilterAdapter;
import in.eratech.socialmediamarketingpostmaker.Adapter.StickerAdapter;
import in.eratech.socialmediamarketingpostmaker.Adapter.Stickermatirialadapter;
import in.eratech.socialmediamarketingpostmaker.Modalclass.Effects;
import in.eratech.socialmediamarketingpostmaker.MultiTouch.MultiTouchListener;
import yuku.ambilwarna.AmbilWarnaDialog;

public class EditImageActivity extends AppCompatActivity {

    public static ImageView edit_image;
    ImageView setcolor;
    public static ImageView ic_saveimage;
    public LinearLayout layout_art, layout_sticker,background;
    LinearLayout shape, line, birthday_cake, artanimal, business, christmas, doodle, element, geometry, love, number, quote;
    LinearLayout offer, sale, birthdarsticker, abcd, stickeranimal, bannersticker, car, cartoon, celebration, education, decoration, emoji, lovesticker, music, sport, word;
     LinearLayout savebtn, art, sticker, textdialog, filter, layout_filter, save ;
    public static LinearLayout layout_backgound;
    LinearLayout color,gallery,gradient;
    RecyclerView anim_rece, sticker_rece, iconsticker_rece, stickermatirial_rece, filtermatirial_rece,background_rece;
    int row_index = -1;
    private static final String TAG = "EditImageActivity";
    private Uri imageUri;
    Animation animation;
    public static int i = 0, i1 = 0, i2 = 0,i3 =0;
    String[] name = new String[]{"Shape", "Line", "Birthday", "Animal", "Business", "Caristmas", "Doodle", "Element", "Geometry", "Love", "Number", "Quote"};
    int[] icon_art = new int[]{R.drawable.shape, R.drawable.birthday_cake, R.drawable.animal, R.drawable.business, R.drawable.christmas, R.drawable.doodle, R.drawable.element, R.drawable.geometry, R.drawable.love, R.drawable.number, R.drawable.quote};
    String[] stickername = new String[]{"Offer", "Sale", "Birthday", "ABCD", "Animal", "Banner", "Car", "Cartoon", "Celebration", "Education", "Decoration", "Emoji", "Love", "Music", "Sport", "Word"};
    int[] icon_sticker = new int[]{R.drawable.sale, R.drawable.sale, R.drawable.brithdarsticker, R.drawable.abcd, R.drawable.animalsticker, R.drawable.banner, R.drawable.car, R.drawable.cartoon, R.drawable.celebration, R.drawable.education, R.drawable.decoration, R.drawable.emoji, R.drawable.lovesticker, R.drawable.music, R.drawable.sport, R.drawable.word};
    int[] imgsticker = new int[]{R.drawable.shape, R.drawable.birthday_cake, R.drawable.shape, R.drawable.birthday_cake, R.drawable.shape, R.drawable.birthday_cake};

    public static FrameLayout fream_stic;
    FrameLayout fream_stics;
    public static StickerView mCurrentView;
    private static Bitmap b;
    private static Canvas c;
    ArrayList<View> mViews = new ArrayList<>();

     public static FrameLayout frameclickhidesticker;
    int[] stickerimg = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a10};
    int[] stickerimg1 = new int[]{R.drawable.a12, R.drawable.a14, R.drawable.a15};
    int[] stickerimg2 = new int[]{R.drawable.a2, R.drawable.a10, R.drawable.a20};
    int[] stickerimg3 = new int[]{R.drawable.a12, R.drawable.a17, R.drawable.a19};
    int[] stickerimg4 = new int[]{R.drawable.a14, R.drawable.a16, R.drawable.a17};
    int[] stickerimg5 = new int[]{R.drawable.a18, R.drawable.a19, R.drawable.a20};
    int[] stickerimg6 = new int[]{R.drawable.a10, R.drawable.a15, R.drawable.a16, R.drawable.a17};
    int[] stickerimg7 = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a10, R.drawable.a16, R.drawable.a20};
    int[] stickerimg8 = new int[]{R.drawable.a1, R.drawable.a19, R.drawable.a20};
    int[] stickerimg10 = new int[]{R.drawable.a16, R.drawable.a18, R.drawable.a19, R.drawable.a20};
    int[] stickerimg9 = new int[]{R.drawable.a12, R.drawable.a14, R.drawable.a19, R.drawable.a20};
    int[] stickerimg11 = new int[]{R.drawable.a12, R.drawable.a14, R.drawable.a19, R.drawable.a20};

    //background
    int[] backgroundimg = new int[]{R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.imageeeee, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.imageeeee, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.imageeeee};
    int currentColor;
    public static Bitmap bmp;

    SeekBar seekbar;
    private int seekTransparent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_image);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        edit_image = findViewById(R.id.edit_image);
        setcolor = findViewById(R.id.setcolor);
        savebtn = findViewById(R.id.savebtn);
        ic_saveimage = findViewById(R.id.ic_saveimage);
        save = findViewById(R.id.save);
        //art
        anim_rece = findViewById(R.id.icon_rece);
        sticker_rece = findViewById(R.id.sticker_rece);
        //sticker
        iconsticker_rece = findViewById(R.id.iconsticker_rece);
        stickermatirial_rece = findViewById(R.id.stickermatirial_rece);

        //background
        background_rece = findViewById(R.id.background_rece);
        background = findViewById(R.id.background);
        color = findViewById(R.id.color);
        gallery = findViewById(R.id.gallery);
        gradient = findViewById(R.id.gradient);
        seekbar = findViewById(R.id.seekbar);
//        updateNow();
        seekbar.setOnSeekBarChangeListener(seekBarChangeListener);


        art = findViewById(R.id.art);
        sticker = findViewById(R.id.sticker);
        layout_art = findViewById(R.id.layout_art);
        layout_sticker = findViewById(R.id.layout_sticker);

        textdialog = findViewById(R.id.textdialog);
        fream_stic = findViewById(R.id.fream_stic);
        fream_stics = findViewById(R.id.fream_stics);

        filter = findViewById(R.id.filter);
        filtermatirial_rece = findViewById(R.id.filtermatirial_rece);
        layout_filter = findViewById(R.id.layout_filter);
        layout_backgound = findViewById(R.id.layout_backgound);
//art
        shape = findViewById(R.id.shape);
        line = findViewById(R.id.line);
        birthday_cake = findViewById(R.id.birthday_cake);
        artanimal = findViewById(R.id.artanimal);
        business = findViewById(R.id.business);
        christmas = findViewById(R.id.christmas);
        doodle = findViewById(R.id.doodle);
        element = findViewById(R.id.element);
        geometry = findViewById(R.id.geometry);
        love = findViewById(R.id.love);
        number = findViewById(R.id.number);
        quote = findViewById(R.id.quote);

        //sticker
        offer = findViewById(R.id.offer);
        sale = findViewById(R.id.sale);
        birthdarsticker = findViewById(R.id.birthdarsticker);
        abcd = findViewById(R.id.abcd);
        stickeranimal = findViewById(R.id.stickeranimal);
        bannersticker = findViewById(R.id.bannersticker);
        car = findViewById(R.id.car);
        cartoon = findViewById(R.id.cartoon);
        celebration = findViewById(R.id.celebration);
        education = findViewById(R.id.education);
        decoration = findViewById(R.id.decoration);
        emoji = findViewById(R.id.emoji);
        lovesticker = findViewById(R.id.lovesticker);
        music = findViewById(R.id.music);
        sport = findViewById(R.id.sport);
        word = findViewById(R.id.word);

// TODO in this framelayout in this id in save btn in set
        fream_stic.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (Stickermatirialadapter.mCurrentView != null) {
                    Stickermatirialadapter.mCurrentView.setInEdit(false);
                }
                if (Artmatirialadapter.mCurrentView != null) {
                    Artmatirialadapter.mCurrentView.setInEdit(false);
                }
                return false;
            }
        });

        //art
        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layout_sticker.getVisibility() == View.VISIBLE) {
                    layout_sticker.setVisibility(View.GONE);
                    i1 = 0;
                }
                if (layout_filter.getVisibility() == View.VISIBLE) {
                    layout_filter.setVisibility(View.GONE);
                    i2 = 0;
                }
                if (layout_backgound.getVisibility() == View.VISIBLE) {
                    layout_backgound.setVisibility(View.GONE);
                    i3 = 0;
                }
                if (i == 0) {
                    layout_art.setAnimation(AnimationUtils.loadAnimation(EditImageActivity.this, R.anim.dilogbtn_animation));
                    layout_art.setVisibility(View.VISIBLE);
                    i = 1;
                } else if (i == 1) {
                    layout_art.setVisibility(View.GONE);
                    i = 0;
                }
            }

        });
        //sticker
        sticker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layout_art.getVisibility() == View.VISIBLE) {
                    layout_art.setVisibility(View.GONE);
                    i = 0;
                }
                if (layout_filter.getVisibility() == View.VISIBLE) {
                    layout_filter.setVisibility(View.GONE);
                    i2 = 0;
                }
                if (layout_backgound.getVisibility() == View.VISIBLE) {
                    layout_backgound.setVisibility(View.GONE);
                    i3 = 0;
                }
                if (i1 == 0) {
                    layout_sticker.setAnimation(AnimationUtils.loadAnimation(EditImageActivity.this, R.anim.dilogbtn_animation));
                    layout_sticker.setVisibility(View.VISIBLE);
                    i1 = 1;
                } else if (i1 == 1) {
                    layout_sticker.setVisibility(View.GONE);
                    i1 = 0;
                }
            }
        });
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                updateNow();
            //    seekbar.setOnSeekBarChangeListener(seekBarChangeListener);
                if (layout_art.getVisibility() == View.VISIBLE) {
                    layout_art.setVisibility(View.GONE);
                    i = 0;
                }
                if (layout_filter.getVisibility() == View.VISIBLE) {
                    layout_filter.setVisibility(View.GONE);
                    i2 = 0;
                }
                if (layout_sticker.getVisibility() == View.VISIBLE) {
                    layout_sticker.setVisibility(View.GONE);
                    i1 = 0;
                }
                if (i3 == 0) {
                    layout_backgound.setAnimation(AnimationUtils.loadAnimation(EditImageActivity.this, R.anim.dilogbtn_animation));
                    layout_backgound.setVisibility(View.VISIBLE);
//                    updateNow();
                    i3 = 1;
                } else if (i3 == 1) {
                    layout_backgound.setVisibility(View.GONE);
                    i3 = 0;
                }
            }
        });
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layout_art.getVisibility() == View.VISIBLE) {
                    layout_art.setVisibility(View.GONE);
                    i = 0;
                }
                if (layout_sticker.getVisibility() == View.VISIBLE) {
                    layout_sticker.setVisibility(View.GONE);
                    i1 = 0;
                }
                if (layout_backgound.getVisibility() == View.VISIBLE) {
                    layout_backgound.setVisibility(View.GONE);
                    i3 = 0;
                }
                if (i2 == 0) {
                    layout_filter.setAnimation(AnimationUtils.loadAnimation(EditImageActivity.this, R.anim.dilogbtn_animation));
                    layout_filter.setVisibility(View.VISIBLE);
                    i2 = 1;
                } else if (i2 == 1) {
                    layout_filter.setVisibility(View.GONE);
                    i2 = 0;
                }

            }
        });

        //textedit
        textdialog.setOnClickListener(new View.OnClickListener() {
//            Chip done_dialog, canceltext_dialog;
//            EditText sticker_text;
            @Override
            public void onClick(View view) {
//                final Dialog dialog = new Dialog(EditImageActivity.this);
//                dialog.setContentView(R.layout.text_stickerdialog);
//
//                done_dialog = dialog.findViewById(R.id.done_dialog);
//                canceltext_dialog = dialog.findViewById(R.id.canceltext_dialog);
//                sticker_text = dialog.findViewById(R.id.sticker_text);
//                done_dialog.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        String name = sticker_text.getText().toString();
//                        if (name.trim().length() == 0) {
//                            sticker_text.setError("Enter your Text");
//                        } else {
//                            ImageView imageView = new ImageView(EditImageActivity.this);
//                            sticker_text.buildDrawingCache();
//                            Bitmap bitmap = sticker_text.getDrawingCache();
//                            imageView.setImageBitmap(bitmap);
//
//                            Bitmap textbitmep = loadBitmapFromView(imageView);
//                            textbitmep = CropBitmapTransparency(textbitmep);
//
//                            ((InputMethodManager) EditImageActivity.this.getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(sticker_text.getWindowToken(), 0);
//                            final CustomTextView stickerTextView = new CustomTextView(EditImageActivity.this);
//                            stickerTextView.setBitmap(textbitmep);
//                            FrameLayout.LayoutParams lp1 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER);
//                            fream_stic.addView(stickerTextView, lp1);
//                            setCurrentEdit(stickerTextView);
//
//                            stickerTextView.setOperationListener(new CustomTextView.OperationListener() {
//                                @Override
//                                public void onDeleteClick() {
//                                    mViews.remove(stickerTextView);
//                                    fream_stic.removeView(stickerTextView);
//                                }
//
//                                @Override
//                                public void onEdit(CustomTextView CustomTextView) {
//                                    cCurrentView.setInEdit(false);
//                                    cCurrentView = CustomTextView;
//                                    cCurrentView.setInEdit(true);
//                                }
//
//                                @Override
//                                public void onTop(CustomTextView CustomTextView) {
//                                }
//                            });
//
//                            fream_stic.setOnTouchListener(new View.OnTouchListener() {
//                                @Override
//                                public boolean onTouch(View view, MotionEvent motionEvent) {
//                                    if (cCurrentView != null) {
//                                        cCurrentView.setInEdit(false);
//                                    }
//                                    return false;
//                                }
//                            });
//                            dialog.dismiss();
//                        }
//                    }
//                });
//                dialog.show();
//                canceltext_dialog.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog.dismiss();
//                    }
//                });
            Intent intent=new Intent(EditImageActivity.this,TextEditActivity.class);
            startActivity(intent);
            }
        });

//art
        Artmatirialadapter artmatirialadapter = new Artmatirialadapter(EditImageActivity.this, stickerimg, layout_art);
        RecyclerView.LayoutManager manager1 = new GridLayoutManager(EditImageActivity.this, 3);
        sticker_rece.setAdapter(artmatirialadapter);
        sticker_rece.setLayoutManager(manager1);

        shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artmatirialadapter artmatirialadapter = new Artmatirialadapter(EditImageActivity.this, stickerimg, layout_art);
                RecyclerView.LayoutManager manager1 = new GridLayoutManager(EditImageActivity.this, 3);
                sticker_rece.setAdapter(artmatirialadapter);
                sticker_rece.setLayoutManager(manager1);
            }
        });
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artmatirialadapter artmatirialadapter = new Artmatirialadapter(EditImageActivity.this, stickerimg1, layout_art);
                RecyclerView.LayoutManager manager1 = new GridLayoutManager(EditImageActivity.this, 3);
                sticker_rece.setAdapter(artmatirialadapter);
                sticker_rece.setLayoutManager(manager1);
            }
        });
        birthday_cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artmatirialadapter artmatirialadapter = new Artmatirialadapter(EditImageActivity.this, stickerimg2, layout_art);
                RecyclerView.LayoutManager manager1 = new GridLayoutManager(EditImageActivity.this, 3);
                sticker_rece.setAdapter(artmatirialadapter);
                sticker_rece.setLayoutManager(manager1);
            }
        });
        artanimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artmatirialadapter artmatirialadapter = new Artmatirialadapter(EditImageActivity.this, stickerimg3, layout_art);
                RecyclerView.LayoutManager manager1 = new GridLayoutManager(EditImageActivity.this, 3);
                sticker_rece.setAdapter(artmatirialadapter);
                sticker_rece.setLayoutManager(manager1);
            }
        });
        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artmatirialadapter artmatirialadapter = new Artmatirialadapter(EditImageActivity.this, stickerimg4, layout_art);
                RecyclerView.LayoutManager manager1 = new GridLayoutManager(EditImageActivity.this, 3);
                sticker_rece.setAdapter(artmatirialadapter);
                sticker_rece.setLayoutManager(manager1);
            }
        });
        christmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artmatirialadapter artmatirialadapter = new Artmatirialadapter(EditImageActivity.this, stickerimg5, layout_art);
                RecyclerView.LayoutManager manager1 = new GridLayoutManager(EditImageActivity.this, 3);
                sticker_rece.setAdapter(artmatirialadapter);
                sticker_rece.setLayoutManager(manager1);
            }
        });
        doodle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artmatirialadapter artmatirialadapter = new Artmatirialadapter(EditImageActivity.this, stickerimg6, layout_art);
                RecyclerView.LayoutManager manager1 = new GridLayoutManager(EditImageActivity.this, 3);
                sticker_rece.setAdapter(artmatirialadapter);
                sticker_rece.setLayoutManager(manager1);
            }
        });
        element.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artmatirialadapter artmatirialadapter = new Artmatirialadapter(EditImageActivity.this, stickerimg7, layout_art);
                RecyclerView.LayoutManager manager1 = new GridLayoutManager(EditImageActivity.this, 3);
                sticker_rece.setAdapter(artmatirialadapter);
                sticker_rece.setLayoutManager(manager1);
            }
        });
        geometry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artmatirialadapter artmatirialadapter = new Artmatirialadapter(EditImageActivity.this, stickerimg8, layout_art);
                RecyclerView.LayoutManager manager1 = new GridLayoutManager(EditImageActivity.this, 3);
                sticker_rece.setAdapter(artmatirialadapter);
                sticker_rece.setLayoutManager(manager1);
            }
        });
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artmatirialadapter artmatirialadapter = new Artmatirialadapter(EditImageActivity.this, stickerimg9, layout_art);
                RecyclerView.LayoutManager manager1 = new GridLayoutManager(EditImageActivity.this, 3);
                sticker_rece.setAdapter(artmatirialadapter);
                sticker_rece.setLayoutManager(manager1);
            }
        });
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artmatirialadapter artmatirialadapter = new Artmatirialadapter(EditImageActivity.this, stickerimg10, layout_art);
                RecyclerView.LayoutManager manager1 = new GridLayoutManager(EditImageActivity.this, 3);
                sticker_rece.setAdapter(artmatirialadapter);
                sticker_rece.setLayoutManager(manager1);
            }
        });
        quote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artmatirialadapter artmatirialadapter = new Artmatirialadapter(EditImageActivity.this, stickerimg11, layout_art);
                RecyclerView.LayoutManager manager1 = new GridLayoutManager(EditImageActivity.this, 3);
                sticker_rece.setAdapter(artmatirialadapter);
                sticker_rece.setLayoutManager(manager1);
            }
        });


//        Artadapter artadapter = new Artadapter(EditImageActivity.this, name, icon_art);
//        RecyclerView.LayoutManager manager = new LinearLayoutManager(EditImageActivity.this, LinearLayoutManager.HORIZONTAL, false);
//        anim_rece.setAdapter(artadapter);
//        anim_rece.setLayoutManager(manager);

//sticker 1
        StickerAdapter stickerAdapter = new StickerAdapter(EditImageActivity.this, stickername, icon_sticker);
        RecyclerView.LayoutManager stickermanger = new LinearLayoutManager(EditImageActivity.this, LinearLayoutManager.HORIZONTAL, false);
        iconsticker_rece.setAdapter(stickerAdapter);
        iconsticker_rece.setLayoutManager(stickermanger);
//sticker 2
        Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
        RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
        stickermatirial_rece.setAdapter(stickermatirialadapter);
        stickermatirial_rece.setLayoutManager(sticer);

        offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });
        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });
        birthdarsticker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });
        abcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });
         stickeranimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });
        bannersticker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });
        cartoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });
        celebration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });
        decoration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });
        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });
        lovesticker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });
        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });
        word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stickermatirialadapter stickermatirialadapter = new Stickermatirialadapter(EditImageActivity.this, imgsticker, layout_sticker);
                RecyclerView.LayoutManager sticer = new GridLayoutManager(EditImageActivity.this, 3);
                stickermatirial_rece.setAdapter(stickermatirialadapter);
                stickermatirial_rece.setLayoutManager(sticer);
            }
        });

        //backgroung
        Backgroundadapter backgroundadapter = new Backgroundadapter(EditImageActivity.this,backgroundimg);
        RecyclerView.LayoutManager manager = new GridLayoutManager(EditImageActivity.this,3);
        background_rece.setAdapter(backgroundadapter);
        background_rece.setLayoutManager(manager);

//filter
        FilterAdapter filterAdapter = new FilterAdapter(EditImageActivity.this);
        RecyclerView.LayoutManager filtermanager = new LinearLayoutManager(EditImageActivity.this, LinearLayoutManager.HORIZONTAL, false);
        filtermatirial_rece.setAdapter(filterAdapter);
        filtermatirial_rece.setLayoutManager(filtermanager);
        final int i = (int) getIntent().getIntExtra("img", 0);
        edit_image.setImageResource(R.drawable.fooddemo);
        savebtn.setAnimation(AnimationUtils.loadAnimation(this, R.anim.dilogbtn_animation));
   /*     Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("crop");
        ic_saveimage.setImageBitmap(bitmap);*/
        //get crop image
          ic_saveimage.setImageBitmap(CropimageActivity.cropped);
          //Glide.with(this).load(CropimageActivity.cropped).into(ic_saveimage);
          edit_image.setImageBitmap(BackgroundCropActivity.croppedback);
     //     Glide.with(EditImageActivity.this).load(CropimageActivity.cropped).into(ic_saveimage);
     //   Drawable drawable=ic_saveimage.getDrawable();
     //   CropimageActivity.cropped=BitmapFactory.decodeResource(getResources())
//
//            final StickerView stickerView = new StickerView(EditImageActivity.this);
//            stickerView.setImageDrawable(drawable);
////          ic_saveimage.setImageResource(Glide.with(EditImageActivity.this).load(CropimageActivity.cropped).into(stickerView));
//            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
//            fream_stic.addView(stickerView, params);
//            setCurrentEdit(stickerView);
//            stickerView.setOperationListener(new StickerView.OperationListener() {
//                @Override
//                public void onDeleteClick() {
//                    fream_stics.removeView(stickerView);
//                }
//                @Override
//                public void onEdit(StickerView stickerView) {
//                    mCurrentView.setInEdit(false);
//                    mCurrentView = stickerView;
//                    mCurrentView.setInEdit(true);
//                }
//                @Override
//                public void onTop(StickerView stickerView) {
//                }
//            });
        //Zoom
   //     ic_saveimage.setOnTouchListener(new MultiTouchListener());

        savebtn.setOnClickListener(new View.OnClickListener() {
            Chip cancel, done;
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(EditImageActivity.this,R.style.dilogstyle);
                dialog.setContentView(R.layout.saveimage_dilog);
                cancel = dialog.findViewById(R.id.cancel);
                done = dialog.findViewById(R.id.done);

                dialog.show();
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        create_Save_Image();
                        dialog.dismiss();
                        onBackPressed();
                    }
                });
            }
        });

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
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 2);
            }
        });
        gradient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EditImageActivity.this,GradientBackgroundActivity.class);
                startActivity(intent);
            }
        });
    }

    public void back(View view) {
        Intent intent = new Intent(EditImageActivity.this, PosterImageActivity.class);
        startActivity(intent);
        finish();

    }

    public Bitmap finalEditedImage;

    private void create_Save_Image() {
        finalEditedImage = getMainFrameBitmap(save);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        0);
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant
                return;
            }
        }
        saveImage(finalEditedImage);
    }

    private Bitmap getMainFrameBitmap(View view) {

        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        return bitmap;
    }

    private void saveImage(Bitmap bitmap2) {
        Log.e("TAG", "saveImageInCache is called");
        Bitmap bitmap;
        OutputStream output;

        // Retrieve the image from the res folder
        bitmap = bitmap2;

        File filepath = Environment.getExternalStorageDirectory();
        // Create a new folder in SD Card
        File dir = new File(filepath.getAbsolutePath() + "/" + "SocialMediaPost");
        dir.mkdirs();
        // Create a name for the saved image
        String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String FileName = ts + ".jpg";
        File file = new File(dir, FileName);
        file.renameTo(file);
        String _uri = "file://" + filepath.getAbsolutePath() + "/" + "SocialMediaPost" + "/" + FileName;
        //for share image
        String _uri2 = filepath.getAbsolutePath() + "/" + "SocialMediaPost" + "/" + FileName;
        String _url = _uri2;//used in share image
        Log.e("cache uri=", _uri);
        //   path.setText("Path :-"+"\t"+_url);
        Toast.makeText(this, "Save Image", Toast.LENGTH_SHORT).show();

        MediaScannerConnection.scanFile(this, new String[]{_url}, null, new MediaScannerConnection.OnScanCompletedListener() {

            @Override
            public void onScanCompleted(String path, Uri uri) {
                Log.i("ExternalStorage", "Scanned " + path + ":");
                Log.i("ExternalStorage", "-> uri=" + uri);
            }
        });
        try {
            output = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, output);
            output.flush();
            output.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void gallery(View view) {
//        setcolor.setColorFilter(ContextCompat.getColor(EditImageActivity.this, R.color.blue));
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
//        startActivityForResult(intent, 1);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) ;
        {
            if (requestCode == 1) {
                Uri uri = data.getData();
                Intent intent = new Intent(EditImageActivity.this, CropimageActivity.class);
                intent.putExtra("pass", uri.toString());
                intent.putExtra("check",2);
                startActivity(intent);
                finish();
                // Glide.with(EditImageActivity.this).load(uri).into(ic_saveimage);
                // ic_saveimage.setOnTouchListener(new MultiTouchListener());
            }
            if (requestCode == 2) {
                Uri uri = data.getData();
                Intent intent = new Intent(EditImageActivity.this, BackgroundCropActivity.class);
                intent.putExtra("passd", uri.toString());
                intent.putExtra("checks",1);
                startActivity(intent);
                finish();
                // Glide.with(EditImageActivity.this).load(uri).into(ic_saveimage);
                // ic_saveimage.setOnTouchListener(new MultiTouchListener());
            }
        }

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
                Intent intent = new Intent(EditImageActivity.this, BackgroundCropActivity.class);
//               intent.putExtra("color",color);
                intent.putExtra("checks",3);
                startActivity(intent);
                //layoutcolor.setBackgroundColor(color);
            }
        });
        dialog.show();
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

    public void ApplyFilter(int position) {
        switch (position) {
            case 0:
                Effects.applyEffectNone(ic_saveimage);
                break;
            case 1:
                Effects.applyEffect1(ic_saveimage);
                break;
            case 2:
                Effects.applyEffect2(ic_saveimage);
                break;
            case 3:
                Effects.applyEffect3(ic_saveimage);
                break;
            case 4:
                Effects.applyEffect4(ic_saveimage);
                break;
            case 5:
                Effects.applyEffect5(ic_saveimage);
                break;
            case 6:
                Effects.applyEffect6(ic_saveimage);
                break;
            case 7:
                Effects.applyEffect7(ic_saveimage);
                break;
            case 8:
                Effects.applyEffect8(ic_saveimage);
                break;
            case 9:
                Effects.applyEffect9(ic_saveimage);
                break;
            case 10:
                Effects.applyEffect10(ic_saveimage);
                break;
            case 11:
                Effects.applyEffect11(ic_saveimage);
                break;
            case 12:
                Effects.applyEffect12(ic_saveimage);
                break;
            case 13:
                Effects.applyEffect13(ic_saveimage);
                break;
            case 14:
                Effects.applyEffect14(ic_saveimage);
                break;
            case 15:
                Effects.applyEffect15(ic_saveimage);
                break;
            case 16:
                Effects.applyEffect16(ic_saveimage);
                break;
            case 17:
                Effects.applyEffect17(ic_saveimage);
                break;
            case 18:
                Effects.applyEffect18(ic_saveimage);
                break;
            case 19:
                Effects.applyEffect19(ic_saveimage);
                break;
            case 20:
                Effects.applyEffect20(ic_saveimage);
                break;
            case 21:
                Effects.applyEffect21(ic_saveimage);
                break;

        }
    }

    private void setCurrentEdit(StickerView stickerView) {
        if (Stickermatirialadapter.mCurrentView != null) {
            Stickermatirialadapter.mCurrentView.setInEdit(false);
        }
        Stickermatirialadapter.mCurrentView = stickerView;
        stickerView.setInEdit(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateZoom(EditImageActivity.this);
        finish();

    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    updateNow();
                   // Toast.makeText(EditImageActivity.this, "progress="+progress, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                 //   Toast.makeText(getApplicationContext(), "toast in uso",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    //Toast.makeText(getApplicationContext(), "toast non in uso",Toast.LENGTH_SHORT).show();
                }
            };

    public void updateNow(){
        seekTransparent = seekbar.getProgress();
       // Toast.makeText(this, "ssss"+seekTransparent, Toast.LENGTH_SHORT).show();
        edit_image.setAlpha(seekTransparent);
    }
}