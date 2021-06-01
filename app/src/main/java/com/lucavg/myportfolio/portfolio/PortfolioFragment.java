package com.lucavg.myportfolio.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lucavg.myportfolio.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class PortfolioFragment extends Fragment implements PortfolioCallback {

    List<PortfolioItem> mdata;
    RecyclerView rv_portfolio;
    PortfolioAdapter portfolioAdapter ;

    public PortfolioFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_portfolio, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_portfolio = view.findViewById(R.id.rv_portfolio);
        mdata = new ArrayList<>();

        mdata.add(new PortfolioItem(R.drawable.android, "Toekomstzicht?"));
        mdata.add(new PortfolioItem(R.drawable.mailtwo, "Schriftelijk Communiceren", "https://drive.google.com/drive/folders/14qFcBIVJLaj7cmgdvmAiYWzweA3GxjRb?usp=sharing"));
        mdata.add(new PortfolioItem(R.drawable.writing, "Schriftelijk Communiceren", "https://www.vlaanderen.be/taaladvies/spellingtests"));
        mdata.add(new PortfolioItem(R.drawable.writing, "Schriftelijk Communiceren", "https://drive.google.com/drive/folders/1LVBeX6GHKl6O0X9AkkNcg5Lyib3oWCyq?usp=sharing"));
        mdata.add(new PortfolioItem(R.drawable.luyten, "Schriftelijk Communiceren", "https://drive.google.com/file/d/1UQ2jwZ8Abbofcwj0-i9fGdH-WKtN2OmD/view?usp=sharing"));
        mdata.add(new PortfolioItem(R.drawable.sap, "Juiste werkhouding & Mondeling Communiceren", "http://www.houtluyten.be/"));
        mdata.add(new PortfolioItem(R.drawable.logo, "Motivatie", "https://github.com/lucavg/My-Portfolio.git"));
        mdata.add(new PortfolioItem(R.drawable.conway, "Motivatie", "https://github.com/lucavg/Game_of_Life.git"));
        mdata.add(new PortfolioItem(R.drawable.friendzone, "Motivatie", "https://github.com/lucavg/Friendzone.git"));
        mdata.add(new PortfolioItem(R.drawable.chiro, "Motivatie", "www.chiro-vorselaar.be"));
        mdata.add(new PortfolioItem(R.drawable.future, "Toekomstplannen", "Afstuderen aan Thomas More Hogeschool met een bachelor in Toegepaste Informatica Application Development."));
        portfolioAdapter = new PortfolioAdapter(mdata,this);

        rv_portfolio.setLayoutManager(new GridLayoutManager(getActivity(),3));
        rv_portfolio.setAdapter(portfolioAdapter);

    }

    @Override
    public void onPortfolioItemClick(int pos) {
        PortfolioFragmentDetails portfolioFragmentDetails =
                new PortfolioFragmentDetails();

        Bundle bundle = new Bundle();
        bundle.putSerializable("object", mdata.get(pos));
        portfolioFragmentDetails.setArguments(bundle);

        portfolioFragmentDetails.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(),"tagname");

    }
}