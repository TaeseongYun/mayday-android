package com.project.mayday.ui.main.viewmodel

import androidx.lifecycle.LiveData
import com.project.content.services.PermissionHelper
import com.project.content.ext.SingleLiveEvent
import com.project.googlemap.viewmodel.GoogleMapViewModel

class MainViewModel(permissionHelper: PermissionHelper) : GoogleMapViewModel(permissionHelper) {


}