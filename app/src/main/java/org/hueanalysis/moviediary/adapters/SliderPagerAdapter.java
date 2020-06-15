package org.hueanalysis.moviediary.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.hueanalysis.moviediary.R;
import org.hueanalysis.moviediary.models.HomeSlideMovieModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<HomeSlideMovieModel> mList;

    public SliderPagerAdapter(Context mContext, List<HomeSlideMovieModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayout = inflater.inflate(R.layout.slide_item, null);

        ImageView slideImg = slideLayout.findViewById(R.id.slide_img);
        TextView textView = slideLayout.findViewById(R.id.slide_title);

        slideImg.setImageResource(mList.get(position).getImage());
        textView.setText(mList.get(position).getTitle());

        container.addView(slideLayout);

        return slideLayout;

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
