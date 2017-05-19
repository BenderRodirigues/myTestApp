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
import testapp.spaceo.com.testapp.model.User;
import testapp.spaceo.com.testapp.model.ProfileViewModel;
import testapp.spaceo.com.testapp.repository.UsersRepository;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private Collection<User> objects;

    public ListAdapter() {
        objects = new LinkedList<>();
    }

    public ListAdapter addItems(Collection<User> items) {
        if(items != null) {
            objects.addAll(items);
            notifyDataSetChanged();
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
        User item = getItem(position);
        holder.update(item);
    }

    private User getItem(int position) {
        return ((LinkedList<User>) objects).get(position);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements ViewHolderInterface<User> {

        private final ItemBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }


        @Override
        public void update(final User item) {
            binding.setViewModel(new ProfileViewModel());
        }
    }
}
