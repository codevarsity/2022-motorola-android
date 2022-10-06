package com.example.fragmentessentials;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class FirstFragment extends Fragment {

    String message;

    Button launchSecondButton;


    public static FirstFragment newFragment(String message) {
        FirstFragment ff = new FirstFragment();
        Bundle b = new Bundle();
        b.putString("message", "Hello from First");
        ff.setArguments(b);
        return ff;
    }


    //must have a default constructor
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            Bundle extraBundle = getArguments();
            String message = extraBundle.getString("message");
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainView = inflater.inflate(R.layout.fragment_first, container, false);
        launchSecondButton = mainView.findViewById(R.id.launchSecondButton);
        launchSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //launch the second fragment
                SecondFragment sf = new SecondFragment();
                sf.setTargetFragment(FirstFragment.this, 101);
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.remove(FirstFragment.this).add(R.id.mainLayout, sf, "SF")
                        .addToBackStack("FF->SF").commit();
            }
        });
        return mainView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == Activity.RESULT_OK && data != null) {
            String message = data.getStringExtra("MESSAGE");
            Log.i("FirstFragment", "message from second " + message );
        }

    }
}