package com.example.poonamiyer.pharmeasyassessment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    APIInterface apiInterface;

    private RecyclerView mRecyclerView;
    private RecyclerViewOnScrollListener mRecyclerViewOnScrollListener;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<User> myDataset = new ArrayList<>();

    private static int mCurrentPageIndex;
    private static int mTotalPageIndex;
    private boolean needToLoadMore = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // load more scroll listener

        this.mRecyclerViewOnScrollListener = new RecyclerViewOnScrollListener() {
            @Override
            public void onLoadMore() {
                mRecyclerViewOnScrollListener.setLoaded();
                if(needToLoadMore){
                    //showSnackBar(mContext, rootView);
                loadMore();
                }
            }
        };
        this.mRecyclerView.addOnScrollListener(this.mRecyclerViewOnScrollListener);


        apiInterface = APIClient.getClient().create(APIInterface.class);

        /**
         GET List Users
         **/
        Call<UserList> call2 = apiInterface.getUserList("1");
        call2.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                mRecyclerViewOnScrollListener.setLoaded();
                UserList userList = response.body();
                mCurrentPageIndex = userList.page;
                mTotalPageIndex = userList.total;
                if(mCurrentPageIndex < mTotalPageIndex)
                    needToLoadMore = true;
                mCurrentPageIndex += 1;
                List<User> user = userList.data;
                //myDataset = userList.data;

                // specify an adapter (see also next example)
                mAdapter = new MyAdapter(user);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                call.cancel();
            }
        });

        // specify an adapter (see also next example)
//        mAdapter = new MyAdapter(myDataset);
//        mRecyclerView.setAdapter(mAdapter);
    }

    private void loadMore() {
        apiInterface = APIClient.getClient().create(APIInterface.class);

        /**
         GET List Users
         **/
        Call<UserList> call2 = apiInterface.getUserList(String.valueOf(mCurrentPageIndex));
        call2.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {

                UserList userList = response.body();
                mCurrentPageIndex = userList.page;
                mTotalPageIndex = userList.total;
                if(mCurrentPageIndex < mTotalPageIndex)
                    needToLoadMore = true;

                mCurrentPageIndex += 1;
                List<User> user = userList.data;
                //myDataset = userList.data;

                // specify an adapter (see also next example)
                mAdapter = new MyAdapter(user);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                call.cancel();
            }
        });

    }
}
