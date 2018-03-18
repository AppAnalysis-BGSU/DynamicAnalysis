package com.adsdk.sdk.mraid;

/* compiled from: MraidProperty */
class MraidScreenSizeProperty extends MraidProperty {
    private final int mScreenHeight;
    private final int mScreenWidth;

    MraidScreenSizeProperty(int width, int height) {
        this.mScreenWidth = width;
        this.mScreenHeight = height;
    }

    public static MraidScreenSizeProperty createWithSize(int width, int height) {
        return new MraidScreenSizeProperty(width, height);
    }

    public String toJsonPair() {
        return "screenSize: { width: " + this.mScreenWidth + ", height: " + this.mScreenHeight + " }";
    }
}
