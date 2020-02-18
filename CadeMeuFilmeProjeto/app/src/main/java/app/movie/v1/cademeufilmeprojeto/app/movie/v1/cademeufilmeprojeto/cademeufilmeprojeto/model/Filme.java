package app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.model;

import java.io.Serializable;

public class Filme implements Serializable {
    private final String caminhoPoster;
    private final String tituloOriginal;
    private final String titulo_Br;
    private final String sinopseResumo;

    public Filme(String tituloOriginal,String caminhoPoster, String titulo_Br,String sinopseResumo) {
        this.tituloOriginal = tituloOriginal;
        this.caminhoPoster=caminhoPoster;
        this.titulo_Br=titulo_Br;
        this.sinopseResumo=sinopseResumo;
    }

    public  String getTitulo_Br(){

        return titulo_Br;
    }

    public String gettituloOriginal() {
        return tituloOriginal;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }
    public  String getSinopseResumo(){return  sinopseResumo;}
}
