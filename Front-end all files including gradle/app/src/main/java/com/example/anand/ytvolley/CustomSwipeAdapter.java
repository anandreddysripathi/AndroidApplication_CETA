package com.example.anand.ytvolley;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomSwipeAdapter extends PagerAdapter {
    private int[] images={R.drawable.cyber,R.drawable.code
            ,R.drawable.java,R.drawable.ds1,R.drawable.py,R.drawable.tes,R.drawable.r,};
private Context ctx;
private LayoutInflater layoutInflater;
public CustomSwipeAdapter(Context ctx)
{
    this.ctx=ctx;
}
    public int getCount() {

        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view==o;
    }

    @Override

    public Object instantiateItem(ViewGroup container,int position){
    layoutInflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    //View item=layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView= new ImageView(ctx);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(images[position]);
        container.addView(imageView);
        return imageView;
    }
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
    }
}
