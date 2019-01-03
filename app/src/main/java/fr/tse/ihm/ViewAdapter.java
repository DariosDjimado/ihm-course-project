package fr.tse.ihm;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<String> list;

    ViewAdapter(List<String> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String name = list.get(i);
        System.out.println(name);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
