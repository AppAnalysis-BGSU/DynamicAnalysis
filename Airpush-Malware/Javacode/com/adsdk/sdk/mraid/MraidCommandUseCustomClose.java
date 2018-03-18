package com.adsdk.sdk.mraid;

import java.util.Map;

/* compiled from: MraidCommand */
class MraidCommandUseCustomClose extends MraidCommand {
    MraidCommandUseCustomClose(Map<String, String> params, MraidView view) {
        super(params, view);
    }

    void execute() {
        this.mView.getDisplayController().useCustomClose(getBooleanFromParamsForKey("shouldUseCustomClose"));
    }
}
