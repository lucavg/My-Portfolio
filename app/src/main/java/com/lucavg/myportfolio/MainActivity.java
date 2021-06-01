package com.lucavg.myportfolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.lucavg.myportfolio.cv.CVFragment;
import com.lucavg.myportfolio.home.HomeFragment;
import com.lucavg.myportfolio.portfolio.PortfolioFragment;
import com.lucavg.myportfolio.sidemenu.Callback;
import com.lucavg.myportfolio.sidemenu.MenuAdapter;
import com.lucavg.myportfolio.sidemenu.MenuItem;
import com.lucavg.myportfolio.sidemenu.MenuUtil;
import com.lucavg.myportfolio.skills.SkillsFragment;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements Callback {

    RecyclerView menuRv;
    List<MenuItem> menuItems;
    MenuAdapter adapter;
    int selectedMenuPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        // setup side menu
        setupSideMenu();

        // set the default fragment when activity launch
        setHomeFragment();


    }

    private void setupSideMenu() {

        menuRv = findViewById(R.id.rv_side_menu);

        // get menu list item  will get data from a static data class

        menuItems = MenuUtil.getMenuList();
        adapter = new MenuAdapter(menuItems, this);
        menuRv.setLayoutManager(new LinearLayoutManager(this));
        menuRv.setAdapter(adapter);

    }

    void setPortfoliofragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PortfolioFragment()).commit();
    }

    void setCVFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CVFragment()).commit();
    }


    void setHomeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }

    void setSkillsFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new SkillsFragment()).commit();
    }


    @Override
    public void onSideMenuItemClick(int i) {

        switch (menuItems.get(i).getCode()) {

            case MenuUtil.HOME_FRAGMENT_CODE:
                setHomeFragment();
                break;
            case MenuUtil.CV_FRAGMENT_CODE:
                setCVFragment();
                break;
            case MenuUtil.SKILLS_FRAGMENT_CODE:
                setSkillsFragment();
                break;
            case MenuUtil.PORTFOLIO_FRAGMENT_CODE:
                setPortfoliofragment();
                break;
            default:
                setHomeFragment();
        }

        // hightligh the selected menu item

        menuItems.get(selectedMenuPos).setSelected(false);
        menuItems.get(i).setSelected(true);
        selectedMenuPos = i;
        adapter.notifyDataSetChanged();

    }
}