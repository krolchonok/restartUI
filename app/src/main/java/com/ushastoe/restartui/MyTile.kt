package com.ushastoe.restartui

import android.graphics.drawable.Icon
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MyTile: TileService() {

    override fun onClick() {
        super.onClick()
        runCommand("killall com.android.systemui")
        qsTile?.let { tile ->
            tile.state = Tile.STATE_INACTIVE
            tile.label = "Restart UI"
            tile.icon = Icon.createWithResource(this, R.drawable.ic_launcher_foreground)
            tile.updateTile()
        }
    }

    override fun onTileAdded() {
        super.onTileAdded()
        qsTile?.let { tile ->
            tile.state = Tile.STATE_INACTIVE
            tile.label = "Restart UI"
            tile.icon = Icon.createWithResource(this, R.drawable.ic_launcher_foreground)
            tile.updateTile()
        }
    }
    override fun onStopListening() {
        super.onStopListening()
        qsTile?.let { tile ->
            tile.state = Tile.STATE_INACTIVE
            tile.label = "Restart UI"
            tile.icon = Icon.createWithResource(this, R.drawable.ic_launcher_foreground)
            tile.updateTile()
        }
    }
    override fun onStartListening() {
        super.onStartListening()
        qsTile?.let { tile ->
            tile.state = Tile.STATE_INACTIVE
            tile.label = "Restart UI"
            tile.icon = Icon.createWithResource(this, R.drawable.ic_launcher_foreground)
            tile.updateTile()
        }
    }
    private fun runCommand(cmd: String?) {
        Runtime.getRuntime().exec("su -c $cmd")
    }
    private fun getDate(): String? {
        val now = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy ")

        return now.format(formatter)
    }
}
