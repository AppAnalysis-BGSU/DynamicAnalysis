package com.adsdk.sdk.mraid;

/* compiled from: MraidProperty */
class MraidPlacementTypeProperty extends MraidProperty {
    private final PlacementType mPlacementType;

    MraidPlacementTypeProperty(PlacementType placementType) {
        this.mPlacementType = placementType;
    }

    public static MraidPlacementTypeProperty createWithType(PlacementType placementType) {
        return new MraidPlacementTypeProperty(placementType);
    }

    public String toJsonPair() {
        return "placementType: '" + this.mPlacementType.toString().toLowerCase() + "'";
    }
}
