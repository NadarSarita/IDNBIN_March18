package com.app.idnbin.Assets;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;

import com.app.idnbin.Assets.Commodities.CommodSymbolFragment;
import com.app.idnbin.Assets.Crypto.CryptoSymbolFragment;
import com.app.idnbin.Assets.Digital.DigitalSymbolFragment;
import com.app.idnbin.Assets.ETF.ETFSymbolFragment;
import com.app.idnbin.Assets.Forex.ForexSymbolFragment;
import com.app.idnbin.LoginRegister.FragmentRegistration;
import com.app.idnbin.R;
import com.app.idnbin.Assets.Stocks.StocksSymbolFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SymbolListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_symbol_list);
    }

}
