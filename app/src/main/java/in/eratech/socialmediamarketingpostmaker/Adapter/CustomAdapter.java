package in.eratech.socialmediamarketingpostmaker.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;

import in.eratech.socialmediamarketingpostmaker.HomeActivity;
import in.eratech.socialmediamarketingpostmaker.PosterImageActivity;
import in.eratech.socialmediamarketingpostmaker.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    Activity activity;
    int[] image;
    String[] name;
    LayoutInflater inflater;

    public CustomAdapter(HomeActivity homeActivity, String[] name, int[] image) {
        activity = homeActivity;
        this.image = image;
        this.name = name;
        inflater = LayoutInflater.from(activity);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_category, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(activity).load(image[position]).into(holder.ic_image);
        //holder.ic_image.setImageResource(image[position]);
        holder.ic_name.setText(name[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(activity, PosterImageActivity.class);
                intent.putExtra("name",name[position]);
                activity.startActivity(intent);
                Animatoo.animateZoom(activity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ic_image;
        TextView ic_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ic_image=itemView.findViewById(R.id.ic_image);
            ic_name=itemView.findViewById(R.id.ic_name);

        }
    }
}
