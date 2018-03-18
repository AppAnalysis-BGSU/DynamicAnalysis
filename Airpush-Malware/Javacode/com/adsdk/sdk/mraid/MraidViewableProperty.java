package com.adsdk.sdk.mraid;

/* compiled from: MraidProperty */
class MraidViewableProperty extends MraidProperty {
    private final boolean mViewable;

    MraidViewableProperty(boolean viewable) {
        this.mViewable = viewable;
    }

    public static MraidViewableProperty createWithViewable(boolean viewable) {
        return new MraidViewableProperty(viewable);
    }

    public String toJsonPair() {
        return "viewable: " + (this.mViewable ? "true" : "false");
    }
}
