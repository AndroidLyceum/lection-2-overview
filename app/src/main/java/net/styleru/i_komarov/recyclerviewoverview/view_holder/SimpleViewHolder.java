package net.styleru.i_komarov.recyclerviewoverview.view_holder;

import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import net.styleru.i_komarov.recyclerviewoverview.R;
import net.styleru.i_komarov.recyclerviewoverview.model.SimpleItemModel;

/**
 * Created by i_komarov on 03.02.17.
 */

public class SimpleViewHolder extends BindableViewHolder<SimpleItemModel, BindableViewHolder.ActionListener<SimpleItemModel>> {

    private AppCompatTextView headlineHolder;
    private AppCompatTextView subheadingHolder;

    public SimpleViewHolder(View itemView, ActionListener<SimpleItemModel> listener) {
        super(itemView, listener);

        headlineHolder = (AppCompatTextView) itemView.findViewById(R.id.list_item_simple_headline);
        subheadingHolder = (AppCompatTextView) itemView.findViewById(R.id.list_item_simple_subheading);
    }

    @Override
    public void bind(int position, SimpleItemModel item) {
        super.bind(position, item);

        headlineHolder.setText(item.getTitle());
        subheadingHolder.setText(item.getSubtitle());
    }
}
