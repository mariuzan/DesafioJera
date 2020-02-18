package app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.ui.listafilmes;

import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import app.movie.v1.cademeufilmeprojeto.R;
import app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.data.network.ApiService;
import app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.mapper.FilmeMapper;
import app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.data.network.response.FilmesResult;
import app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.model.Filme;
import app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.ui.listafilmes.ui.detalhesfilme.DetalhesFilmeActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity implements ListaFilmesContrato.ListaFilmesView
        , ListaFilmesAdapter.ItemFilmeClickListener

{



    private ListaFilmesAdapter filmesAdapter;

    private  ListaFilmesContrato.ListaFilmesPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_lista_filmes);

        configuraAdapter();

        presenter= new ListaFilmesPresenter(this);

        presenter.obtemFilmes();

    }

    private  void  configuraAdapter(){

        final RecyclerView recyclerFilmes= findViewById(R.id.recycler_filmes);

        filmesAdapter= new ListaFilmesAdapter(this);

        RecyclerView.LayoutManager gridLayoutManager= new GridLayoutManager(this,2);

        recyclerFilmes.setLayoutManager(gridLayoutManager);

        recyclerFilmes.setAdapter( filmesAdapter);

    }



    @Override
    public void mostraFilmes(List<Filme> filmes) {
                filmesAdapter.setFilmes(filmes);
    }


    @Override
    public void mostraErro(){

        Toast.makeText(this,"Erro ao obter filmes",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destruirView();

    }

    @Override
    public void onItemClicado(Filme filme) {
        Intent intent= new Intent(this, DetalhesFilmeActivity.class);
        intent.putExtra(DetalhesFilmeActivity.EXTRA_FILME,filme);
        startActivity(intent);
    }
}
