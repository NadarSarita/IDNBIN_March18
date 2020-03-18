package com.app.idnbin.HomeScreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.idnbin.R;

public class PresetsAdapter extends RecyclerView.Adapter<PresetsAdapter.ItemViewHolder> {

    private String[] a;
    private Context context;
    onItemClickListner onItemClickListner;

    public PresetsAdapter(Context context, String[] a) {
        this.context = context;
        this.a = a;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_presets, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.TvPresets.setText(a[position]);
        holder.TvPresets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListner.onClick(a);
            }
        });
    }

    @Override
    public int getItemCount() {
        return a.length;
    }

    public void onItemClickListner(PresetsAdapter.onItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public interface onItemClickListner{
        void onClick(String[] str);//pass your object types.
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView TvPresets;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            TvPresets = itemView.findViewById(R.id.TvPresets);
        }
    }
}
