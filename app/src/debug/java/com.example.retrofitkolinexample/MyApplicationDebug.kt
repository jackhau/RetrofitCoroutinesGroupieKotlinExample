package com.example.retrofitkolinexample

import com.example.retrofitkolinexample.retrofit.ServiceGenerator
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader

class MyApplicationDebug: MyApplication() {

    override fun onCreate() {
        super.onCreate()

        SoLoader.init(this, false)

        val networkPlugin = NetworkFlipperPlugin()
        val client = AndroidFlipperClient.getInstance(this)
        client.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()))
        client.addPlugin(networkPlugin)
        client.start()

        val plugin = AndroidFlipperClient
            .getInstance(this)
            .getPluginByClass(NetworkFlipperPlugin::class.java)

        ServiceGenerator.addNetworkInterceptor(FlipperOkhttpInterceptor(plugin))
    }
}