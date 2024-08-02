package com.ushastoe.restartui

import android.app.StatusBarManager
import android.content.ComponentName
import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.color.DynamicColors
import com.google.android.material.color.utilities.DynamicColor
import java.util.concurrent.Executor
import java.util.function.Consumer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DynamicColors.applyToActivityIfAvailable(this@MainActivity)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val statusBarManager: StatusBarManager = getSystemService(StatusBarManager::class.java)
        findViewById<Button>(R.id.button).setOnClickListener {
            statusBarManager.requestAddTileService(
                ComponentName(
                    this,
                    MyTile::class.java
                ),
                "Create Restart Button",
                Icon.createWithResource(this, R.drawable.ic_launcher_foreground),
                {  }, {  }
            )
        }
    }
}