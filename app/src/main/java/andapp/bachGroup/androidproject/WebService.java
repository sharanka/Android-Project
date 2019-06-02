package andapp.bachGroup.androidproject;

import android.graphics.Bitmap;
import android.media.Image;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WebService {

    @GET("/3/discover/movie?api_key=dbecaf5a0998ddf17402996f6f72cd32")
    Call <Result> loadMovies();

    @GET("t/p/original/{url}")
    Call <ResponseBody> loadImages(@Query("url")String url);
}

