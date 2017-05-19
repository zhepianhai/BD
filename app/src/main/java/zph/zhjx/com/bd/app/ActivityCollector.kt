package zph.zhjx.com.bd.app

import android.app.Activity
import java.util.*

/**
 * Created by adminZPH on 2017/3/6.
 * 活动管理容器
 */

object ActivityCollector {
    var activities: MutableList<Activity> = ArrayList()
    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    fun finishAll() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
    }
}
