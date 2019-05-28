package andapp.bachGroup.androidproject;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.net.URL;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoadMovieTask extends AsyncTask <String, Result, ArrayList>{

    private WebService movieService;
    private ArrayList<Result> resultArrayList;
    private RecyclerView theRecyclerView;
    private RecyclerView.Adapter theAdapter;
    private Retrofit retrofit;
    public ASyncTaskResponse aResponse = null;

    @Override
    protected ArrayList doInBackground(String... strings) {
        retrofit = new Retrofit.Builder().baseUrl(strings[0]).addConverterFactory(GsonConverterFactory.create()).build();
        movieService = retrofit.create(WebService.class);
        resultArrayList = new ArrayList<>();
        Call<Result> movies = movieService.loadMovies();
        try {
            resultArrayList.add(movies.execute().body());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultArrayList;
    }

    @Override
    protected void onPreExecute(){

    }

    @Override
    protected void onPostExecute(ArrayList resultArrayList){
        //theAdapter = new MovieAdapter(resultArrayList);
        //theRecyclerView.setAdapter(theAdapter);
        aResponse.response(resultArrayList);
    }
}
