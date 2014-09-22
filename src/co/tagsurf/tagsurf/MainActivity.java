package co.tagsurf.tagsurf;
import co.tagsurf.tagsurf.R;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String ua = webSettings.getUserAgentString();
        webSettings.setUserAgentString(ua + " AndroidWebView");
        myWebView.loadUrl("http://beta.tagsurf.co/share/trending/0");
    }
}
