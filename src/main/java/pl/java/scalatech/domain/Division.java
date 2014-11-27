package pl.java.scalatech.domain;

import lombok.Getter;

public enum Division {
    Heavyweight("heavyweight.message",-1f,-1),
    Cruiserweight("cruiserweight.message",90.719f,200),
    Light_Heavyweight("light_Heavyweight.message",79.379f,175),
    Super_Middleweight("super_Middleweight.message",76.204f,168),
    Middleweight("middleweight.message",72.575f,160),
    Super_Welterweight("super_Welterweight.message",69.853f,154),
    Welterweight("welterweight.message",66.678f,147),
    Super_Lightweight("super_Lightweight.message",63.503f,140),
    Lightweight("lightweight.message",61.235f,135),
    NO_SELECTED("no_SELECTED.message",-1f,-1);
    
    @Getter
    private String name;
    @Getter
    private float weigthKgLimit;
    @Getter
    private int weigthLbLimit;

 

    private Division(String name, float weigthKgLimit, int weigthLbLimit) {
        this.name = name;
        this.weigthKgLimit = weigthKgLimit;
        this.weigthLbLimit = weigthLbLimit;
    }
    
    
    
}
