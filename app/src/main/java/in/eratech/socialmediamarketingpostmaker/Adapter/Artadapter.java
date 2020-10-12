package in.eratech.socialmediamarketingpostmaker.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import in.eratech.socialmediamarketingpostmaker.EditImageActivity;
import in.eratech.socialmediamarketingpostmaker.R;

public class Artadapter extends RecyclerView.Adapter<Artadapter.viewHolder> {
    Activity activity;
    String[] name;
    int[] icon_art;

    public Artadapter(EditImageActivity editImageActivity, String[] name, int[] icon_art) {
        activity=editImageActivity;
        this.name=name;
        this.icon_art=icon_art;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.view_art,parent,false);
        viewHolder viewHolder=new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    // holder.art_img.setImageResource(icon_art[position]);
     holder.art_text.setText(name[position]);
     Glide.with(activity).load(icon_art[position]).into(holder.art_img);
    }

    @Override
    public int getItemCount() {
        return icon_art.length;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView art_img;
        TextView art_text;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            art_img=itemView.findViewById(R.id.art_img);
            art_text=itemView.findViewById(R.id.art_text);
        }
    }
}
