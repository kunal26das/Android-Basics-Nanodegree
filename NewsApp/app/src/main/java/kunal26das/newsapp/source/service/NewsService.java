package kunal26das.newsapp.source.service;

import io.reactivex.Single;
import kunal26das.newsapp.source.model.DebatesResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kunal on 10-03-2020.
 */
public interface NewsService {

    @GET("search")
    Single<DebatesResponse> getNews(@Query("q") String query, @Query("page") Integer page, @Query("api-key") String apiKey);
}
