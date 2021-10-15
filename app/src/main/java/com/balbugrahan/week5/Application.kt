package com.balbugrahan.week5

import android.app.Application
import com.balbugrahan.week5.network.ServiceConnector

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceConnector.init()

    }
}
/*
*
class Application : MultiDexApplication(),HasActivityInjector{
    private val BASE_URL = "https://api.themoviedb.org/"

    companion object {
        private var instance: Application? = null

        fun getInstance(): Application? {
            return instance }
    }

    @Inject
    lateinit var actInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        instance = this

        val appConfig = object : AppConfig() {
            override fun apiUrl(): String {
                return BASE_URL
            }
        }
        /*
        val appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .configurations(appConfig)
            .build()
        */
        //appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return actInjector
    }

}
*
*
* */