package fr.tse.ihm;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class ListItemViewAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    private final List<String> list;

    ListItemViewAdapter(List<String> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ListItemViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder listItemHolder, int i) {
        listItemHolder.setName(list.get(i), i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
