package net.styleru.i_komarov.recyclerviewoverview.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by i_komarov on 03.02.17.
 */

public class BindableViewHolder<T, L extends BindableViewHolder.ActionListener<T>> extends RecyclerView.ViewHolder {

    private int position;
    private T item;

    public BindableViewHolder(View itemView, final L listener) {
        super(itemView);

        itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.clicks(position, item);
                    }
                }
        );

        itemView.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        listener.longClicks(position, item);
                        return true;
                    }
                }
        );
    }

    public void bind(int position, T item) {
        this.position = position;
        this.item = item;
    }

    public interface ActionListener<T> {

        void clicks(int position, T item);

        void longClicks(int position, T item);
    }
}
