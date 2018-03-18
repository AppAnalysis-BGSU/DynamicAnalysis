package com.adsdk.sdk.mraid;

import java.util.Map;

/* compiled from: MraidCommand */
class MraidCommandClose extends MraidCommand {
    MraidCommandClose(Map<String, String> params, MraidView view) {
        super(params, view);
    }

    void execute() {
        this.mView.getDisplayController().close();
    }
}
