package com.bw.nierunzhang20200330.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.nierunzhang20200330.R;
import com.bw.nierunzhang20200330.adapter.GoodAdapter;
import com.bw.nierunzhang20200330.base.BaseActivity;
import com.bw.nierunzhang20200330.base.DataCall;
import com.bw.nierunzhang20200330.base.OnClick;
import com.bw.nierunzhang20200330.bean.Goods;
import com.bw.nierunzhang20200330.bean.GoodsInfo;
import com.bw.nierunzhang20200330.presenter.GoodsPresenter;

import java.util.List;

public class MainActivity extends BaseActivity {
        EditText name;
        Button button;
    RecyclerView heng, zong, wang;
    GoodsPresenter goodsPresenter;
    GoodAdapter hengAdapter, zongAdapter, wangAdapter;
Goods goods;
    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        name=findViewById(R.id.edit_name);
        button=findViewById(R.id.button);
        final String na = name.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Toast.makeText(getBaseContext(), "找不到您搜索的商品", Toast.LENGTH_SHORT).show();

            }
        });

        heng = findViewById(R.id.bangdan);
        heng.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        hengAdapter = new GoodAdapter();
        heng.setAdapter(hengAdapter);
        hengAdapter.setOnClick(new OnClick() {
            @Override
            public void OnClick(Goods goods) {
                Toast.makeText(MainActivity.this, goods.goods_name, Toast.LENGTH_SHORT).show();
            }
        });
        zong = findViewById(R.id.duoshou);
        zong.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        zongAdapter = new GoodAdapter();
        zong.setAdapter(zongAdapter);
        zongAdapter.setOnClick(new OnClick() {
            @Override
            public void OnClick(Goods goods) {
                Toast.makeText(MainActivity.this, goods.goods_name, Toast.LENGTH_SHORT).show();
            }
        });
        wang = findViewById(R.id.fulishe);
        wang.setLayoutManager(new GridLayoutManager(this, 2));
        wangAdapter = new GoodAdapter();
        wang.setAdapter(wangAdapter);
        wangAdapter.setOnClick(new OnClick() {
            @Override
            public void OnClick(Goods goods) {
                Toast.makeText(MainActivity.this, goods.goods_name, Toast.LENGTH_SHORT).show();
            }
        });
        goodsPresenter = new GoodsPresenter(new GoodsCall());
        goodsPresenter.request();
    }

     class GoodsCall implements DataCall<GoodsInfo> {
        @Override
        public void sercce(GoodsInfo data) {
            hengAdapter.addAll(data.data_one);
            zongAdapter.addAll(data.data_two);
            wangAdapter.addAll(data.data_three);
            hengAdapter.notifyDataSetChanged();
            zongAdapter.notifyDataSetChanged();
            wangAdapter.notifyDataSetChanged();
        }

        @Override
        public void eroor(String eroor) {

        }
    }
}






     /*
     *  hengAdapter.addAll((List<Goods>) data.data_one);
             zongAdapter.addAll((List<Goods>) data.data_two);
             wangAdapter.addAll((List<Goods>) data.data_three);
             hengAdapter.notifyDataSetChanged();
             zongAdapter.notifyDataSetChanged();
             wangAdapter.notifyDataSetChanged();
     * */

