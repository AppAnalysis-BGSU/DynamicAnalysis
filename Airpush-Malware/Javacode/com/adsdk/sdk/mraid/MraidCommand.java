package com.adsdk.sdk.mraid;

import java.util.Map;

abstract class MraidCommand {
    protected Map<String, String> mParams;
    protected MraidView mView;

    abstract void execute();

    MraidCommand(Map<String, String> params, MraidView view) {
        this.mParams = params;
        this.mView = view;
    }

    protected int getIntFromParamsForKey(String key) {
        int i = -1;
        String s = (String) this.mParams.get(key);
        if (s != null) {
            try {
                i = Integer.parseInt(s, 10);
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    protected String getStringFromParamsForKey(String key) {
        return (String) this.mParams.get(key);
    }

    protected float getFloatFromParamsForKey(String key) {
        float f = 0.0f;
        if (((String) this.mParams.get(key)) != null) {
            try {
                f = Float.parseFloat(key);
            } catch (NumberFormatException e) {
            }
        }
        return f;
    }

    protected boolean getBooleanFromParamsForKey(String key) {
        return "true".equals(this.mParams.get(key));
    }
}
