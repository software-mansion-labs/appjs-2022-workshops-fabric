package com.reactnativeappjs;

import androidx.annotation.NonNull;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.soloader.SoLoader;

import java.util.ArrayList;
import java.util.List;

public class AppjsPackage implements ReactPackage {
    @NonNull
    @Override
    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new Utils(reactContext));
        return modules;
    }

    @NonNull
    @Override
    public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
        if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
          SoLoader.loadLibrary("reactnativeappjs_modules");
        }
        List<ViewManager> viewManagers = new ArrayList<>();
        viewManagers.add(new RNMapViewManager(reactContext));
        return viewManagers;
    }
}
