package com.beefnb.dbdemo;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beefnb.dbdemo.db.bean.NoteBean;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>{


    private List<NoteBean>list = new ArrayList<>();

    public void update(List<NoteBean> list){
        this.list = list;
        this.notifyDataSetChanged();
    }

    public NoteAdapter() {}

    @Override
    public NoteAdapter.NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteAdapter.NoteViewHolder holder, int position) {
        holder.setItem(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class NoteViewHolder extends RecyclerView.ViewHolder{

        private TextView content,time;

        public NoteViewHolder(View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.content);
            time = itemView.findViewById(R.id.time);
        }

        public void setItem(NoteBean bean){
            time.setText(bean.getTime());
            content.setText(bean.getContent());
        }

    }

}
