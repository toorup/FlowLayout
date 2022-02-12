package com.icecool.mylist_xj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class adapter_xianji extends RecyclerView.Adapter<adapter_xianji.MyViewHolder> implements OnClickListener {

    private List<info_xianji> datas;
    private LayoutInflater inflater;
    private RecyclerView rv;


    private OnItemClickListener onItemClickListener;//声明一下这个接口
    //提供setter方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }



    public adapter_xianji(Context context, List<info_xianji> datas, RecyclerView rv) {
        inflater = LayoutInflater.from(context);
        this.datas = datas;
        this.rv=rv;
    }


    // 创建每一行的View 用RecyclerView.ViewHolder包装
    @SuppressLint("InflateParams")
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,parent,false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    // 给每一行View填充数据
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.textview.setText(datas.get(position).gettxt());
        //判断是否选中设置不同背景
        if(datas.get(position).getcheckState()) {
            holder.textview.setBackgroundResource(R.drawable.item_bg_uncheck);
        }else {
            holder.textview.setBackgroundResource(R.drawable.item_bg_checked);
        }
    }


    // 数据源的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textview = (TextView) itemView.findViewById(R.id.zbtitle);
        }
    }


    @Override
    public void onClick(View v) {
        //根据RecyclerView获得当前View的位置
        int position = rv.getChildPosition(v);
        //程序执行到此，会去执行具体实现的onItemClick()方法
        if (onItemClickListener!=null){
            onItemClickListener.onItemClick(rv, v, position, datas);
        }
    }


}
