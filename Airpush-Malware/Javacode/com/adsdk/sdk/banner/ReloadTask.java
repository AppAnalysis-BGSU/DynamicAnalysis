package com.adsdk.sdk.banner;

import java.util.TimerTask;

class ReloadTask extends TimerTask {
    private final AdView mWebView;

    public ReloadTask(AdView WebView) {
        this.mWebView = WebView;
    }

    public void run() {
        this.mWebView.loadNextAd();
    }
}
