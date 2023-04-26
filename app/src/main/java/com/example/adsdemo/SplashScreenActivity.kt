package com.example.adsdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amazic.ads.callback.InterCallback
import com.amazic.ads.util.Admob
import com.example.adsdemo.databinding.ActivitySplashScreenBinding
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd


class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private var mInterstitialAd: InterstitialAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Admob.getInstance().loadSplashInterAds(
            this,
            "ca-app-pub-3940256099942544/1033173712",
            25000,
            5000,
            object : InterCallback() {
                override fun onNextAction() {
                    super.onNextAction()
                    startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                    finish()

                }
            })
//        Admob.getInstance().loadInterAds(this, "ca-app-pub-3940256099942544/1033173712", object : InterCallback() {
//            override fun onInterstitialLoad(interstitialAd: InterstitialAd?) {
//                super.onInterstitialLoad(interstitialAd)
//
//                mInterstitialAd = interstitialAd
//
//            }
//        })
//
//        binding.btn.setOnClickListener {
//            Admob.getInstance().showInterAds(this, mInterstitialAd, object : InterCallback() {
//                override fun onNextAction() {
//                    super.onNextAction()
//                    startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
//                    finish()
//                }
//
//            })
//        }
    }
}