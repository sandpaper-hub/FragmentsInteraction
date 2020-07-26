package com.example.constantinekim.fragmentsinteraction;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Date;

public class ListFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        Button button = view.findViewById(R.id.update_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail();
            }
        });

        return view;
    }

    interface OnFragmentInteractionListener {
        void onFragmentInteraction(String link);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }

    public void updateDetail() {
        String currentDate = new Date().toString();
        mListener.onFragmentInteraction(currentDate);
    }
}
