package in.eratech.socialmediamarketingpostmaker.Adapter;

import android.app.Activity;
import android.provider.ContactsContract;
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

public class Stickermatirialadapter extends RecyclerView.Adapter<Stickermatirialadapter.ViewStickerholder> {
    Activity activity;
    int[] imgsticker;
    LinearLayout layout_sticker;
    public static StickerView mCurrentView;
    public Stickermatirialadapter(EditImageActivity editImageActivity, int[] imgsticker, LinearLayout layout_sticker) {
        activity = editImageActivity;
        this.imgsticker = imgsticker;
        this.layout_sticker=layout_sticker;
    }

    @NonNull
    @Override
    public ViewStickerholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.view_stickermatirial, parent, false);
        ViewStickerholder viewStickerholder = new ViewStickerholder(view);

        return viewStickerholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewStickerholder holder, final int position) {
        Glide.with(activity).load(imgsticker[position]).into(holder.stickermatirialimage);
       // holder.stickermatirialimage.setImageResource(imgsticker[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_sticker.setVisibility(View.GONE);
                SetStickerView(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imgsticker.length;
    }

    public class ViewStickerholder extends RecyclerView.ViewHolder {
        private final ImageView stickermatirialimage;

        public ViewStickerholder(@NonNull View itemView) {
            super(itemView);
            stickermatirialimage=itemView.findViewById(R.id.stickermatirialimage);
        }
    }
    public void SetStickerView(int position){

        final StickerView stickerView =new StickerView(activity);
        stickerView.setImageResource(imgsticker[position]);
       // Glide.with(activity).load(imgsticker[position]).into(stickerView);
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
