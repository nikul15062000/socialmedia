package in.eratech.socialmediamarketingpostmaker.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import in.eratech.socialmediamarketingpostmaker.EditImageActivity;
import in.eratech.socialmediamarketingpostmaker.R;

public class StickerAdapter extends RecyclerView.Adapter<StickerAdapter.ViewHOlder> {
    Activity activity;
    String[] stickername;
    int[] icon_sticker;
    public StickerAdapter(EditImageActivity editImageActivity, String[] stickername, int[] icon_sticker) {
        activity=editImageActivity;
        this.stickername=stickername;
        this.icon_sticker=icon_sticker;

    }

    @NonNull
    @Override
    public ViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.view_sticker,parent,false);
         ViewHOlder viewHOlder=new ViewHOlder(view);
        return viewHOlder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHOlder holder, int position) {
         holder.sticker_text.setText(stickername[position]);
       //  holder.sticker_img.setImageResource(icon_sticker[position]);
        Glide.with(activity).load(icon_sticker[position]).into(holder.sticker_img);
    }

    @Override
    public int getItemCount() {
        return icon_sticker.length;
    }

    public class ViewHOlder extends RecyclerView.ViewHolder {
        ImageView sticker_img;
        TextView sticker_text;
        public ViewHOlder(@NonNull View itemView) {
            super(itemView);
            sticker_img=itemView.findViewById(R.id.sticker_img);
            sticker_text=itemView.findViewById(R.id.sticker_name);
        }
    }
}
