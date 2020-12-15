package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adpater extends RecyclerView.Adapter<Adpater.Viewholder> {

ArrayList<String> v;
Context context;

    public Adpater( Context context,ArrayList<String> v) {
        this.v = v;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.itemview,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
     holder.textView.setText(v.get(position));

    }


    @Override
    public int getItemCount() {
        return v.size()-1;
    }
    public class Viewholder extends RecyclerView.ViewHolder{
public TextView textView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText(textView.getText()+" click ");
                }
            });
          textView= itemView.findViewById(R.id.text);

        }

    }

}
