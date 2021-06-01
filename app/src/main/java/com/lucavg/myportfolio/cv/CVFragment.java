package com.lucavg.myportfolio.cv;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lucavg.myportfolio.R;

import java.util.ArrayList;
import java.util.List;

public class CVFragment extends Fragment {

    RecyclerView RvCv;
    CVAdapter adapter;
    List<CVItem> items;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RvCv = view.findViewById(R.id.recyclerview_cv);

        //new list created
        items = new ArrayList<>();
        items.add(new CVItem(getString(R.string.carrefourTitle), getString(R.string.carrefour)));
        items.add(new CVItem(getString(R.string.ecoverTitle), getString(R.string.ecover)));
        items.add(new CVItem(getString(R.string.koshTitle), getString(R.string.kosh)));
        items.add(new CVItem(getString(R.string.kdgTitle), getString(R.string.kdg)));
        items.add(new CVItem(getString(R.string.luytenTitle), getString(R.string.luyten)));

        adapter = new CVAdapter(items);
        RvCv.setLayoutManager(new LinearLayoutManager(getContext()));
        RvCv.setAdapter(adapter);

    }

    public CVFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c_v, container, false);
    }
}