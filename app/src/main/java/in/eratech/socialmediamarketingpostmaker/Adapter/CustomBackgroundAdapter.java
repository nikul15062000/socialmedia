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

import in.eratech.socialmediamarketingpostmaker.BackgroundCropActivity;
import in.eratech.socialmediamarketingpostmaker.BackgroundselectedActivity;
import in.eratech.socialmediamarketingpostmaker.CropimageActivity;
import in.eratech.socialmediamarketingpostmaker.R;

public class CustomBackgroundAdapter extends RecyclerView.Adapter<CustomBackgroundAdapter.viewHolder> {
    Activity activity;
    int[] img;
    public CustomBackgroundAdapter(BackgroundselectedActivity backgroundselectedActivity, int[] img) {
        activity=backgroundselectedActivity;
        this.img=img;

    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.background_view,parent,false);
        viewHolder viewHolder=new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
    //  holder.background_img.setImageResource(img[position]);
        Glide.with(activity).load(img[position]).into(holder.background_img);
      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(activity, BackgroundCropActivity.class);
              intent.putExtra("imagedata",position);
              intent.putExtra("checks",4);
              activity.startActivity(intent);
          }
      });
    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView background_img;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            background_img=itemView.findViewById(R.id.background_img);
        }
    }
}
