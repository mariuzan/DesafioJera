package app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.ui.listafilmes;

import java.util.List;

import app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.data.network.ApiService;
import app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.data.network.response.FilmesResult;
import app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.mapper.FilmeMapper;
import app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.model.Filme;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesPresenter implements ListaFilmesContrato.ListaFilmesPresenter{

        private  ListaFilmesContrato.ListaFilmesView view;
        public  ListaFilmesPresenter(ListaFilmesContrato.ListaFilmesView view){
            this.view=view;
        }

    @Override
    public void obtemFilmes() {
        ApiService.getInstance().obterFilmesPopulares("48700ad284353359a6787267021749e1","pt-BR")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {

                        if(response.isSuccessful()){
                            final List<Filme> listaFilmes= FilmeMapper
                                    .deResponseParaDominio(response.body().getResultadoFilmes());


                            //filmesAdapter.setFilmes(listaFilmes);
                            view.mostraFilmes(listaFilmes);
                        }
                        else{
                           view.mostraErro();

                        }

                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {
                        view.mostraErro();
                    }
                });

    }

    @Override
    public void destruirView() {
        this.view=null;
    }
}
