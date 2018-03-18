package com.adsdk.sdk.mraid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

class MraidBrowserController extends MraidAbstractController {
    private static final String LOGTAG = "MraidBrowserController";

    MraidBrowserController(MraidView view) {
        super(view);
    }

    protected void open(String url) {
        Log.d(LOGTAG, "Opening in-app browser: " + url);
        MraidView view = getView();
        if (view.getOnOpenListener() != null) {
            view.getOnOpenListener().onOpen(view);
        }
        Context context = getView().getContext();
        if (url.endsWith(".mp4")) {
            Intent i = new Intent("android.intent.action.VIEW");
            i.setDataAndType(Uri.parse(url), "video/mp4");
            context.startActivity(i);
            return;
        }
        i = new Intent("android.intent.action.VIEW");
        i.setData(Uri.parse(url));
        context.startActivity(i);
    }
}
