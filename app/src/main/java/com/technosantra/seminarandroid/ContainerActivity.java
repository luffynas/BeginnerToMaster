package com.technosantra.seminarandroid;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        ViewPager viewPager = findViewById(R.id.viewPager);
        PageAdapter pagerAdapter = new PageAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new OneFragment());
        pagerAdapter.addFragment(new TwoFragment());
        pagerAdapter.addFragment(new ThreeFragment());
        viewPager.setAdapter(pagerAdapter);
    }
}

class PageAdapter extends FragmentStatePagerAdapter {
    List<Fragment> mFragment = new ArrayList<>();

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment){
        mFragment.add(fragment);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragment.get(i);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }
}

@SuppressLint("ValidFragment")
class OneFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.one_fragment, container, false);

        List<String> mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mData.add("Data ke : "+i);
        }
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mData);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;

    }
}

@SuppressLint("ValidFragment")
class TwoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.two_fragment, container, false);

        return view;

    }
}

@SuppressLint("ValidFragment")
class ThreeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.three_fragment, container, false);
        return view;

    }
}