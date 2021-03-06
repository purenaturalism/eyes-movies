package com.droidapp.ivanelv.eyesmovies.API;

import com.droidapp.ivanelv.eyesmovies.Model.MovieResponse;
import com.droidapp.ivanelv.eyesmovies.Model.MovieReview;
import com.droidapp.ivanelv.eyesmovies.Model.MovieTrailer;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by if on 22/08/17.
 */

public interface IEndpoint
{
    @GET(Contract.PATH_POPULAR_MOVIE)
    Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey);

    @GET(Contract.PATH_TOP_RATED_MOVIE)
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}/videos")
    Call<MovieTrailer> getMovieTrailer(@Path("id") int id,
                                       @Query("api_key") String apiKey);

    @GET("movie/{id}/reviews")
    Call<MovieReview> getMovieReview(@Path("id") int id,
                                     @Query("api_key") String apiKey);

    @GET(Contract.SIZE_MOBILE + "{posterImagePath}")
    Call<ResponseBody> getPosterImage(
            @Path(value = "posterImagePath", encoded = true)
            String posterImagePath);

    @GET("w780{backdropImagePath}")
    Call<ResponseBody> getBackdropImage(
            @Path(value = "backdropImagePath", encoded = true)
                    String backdropImagePath);
}
