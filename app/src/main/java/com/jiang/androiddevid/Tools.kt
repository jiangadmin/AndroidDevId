package com.jiang.androiddevid

import android.content.Context
import com.baidu.liantian.ac.LH
import java.util.Locale

object Tools {

    /**
     * 获取设备ID
     *
     * @param context
     * @return
     */
    private var deviceID: String = ""

    @Synchronized
    fun getDeviceId(context: Context?): String {
        if ("" == deviceID) {
            try {
                LH.init(context, false)
                val deviceId = LH.getId(context, "1")
                if (deviceId?.second != null) {
                    deviceID = (deviceId.second as String).uppercase(Locale.getDefault())
                }
            } catch (var2: java.lang.Exception) {
                val var2 = var2
                var2.printStackTrace()
            }
        }

        return deviceID
    }
}