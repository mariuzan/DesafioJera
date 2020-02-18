package app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.data.network.response;

import com.squareup.moshi.Json;

public class FilmeResponse {
        @Json(name="poster_path")
        private final String caminhoPoster;
        //mudei para puxar o nome em portugues

        @Json(name="original_title")
        private final String tituloOriginal;


       @Json(name="title")
        private final String titulo_Br;

       @Json(name="overview")
       private final String sinopseResumo;


    public FilmeResponse(String caminhoPoster, String tituloOriginal, String titulo_Br,String sinopseResumo) {
        this.caminhoPoster = caminhoPoster;
        this.tituloOriginal = tituloOriginal;
        this.titulo_Br=titulo_Br;
        this.sinopseResumo=sinopseResumo;
    }

    public  String getTitulo_Br(){
        return titulo_Br;

    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }
    public String getSinopseResumo(){
        return  sinopseResumo;
    }
}
