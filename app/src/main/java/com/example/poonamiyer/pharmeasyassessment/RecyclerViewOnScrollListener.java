package com.example.poonamiyer.pharmeasyassessment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public abstract class RecyclerViewOnScrollListener extends RecyclerView.OnScrollListener {
    /**
     * The total number of items in the dataset after the last load
     */
    private int mPreviousTotal = 0;
    /**
     * True if we are still waiting for the last set of data to load.
     */
    private boolean mLoading = false;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (dy > 0) { // scrolling down
            int visibleItemCount = recyclerView.getChildCount();
            int totalItemCount = recyclerView.getLayoutManager().getItemCount();
            int firstVisibleItem =
                    ((LinearLayoutManager) recyclerView.getLayoutManager())
                            .findFirstVisibleItemPosition();


            if (this.mLoading) {
                if (totalItemCount > mPreviousTotal) {
                    this.mLoading = false;
                    mPreviousTotal = totalItemCount;
                }
            }

            int visibleThreshold = 5;
            if (!this.mLoading &&
                    (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {

                // End has been reached
                onLoadMore();
                this.mLoading = true;
            }
        }
    }

    public void setLoaded() {
        this.mLoading = false;
    }

    @Override
    public void onScrollStateChanged(final RecyclerView recyclerView, final int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

    public abstract void onLoadMore();
}