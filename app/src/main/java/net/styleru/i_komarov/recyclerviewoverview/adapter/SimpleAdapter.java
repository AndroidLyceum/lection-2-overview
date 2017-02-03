package net.styleru.i_komarov.recyclerviewoverview.adapter;

import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.util.SortedListAdapterCallback;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.styleru.i_komarov.recyclerviewoverview.R;
import net.styleru.i_komarov.recyclerviewoverview.model.SimpleItemModel;
import net.styleru.i_komarov.recyclerviewoverview.view_holder.BindableViewHolder;
import net.styleru.i_komarov.recyclerviewoverview.view_holder.SimpleViewHolder;

import java.util.List;

/**
 * Created by i_komarov on 03.02.17.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    private SortedList<SimpleItemModel> list;

    //Default implementation to avoid null pointer exceptions
    private BindableViewHolder.ActionListener<SimpleItemModel> listener = new BindableViewHolder.ActionListener<SimpleItemModel>() {
        @Override
        public void clicks(int position, SimpleItemModel item) {
            Log.d("SimpleAdapter", "click was handled by default listener implementation");
        }

        @Override
        public void longClicks(int position, SimpleItemModel item) {
            Log.d("SimpleAdapter", "long click was handled by default listener implementation");
        }
    };

    public SimpleAdapter() {
        this.list = new SortedList<SimpleItemModel>(SimpleItemModel.class, new SortedListAdapterCallback<SimpleItemModel>(this) {
            @Override
            public int compare(SimpleItemModel o1, SimpleItemModel o2) {
                return o1.getPosition() - o2.getPosition();
            }

            @Override
            public boolean areContentsTheSame(SimpleItemModel oldItem, SimpleItemModel newItem) {
                if(oldItem != null && newItem != null) {
                    return oldItem.getTitle().equals(newItem.getTitle()) && oldItem.getSubtitle().equals(newItem.getSubtitle());
                } else {
                    return false;
                }
            }

            @Override
            public boolean areItemsTheSame(SimpleItemModel item1, SimpleItemModel item2) {
                return item1.getPosition() == item2.getPosition();
            }
        });
    }

    public SimpleAdapter(BindableViewHolder.ActionListener<SimpleItemModel> listener) {
        this.listener = listener;
        this.list = new SortedList<>(SimpleItemModel.class, new SortedListAdapterCallback<SimpleItemModel>(this) {
            @Override
            public int compare(SimpleItemModel o1, SimpleItemModel o2) {
                return o1.getPosition() - o2.getPosition();
            }

            @Override
            public boolean areContentsTheSame(SimpleItemModel oldItem, SimpleItemModel newItem) {
                return  oldItem != null && newItem != null &&
                        oldItem.getTitle().equals(newItem.getTitle()) &&
                        oldItem.getSubtitle().equals(newItem.getSubtitle());
            }

            @Override
            public boolean areItemsTheSame(SimpleItemModel item1, SimpleItemModel item2) {
                return item1.getPosition() == item2.getPosition();
            }
        });
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
        this.list.add(item);
    }

    public void add(List<SimpleItemModel> items) {
        this.list.addAll(items);
    }

    public void remove(int position) {
        this.list.removeItemAt(position);
    }

    public void clear() {
        this.list.clear();
    }
}
