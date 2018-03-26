package com.johnhao.listviewdemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.johnhao.listviewdemo.Fragment.RightFragment;
import com.johnhao.listviewdemo.R;

public class FragmentSimActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_sim);
        setTitle("Fragment");
    }
}
