package me.danwi.network.app;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wifi管理器
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        List<WifiConfiguration> configurationList = wifiManager.getConfiguredNetworks();
        int netWork = -1;
        for(WifiConfiguration wifiConfiguration : configurationList){
            if(wifiConfiguration.SSID.equals("\""+"ChrisWu"+"\"")){
                netWork = wifiConfiguration.networkId;
                boolean result = wifiManager.enableNetwork(netWork, true);
                int i = 0;
            }
        }

    }

}
