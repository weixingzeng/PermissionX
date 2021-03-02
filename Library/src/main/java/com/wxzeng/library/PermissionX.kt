package com.wxzeng.library

import androidx.fragment.app.FragmentActivity

/**
 *  @author: weixingzeng
 *  @e-mail: 330446962@qq.com
 *  @date 2021/03/02 5:31 PM
 *  @desc:
 *  @version:
 */
object PermissionX {
     private const val TAG ="InvisibleFragment"

    fun request(activity:FragmentActivity,vararg permissions :String ,callback:PermissionCallback){
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if(existedFragment!= null){
            existedFragment as InvisibleFragment
        }else{
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback,*permissions)
    }
}