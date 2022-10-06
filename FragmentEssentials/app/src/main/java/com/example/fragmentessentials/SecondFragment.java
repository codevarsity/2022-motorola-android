package com.example.fragmentessentials;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SecondFragment extends Fragment {

    EditText userMessageEditText;
    Button sendButton;
    ImageView imageView;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainView = inflater.inflate(R.layout.fragment_second, container, false);
        userMessageEditText = mainView.findViewById(R.id.userMessageEditText);
        sendButton = mainView.findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userMessage = userMessageEditText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("MESSAGE", userMessage);

                getTargetFragment().onActivityResult(101, Activity.RESULT_OK, intent);
                getParentFragmentManager().popBackStack();
            }
        });
        imageView = mainView.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.steve_jobs);

        return mainView;
    }
}