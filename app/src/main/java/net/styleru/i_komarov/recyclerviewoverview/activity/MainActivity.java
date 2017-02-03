package net.styleru.i_komarov.recyclerviewoverview.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import net.styleru.i_komarov.recyclerviewoverview.R;
import net.styleru.i_komarov.recyclerviewoverview.adapter.SimpleAdapter;
import net.styleru.i_komarov.recyclerviewoverview.model.SimpleItemModel;
import net.styleru.i_komarov.recyclerviewoverview.view_holder.BindableViewHolder;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BindableViewHolder.ActionListener<SimpleItemModel> {

    private RecyclerView list;
    private SimpleAdapter adapter;
    private ViewModelGenerator generator = new ViewModelGenerator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViewComponents();
    }

    private void bindViewComponents() {
        list = (RecyclerView) findViewById(R.id.activity_main_recycler_view);
        //this below - is casting MainActivity to Context class, which is superclass for Activity
        list.setLayoutManager(new LinearLayoutManager(this));
        //this below - is casting MainActivity to ActionListener that it implements
        adapter = new SimpleAdapter(this);
        list.setAdapter(adapter);
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        adapter.add(generator.generate());
                    }
                },
                500
        );

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        adapter.add(generator.generate());
                    }
                },
                5000
        );

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        adapter.add(generator.generate());
                    }
                },
                8000
        );
    }

    @Override
    public void clicks(int position, SimpleItemModel item) {
        Toast.makeText(this, "Item was clicked at position: " + position, Toast.LENGTH_LONG).show();
    }

    @Override
    public void longClicks(int position, SimpleItemModel item) {
        Toast.makeText(this, "Item was long clicked at position: " + position, Toast.LENGTH_LONG).show();
    }

    private static class ViewModelGenerator {

        private int position = 0;

        public List<SimpleItemModel> generate() {
            return Arrays.asList(
                    new SimpleItemModel(position, "Headline " + position, "Subheading " + position++),
                    new SimpleItemModel(position, "Headline " + position, "Subheading " + position++),
                    new SimpleItemModel(position, "Headline " + position, "Subheading " + position++),
                    new SimpleItemModel(position, "Headline " + position, "Subheading " + position++),
                    new SimpleItemModel(position, "Headline " + position, "Subheading " + position++),
                    new SimpleItemModel(position, "Headline " + position, "Subheading " + position++),
                    new SimpleItemModel(position, "Headline " + position, "Subheading " + position++),
                    new SimpleItemModel(position, "Headline " + position, "Subheading " + position++),
                    new SimpleItemModel(position, "Headline " + position, "Subheading " + position++),
                    new SimpleItemModel(position, "Headline " + position, "Subheading " + position++)
            );
        }
    }
}
