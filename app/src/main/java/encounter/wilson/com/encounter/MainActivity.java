package encounter.wilson.com.encounter;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import encounter.wilson.com.encounter.UI.Activity.DetailActivity;
import encounter.wilson.com.encounter.UI.RecycleItemClickListener;
import encounter.wilson.com.encounter.adapter.MasonryAdapter;
import encounter.wilson.com.encounter.util.SpacesItemDecoration;
import encounter.wilson.com.encounter.util.Tool;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private List<Integer> piclist;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        // 透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        Tool.setStatusBar(this);
        setContentView(R.layout.activity_main);


        initview();
    }


    private void initview() {
        piclist = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        toolbar = (Toolbar) findViewById(R.id.homepage_toolbar);
//
//        this.setSupportActionBar(toolbar);
////        toolbar.setNavigationIcon(R.mipmap.icon_list);
//        this.getSupportActionBar().setHomeButtonEnabled(true);
//        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
//        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close) {
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//            }
//        };
//        drawerToggle.syncState();
//        drawerLayout.setDrawerListener(drawerToggle);

        //set RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        initData();
        RecycleItemClickListener recycleItemClickListener=new RecycleItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(MainActivity.this, DetailActivity.class));
            }
        };
        MasonryAdapter adapter = new MasonryAdapter(piclist,recycleItemClickListener);
        recyclerView.setAdapter(adapter);
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        recyclerView.addItemDecoration(decoration);

    }


    private void initData() {
        piclist.add(R.mipmap.p1);
        piclist.add(R.mipmap.p2);
        piclist.add(R.mipmap.p3);
        piclist.add(R.mipmap.p4);
        piclist.add(R.mipmap.p5);
        piclist.add(R.mipmap.p1);
        piclist.add(R.mipmap.p2);
        piclist.add(R.mipmap.p3);
        piclist.add(R.mipmap.p4);
        piclist.add(R.mipmap.p5);
        piclist.add(R.mipmap.p4);
    }
}

