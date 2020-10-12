package in.eratech.socialmediamarketingpostmaker.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;

import in.eratech.socialmediamarketingpostmaker.HomeActivity;
import in.eratech.socialmediamarketingpostmaker.PosterImageActivity;
import in.eratech.socialmediamarketingpostmaker.R;
import in.eratech.socialmediamarketingpostmaker.TempletCategaryActivity;

public class TempletAdapter extends RecyclerView.Adapter<TempletAdapter.ViewTempletHolder> {
    Activity activity;
    int[] img;


    public TempletAdapter(TempletCategaryActivity templetCategaryActivity, int[] img) {
        activity = templetCategaryActivity;
        this.img = img;

    }

    @NonNull
    @Override
    public ViewTempletHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.view_templetinnerimg, parent, false);
        ViewTempletHolder viewTempletHolder = new ViewTempletHolder(view);
        return viewTempletHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTempletHolder holder, int position) {
        Glide.with(activity).load(img[position]).into(holder.image);
        //holder.image.setImageResource(img[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity, PosterImageActivity.class);
                activity.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return 4;
    }
    public class ViewTempletHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public ViewTempletHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.templetinnerimg);
                }
    }
}
