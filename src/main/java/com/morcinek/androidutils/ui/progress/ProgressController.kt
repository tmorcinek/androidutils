package com.morcinek.androidutils.ui.progress

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
interface ProgressController {

    fun preExecute()

    fun postExecuteWithSuccess(success: Boolean)
}
