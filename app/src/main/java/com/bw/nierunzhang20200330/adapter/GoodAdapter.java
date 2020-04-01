package com.bw.nierunzhang20200330.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.nierunzhang20200330.R;
import com.bw.nierunzhang20200330.base.OnClick;
import com.bw.nierunzhang20200330.bean.Goods;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.30<p>
 * <p>更改时间：2020.3.30<p>
 */
public class GoodAdapter extends RecyclerView.Adapter<GoodAdapter.MyHolder> {
    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }
List<Goods> list=new ArrayList<>();
    public void addAll(List<Goods> data){
        if (data!=null){
            list.addAll(data);
        }

    }
    @NonNull
    @Override
    public GoodAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_top, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodAdapter.MyHolder myHolder, int i) {
        final Goods goods = list.get(i);
        myHolder.name.setText(goods.goods_name);
        myHolder.price.setText("$"+goods.currency_price);
        myHolder.itemView.setTag(goods);
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick!=null){
                    onClick.OnClick((Goods)v.getTag() );
                }
            }
        });
        final RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.a)
                .fallback(R.drawable.a)
                .error(R.drawable.a)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(40)));
        Glide.with(myHolder.image.getContext())
                .applyDefaultRequestOptions(options)
                .load(goods.goods_thumb).into(myHolder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name,price;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageview);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
        }
    }
}
