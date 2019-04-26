package andapp.bachGroup.androidproject;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WebService {

    @GET("discover/movie")
    Call<List<Movie>> loadMovies();
}
