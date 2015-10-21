package co.tagsurf.tagsurf;

import co.tagsurf.tagsurf.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.view.View;
import android.view.Window;
import android.content.Intent;
import android.net.Uri;
import com.urx.android.AndroidClient;
import com.urx.core.ClientConfig;
import com.urx.android.resolve.AndroidResolver;
import com.urx.core.resolution.UriResolve;

public class MainActivity extends Activity
{
    WebView myWebView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);

        ClientConfig config = new ClientConfig();
        final AndroidClient client = new AndroidClient(config);

        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.contains("tagsurf"))
                    view.loadUrl(url);
                else if (url.contains("urx.io")) {
                    String uri = url.replaceAll("//", "/").replace("https:/urx.io/", "");
                    UriResolve resolution = new UriResolve(uri);
                    Log.i("deep resolution", url);
                    client.resolve(resolution, AndroidResolver.installedApps(MainActivity.this));
                }
                else {
                    final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
                    Log.i("web resolution", url);
                    startActivity(intent);
                }
                return true;
            }
        });
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String ua = webSettings.getUserAgentString();
        webSettings.setUserAgentString(ua + " AndroidWebView");
        myWebView.loadUrl("http://beta.tagsurf.co/share/trending/0");
    }

    @Override
    public void onBackPressed()
    {
        if(myWebView.canGoBack())
            myWebView.goBack();
        else
            super.onBackPressed();
    }
}
