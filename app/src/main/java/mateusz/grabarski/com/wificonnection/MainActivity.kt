package mateusz.grabarski.com.wificonnection

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.thanosfisherman.wifiutils.WifiUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var wifiManager: WifiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        WifiUtils.enableLog(true);

        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        connect.setOnClickListener { connectToWiFi(ssid = ssid.text.toString(), password = password.text.toString()) }
    }

    private fun connectToWiFi(ssid: String, password: String) {
        WifiUtils.withContext(applicationContext)
            .connectWith(ssid, password)
            .onConnectionResult { Log.d("MainActivityWIFI", "result, $it") }
            .start();
    }
}
