package me.dimoge.TechnologyHaggis.screencapture.window_ball;

public class MainActivity {
    /**
     *

    Button btn_start, btn_end;
    WindowManager mWindowManger;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取
        mWindowManger = (WindowManager) getApplication().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(80, 80);
        params.type= WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        params.gravity = Gravity.CENTER;
        params.width = 80;
        params.height = 80;
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        view = new View(getApplicationContext());
        view.setBackgroundResource(R.mipmap.ic_launcher);


        btn_end = (Button) findViewById(R.id.btn_end);
        btn_start = (Button) findViewById(R.id.btn_start);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWindowManger.addView(view, params);
            }
        });

        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWindowManger.removeViewImmediate(view);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
     */
}
