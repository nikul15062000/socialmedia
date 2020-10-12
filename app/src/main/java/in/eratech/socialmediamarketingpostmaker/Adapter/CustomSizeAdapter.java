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

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.ViewPreloadSizeProvider;

import in.eratech.socialmediamarketingpostmaker.BackgroundselectedActivity;
import in.eratech.socialmediamarketingpostmaker.PostresizeActivity;
import in.eratech.socialmediamarketingpostmaker.R;

public class CustomSizeAdapter extends RecyclerView.Adapter<CustomSizeAdapter.ViewsizeHolder> {
    Activity activity;
   int[] imagesize;
   String[] sizestexts;
    public CustomSizeAdapter(PostresizeActivity postresizeActivity, int[] imagesize, String[] sizestexts) {
        activity=postresizeActivity;
        this.imagesize=imagesize;
        this.sizestexts=sizestexts;

    }

    @NonNull
    @Override
    public ViewsizeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.sizeview,parent,false);
        ViewsizeHolder viewsizeHolder=new ViewsizeHolder(view);
        return viewsizeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewsizeHolder holder, int position) {
        Glide.with(activity).load(imagesize[position]).into(holder.sizesimages);
        holder.sizestext.setText(sizestexts[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity, BackgroundselectedActivity.class);
                activity.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return imagesize.length;
    }

    public class ViewsizeHolder extends RecyclerView.ViewHolder {
        private final ImageView sizesimages;
        private final TextView sizestext;

        public ViewsizeHolder(@NonNull View itemView) {
            super(itemView);

            sizesimages=itemView.findViewById(R.id.sizesimage);
            sizestext = itemView.findViewById(R.id.sizestext);

        }
    }
}
