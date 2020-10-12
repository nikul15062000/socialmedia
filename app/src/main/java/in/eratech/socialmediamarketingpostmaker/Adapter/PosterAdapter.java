package in.eratech.socialmediamarketingpostmaker.Adapter;

import android.app.Activity;
import android.content.Intent;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Random;

import in.eratech.socialmediamarketingpostmaker.CropimageActivity;
import in.eratech.socialmediamarketingpostmaker.EditImageActivity;
import in.eratech.socialmediamarketingpostmaker.Modalclass.Posterimageclass;
import in.eratech.socialmediamarketingpostmaker.PosterImageActivity;
import in.eratech.socialmediamarketingpostmaker.R;

public class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.ViewHolders> {
    Activity activity;
    List<Posterimageclass> datalist;
    public PosterAdapter(PosterImageActivity posterImageActivity, List<Posterimageclass> datalist) {
        activity =posterImageActivity;
        this.datalist =datalist;
    }

    @NonNull
    @Override
    public ViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.ic_poster,parent,false);
        ViewHolders viewHolders=new ViewHolders(view);
        return viewHolders;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolders holder, final int position) {

    //   holder.ic_Image.setImageResource(datalist.get(position).img);
         //Glide.with(activity).load((datalist.get(position).img);
       Glide.with(activity).load("https://imge.com/wp-content/uploads/2019/02/IMGE-Social-Share.png").into(holder.ic_Image);
      //  Glide.with(activity).load(datalist.get(position)).into(holder.ic_Image);
        Random rnd = new Random();
        int currentColor = Color.argb(200, rnd.nextInt(300), rnd.nextInt(300), rnd.nextInt(300));
        holder.imgbackcolor.setBackgroundColor(currentColor);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(activity, EditImageActivity.class);
                intent.putExtra("img",datalist.get(position).img);
                CropimageActivity.cropped=null;
                activity.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ViewHolders extends RecyclerView.ViewHolder {
        private final FrameLayout imgbackcolor;
        ImageView ic_Image;
        public ViewHolders(@NonNull View itemView) {
            super(itemView);
            ic_Image=itemView.findViewById(R.id.ic_image);
            imgbackcolor=itemView.findViewById(R.id.imgbackcolor);
        }
    }
}
