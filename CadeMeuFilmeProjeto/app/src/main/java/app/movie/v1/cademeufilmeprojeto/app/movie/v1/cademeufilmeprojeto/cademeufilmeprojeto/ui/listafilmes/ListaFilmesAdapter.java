package app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.ui.listafilmes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import app.movie.v1.cademeufilmeprojeto.R;
import app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.model.Filme;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> {

    private List<Filme> filmes;
    private  static ItemFilmeClickListener itemFilmeClickListener;


    public ListaFilmesAdapter(ItemFilmeClickListener itemFilmeClickListener) {

        this.itemFilmeClickListener=itemFilmeClickListener;

        filmes = new ArrayList<>();

    }


    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);

        return new ListaFilmesViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) {

        holder.bind(filmes.get(position));


    }

    @Override
    public int getItemCount() {
        return(filmes != null && filmes.size()>0) ? filmes.size():0;
    }

    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder {

        private TextView textTituloFilme;
        private ImageView imagePosterFilme;
        private  TextView textoTituloBr;
        private  Filme filme;


        public ListaFilmesViewHolder(View itemView) {
            super(itemView);

            //textTituloFilme = itemView.findViewById(R.id.text_titulo_filme);
            imagePosterFilme=itemView.findViewById(R.id.image_poster_filme);
            textoTituloBr=itemView.findViewById(R.id.titulo_br);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemFilmeClickListener!=null){

                        itemFilmeClickListener.onItemClicado(filme);

                    }
                }
            });

        }
        public  void bind(Filme filme){

            this.filme=filme;

            textoTituloBr.setText(filme.getTitulo_Br());

//            textTituloFilme.setText(filme.gettituloOriginal());


            Picasso.get().load("https://image.tmdb.org/t/p/w342/"+ filme.getCaminhoPoster())
                    .into(imagePosterFilme);

        }
    }

    public void setFilmes(List<Filme> Filmes) {

        this.filmes = Filmes;
        notifyDataSetChanged();
    }

    public interface  ItemFilmeClickListener{

        void onItemClicado(Filme filme);

    }


}
