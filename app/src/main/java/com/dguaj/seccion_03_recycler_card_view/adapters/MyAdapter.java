package com.dguaj.seccion_03_recycler_card_view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dguaj.seccion_03_recycler_card_view.R;
import com.dguaj.seccion_03_recycler_card_view.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dguaj on 12-04-17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Movie> movies;
    private int layout;
    private OnItemClickListener itemClickListener;
    private Context context;

    public MyAdapter(List<Movie> movies, int layout, OnItemClickListener itemClickListener) {
        this.movies = movies;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout y se lo pasamos al constructor del ViewHolder, donde manejaremos
        // toda la logica como extraer los datos, referencias ...
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Llamamos al método bind del ViewHolder pasandole objeto y listener
        holder.bind(movies.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Elementos UI a rrellenar
        public TextView textViewName;
        public ImageView imageViewPoster;


        public ViewHolder(View itemView) {
            // Recibe la view completa. La pasa al constructor padre y enlazamos referencias UI
            // con nuestras propiedades ViewHolder declaradas justo arriba
            super(itemView);
            textViewName = (TextView)itemView.findViewById(R.id.textViewTitle);
            imageViewPoster = (ImageView)itemView.findViewById(R.id.imageViewPoster);
        }

        public void bind(final Movie movie, final OnItemClickListener listener){
            // Procesamos los datos a renderizar
            textViewName.setText(movie.getName());
            //imageViewPoster.setImageResource(movie.getPoster());
            Picasso.with(context).load(movie.getPoster()).fit().into(imageViewPoster);
            // Definimos que por cada elemento de nuestro recyclervew, tenemos un click listener
            // que se comporta de la siguiente manera.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(movie, getAdapterPosition());
                }
            });
        }
    }

    // Declaramos nuestra interfaz con el /los médoto/s a implementar
    public interface OnItemClickListener {
        void onItemClick(Movie movie, int position);
    }
}
