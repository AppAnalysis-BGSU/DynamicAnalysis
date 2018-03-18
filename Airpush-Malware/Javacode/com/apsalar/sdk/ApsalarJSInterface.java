package com.apsalar.sdk;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public class ApsalarJSInterface {
    Context mContext;
    int webViewId;

    public ApsalarJSInterface(Context context) {
        this.mContext = context;
    }

    public void registerCallback(String str) {
        if (this.webViewId == 0) {
            Log.d("Apsalar SDK/JSInterface", "WebViewId = 0, Please set your WebViewId");
            return;
        }
        Apsalar.registerCallback(str, (WebView) ((Activity) this.mContext).findViewById(this.webViewId));
        Log.d("Apsalar SDK/JSInterface", "WebViewId " + this.webViewId);
    }

    public void endSession() {
        Apsalar.endSession();
    }

    public void trigger(String str) {
        Apsalar.trigger((Activity) this.mContext, str);
    }

    public void event(String str) {
        Apsalar.event(str);
    }

    public void event(String str, String str2) throws JSONException {
        Apsalar.event(str, new JSONObject(str2));
    }

    public void survey(String str) {
        Apsalar.survey((Activity) this.mContext, str);
    }

    public void setWebViewId(int i) {
        this.webViewId = i;
    }
}
