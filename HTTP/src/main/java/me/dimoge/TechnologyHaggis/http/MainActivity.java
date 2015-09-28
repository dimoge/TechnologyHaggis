package me.dimoge.TechnologyHaggis.http;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

public class MainActivity extends Activity {

    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                HttpUtils http = new HttpUtils();
                RequestParams params = new RequestParams();
                params.addBodyParameter("displayId", "0000-11111-2222-3333");

                http.send(HttpRequest.HttpMethod.POST,   //@param 请求类型:POST
                        "http://sbuu.danwi.me/app_api/display/getInfo.do",    //@param 请求地址 http://www.baidu.com.....
                        params, //@param post请求参数
                        new RequestCallBack<Object>() {     //@param 请求回调
                            @Override
                            public void onSuccess(ResponseInfo<Object> responseInfo) {
                                Toast.makeText(MainActivity.this, "post请求成功", Toast.LENGTH_SHORT).show();
                                textView.setText(responseInfo.result.toString());
                            }

                            @Override
                            public void onFailure(HttpException e, String s) {
                                Toast.makeText(MainActivity.this, "post请求失败!!!!1"+s, Toast.LENGTH_SHORT).show();
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
        });
    }

}
