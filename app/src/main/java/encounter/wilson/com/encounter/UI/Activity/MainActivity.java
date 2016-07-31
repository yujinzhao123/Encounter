package encounter.wilson.com.encounter.UI.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import encounter.wilson.com.encounter.DTO.Pictrue;
import encounter.wilson.com.encounter.R;
import encounter.wilson.com.encounter.adapter.PicWallAdapter;
import encounter.wilson.com.encounter.util.SpacesItemDecoration;

/**
 * Created by xiaoqiang on 16/7/31.
 */
public class MainActivity extends AppCompatActivity {
    //瀑布流
    private PullLoadMoreRecyclerView pullLoadMoreRecyclerView;
    private PicWallAdapter adapter;

    //测试数据
    ArrayList<Pictrue> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        getdata();
        init();
    }

    private void init() {


        pullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) findViewById(R.id.main_content_list);
        pullLoadMoreRecyclerView.setRefreshing(false);
        pullLoadMoreRecyclerView.setPullRefreshEnable(false);
        pullLoadMoreRecyclerView.setPushRefreshEnable(true);
//        pullLoadMoreRecyclerView.setFooterViewText("loading");
//        pullLoadMoreRecyclerView.setFooterViewTextColor(R.color.white);
//        pullLoadMoreRecyclerView.setFooterViewBackgroundColor(R.color.bg_black);
        pullLoadMoreRecyclerView.setStaggeredGridLayout(2);

        adapter = new PicWallAdapter(this, datas);
        pullLoadMoreRecyclerView.setAdapter(adapter);
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);

    }


    void getdata() {
        List<Integer> piclist = new ArrayList<>();
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
        datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Pictrue p = new Pictrue();
            p.setTestpic(piclist.get(i));
            datas.add(p);
        }
        ;
    }


}
