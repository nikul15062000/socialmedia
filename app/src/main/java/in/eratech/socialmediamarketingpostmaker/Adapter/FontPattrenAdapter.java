package in.eratech.socialmediamarketingpostmaker.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import in.eratech.socialmediamarketingpostmaker.Modalclass.PATTERN;
import in.eratech.socialmediamarketingpostmaker.R;
import in.eratech.socialmediamarketingpostmaker.TextEditActivity;


public class FontPattrenAdapter extends BaseAdapter {

    Activity activity;
    LayoutInflater inflater;
    List<PATTERN> list;

    public FontPattrenAdapter(TextEditActivity textEditActivity, List<PATTERN> list) {
        activity = textEditActivity;
        this.list = list;
        inflater = LayoutInflater.from(activity);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        view = inflater.inflate(R.layout.pattren, null, false);
        ImageView IMG_PTN = (ImageView) view.findViewById(R.id.img_ptn);
        IMG_PTN.setImageResource(list.get(position).getImg());
        IMG_PTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        ((TextEditActivity) activity).Pattren(0);
                        break;

                    case 1:
                        ((TextEditActivity) activity).Pattren(1);
                        break;

                    case 2:
                        ((TextEditActivity) activity).Pattren(2);
                        break;

                    case 3:
                        ((TextEditActivity) activity).Pattren(3);
                        break;

                    case 4:
                        ((TextEditActivity) activity).Pattren(4);
                        break;

                    case 5:
                        ((TextEditActivity) activity).Pattren(5);
                        break;

                    case 6:
                        ((TextEditActivity) activity).Pattren(6);
                        break;

                    case 7:
                        ((TextEditActivity) activity).Pattren(7);
                        break;

                    case 8:
                        ((TextEditActivity) activity).Pattren(8);
                        break;

                    case 9:
                        ((TextEditActivity) activity).Pattren(9);
                        break;

                }
            }
        });
        return view;
    }


}
