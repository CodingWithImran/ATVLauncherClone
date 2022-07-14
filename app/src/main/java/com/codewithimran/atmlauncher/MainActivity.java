
package com.codewithimran.atmlauncher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ItemModals> list;
    PackageManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        /*     Load Apps in Array using Intents     */
        manager = getPackageManager();
        list = new ArrayList<>();
        Intent i = new Intent(getIntent().ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> availableActivities = manager.queryIntentActivities(i, 0);

        for(ResolveInfo ri : availableActivities){
            ItemModals modal = new ItemModals();
            modal.setPackageName(ri.activityInfo.packageName);
            modal.setName(ri.loadLabel(manager));
            modal.setImage(ri.loadIcon(manager));
            list.add(modal);
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(gridLayoutManager);
        ItemAdapter ad = new ItemAdapter(this, list);
        recyclerView.setAdapter(ad);
    }
}