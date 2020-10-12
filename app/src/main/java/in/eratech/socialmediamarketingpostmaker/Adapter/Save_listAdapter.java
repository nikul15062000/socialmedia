package in.eratech.socialmediamarketingpostmaker.Adapter;

import android.app.Activity;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import in.eratech.socialmediamarketingpostmaker.R;
import in.eratech.socialmediamarketingpostmaker.SaveimageActivity;

public class Save_listAdapter extends RecyclerView.Adapter<Save_listAdapter.Holder> {
    Activity activity;
    ArrayList images;

    public Save_listAdapter(SaveimageActivity saveimageActivity, ArrayList images) {

        activity=saveimageActivity;
        this.images=images;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.saveview,parent,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Glide.with(activity).load(images.get(position)).into(holder.saveimageset);
      //  holder.saveimageset.set(Environment.getExternalStorageDirectory().getAbsolutePath()+"/SocialMediaPost/"+images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private final ImageView saveimageset;

        public Holder(@NonNull View itemView) {
            super(itemView);
            saveimageset = itemView.findViewById(R.id.saveimageset);
        }
    }
}
