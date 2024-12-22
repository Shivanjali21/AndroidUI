package com.practice.androidui.activities

import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.practice.androidui.R
import com.practice.androidui.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val sharedPref by lazy {
        applicationContext.getSharedPreferences("dynamicIcon", MODE_PRIVATE)
    }
    enum class AppLauncherIcons(val themeName:String,val imageRes:Int){
        Theme_One(themeName = ".Icon1", imageRes = R.drawable.android),
        Theme_Two(themeName = ".Icon2", imageRes = R.drawable.christmas),
        Theme_Three(themeName = ".Icon3", imageRes = R.drawable.food),
        Theme_Four(themeName = ".Icon4", imageRes = R.drawable.happynewyear),
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.apply {
            binding.apply {
                ivAndroid.setOnClickListener {
                  bottomSheetDialog(AppLauncherIcons.Theme_One)
                }

                ivChristmas.setOnClickListener {
                  bottomSheetDialog(AppLauncherIcons.Theme_Two)
                }

                ivFood.setOnClickListener {
                  bottomSheetDialog(AppLauncherIcons.Theme_Three)
                }

                ivHNY.setOnClickListener {
                  bottomSheetDialog(AppLauncherIcons.Theme_Four)
                }
            }
        }
    }

    private fun bottomSheetDialog(icon: AppLauncherIcons){
       binding.btnConfirm.setOnClickListener {
          val bottomSheetDialog = BottomSheetDialog(this@MainActivity, R.style.TransparentBottomSheetDialogTheme)
          val bottomSheetView: View = LayoutInflater.from(applicationContext).inflate(R.layout.layout_bottom_sheet, null)
          bottomSheetDialog.setContentView(bottomSheetView)
          bottomSheetDialog.show()
          val selectedImg = bottomSheetView.findViewById<ImageView>(R.id.ivDIcon)
          selectedImg.setImageResource(icon.imageRes)
          bottomSheetView.findViewById<View>(R.id.btnConfirm).setOnClickListener {
              changeIconDynamically(icon)
              Toast.makeText(this@MainActivity, "Icon will change please wait!", Toast.LENGTH_SHORT).show()
              bottomSheetDialog.dismiss()
          }
       }
    }

    private fun changeIconDynamically(iconImage: AppLauncherIcons) {

        val currentIcon = sharedPref.getString("currentIcon", AppLauncherIcons.Theme_One.themeName)
        if (currentIcon == iconImage.themeName) return  //no action performed

        packageManager.setComponentEnabledSetting(
            ComponentName(this, "$packageName${iconImage.themeName}"),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )

        packageManager.setComponentEnabledSetting(
            ComponentName(this, "$packageName$currentIcon"),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )

        sharedPref.edit {
            putString("currentIcon", iconImage.themeName)
            apply()
        }
    }
}