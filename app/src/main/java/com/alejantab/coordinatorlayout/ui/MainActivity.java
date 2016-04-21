package com.alejantab.coordinatorlayout.ui;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.alejantab.coordinatorlayout.R;
import com.alejantab.coordinatorlayout.helpers.DividerItemDecoration;
import com.alejantab.coordinatorlayout.helpers.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);

        AppBarLayout.LayoutParams toolbarParams = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        // Hide Toolbar when is scrolling to down of the list, and show back when the scroll is to up
        toolbarParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);

        // Hide Toolbar when is scrolling to down of the list, and show back when the scroll is to up and the next item to show is the first
//        toolbarParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);

        // Tabs
        TabLayout tabsContainer = (TabLayout) findViewById(R.id.tabsContainer);
        tabsContainer.setTabMode(TabLayout.MODE_FIXED);
        tabsContainer.addTab(tabsContainer.newTab().setText("Tab: 1"));
        tabsContainer.addTab(tabsContainer.newTab().setText("Tab: 2"));
        tabsContainer.addTab(tabsContainer.newTab().setText("Tab: 3"));

        AppBarLayout.LayoutParams tabsParams = (AppBarLayout.LayoutParams) tabsContainer.getLayoutParams();
        // Hide Tabs when is scrolling to down of the list, and show back when the scroll is to up
//        tabsParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);

        // Hide Tabs when is scrolling to down of the list, and show back when the scroll is to up and the next item to show is the first
//        tabsParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);

        // RecyclerView
        RecyclerView recyclerData = (RecyclerView) findViewById(R.id.recyclerData);
        recyclerData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerData.setItemAnimator(new DefaultItemAnimator());
        recyclerData.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.ListOrientation.VERTICAL));

        List<String> data = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            data.add("Test Item #" + i);
        }

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(data);
        recyclerData.setAdapter(recyclerAdapter);
    }
}