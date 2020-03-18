package com.app.idnbin.Chat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.app.idnbin.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChatFragment extends Fragment implements View.OnClickListener {
    LinearLayout LL_ChatName;
    String number = "+91 000000000";

    ListView Chatview;
    ChatAdapter chatAdapter;
    Intent i;
    private String[] groupchat = {"Digital Chat","Forex Chat","Stocks Chat","ETF Chat","Commodity Chat","Crypto Chat"};
    private List<String> list = new ArrayList<String>(Arrays.asList(groupchat));
    int[] chatimage = {R.drawable.ic_digital,R.drawable.ic_forex_support,R.drawable.ic_stocks,R.drawable.ic_etf,R.drawable.ic_commodites,R.drawable.ic_crypto,};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        LL_ChatName= view.findViewById(R.id.LL_ChatName);
        Chatview = view.findViewById(R.id.Chatview);

        ChatAdapter myAdapter = new ChatAdapter(getContext(), groupchat, chatimage);
        Chatview.setAdapter(myAdapter);

        LL_ChatName.setOnClickListener(this);

        Chatview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==0){
                    i = new Intent(getContext(),GroupChatActivity.class);
                    i.putExtra("Chat","Digital");
                    startActivity(i);

                }
                if (position==1){
                    i = new Intent(getContext(),GroupChatActivity.class);
                    i.putExtra("Chat","Forex");
                    startActivity(i);

                }
                if (position==2) {
                    i = new Intent(getContext(),GroupChatActivity.class);
                    i.putExtra("Chat","Stocks Chat");
                    startActivity(i);
                }
                if (position==3){
                    i = new Intent(getContext(),GroupChatActivity.class);
                    i.putExtra("Chat","ETF Chat");
                    startActivity(i);

                }
                if (position==4){
                    i = new Intent(getContext(),GroupChatActivity.class);
                    i.putExtra("Chat","Commodity Chat");
                    startActivity(i);

                }
                if (position==5){
                    i = new Intent(getContext(),GroupChatActivity.class);
                    i.putExtra("Chat","Crypto Chat");
                    startActivity(i);

                }
            }

        });

        return view;
    }

    @Override
    public void onClick(View v) {
        String url = "https://api.whatsapp.com/send?phone="+number;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}