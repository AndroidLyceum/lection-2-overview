package net.styleru.i_komarov.recyclerviewoverview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.styleru.i_komarov.recyclerviewoverview.R;
import net.styleru.i_komarov.recyclerviewoverview.model.SimpleItemModel;
import net.styleru.i_komarov.recyclerviewoverview.view_holder.BindableViewHolder;
import net.styleru.i_komarov.recyclerviewoverview.view_holder.SimpleViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i_komarov on 04.02.17.
 */

public class VerySimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    private BindableViewHolder.ActionListener<SimpleItemModel> listener = new BindableViewHolder.ActionListener<SimpleItemModel>() {
        @Override
        public void clicks(int position, SimpleItemModel item) {

        }

        @Override
        public void longClicks(int position, SimpleItemModel item) {

        }
    };

    private List<SimpleItemModel> list;

    public VerySimpleAdapter() {
        this.list = new ArrayList<>();
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimpleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_simple, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.bind(position, list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void add(SimpleItemModel item) {
        final int insertPosition = this.list.size();
        this.list.add(item);
        notifyItemInserted(insertPosition);
    }

    public void add(List<SimpleItemModel> items) {
        final int insertPosition = this.list.size();
        final int itemCount = items.size();
        this.list.addAll(items);
        notifyItemRangeInserted(insertPosition, itemCount);
    }

    public void remove(int position) {
        this.list.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        final int itemCount = this.list.size();
        this.list.clear();
        notifyItemRangeRemoved(0, itemCount);
    }
}
