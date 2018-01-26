package com.gmgroup.temcliente;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    ImageView imageView;
    RelativeLayout tutorialView;
    ViewPager tutorialPager;
    LinearLayout dotsView;
    ImageView dots[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);
        imageView = (ImageView)findViewById(R.id.imageView);
        tutorialView = (RelativeLayout)findViewById(R.id.tutorialView);
        tutorialPager = (ViewPager)findViewById(R.id.tutorialPager);
        dotsView = (LinearLayout)findViewById(R.id.dotsView);

        webView.setVisibility(View.INVISIBLE);
        tutorialView.setVisibility(View.INVISIBLE);
        imageView.setVisibility(View.VISIBLE);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(10,10);
        layoutParams.setMargins(5,0,0,0);
        dots = new ImageView[4];
        dots[0] = new ImageView(getBaseContext());
        dots[0].setImageResource(R.drawable.doton);
        dots[1] = new ImageView(getBaseContext());
        dots[1].setImageResource(R.drawable.dotoff);
        dots[2] = new ImageView(getBaseContext());
        dots[2].setImageResource(R.drawable.dotoff);
        dots[3] = new ImageView(getBaseContext());
        dots[3].setImageResource(R.drawable.dotoff);
        for (int i=0; i < dots.length; i++)
            dotsView.addView(dots[i],layoutParams);

        tutorialPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                for (int i=0; i < dots.length; i++) {
                    if (i==position)
                        dots[i].setImageResource(R.drawable.doton);
                    else
                        dots[i].setImageResource(R.drawable.dotoff);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        tutorialPager.setAdapter(new TutorialPagerAdapter(getSupportFragmentManager()));

        webView.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view,url);

                webView.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);
                tutorialView.setVisibility(View.VISIBLE);
            }
        });

        webView.loadUrl("https://www.temcliente.com/entrada/");

        Button btnEntendi = (Button)findViewById(R.id.btnEntendi);

        btnEntendi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tutorialView.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);
            }
        });
    }
}