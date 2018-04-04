package com.suozhang.rentaluser.feature.user.view;

import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.rentaluser.R;

import butterknife.BindView;

public class AuthWebActivity extends BaseActivity {


    @BindView(R.id.webview)
    WebView vWVContent;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private String mUrl = "";

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_auth_web;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initData() {

        mUrl = this.getIntent().getStringExtra("url");
        WebSettings settings = vWVContent.getSettings();
        vWVContent.setWebViewClient(new WebViewClient());
        vWVContent.getSettings().setJavaScriptEnabled(true);
        vWVContent.getSettings().setBuiltInZoomControls(true); //显示放大缩小 controler
        vWVContent.getSettings().setSupportZoom(true); //可以缩放

//屏幕自适应
        vWVContent.getSettings().setUseWideViewPort(true);
        vWVContent.getSettings().setLoadWithOverviewMode(true);

        vWVContent.setInitialScale(100);
        vWVContent.setWebChromeClient(new WebChromeClient() {


            @Override
            public void onProgressChanged(WebView view, int newProgress) {
// TODO Auto-generated method stub
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    progressBar.setProgress(newProgress);
                }

            }

        });
        vWVContent.loadUrl(mUrl);
    }


}



