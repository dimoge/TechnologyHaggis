package me.dimoge.TechnologyHaggis.http;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    Button btn;
    TextView textView;

    RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRequestQueue = Volley.newRequestQueue(MainActivity.this);

        btn = (Button) findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                volley_test();
            }
        });
    }

    /**
     * s使用xutils框架 POST请求方式
     */
    private void xUtils_test(){
        HttpUtils http = new HttpUtils();
        RequestParams params = new RequestParams();
        params.addBodyParameter("displayId", "1111-2222-3333");

        http.send(HttpRequest.HttpMethod.POST,   //@param 请求类型:POST
                "http://192.168.126.19:3000/app_api/display/getInfo.do",    //@param 请求地址 http://www.baidu.com.....
                params, //@param post请求参数
                new RequestCallBack<Object>() {     //@param 请求回调
                    @Override
                    public void onSuccess(ResponseInfo<Object> responseInfo) {
                        Toast.makeText(MainActivity.this, "post请求成功", Toast.LENGTH_SHORT).show();
                        textView.setText(responseInfo.result.toString());
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {
                        Toast.makeText(MainActivity.this, "post请求失败!!!!1" + s, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLoading(long total, long current, boolean isUploading) {
                        super.onLoading(total, current, isUploading);
                    }

                    @Override
                    public void onCancelled() {
                        super.onCancelled();
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                    }

                    @Override
                    protected Object clone() throws CloneNotSupportedException {
                        return super.clone();
                    }
                });
    }

    private void volley_test(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("displayId", "1111-2222-3333");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                "http://192.168.126.19:3000/app_api/display/getInfo.do",
                new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Toast.makeText(MainActivity.this, "volley-post-succe", Toast.LENGTH_SHORT).show();
                        textView.setText(jsonObject.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(MainActivity.this, "volley-post-error"+volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        mRequestQueue.add(jsonObjectRequest);
    }

    private void okHttp_test(){
    }

}
