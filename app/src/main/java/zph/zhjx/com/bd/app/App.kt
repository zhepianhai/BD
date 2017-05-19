package zph.zhjx.com.bd.app

import android.app.Application


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        intance = this
        val crashHandler = CrashHandler.getInstance()
        crashHandler.init(applicationContext)
    }

    companion object {
        var intance: App? = null
            private set
        var phone: String? = null
        var UserID: String? = null
        var token: String? = null
        var appVersion: String? = null
    }
}
