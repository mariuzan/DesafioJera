package app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.data.network;

import app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.data.network.response.FilmesResult;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmesService {

    @GET("discover/movie")
    Call<FilmesResult> obterFilmesPopulares(@Query("api_key") String chaveApi,@Query("language") String idioma);


}
//@Query("sort_by")String pesquisa
/*public interface FilmesService {

    @GET("movie/popular")
    Call<FilmesResult> obterFilmesPopulares(@Query("api_key") String chaveApi,@Query("language") String idioma);


}*/
