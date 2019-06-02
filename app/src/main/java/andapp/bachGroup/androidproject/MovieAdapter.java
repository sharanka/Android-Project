package andapp.bachGroup.androidproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private String baseUrl = "https://image.tmdb.org/t/p/w200/";
    private List<Movie> theIntArray;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView theTextView;
        public ImageView theImageView;
        public View fLayout;
        public ViewHolder(View fLayout, TextView v, ImageView iV){
            super(fLayout);
            theTextView = v;
            theImageView = iV;
        }
    }

    public MovieAdapter(ArrayList<Result> intArray) {
            theIntArray = new ArrayList<Movie>();
        for (Result result: intArray) {
            theIntArray.addAll(result.getMovies());
        }
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_view, parent, false);
        TextView tv = v.findViewById(R.id.test_tv);
        ImageView iv = v.findViewById(R.id.imageView2);
        ViewHolder vH = new ViewHolder(v, tv, iv);
        return vH;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.theTextView.setText(theIntArray.get(position).toString());
        Picasso.get().load(baseUrl+theIntArray.get(position).getPosterPath()).fit().into(holder.theImageView);
        System.out.println(baseUrl+theIntArray.get(position).getPosterPath());
        holder.theTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteItem(holder.getAdapterPosition(), view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return theIntArray.size();
    }

    private void deleteItem(final int position, View v){

    }

    public void addItem(Result result){
        for (Movie movie:result.getMovies()) {
   //         setImagesForItems(movie);
            theIntArray.add(movie);
        }
        notifyDataSetChanged();
    }

    private void setImagesForItems(Movie movie){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        WebService imageService = retrofit.create(WebService.class);
        Call<ResponseBody> image = imageService.loadImages(movie.getPosterPath());

        image.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Bitmap bitmap = BitmapFactory.decodeStream(response.body().byteStream());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}