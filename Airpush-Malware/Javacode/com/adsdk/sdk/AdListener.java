package com.adsdk.sdk;

public interface AdListener {
    void adClicked();

    void adClosed(Ad ad, boolean z);

    void adLoadSucceeded(Ad ad);

    void adShown(Ad ad, boolean z);

    void noAdFound();
}
