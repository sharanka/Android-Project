package andapp.bachGroup.androidproject;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WebService {

    @GET("/3/discover/movie?api_key=dbecaf5a0998ddf17402996f6f72cd32")
    Call <Result> loadMovies();
}
