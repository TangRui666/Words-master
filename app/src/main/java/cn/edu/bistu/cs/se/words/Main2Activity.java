package cn.edu.bistu.cs.se.words;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.webkit.WebViewClient;
public class Main2Activity extends AppCompatActivity {
    private TextView tips;
   // private EditText editText;
    private WebView webView;
    private Handler tHandler = new Handler();
   // private Button b_return;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        webView=(WebView)findViewById(R.id.toutput);
        final Button submit=(Button)findViewById(R.id.submit);
        //editText=(EditText)findViewById(R.id.tinput);
       // tips=(TextView)findViewById(R.id.tips);
       // b_return = (Button)findViewById(R.id.b);



      /*  b_return.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });*/

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSaveFormData(false);
        webSettings.setSavePassword(false);
        webSettings.setSupportZoom(false);
        submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //tips.setVisibility(TextView.VISIBLE);
                webView.setVisibility(WebView.VISIBLE);
                tHandler.post(new Runnable(){
                    public void run(){
                        //if (editText.getText().toString() != ""){
                         //  webView.loadUrl("http://dict.cn/mini.php?q="+ editText.getText().toString());
                       // }
                        webView.loadUrl("http://m.enread.com/index.php?catid=13&mid=2");
                    }


                    class webViewClient extends WebViewClient{

                        //重写shouldOverrideUrlLoading方法，使点击链接后不使用其他的浏览器打开。

                        @Override

                        public boolean shouldOverrideUrlLoading(WebView view, String url) {

                            view.loadUrl(url);

                            //如果不需要其他对点击链接事件的处理返回true，否则返回false

                            return true;

                        }
                    }


                });
            }
        });






    }
}