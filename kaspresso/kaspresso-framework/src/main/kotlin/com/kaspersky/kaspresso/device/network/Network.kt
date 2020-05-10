package com.kaspersky.kaspresso.device.network

import android.os.Build
import com.kaspersky.kaspresso.annotations.MaximumSupportedVersion
import com.kaspersky.kaspresso.annotations.RequiresAdbServer

/**
 * The interface to work with network settings.
 *
 * Required: Started AdbServer
 *     1. Download a file "kaspresso/artifacts/desktop.jar"
 *     2. Start AdbServer => input in cmd "java jar path_to_file/desktop.jar"
 * Methods demanding to use AdbServer in the default implementation of this interface are marked.
 *     But nobody can't deprecate you to write implementation that doesn't require AdbServer.
 */
interface Network {

    /**
     * Enables wi-fi and mobile data using adb.
     *
     * Required Permissions: INTERNET.
     *
     * This method is supported only for Android P or below.
     * There is an [issue-139](https://github.com/KasperskyLab/Kaspresso/issues/139) to improve the current solution.
     */
    @RequiresAdbServer
    @MaximumSupportedVersion(Build.VERSION_CODES.P)
    fun enable()

    /**
     * Disables wi-fi and mobile data using adb.
     *
     * Required Permissions: INTERNET.
     *
     * This method is supported only for Android P or below.
     * There is an [issue-139](https://github.com/KasperskyLab/Kaspresso/issues/139) to improve the current solution.
     */
    @RequiresAdbServer
    @MaximumSupportedVersion(Build.VERSION_CODES.P)
    fun disable()

    /**
     * Toggles only wi-fi. Note: it works only if flight mode is off.
     *
     * This method is supported only for Android P or below.
     * There is an [issue-139](https://github.com/KasperskyLab/Kaspresso/issues/139) to improve the current solution.
     */
    @MaximumSupportedVersion(Build.VERSION_CODES.P)
    fun toggleWiFi(enable: Boolean)
}
