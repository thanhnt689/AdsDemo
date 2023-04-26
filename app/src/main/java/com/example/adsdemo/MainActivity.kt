package com.example.adsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.amazic.ads.callback.NativeCallback
import com.amazic.ads.util.Admob
import com.example.adsdemo.databinding.ActivityMainBinding
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Admob.getInstance().loadBanner(this, "ca-app-pub-3940256099942544/6300978111")

        Admob.getInstance().loadNativeAd(
            this,
            "ca-app-pub-3940256099942544/2247696110",
            object : NativeCallback() {
                override fun onNativeAdLoaded(nativeAd: NativeAd?) {
                    super.onNativeAdLoaded(nativeAd)
                    Log.d("ThanhNT", "onNativeAdLoaded")
                    val adView = LayoutInflater.from(this@MainActivity)
                        .inflate(R.layout.ads_native, null) as NativeAdView
                    binding.frAds3.removeAllViews()
                    binding.frAds3.addView(adView)

                    Admob.getInstance().pushAdsToViewCustom(nativeAd, adView)
                }

                override fun onAdFailedToLoad() {
                    Log.d("ThanhNT", "onAdFailedToLoad")
//                    binding.frAds3.visibility = View.GONE
//                    binding.frAds3.removeAllViews()
                }
            })

    }
}