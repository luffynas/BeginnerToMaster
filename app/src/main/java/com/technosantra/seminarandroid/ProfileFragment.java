package com.technosantra.seminarandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by M. Nashrulloh on 05/04/19.
 * at PT. Ansvia
 * contact us blankcd3@gmail.com or mohammad.nashrulloh@ansvia.com
 */
public class ProfileFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("Lifecycles Fragment", "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Lifecycles Fragment", "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.profile_fragment, container, false);

        Log.d("Lifecycles Fragment", "onCreateView");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Lifecycles Fragment", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Lifecycles Fragment", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Lifecycles Fragment", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Lifecycles Fragment", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Lifecycles Fragment", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Lifecycles Fragment", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycles Fragment", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Lifecycles Fragment", "onDetach");
    }
}
