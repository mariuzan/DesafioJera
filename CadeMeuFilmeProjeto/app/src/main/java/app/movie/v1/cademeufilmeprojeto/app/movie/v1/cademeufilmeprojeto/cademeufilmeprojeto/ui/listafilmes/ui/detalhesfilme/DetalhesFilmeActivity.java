package app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.ui.listafilmes.ui.detalhesfilme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import app.movie.v1.cademeufilmeprojeto.R;
import app.movie.v1.cademeufilmeprojeto.app.movie.v1.cademeufilmeprojeto.cademeufilmeprojeto.model.Filme;

public class DetalhesFilmeActivity extends AppCompatActivity {
    public static  final  String EXTRA_FILME  ="EXTRA_FILME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filme);

        TextView textSinopse=findViewById(R.id.sinopse);
        TextView textTituloFilme=findViewById(R.id.textTituloFilme);
        ImageView imageView=findViewById(R.id.image_poster_filme_detalhe);
        TextView textTituloOriginal= findViewById(R.id.tituloOriginal);

        final Filme filme =(Filme) getIntent().getSerializableExtra(EXTRA_FILME);

        textTituloFilme.setText(filme.getTitulo_Br());
        textSinopse.setText(filme.getSinopseResumo());
        textTituloOriginal.setText(filme.gettituloOriginal());

        Picasso.get().load("https://image.tmdb.org/t/p/w342/"+ filme.getCaminhoPoster())
                .into(imageView);





    }
}
