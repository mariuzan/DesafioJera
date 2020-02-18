package app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.mapper;

import java.util.ArrayList;
import java.util.List;

import app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.data.network.response.FilmeResponse;
import app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.model.Filme;

public class FilmeMapper {

    public static List<Filme> deResponseParaDominio(List<FilmeResponse> listaFilmeResponse) {

        List<Filme> listaFilmes = new ArrayList<>();
        for (FilmeResponse filmeResponse : listaFilmeResponse) {

            final Filme filme = new Filme(filmeResponse.getTituloOriginal()
                    , filmeResponse.getCaminhoPoster(),filmeResponse.getTitulo_Br(),
                    filmeResponse.getSinopseResumo()
                    );


            listaFilmes.add(filme);
        }
        return listaFilmes;

    }
}
