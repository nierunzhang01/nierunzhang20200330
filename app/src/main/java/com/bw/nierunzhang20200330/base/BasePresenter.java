package com.bw.nierunzhang20200330.base;

import com.android.volley.Request;
import com.bw.nierunzhang20200330.bean.GoodsInfo;
import com.bw.nierunzhang20200330.util.VolleyUtil;
import com.google.gson.Gson;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.30<p>
 * <p>更改时间：2020.3.30<p>
 */
public  abstract class BasePresenter {
    public static final Gson GSON=new Gson();
    private DataCall dataCall;

    public BasePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }

    protected abstract String getUrl(String...args);
    protected abstract GoodsInfo getData(String json);
    public void request(String...args){
        VolleyUtil.request(Request.Method.GET, getUrl(args), new IMode() {
            @Override
            public void requestserssrcc(String json) {
                final GoodsInfo data = getData(json);
                dataCall.sercce(data);
            }

            @Override
            public void requesteroor(String eroor) {
                    dataCall.eroor(eroor);
            }
        });
    }
}
