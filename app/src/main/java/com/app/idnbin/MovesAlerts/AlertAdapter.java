package com.app.idnbin.MovesAlerts;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.app.idnbin.R;
import java.util.ArrayList;


public class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.Viewholder> {
    Context context;
    ArrayList<String> alertList ;
    public  AlertAdapter (Context context , ArrayList<String> alertList){
        this.context =context;
        this.alertList = alertList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.alerts_list,parent,false);

        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        holder.tv_st.setText(alertList.get(position));
        holder.tv_cncy.setText(alertList.get(position));

    }

    @Override
    public int getItemCount() {
        return alertList.size();
    }

    public  class Viewholder extends RecyclerView.ViewHolder{

        TextView tv_st,tv_cncy;


        public Viewholder(@NonNull View itemView) {

            super(itemView);
            tv_cncy = itemView.findViewById(R.id.tv_cncy);
            tv_st=itemView.findViewById(R.id.tv_st);


        }
    }
}

