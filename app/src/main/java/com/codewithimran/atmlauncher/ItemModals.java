package com.codewithimran.atmlauncher;

import android.graphics.drawable.Drawable;

public class ItemModals {
    private String packageName;
    private CharSequence name;
    private Drawable image;
    private Boolean isAppInDrawer;

    public ItemModals() {
    }

    public ItemModals(String packageName, CharSequence name) {
        this.packageName = packageName;
        this.name = name;
    }

    public CharSequence getName() {
        return name;
    }

    public void setName(CharSequence name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Boolean getAppInDrawer() {
        return isAppInDrawer;
    }

    public void setAppInDrawer(Boolean appInDrawer) {
        isAppInDrawer = appInDrawer;
    }
}
