package app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.ui.listafilmes;

import java.util.List;

import app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.model.Filme;

public interface ListaFilmesContrato {

    interface  ListaFilmesView{
        void mostraFilmes(List<Filme> filmes);


        void mostraErro();

    }

    interface  ListaFilmesPresenter{

        void obtemFilmes();

        void destruirView();
    }

}
