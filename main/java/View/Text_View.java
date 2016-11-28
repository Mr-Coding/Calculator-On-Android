package View;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class Text_View extends TextView {
    public Text_View(Context context) {
        super(context);
        Typeface typeface = Typeface.createFromAsset(context.getResources().getAssets(),"font/DS-DIGIT.TTF");
        init(typeface);
    }

    public Text_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface typeface = Typeface.createFromAsset(context.getResources().getAssets(),"font/DS-DIGIT.TTF");
        init(typeface);
    }
    public void init(Typeface typeface){
        setTextColor(Color.BLACK);
        setTypeface(typeface);
        setSingleLine(true);
    }

}
