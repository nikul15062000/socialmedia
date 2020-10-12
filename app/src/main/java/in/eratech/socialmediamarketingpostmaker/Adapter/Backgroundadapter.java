package in.eratech.socialmediamarketingpostmaker.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import in.eratech.socialmediamarketingpostmaker.EditImageActivity;
import in.eratech.socialmediamarketingpostmaker.R;

public class Backgroundadapter extends RecyclerView.Adapter<Backgroundadapter.ViewHolder> {

    Activity activity;
    int[] backgroundimg;
    public Backgroundadapter(EditImageActivity editImageActivity, int[] backgroundimg) {
        activity=editImageActivity;
        this.backgroundimg=backgroundimg;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.edit_view_background,parent,false);
        Backgroundadapter.ViewHolder viewHolder=new Backgroundadapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Glide.with(activity).load(backgroundimg[position]).into(holder.background_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditImageActivity.fream_stic.setBackgroundResource(backgroundimg[position]);
              //  Glide.with(activity).load(backgroundimg[position]).into(EditImageActivity.edit_image);
                EditImageActivity.layout_backgound.setVisibility(view.GONE);
                EditImageActivity.i3=0;
            }
        });
    }

    @Override
    public int getItemCount() {
        return backgroundimg.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView background_img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            background_img=itemView.findViewById(R.id.background_img);
        }
    }
}
