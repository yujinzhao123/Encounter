package encounter.wilson.com.encounter.UI.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import encounter.wilson.com.encounter.R;
import encounter.wilson.com.encounter.UI.ImageCycleView;
import encounter.wilson.com.encounter.util.Constants;

/**
 * Created by xiaoqiang on 16/7/12.
 */
public class DetailActivity extends Activity {

    private ImageCycleView imageCycleView;
    List<String> ImgUrls = new ArrayList<String>();
    String a = "http://b.hiphotos.baidu.com/zhidao/pic/item/f7246b600c3387443a0c6ee7540fd9f9d62aa064.jpg";
    String b = "http://tupian.enterdesk.com/2013/mxy/0810/07/2.jpg";
    String c = "http://d.5857.com/jxaq_140319/003.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initview();

    }


    private void initview() {
    imageCycleView= (ImageCycleView) findViewById(R.id.detail_pics);
        ImgUrls.add(a);
        ImgUrls.add(b);
        ImgUrls.add(c);
        imageCycleView.setImageResources((ArrayList<String>) ImgUrls, new ImageCycleView.ImageCycleViewListener() {
            @Override
            public void displayImage(String imageURL, ImageView imageView) {
                ImageLoader.getInstance().displayImage(imageURL, imageView, Constants.IM_IMAGE_OPTIONS);
            }

            @Override
            public void onImageClick(int position, View imageView) {

            }
        });
    }
}
