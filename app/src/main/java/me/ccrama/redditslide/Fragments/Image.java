package me.ccrama.redditslide.Fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import me.ccrama.redditslide.R;
import me.ccrama.redditslide.Reddit;


/**
 * Created by ccrama on 6/2/2015.
 */
public class Image extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.submission_imagecard, container, false);

        final SubsamplingScaleImageView image = (SubsamplingScaleImageView) rootView.findViewById(R.id.image);
        TextView title = (TextView) rootView.findViewById(R.id.title);
        TextView desc = (TextView) rootView.findViewById(R.id.desc);

      title.setVisibility(View.GONE);
        desc.setVisibility(View.GONE);


            ((Reddit) getContext().getApplicationContext()).getImageLoader()
                    .loadImage(url,
                            new SimpleImageLoadingListener() {

                                @Override
                                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                                    image.setImage(ImageSource.bitmap(loadedImage));
                                }
                            });



        return rootView;
    }


String url;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        url = bundle.getString("url");

    }

}
