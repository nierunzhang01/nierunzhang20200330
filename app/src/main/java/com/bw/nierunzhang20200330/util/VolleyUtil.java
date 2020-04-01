package com.bw.nierunzhang20200330.util;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bw.nierunzhang20200330.base.IMode;
import com.bw.nierunzhang20200330.base.MyAppliaction;

import org.w3c.dom.EntityReference;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Queue;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.30<p>
 * <p>更改时间：2020.3.30<p>
 */
public class VolleyUtil {
    private static final String TAG="VolleyUtil";
    private static RequestQueue QUEUE= Volley.newRequestQueue(MyAppliaction.getContext());
    public static void request(int methed, String url, IMode iMode){
        if (methed== Request.Method.GET){
            get(url,iMode);
        }
    }

    private static void get(String url, final IMode iMode) {
        final StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, response);
                        iMode.requestserssrcc(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, error.getMessage());
                iMode.requesteroor(error.getMessage());
            }
        }){
            protected Response<String> parseNetworkResponse(NetworkResponse response){
                try {
                    String string = new String(response.data, "UTF-8");
                    return Response.success(string,
                            HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (Exception je) {
                    return Response.error(new ParseError(je));
                }
            }
        };
        QUEUE.add(request);
    }
}
