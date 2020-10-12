package in.eratech.socialmediamarketingpostmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.eratech.socialmediamarketingpostmaker.Adapter.PosterAdapter;
import in.eratech.socialmediamarketingpostmaker.Modalclass.Posterimageclass;

public class PosterImageActivity extends AppCompatActivity {

    TextView ic_text;
    RecyclerView ic_recycle;
    ImageView back;
    // String url = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    String url = "https://jsonplaceholder.typicode.com/photos";
    List<Posterimageclass> datalist = new ArrayList<>();

    private static final String TAG = "PosterImageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poster_image);
        getSupportActionBar().hide();
        ic_text = findViewById(R.id.ic_text);
        ic_recycle = findViewById(R.id.ic_recycle);
        back =findViewById(R.id.back);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        ic_text.setText(name);

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Toast.makeText(PosterImageActivity.this, "Done", Toast.LENGTH_SHORT).show();

                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);
                        Integer id = object.getInt("id");
                        String img = object.getString("url");
                        Posterimageclass postclass = new Posterimageclass(id, img);
                        datalist.add(postclass);
                        Log.e(TAG, "onResponse: ==========>>>>>>>" + id);
                    }

                    PosterAdapter posterAdapter = new PosterAdapter(PosterImageActivity.this, datalist);
                    RecyclerView.LayoutManager manager = new GridLayoutManager(PosterImageActivity.this, 2);
                    ic_recycle.setAdapter(posterAdapter);
                    ic_recycle.setLayoutManager(manager);

                } catch (JSONException e) {
                    Log.e(TAG, "onResponse: =======>>>>>>" + e.getMessage());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PosterImageActivity.this, "Place internet Error", Toast.LENGTH_SHORT).show();
                //dialog open in this internet start
            }
        });
        RequestQueue queue = Volley.newRequestQueue(PosterImageActivity.this);
        queue.add(request);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onBackPressed();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateZoom(PosterImageActivity.this);
        finish();
    }
}