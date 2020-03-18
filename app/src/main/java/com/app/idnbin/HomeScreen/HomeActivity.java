package com.app.idnbin.HomeScreen;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.idnbin.Assets.SymbolListActivity;
import com.app.idnbin.BlankFragment;
import com.app.idnbin.Chat.ChatFragment;
import com.app.idnbin.Customize.CustomizeFragment;
import com.app.idnbin.MarketAnalysis.MarketAnalysisFragment;
import com.app.idnbin.MovesAlerts.MovesAlertsFragment;
import com.app.idnbin.Portfolio.PortfolioFragment;
import com.app.idnbin.Profile.ProfileFragment;
import com.app.idnbin.Tutorial.TutorialFragment;
import com.app.idnbin.R;
import com.app.idnbin.SymbolInfo.SymbolInfoFragment;
import com.app.idnbin.util.BaseActivity;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private ImageView IvPortfolio, IvMarketAnalysis, IvChat, IvMenu, IvMovesAlerts, IvTutorials, IvCustomize, IvInfo, IvAddSymbol;
    private RelativeLayout RLFrames, RLNavigation, RLBalance, RLInvest,RLLeverage,RLPrice;
    private String selectedTabItem;
    private TextView TvDeposit,TvInvestValue;
    Button BtnLogin;

    AlertDialog balancedialog;
    AlertDialog signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        IvPortfolio = findViewById(R.id.IvPortfolio);
        IvMarketAnalysis = findViewById(R.id.IvMarketAnalysis);
        IvChat = findViewById(R.id.IvChat);
        IvMenu = findViewById(R.id.IvMenu);
        IvMovesAlerts = findViewById(R.id.IvMovesAlerts);
        IvTutorials = findViewById(R.id.IvTutorials);
        IvCustomize = findViewById(R.id.IvCustomize);
        IvAddSymbol = findViewById(R.id.IvAddSymbol);
        IvInfo = findViewById(R.id.IvInfo);
        RLFrames = findViewById(R.id.RLFrames);
        RLNavigation = findViewById(R.id.RLNavigation);
        RLBalance = findViewById(R.id.RLBalance);
        TvDeposit = findViewById(R.id.TvDeposit);
        RLInvest = findViewById(R.id.RLInvest);
        TvInvestValue = findViewById(R.id.TvInvestValue);
        RLLeverage = findViewById(R.id.RLLeverage);
        RLPrice = findViewById(R.id.RLPrice);

        IvPortfolio.setOnClickListener(this);
        IvMarketAnalysis.setOnClickListener(this);
        IvChat.setOnClickListener(this);
        IvMovesAlerts.setOnClickListener(this);
        IvTutorials.setOnClickListener(this);
        IvCustomize.setOnClickListener(this);
        IvAddSymbol.setOnClickListener(this);
        IvMenu.setOnClickListener(this);
        IvInfo.setOnClickListener(this);
        RLBalance.setOnClickListener(this);
        TvDeposit.setOnClickListener(this);
        RLInvest.setOnClickListener(this);
        RLLeverage.setOnClickListener(this);
        RLPrice.setOnClickListener(this);


        if (getPref(this, "firstinstall").equalsIgnoreCase("null")) {
            setPref(this, "firstinstall", "first");
            Toast.makeText(this, "FirstInstall", Toast.LENGTH_SHORT).show();

            setPref(this, "Switch_ExpirationPanel", "0");
            setPref(this, "Switch_TraderSentiments", "0");
            setPref(this, "Switch_LiveDeals", "0");
            setPref(this, "Switch_SharemyLiveDeals", "0");
            setPref(this, "Switch_ClosedDealsonChartOptions", "0");
            setPref(this, "Switch_ClosedDealsonChartFCC", "0");
            setPref(this, "Switch_Sound", "0");
            setPref(this, "Switch_InvestmentAmount", "0");
            setPref(this, "Switch_ShowHighLowonChart", "0");
            setPref(this, "Switch_BuyinOneClickOptions", "0");
            setPref(this, "Switch_BuywithconfirmationForex", "0");
            setPref(this, "Switch_UseBalancetokeepposition", "0");
            setPref(this, "Switch_trailingStop", "0");
            setPref(this, "Switch_ShwoNotificationaboutexecution", "0");
            setPref(this, "Switch_ShowPriceMovements", "0");
        }

    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        switch (v.getId()) {
            case R.id.RLPrice:
                AlertDialog pricedialog = new AlertDialog.Builder(this).create();
                pricedialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                pricedialog.setView(getLayoutInflater().inflate(R.layout.layout_price_dialog, null));
                pricedialog.show();

                EditText EtAmount = pricedialog.findViewById(R.id.EtAmount);
                Button BtnPriceUp = pricedialog.findViewById(R.id.BtnPriceUp);
                Button BtnPriceDown = pricedialog.findViewById(R.id.BtnPriceDown);

                BtnPriceDown.setOnClickListener(v1 -> {
                    if(TextUtils.isEmpty(EtAmount.getText())){
                        Toast.makeText(HomeActivity.this, "Enter a Amount", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        int amountt = Integer.parseInt(EtAmount.getText().toString());
                        if(amountt >= 2){
                            amountt--;
                        }else {
                            Toast.makeText(HomeActivity.this, "Minimum Purchase Price should be $1", Toast.LENGTH_SHORT).show();
                        }
                        EtAmount.setText(String.valueOf(amountt));
                    }
                });

                BtnPriceUp.setOnClickListener(v12 -> {
                    if(TextUtils.isEmpty(EtAmount.getText())){
                        Toast.makeText(HomeActivity.this, "Enter a Amount", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        int amountt = Integer.parseInt(EtAmount.getText().toString());
                        amountt++;
                        EtAmount.setText(String.valueOf(amountt));
                    }
                });
                break;
            case R.id.RLLeverage:
                PopupMenu popuplever = new PopupMenu(this, RLLeverage);
                popuplever.getMenuInflater().inflate(R.menu.menu_leverage, popuplever.getMenu());
                popuplever.show();
                break;
            case R.id.RLInvest:
                AlertDialog investdialog = new AlertDialog.Builder(this).create();
                investdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                investdialog.setView(getLayoutInflater().inflate(R.layout.layout_invest_dialog, null));
                investdialog.show();

                Button  BtnConfirm, BtnMultiply, BtnDivide;
                EditText EtValue, EtCoefficient;
                final double[] total = new double[1];
                final double[] amount = new double[1];
                final double[] Coefficient = new double[1];
                RecyclerView RvPresets = investdialog.findViewById(R.id.RvPresets);
                BtnConfirm = investdialog.findViewById(R.id.BtnConfirm);

                EtValue = investdialog.findViewById(R.id.EtValue);
                EtCoefficient = investdialog.findViewById(R.id.EtCoefficient);

                BtnMultiply = investdialog.findViewById(R.id.BtnMultiply);
                BtnDivide = investdialog.findViewById(R.id.BtnDivide);

                BtnDivide.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((EtValue.getText().length() > 0) && (EtCoefficient.getText().length() > 0)) {
                            amount[0] = Double.parseDouble(EtValue.getText().toString());
                            Coefficient[0] = Double.parseDouble(EtCoefficient.getText().toString());
                            total[0] = amount[0] / Coefficient[0];
                            EtValue.setText(Double.toString(total[0]));
                        }

                    }
                });

                BtnMultiply.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((EtValue.getText().length() > 0) && (EtCoefficient.getText().length() > 0)) {
                            amount[0] = Double.parseDouble(EtValue.getText().toString());
                            Coefficient[0] = Double.parseDouble(EtCoefficient.getText().toString());
                            total[0] = amount[0] * Coefficient[0];
                            EtValue.setText(Double.toString(total[0]));
                        }
                    }
                });

                BtnConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TvInvestValue.setText(EtValue.getText());
                        investdialog.dismiss();
                    }
                });
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
                RvPresets.setLayoutManager(layoutManager);


                String[] a = {"50","100","200","300","400","500","1000","2000","5000","10000"};

                PresetsAdapter presetsAdapter = new PresetsAdapter(this, a);
                RvPresets.setAdapter(presetsAdapter);
                presetsAdapter.notifyDataSetChanged();
                presetsAdapter.onItemClickListner(new PresetsAdapter.onItemClickListner() {
                    @Override
                    public void onClick(String[] str) {
                        Toast.makeText(HomeActivity.this, str[0], Toast.LENGTH_LONG).show();
                        EtValue.setText(str[0]);
                    }
                });
                break;
            case R.id.TvDeposit:
                signin = new AlertDialog.Builder(this).create();
                signin.requestWindowFeature(Window.FEATURE_NO_TITLE);
                signin.setView(getLayoutInflater().inflate(R.layout.layout_signin_dialog, null));
                signin.show();

                BtnLogin = signin.findViewById(R.id.BtnLogin);
                BtnLogin.setOnClickListener(this);
                break;
            case R.id.BtnLogin:
                signin.dismiss();
                break;
            case R.id.TvAddRealAccount:
                balancedialog.dismiss();
                signin = new AlertDialog.Builder(this).create();
                signin.requestWindowFeature(Window.FEATURE_NO_TITLE);
                signin.setView(getLayoutInflater().inflate(R.layout.layout_signin_dialog, null));
                signin.show();

                BtnLogin = signin.findViewById(R.id.BtnLogin);
                BtnLogin.setOnClickListener(this);

                break;
            case R.id.RLBalance:
                balancedialog = new AlertDialog.Builder(this).create();
                balancedialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                balancedialog.setView(getLayoutInflater().inflate(R.layout.layout_balance_dialog, null));
                balancedialog.show();

                TextView TvAddRealAccount = balancedialog.findViewById(R.id.TvAddRealAccount);

                TvAddRealAccount.setOnClickListener(this);

                break;
            case R.id.IvAddSymbol:
                startActivity(new Intent(HomeActivity.this, SymbolListActivity.class));
                break;
            case R.id.IvMenu:
                RLFrames.setVisibility(View.GONE);
                fragmentTransaction.replace(R.id.FragmentHolder, new BlankFragment());
                if (RLNavigation.getVisibility() == View.VISIBLE) {
                    RLNavigation.setVisibility(View.GONE);
                    fragmentTransaction.replace(R.id.FragmentNav, new BlankFragment());
                } else {
                    fragmentTransaction.replace(R.id.FragmentNav, new ProfileFragment());
                    RLNavigation.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.IvPortfolio:
                if (RLFrames.getVisibility() == View.VISIBLE) {
                    if (selectedTabItem.equalsIgnoreCase("Portfolio")) {
                        RLFrames.setVisibility(View.GONE);
                        fragmentTransaction.replace(R.id.FragmentHolder, new BlankFragment());
                    } else {
                        fragmentTransaction.replace(R.id.FragmentHolder, new PortfolioFragment());
                        selectedTabItem = "Portfolio";
                    }

                } else {
                    fragmentTransaction.replace(R.id.FragmentHolder, new PortfolioFragment());
                    RLFrames.setVisibility(View.VISIBLE);
                    selectedTabItem = "Portfolio";
                }

                break;
            case R.id.IvMarketAnalysis:
                if (RLFrames.getVisibility() == View.VISIBLE) {
                    if (selectedTabItem.equalsIgnoreCase("MerketAnalysis")) {
                        RLFrames.setVisibility(View.GONE);
                        fragmentTransaction.replace(R.id.FragmentHolder, new BlankFragment());
                    } else {
                        fragmentTransaction.replace(R.id.FragmentHolder, new MarketAnalysisFragment());
                        selectedTabItem = "MerketAnalysis";
                    }

                } else {
                    fragmentTransaction.replace(R.id.FragmentHolder, new MarketAnalysisFragment());
                    RLFrames.setVisibility(View.VISIBLE);
                    selectedTabItem = "MerketAnalysis";
                }

                break;
            case R.id.IvChat:
                if (RLFrames.getVisibility() == View.VISIBLE) {
                    if (selectedTabItem.equalsIgnoreCase("Chat")) {
                        RLFrames.setVisibility(View.GONE);
                        fragmentTransaction.replace(R.id.FragmentHolder, new BlankFragment());
                    } else {
                        fragmentTransaction.replace(R.id.FragmentHolder, new ChatFragment());
                        selectedTabItem = "Chat";
                    }

                } else {
                    fragmentTransaction.replace(R.id.FragmentHolder, new ChatFragment());
                    RLFrames.setVisibility(View.VISIBLE);
                    selectedTabItem = "Chat";
                }
                break;

            case R.id.IvMovesAlerts:
                if (RLFrames.getVisibility() == View.VISIBLE) {
                    if (selectedTabItem.equalsIgnoreCase("MovesAlerts")) {
                        RLFrames.setVisibility(View.GONE);
                        fragmentTransaction.replace(R.id.FragmentHolder, new BlankFragment());
                    } else {
                        fragmentTransaction.replace(R.id.FragmentHolder, new MovesAlertsFragment());
                        selectedTabItem = "MovesAlerts";
                    }

                } else {
                    fragmentTransaction.replace(R.id.FragmentHolder, new MovesAlertsFragment());
                    RLFrames.setVisibility(View.VISIBLE);
                    selectedTabItem = "MovesAlerts";
                }
                break;
            case R.id.IvTutorials:
                if (RLFrames.getVisibility() == View.VISIBLE) {
                    if (selectedTabItem.equalsIgnoreCase("Tutorials")) {
                        RLFrames.setVisibility(View.GONE);
                        fragmentTransaction.replace(R.id.FragmentHolder, new BlankFragment());
                    } else {
                        fragmentTransaction.replace(R.id.FragmentHolder, new TutorialFragment());
                        selectedTabItem = "Tutorials";
                    }

                } else {
                    fragmentTransaction.replace(R.id.FragmentHolder, new TutorialFragment());
                    RLFrames.setVisibility(View.VISIBLE);
                    selectedTabItem = "Tutorials";
                }
                break;
            case R.id.IvCustomize:
                if (RLFrames.getVisibility() == View.VISIBLE) {
                    if (selectedTabItem.equalsIgnoreCase("Customize")) {
                        RLFrames.setVisibility(View.GONE);
                        fragmentTransaction.replace(R.id.FragmentHolder, new BlankFragment());
                    } else {
                        fragmentTransaction.replace(R.id.FragmentHolder, new CustomizeFragment());
                        selectedTabItem = "Customize";
                    }

                } else {
                    fragmentTransaction.replace(R.id.FragmentHolder, new CustomizeFragment());
                    RLFrames.setVisibility(View.VISIBLE);
                    selectedTabItem = "Customize";
                }
                break;
            case R.id.IvInfo:
                if (RLFrames.getVisibility() == View.VISIBLE) {
                    if (selectedTabItem.equalsIgnoreCase("Info")) {
                        RLFrames.setVisibility(View.GONE);
                        fragmentTransaction.replace(R.id.FragmentHolder, new BlankFragment());
                    } else {
                        fragmentTransaction.replace(R.id.FragmentHolder, new SymbolInfoFragment());
                        selectedTabItem = "Info";
                    }

                } else {
                    fragmentTransaction.replace(R.id.FragmentHolder, new SymbolInfoFragment());
                    RLFrames.setVisibility(View.VISIBLE);
                    selectedTabItem = "Info";
                }
                break;
        }
        fragmentTransaction.commit();
    }
}
