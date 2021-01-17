package com.vanced.manager.model

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.lifecycle.LiveData
import com.beust.klaxon.JsonObject
import com.vanced.manager.utils.PackageHelper

class RootDataModel(
    jsonObject: LiveData<JsonObject?>,
    context: Context,
    appPkg: String,
    appName: String,
    appIcon: Drawable?,
    //BUG THIS!
    //kotlin thinks that this value is null if we use
    //private val scriptName: String
    //Although it's impossible for it to be null.
    //Ironic, isn't it?
    private val scriptName: String?
): DataModel(
    jsonObject, context, appPkg, appName, appIcon
) {

    override fun isAppInstalled(pkg: String): Boolean {
        //Adapt to nullable shit
        return if (scriptName?.let { PackageHelper.scriptExists(it) } == true) {
            super.isAppInstalled(appPkg)
        } else {
            false
        }
    }

}