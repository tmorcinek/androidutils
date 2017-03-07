package com.morcinek.androidutils.ui.progress

import android.app.Activity
import android.app.Dialog
import org.jetbrains.anko.indeterminateProgressDialog


/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
class MessageProgressController(private val activity: Activity, private val message: Int) : ProgressController {

    private var progressDialog: Dialog? = null

    override fun preExecute() {
        progressDialog?.dismiss()
        progressDialog = activity.indeterminateProgressDialog(message).apply {
            setCancelable(false)
            show()
        }
    }

    override fun postExecuteWithSuccess(success: Boolean) {
        activity.runOnUiThread { progressDialog?.dismiss() }
    }
}