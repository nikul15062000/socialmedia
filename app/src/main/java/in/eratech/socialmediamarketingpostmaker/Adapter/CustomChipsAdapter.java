package in.eratech.socialmediamarketingpostmaker.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.robertlevonyan.views.chip.Chip;

import java.util.Random;

import in.eratech.socialmediamarketingpostmaker.HomeActivity;
import in.eratech.socialmediamarketingpostmaker.PosterImageActivity;
import in.eratech.socialmediamarketingpostmaker.R;

public class CustomChipsAdapter extends RecyclerView.Adapter<CustomChipsAdapter.ViewHolder> {
    Activity activity;
    String[] name;

    public CustomChipsAdapter(HomeActivity mtoActivity, String[] chipsname) {
        activity =mtoActivity;
        this.name=chipsname;
    }

    @NonNull
    @Override
    public CustomChipsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(activity).inflate(R.layout.view_chipsbutton,parent,false);
       ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.btn.setText(name[position]);

        Random rnd = new Random();
        int currentColor = Color.argb(240, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(255));
        holder.btn.setChipBackgroundColor(currentColor);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity, PosterImageActivity.class);
                intent.putExtra("name",name[position]);
                activity.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return name.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout  p1;
        Chip btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn=itemView.findViewById(R.id.chip);
        }
    }
}
