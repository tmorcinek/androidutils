package com.morcinek.androidutils.ui.progress

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.widget.ProgressBar
import com.morcinek.androidutils.R


/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
class DialogProgressController(private val activity: Activity) : ProgressController {

    private var progressDialog: Dialog? = null

    override fun preExecute() {
        progressDialog?.dismiss()
        progressDialog = ScreenProgressDialog(activity).apply { show() }
    }

    override fun postExecuteWithSuccess(success: Boolean) {
        activity.runOnUiThread { progressDialog?.dismiss() }
    }

    private class ScreenProgressDialog(context: Context) : Dialog(context, R.style.DimmedDialogTheme) {

        init {
            window.setContentView(ProgressBar(context))
            setCancelable(false)
        }
    }
}