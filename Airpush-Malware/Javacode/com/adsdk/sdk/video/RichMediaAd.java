package com.adsdk.sdk.video;

import com.adsdk.sdk.Ad;

public class RichMediaAd implements Ad {
    public static final int ANIMATION_FADE_IN = 1;
    public static final int ANIMATION_FLIP_IN = 6;
    public static final int ANIMATION_NONE = 0;
    public static final int ANIMATION_SLIDE_IN_BOTTOM = 3;
    public static final int ANIMATION_SLIDE_IN_LEFT = 4;
    public static final int ANIMATION_SLIDE_IN_RIGHT = 5;
    public static final int ANIMATION_SLIDE_IN_TOP = 2;
    private static final long serialVersionUID = 6443573739926220979L;
    private int animation;
    private InterstitialData interstitial;
    private long timestamp;
    private int type;
    private VideoData video;

    public int getType() {
        return this.type;
    }

    public void setType(int adType) {
        this.type = adType;
    }

    public int getAnimation() {
        return this.animation;
    }

    public void setAnimation(int animation) {
        this.animation = animation;
    }

    public VideoData getVideo() {
        return this.video;
    }

    public void setVideo(VideoData video) {
        this.video = video;
    }

    public InterstitialData getInterstitial() {
        return this.interstitial;
    }

    public void setInterstitial(InterstitialData interstitial) {
        this.interstitial = interstitial;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String toString() {
        return "RichMediaAD [timestamp=" + this.timestamp + ", type=" + this.type + ", animation=" + this.animation + ", video=" + this.video + ", interstitial=" + this.interstitial + "]";
    }
}
