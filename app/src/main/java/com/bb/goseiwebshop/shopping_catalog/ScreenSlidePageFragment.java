package com.bb.goseiwebshop.shopping_catalog;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.goseiwebshop.R;

public class ScreenSlidePageFragment extends Fragment {

    private static final String BUNDLE_MESSAGE = "productIDs";

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    private final ProductViewClickListener clickListener;

    public ScreenSlidePageFragment(ProductViewClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public static ScreenSlidePageFragment newInstance(int[] productIDs, ShoppingCatalogActivity activity) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment(activity);

        Bundle args = new Bundle();
        args.putIntArray(BUNDLE_MESSAGE, productIDs);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shopping_catalog_fragment, container, false);

        setupRecyclerView(view);
        setupRecyclerData();

        return view;
    }

    @Override
    public
    void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void setupRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter = new RecyclerAdapter(this.clickListener);
        recyclerView.setAdapter(adapter);
    }

    private void setupRecyclerData() {
        if (getArguments() != null) {
            int[] productIDs = getArguments().getIntArray(BUNDLE_MESSAGE);

            if (productIDs != null) {
                adapter.addData(productIDs);
            }
        }
    }
}