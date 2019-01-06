package fr.tse.ihm;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class ListItemViewHolder extends RecyclerView.ViewHolder {

    private CardView listItemCardView;
    private TextView textViewName;


    ListItemViewHolder(@NonNull View itemView) {
        super(itemView);
        listItemCardView = itemView.findViewById(R.id.list_item_view_card);
        textViewName = itemView.findViewById(R.id.list_name_name_text_view);
    }

    void setName(String name, int i) {
        if (i % 2 != 0) {
            listItemCardView.setCardBackgroundColor(Color.GRAY);
            textViewName.setTextColor(Color.WHITE);
        }
        textViewName.setText(name);
    }


}
