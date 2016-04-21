package com.alejantab.coordinatorlayout.helpers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alejantab.coordinatorlayout.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemVH> {
    private List<String> data;

    public RecyclerAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public ItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler, parent, false);

        return new ItemVH(view);
    }

    @Override
    public void onBindViewHolder(ItemVH holder, int position) {
        holder.txtItem.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return (data != null) ? data.size() : 0;
    }

    public static class ItemVH extends RecyclerView.ViewHolder {
        private TextView txtItem;

        public ItemVH(View itemView) {
            super(itemView);

            txtItem = (TextView) itemView.findViewById(R.id.txtItem);
        }
    }
}