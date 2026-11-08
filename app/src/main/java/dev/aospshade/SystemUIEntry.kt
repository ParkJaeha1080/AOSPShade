package dev.aospshade

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.callbacks.XC_LoadPackage

class SystemUIEntry : IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (lpparam.packageName != "com.android.systemui") return
        XposedBridge.log("AOSPShade: loaded in SystemUI; sdk=" + android.os.Build.VERSION.SDK_INT)

        val candidates = listOf(
            "com.android.systemui.shade.NotificationPanelViewController",
            "com.android.systemui.statusbar.phone.CentralSurfacesImpl",
            "com.android.systemui.qs.QSPanelController"
        )
        candidates.forEach { name ->
            val clazz = try {
                Class.forName(name, false, lpparam.classLoader)
            } catch (_: Throwable) {
                null
            }
            XposedBridge.log("AOSPShade: class probe " + name + " = " + (clazz != null))
            clazz?.declaredMethods
                ?.filter { it.name in setOf("onViewAttached", "setQsExpansion", "onPanelExpansionChanged") }
                ?.forEach { method ->
                    XposedBridge.log("AOSPShade: candidate hook " + clazz.name + "#" + method.name)
                }
        }
    }
}
