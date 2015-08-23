package lt.mm.weatherly.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import lt.mm.weatherly.R;

import java.util.ArrayList;

/**
 * Created by mariusmerkevicius on 8/23/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<IData> data;

    public RecyclerAdapter() {
        data = new ArrayList<>();
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        IData data = this.data.get(position);
        handleText(holder.titleView, data.getTitle());
        handleText(holder.subtitleView, data.getSubtitle());
        handleText(holder.footerView, data.getFooter());
        handleText(holder.imageView, data.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<? extends IData> data) {
        this.data.clear();
        if (data == null)
            return;
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    //region Convenience

    /**
     * Convenience method to validate input and set it on the view
     * @param view provided view
     * @param text provided text input
     */
    void handleText(View view, String text) {
        if (view == null)
            return;
        if (TextUtils.isEmpty(text)) {
            view.setVisibility( (view instanceof TextView) ? View.INVISIBLE : View.GONE );
            return;
        }
        if (view instanceof TextView)
            ((TextView) view).setText(text);
        if (view instanceof ImageView) // todo fix this whenever image loading is implemented
            ((ImageView) view).setImageBitmap(null);
        view.setVisibility(View.VISIBLE);
    }

    //endregion

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

    public interface IData {
        String getTitle();
        String getSubtitle();
        String getFooter();
        String getImageUrl();
    }

    //endregion
}
