package com.example.poonamiyer.pharmeasyassessment;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Poonam Iyer on 6/18/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<User> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextViewId;
        public TextView mTextViewFName;
        public TextView mTextViewLName;
        public TextView mTextViewAvatar;
        public ImageView mImageViewAvatar;

        public ViewHolder(View v) {
            super(v);
            //mTextView = v;
            mTextViewId = (TextView) v.findViewById(R.id.textvw_id);
            mTextViewFName = (TextView) v.findViewById(R.id.textvw_fname);
            mTextViewLName = (TextView) v.findViewById(R.id.textvw_lname);
            mTextViewAvatar = (TextView) v.findViewById(R.id.textvw_avatar);
            mImageViewAvatar = (ImageView) v.findViewById(R.id.imagevw_avatar);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<User> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        //...
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        if (mDataset != null) {
            holder.mTextViewId.setText(mDataset.get(position).getId().toString());
            holder.mTextViewFName.setText(mDataset.get(position).getFirstName());
            holder.mTextViewLName.setText(mDataset.get(position).getLastName());
            holder.mTextViewAvatar.setText(Html.fromHtml("<b>URL</b>: \n" + "<a href=\"" + mDataset.get(position).getAvatar() + "\">"
                    + mDataset.get(position).getAvatar() + "</a>"));
            Picasso.get().load(mDataset.get(position).getAvatar()).resize(250, 250).into(holder.mImageViewAvatar);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}