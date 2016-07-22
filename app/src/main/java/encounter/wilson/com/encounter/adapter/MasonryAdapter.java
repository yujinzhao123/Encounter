package encounter.wilson.com.encounter.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.joooonho.SelectableRoundedImageView;

import java.util.List;

import encounter.wilson.com.encounter.R;
import encounter.wilson.com.encounter.UI.RecycleItemClickListener;

/**
 * Created by clevo on 2015/7/27.
 */

public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryView> {
    private List<Integer> products;
    private static RecycleItemClickListener itemClickListener;


    public MasonryAdapter(List<Integer> list, RecycleItemClickListener clickListener) {
        products = list;

        itemClickListener = clickListener;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_masonry_item, viewGroup, false);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(MasonryView masonryView, int position) {
        masonryView.imageView.setImageResource(products.get(position));
//        masonryView.textView.setText(products.get(position).getTitle());

    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    //viewholder
    public static class MasonryView extends RecyclerView.ViewHolder implements View.OnClickListener {

        private SelectableRoundedImageView imageView;
        private TextView textView;


        public MasonryView(View itemView) {
            super(itemView);
            imageView = (SelectableRoundedImageView) itemView.findViewById(R.id.masonry_item_img);
            imageView.setCornerRadiiDP(10, 10, 0, 0);
//           textView= (TextView) itemView.findViewById(R.id.masonry_item_title);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v, this.getLayoutPosition());
        }
    }


}
