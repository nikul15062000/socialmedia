package in.eratech.socialmediamarketingpostmaker.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import in.eratech.socialmediamarketingpostmaker.EditImageActivity;
import in.eratech.socialmediamarketingpostmaker.Modalclass.Effects;
import in.eratech.socialmediamarketingpostmaker.R;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.Holder> {
    Activity activity;

    public FilterAdapter(EditImageActivity editImageActivity) {
        activity = editImageActivity;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.filter, parent, false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {

        switch (position) {
            case 0:
                Effects.applyEffectNone(holder.filter);
                break;
            case 1:
                Effects.applyEffect1(holder.filter);
                break;
            case 2:
                Effects.applyEffect2(holder.filter);
                break;
            case 3:
                Effects.applyEffect3(holder.filter);
                break;
            case 4:
                Effects.applyEffect4(holder.filter);
                break;
            case 5:
                Effects.applyEffect5(holder.filter);
                break;
            case 6:
                Effects.applyEffect6(holder.filter);
                break;
            case 7:
                Effects.applyEffect7(holder.filter);
                break;
            case 8:
                Effects.applyEffect8(holder.filter);
                break;
            case 9:
                Effects.applyEffect9(holder.filter);
                break;
            case 10:
                Effects.applyEffect10(holder.filter);
                break;
            case 11:
                Effects.applyEffect11(holder.filter);
                break;
            case 12:
                Effects.applyEffect12(holder.filter);
                break;
            case 13:
                Effects.applyEffect13(holder.filter);
                break;
            case 14:
                Effects.applyEffect14(holder.filter);
                break;
            case 15:
                Effects.applyEffect15(holder.filter);
                break;
            case 16:
                Effects.applyEffect16(holder.filter);
                break;
            case 17:
                Effects.applyEffect17(holder.filter);
                break;
            case 18:
                Effects.applyEffect18(holder.filter);
                break;
            case 19:
                Effects.applyEffect19(holder.filter);
                break;
            case 20:
                Effects.applyEffect20(holder.filter);
                break;
            case 21:
                Effects.applyEffect21(holder.filter);
                break;
        }
        holder.filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((EditImageActivity) activity).ApplyFilter(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 22;
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView filter;

        public Holder(@NonNull View itemView) {
            super(itemView);
            filter = itemView.findViewById(R.id.filter);
        }
    }
}
