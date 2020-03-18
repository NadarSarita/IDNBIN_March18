package com.app.idnbin.Chat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



import com.app.idnbin.R;

import java.util.ArrayList;

public class ChatAdapter extends ArrayAdapter<String> {
    String[] names;
    int[] countryFlags;
    Context mContext;

    public ChatAdapter(Context context, String[] countryNames, int[] countryFlags) {
        super(context, R.layout.layout_groupchat);
        this.names = countryNames;
        this.countryFlags = countryFlags;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.layout_groupchat, parent, false);
            mViewHolder.IMG_ChatLogo =  convertView.findViewById(R.id.IMG_ChatLogo);
            mViewHolder.TV_chat =  convertView.findViewById(R.id.TV_chat);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.IMG_ChatLogo.setImageResource(countryFlags[position]);
        mViewHolder.TV_chat.setText(names[position]);

        return convertView;
    }

    public  static class ViewHolder {
        ImageView IMG_ChatLogo;
        TextView TV_chat;
    }
}

//public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
//    ArrayList<String> name;
//    int[] countryFlags;
//  Context mContext;
//  public ChatAdapter(Context context, ArrayList<String> name, int[] countryFlags){
//      this.name = name;
//        this.countryFlags = countryFlags;
//       this.mContext = context;
//  }
//    @NonNull
//    @Override
//    public ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_groupchat,parent,false);
//        return new ChatAdapter.ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder holder, int position) {
//        holder.IMG_ChatLogo.setImageResource(countryFlags[position]);
//        holder.TV_chat.setText(name.get(position));
//        if (position==0){
//            Intent intent = new Intent(mContext, DigitalchatActivity.class);
//            mContext.startActivity(intent);
//
//        }
//        if (position==1){
//            Intent i = new Intent(mContext, ForexChat.class);
//            mContext.startActivity(i);
//        }
//        if (position==2){
//            Intent intent1 = new Intent(mContext, StockActivity.class);
//            mContext.startActivity(intent1);
//        }
//        if (position==3){
//            Intent intent2 = new Intent(mContext, ETFChatActivity.class);
//            mContext.startActivity(intent2);
//        }
//        if (position==4){
//            Intent intent3 = new Intent(mContext, CommodChatActivity.class);
//            mContext.startActivity(intent3);
//        }
//
//        if (position==5){
//            Intent intent4 = new Intent(mContext, CryptochatActivity.class);
//            mContext.startActivity(intent4);
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return name.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//      ImageView IMG_ChatLogo;
//        TextView TV_chat;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            IMG_ChatLogo =  itemView.findViewById(R.id.IMG_ChatLogo);
//            TV_chat =  itemView.findViewById(R.id.TV_chat);
//        }
//    }
//}