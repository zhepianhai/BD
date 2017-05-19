package zph.zhjx.com.bd.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import com.readystatesoftware.systembartint.SystemBarTintManager
import zph.zhjx.com.bd.R
import zph.zhjx.com.bd.app.ActivityCollector
import zph.zhjx.com.bd.contact.Contact
import zph.zhjx.com.bd.view.CustomToast

open class BaseActivity : FragmentActivity() {

    internal var customToast: CustomToast? =null
    override fun onCreate(arg0: Bundle?) {
        super.onCreate(arg0)
        customToast = CustomToast(this)
        ActivityCollector.addActivity(this)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }

    fun setHeaderTitle(headerView: View, left_text: String?, title: String?, position: Contact.Position) {
        val tv = headerView.findViewById(R.id.headview_center) as TextView
        val tvv = headerView.findViewById(R.id.headview_left_textview) as TextView
        if (title == null) {
            tv.text = "TITLE"
        } else {
            tv.text = title
        }
        if (left_text == null) {
            tvv.text = "返回"
        } else {
            tvv.text = left_text
        }
        when (position) {
            Contact.Position.LEFT -> tv.gravity = Gravity.LEFT
        }
    }

     fun setHeaderRightText(headerView: View, text: String?, listener: OnClickListener?) {
        val textView = headerView.findViewById(R.id.headview_right) as TextView
        if (text != null) {
            textView.text = text
        }
        if (listener != null) {
            textView.setOnClickListener(listener)
        }
    }

    fun setHeaderTitle(headerView: View, title: String) {
        setHeaderTitle(headerView, null, title, Contact.Position.CENTER)
    }

    fun setHeaderImage(headerView: View, position: Contact.Position, listener: OnClickListener?) {
        var iv: LinearLayout? = null
        when (position) {
            Contact.Position.LEFT -> {
                iv = headerView.findViewById(R.id.headview_left_layout) as LinearLayout
                if (listener != null) {
                    iv.setOnClickListener(listener)
                }
            }
        }
    }


    open fun setstatusbarcolor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            val tintManager = SystemBarTintManager(this)
            // 激活状态栏
            tintManager.isStatusBarTintEnabled = true
            // enable navigation bar tint 激活导航栏
            tintManager.setNavigationBarTintEnabled(true)
            //设置系统栏设置颜色
            tintManager.setTintColor(R.color.colorHomeNew)
            //给状态栏设置颜色
            tintManager.setStatusBarTintResource(R.color.colorHomeNew)
            //给导航栏设置资源
            tintManager.setNavigationBarTintResource(R.color.colorHomeNew)
        }
    }


    fun setstatusbackground() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }
    }


    fun setstatusbarcolor(color: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            val tintManager = SystemBarTintManager(this)
            // 激活状态栏
            tintManager.isStatusBarTintEnabled = true
            // enable navigation bar tint 激活导航栏
            tintManager.setNavigationBarTintEnabled(true)
            //设置系统栏设置颜色
            tintManager.setTintColor(Color.parseColor(color))
            //给状态栏设置颜色
            //            tintManager.setStatusBarTintResource(Color.parseColor(color));
            //给导航栏设置资源
            tintManager.setNavigationBarTintResource(Color.parseColor(color))
        }
    }

    //写一些打印“吐司”的方法

    fun toast(text: String) {

        if (TextUtils.isEmpty(text)) {
            return
        }
        /*  if (customToast != null) {
            customToast.hide();
        }*/
        customToast?.show(text, 1300)

    }


    fun CheckIsEmpty(vararg strings: String): Boolean {
        for (s in strings) {
            if (s.isEmpty()) {
                return false
            }
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    fun onClickBack(v: View) {
        this.finish()
    }

}
