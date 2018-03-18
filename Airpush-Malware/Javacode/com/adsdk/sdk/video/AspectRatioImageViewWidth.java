package com.adsdk.sdk.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class AspectRatioImageViewWidth extends ImageView {
    public AspectRatioImageViewWidth(Context context) {
        super(context);
    }

    public AspectRatioImageViewWidth(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AspectRatioImageViewWidth(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
    }
}
