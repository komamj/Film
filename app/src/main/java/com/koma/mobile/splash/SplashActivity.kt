package com.koma.mobile.splash

import android.Manifest
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.fragment.app.commit
import com.koma.commonlibrary.base.BaseActivity
import com.koma.mobile.R
import com.koma.mobile.databinding.ActivitySplashBinding
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

class SplashActivity : BaseActivity<ActivitySplashBinding>(), EasyPermissions.PermissionCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init() {
        if (isPermissionGranted()) {
            val splashFragment = supportFragmentManager.findFragmentById(R.id.content_main)
                    as SplashFragment? ?: SplashFragment().also {
                supportFragmentManager.commit {
                    replace(R.id.content_main, it)
                }
            }
        } else {
            requestPermission()
        }
    }

    private fun requestPermission() {
        EasyPermissions.requestPermissions(
            this,
            getString(R.string.app_name),
            REQUEST_CODE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE
        )
    }

    private fun isPermissionGranted(): Boolean {
        return EasyPermissions.hasPermissions(
            this,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        @NonNull permissions: Array<String>,
        @NonNull grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // EasyPermissions handles the request result.
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
    }

    override fun getLayoutId() = R.layout.activity_splash

    companion object {
        private const val REQUEST_CODE = 100
    }
}
