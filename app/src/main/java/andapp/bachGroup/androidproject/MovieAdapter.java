package andapp.bachGroup.androidproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private ArrayList<Movie> theIntArray;

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

    public MovieAdapter(ArrayList<Movie> intArray) {
        theIntArray = intArray;
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
}