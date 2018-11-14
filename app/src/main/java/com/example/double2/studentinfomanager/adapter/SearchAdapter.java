package com.example.double2.studentinfomanager.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.double2.studentinfomanager.R;
import com.example.double2.studentinfomanager.activity.EditActivity;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private Context mContext;

    private ArrayList<String> mNumber;
    private ArrayList<String> mName;

    public final static int maxSize = 60;//最多显示60条

    public SearchAdapter(Context context, ArrayList<String> number, ArrayList<String> name) {
        mContext = context;
        mNumber = number;
        mName = name;
    }

    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View views = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_search, parent, false);

        return new ViewHolder(views);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout llSearch;
        public TextView tvNumber;
        public TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            llSearch = (LinearLayout) itemView.findViewById(R.id.ll_search);
            tvNumber = (TextView) itemView.findViewById(R.id.tv_search_number);
            tvName = (TextView) itemView.findViewById(R.id.tv_search_name);
        }

    }

    @Override
    public void onBindViewHolder(SearchAdapter.ViewHolder holder, final int position) {

        holder.tvNumber.setText(mNumber.get(position));
        holder.tvName.setText(mName.get(position));

        holder.llSearch.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {//跳转到搜索到的学生界面
                                                   Intent intent = new Intent(mContext, EditActivity.class);
                                                   intent.putExtra("type", EditActivity.TYPE_EDIT);
                                                   intent.putExtra("number", mNumber.get(position));
                                                   mContext.startActivity(intent);
                                               }
                                           }
        );

    }

    @Override
    public int getItemCount() {
        if (mNumber.size() < maxSize)
            return mNumber.size();
        else
            return maxSize;
    }


}
