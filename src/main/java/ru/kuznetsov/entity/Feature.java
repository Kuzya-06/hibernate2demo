package ru.kuznetsov.entity;

import static java.util.Objects.isNull;

public enum Feature {

    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes") ;

    private final String val;

    Feature(String v) {
        this.val = v;
    }

    public String getVal() {
        return val;
    }

    public static Feature getFeatureByVal(String val){
        if(isNull(val) || val.isEmpty()){
            return null;
        }
        Feature[] features = Feature.values();
        for (Feature feature : features) {
            if(feature.val.equals(val)){
                return feature;
            }
        }
        return null;
    }
}
