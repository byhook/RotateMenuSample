package cn.z.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import sample.byhook.rotatemenu.R;

/**
 * Created by byhook on 15-11-16.
 * Mail : byhook@163.com
 * 基本的Item适配对象
 */
public class BaseItemAdapter {

    private Context ctx;

    private List<ApplicationInfo> items;

    private LayoutInflater inflater;

    private PackageManager pm;

    public BaseItemAdapter(Context ctx,List<ApplicationInfo> items) {
        this.ctx = ctx;
        this.items = items;
        this.inflater = LayoutInflater.from(ctx);
        this.pm = ctx.getPackageManager();
    }

    public int getCount() {
        return items.size();
    }

    public View getItem(final int index) {

        TextView child = (TextView) inflater.inflate(R.layout.rotate_item,null);
        child.setText(items.get(index).loadLabel(pm));

        final Drawable drawable = items.get(index).loadIcon(pm);
        drawable.setBounds(0, 0, DimenUtils.getDis(ctx).widthPixels / 9, DimenUtils.getDis(ctx).widthPixels / 9);
        child.setCompoundDrawables(null, drawable, null, null);

        child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, "INDEX=" + drawable.getMinimumHeight() + "/" + drawable.getMinimumWidth(), Toast.LENGTH_SHORT).show();
            }
        });

        return child;
    }

}
