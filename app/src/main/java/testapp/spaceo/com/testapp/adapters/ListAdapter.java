package testapp.spaceo.com.testapp.adapters;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collection;
import java.util.LinkedList;

import testapp.spaceo.com.testapp.R;
import testapp.spaceo.com.testapp.databinding.ItemBinding;
import testapp.spaceo.com.testapp.model.ListItem;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private Collection<ListItem> objects;

    public ListAdapter() {
        objects = new LinkedList<>();
    }

    public ListAdapter addItems(Collection<ListItem> items) {
        if(items != null) {
            objects.addAll(items);
        }
        return this;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem item = getItem(position);
        holder.update(item);
    }

    private ListItem getItem(int position) {
        return ((LinkedList<ListItem>) objects).get(position);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements ViewHolderInterface<ListItem> {

        private final ItemBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }


        @Override
        public void update(ListItem item) {
            binding.setItem(item);
        }
    }
}
