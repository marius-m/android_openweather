package lt.mm.weatherly.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import lt.mm.weatherly.R;

/**
 * Created by mariusmerkevicius on 8/23/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private String[] dataset;

    public RecyclerAdapter(String[] myDataset) {
        dataset = myDataset;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleView.setText(dataset[position]);
    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }

    //region Classes

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleView;
        public TextView subtitleView;
        public TextView footerView;
        public ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            titleView = (TextView) v.findViewById(R.id.view_title);
            subtitleView = (TextView) v.findViewById(R.id.view_subtitle);
            footerView = (TextView) v.findViewById(R.id.view_footer);
            imageView = (ImageView) v.findViewById(R.id.view_image);
        }
    }

    //endregion
}
