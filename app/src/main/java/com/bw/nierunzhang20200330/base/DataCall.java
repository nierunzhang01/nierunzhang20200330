package com.bw.nierunzhang20200330.base;

import com.bw.nierunzhang20200330.bean.Goods;
import com.bw.nierunzhang20200330.bean.GoodsInfo;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.30<p>
 * <p>更改时间：2020.3.30<p>
 */
public interface DataCall<T>{
    void sercce(GoodsInfo data );
    void eroor(String eroor);
}
