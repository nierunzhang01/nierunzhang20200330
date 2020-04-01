package com.bw.nierunzhang20200330.presenter;

import com.bw.nierunzhang20200330.activity.MainActivity;
import com.bw.nierunzhang20200330.base.BasePresenter;
import com.bw.nierunzhang20200330.base.DataCall;
import com.bw.nierunzhang20200330.bean.Goods;
import com.bw.nierunzhang20200330.bean.GoodsInfo;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.30<p>
 * <p>更改时间：2020.3.30<p>
 */
public class GoodsPresenter extends BasePresenter {


    public GoodsPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected String getUrl(String... args) {
        return "http://blog.zhaoliang5156.cn/api/shop/fulishe.json";
    }

    @Override
    protected GoodsInfo getData(String json) {
        final Type type = new TypeToken<GoodsInfo>() {
        }.getType();
        return GSON.fromJson(json, type);
    }
}
