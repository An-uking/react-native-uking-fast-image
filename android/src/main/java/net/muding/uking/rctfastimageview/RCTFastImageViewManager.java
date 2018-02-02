package net.muding.uking.rctfastimageview;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by uking on 2018/2/1.
 */

public class RCTFastImageViewManager extends SimpleViewManager<ImageView>  {

    private static final String TAG = "RCTFastImageView";
    private Context context;
    private String src;
    private String placeholder;
    private ImageView.ScaleType scaleType;

    @Override
    public String getName() {
        return TAG;
    }

    public RCTFastImageViewManager(Context context) {
        this.context=context;
    }

    @Override
    protected ImageView createViewInstance(ThemedReactContext reactContext) {

        if (context == null) {
            context = reactContext;
        }
        return new ImageView(context);
    }
    @ReactProp(name = "src")
    public void setSrc(ImageView imageView ,String src){
        this.src=src;
    }
    @ReactProp(name = "placeholder")
    public void setPlaceholder(ImageView imageView ,String placeholder){
        this.placeholder=placeholder;
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(ImageView view, String resizeMode) {
        //this.scaleType = ImageView.ScaleType.valueOf(resizeMode);
        switch (resizeMode){
            case "contain":
                this.scaleType=ImageView.ScaleType.FIT_CENTER;
                break;
            case "stretch":
                this.scaleType=ImageView.ScaleType.FIT_XY;
                break;
            case "center":
                this.scaleType=ImageView.ScaleType.CENTER;
                break;
            case "cover":
            default:
                this.scaleType=ImageView.ScaleType.CENTER_CROP;
                break;
        }
    }
    @Override
    public void onDropViewInstance(ImageView view) {
        Glide.clear(view);
        super.onDropViewInstance(view);
    }

    @Override
    protected void onAfterUpdateTransaction(ImageView view) {
        Glide.clear(view);
        Glide
                .with(this.context.getApplicationContext())
                .load(this.src).placeholder(getSplashId(this.placeholder))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontTransform()
                .skipMemoryCache(true)
                .crossFade()
                .into(view);
        view.setScaleType(this.scaleType);
        super.onAfterUpdateTransaction(view);
    }
    private int getSplashId(String s) {
        if (context != null&&s!=null&&!s.isEmpty()) {
            int drawableId = context.getResources().getIdentifier(s, "drawable", context.getClass().getPackage().getName());
            if (drawableId == 0) {
                drawableId = context.getResources().getIdentifier(s, "drawable", context.getPackageName());
            }
            return drawableId;
        }
        return 0;
    }
}
