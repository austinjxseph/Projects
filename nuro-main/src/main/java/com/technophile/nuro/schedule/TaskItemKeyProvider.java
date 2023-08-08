package com.technophile.nuro.schedule;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.widget.RecyclerView;

public class TaskItemKeyProvider extends ItemKeyProvider<Long> {

    private final RecyclerView recyclerView;

    public TaskItemKeyProvider(RecyclerView recyclerView) {
        super(SCOPE_MAPPED);
        this.recyclerView = recyclerView;
    }

    @Nullable
    @Override
    public Long getKey(int position) {
        if (recyclerView.getAdapter() != null) {
            return recyclerView.getAdapter().getItemId(position);
        }
        else {
            return RecyclerView.NO_ID;
        }
    }

    @Override
    public int getPosition(@NonNull Long key) {
        if (recyclerView.getAdapter() != null) {
            return recyclerView.findViewHolderForItemId(key).getAdapterPosition();
        }
        else {
            return RecyclerView.NO_POSITION;
        }
    }
}
