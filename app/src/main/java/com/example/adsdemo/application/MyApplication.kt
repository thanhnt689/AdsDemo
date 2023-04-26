package com.example.adsdemo.application

import com.amazic.ads.util.AdsApplication

class MyApplication : AdsApplication() {
    override fun enableAdsResume(): Boolean {
        return true
    }

    override fun getListTestDeviceId(): MutableList<String>? {
        return null
    }

    override fun getResumeAdId(): String {
        return "resume_id";
    }

    override fun buildDebug(): Boolean {
        return true
    }
}