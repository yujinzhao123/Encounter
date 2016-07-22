package encounter.wilson.com.encounter.util;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by clevo on 2015/7/27.
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public SpacesItemDecoration(int space) {
        this.space=space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left=space/2;
        outRect.right=space/2;
        outRect.bottom=space+10;
        if(parent.getChildAdapterPosition(view)==0){
            outRect.top=space;
        }
    }
}
