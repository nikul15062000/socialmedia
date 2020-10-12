package in.eratech.socialmediamarketingpostmaker.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import in.eratech.socialmediamarketingpostmaker.EditImageActivity;
import in.eratech.socialmediamarketingpostmaker.R;
import in.eratech.socialmediamarketingpostmaker.StickerView;

import static in.eratech.socialmediamarketingpostmaker.EditImageActivity.fream_stic;

public class Artmatirialadapter extends RecyclerView.Adapter<Artmatirialadapter.ViewHOLDER> {
    Activity activity;
    int[] img;
    LinearLayout layout_sticker;
    public static StickerView mCurrentView;
    public Artmatirialadapter(EditImageActivity editImageActivity, int[] img, LinearLayout layout_sticker) {
        activity = editImageActivity;
        this.img = img;
        this.layout_sticker=layout_sticker;
    }

    @NonNull
    @Override
    public ViewHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.view_artmatirial, parent, false);
        ViewHOLDER viewHOLDER = new ViewHOLDER(view);
        return viewHOLDER;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHOLDER holder, final int position) {

        Glide.with(activity).load(img[position]).into(holder.artmatirialimage);
        //holder.artmatirialimage.setImageResource(img[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_sticker.setVisibility(View.INVISIBLE);
                SetStickerView(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    public class ViewHOLDER extends RecyclerView.ViewHolder {
        ImageView artmatirialimage;

        public ViewHOLDER(@NonNull View itemView) {
            super(itemView);
            artmatirialimage = itemView.findViewById(R.id.artmatirialimage);
        }
    }
    public void SetStickerView(int position){

        final StickerView stickerView =new StickerView(activity);
        stickerView.setImageResource(img[position]);
       // Glide.with(activity).load(img[position]).into(stickerView);
        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        fream_stic.addView(stickerView,params);
        setCurrentEdit(stickerView);
        stickerView.setOperationListener(new StickerView.OperationListener() {
            @Override
            public void onDeleteClick() {
                fream_stic.removeView(stickerView);
            }
            @Override
            public void onEdit(StickerView stickerView) {
                mCurrentView.setInEdit(false);
                mCurrentView = stickerView;
                mCurrentView.setInEdit(true);
            }
            @Override
            public void onTop(StickerView stickerView) {
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
}
