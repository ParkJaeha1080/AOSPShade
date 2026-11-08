package dev.aospshade

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 48, 32, 32)
        }
        content.addView(TextView(this).apply {
            text = "AOSPShade 0.1.0"
            textSize = 24f
        })
        content.addView(TextView(this).apply {
            text = "LSPosed entry-point probe for Samsung One UI 9.\n\nThis build checks whether known SystemUI shade controller classes are present. It does not replace the notification shade or Quick Settings yet.\n\nNext: collect verified One UI 9 hook points before enabling UI interception."
            textSize = 16f
            setPadding(0, 24, 0, 0)
        })
        setContentView(content)
    }
}
