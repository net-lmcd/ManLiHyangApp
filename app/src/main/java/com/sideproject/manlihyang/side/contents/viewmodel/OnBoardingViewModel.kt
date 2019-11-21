package com.sideproject.manlihyang.side.contents.viewmodel

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.sideproject.manlihyang.side.contents.base.BaseNavigator
import com.sideproject.manlihyang.side.contents.base.BaseViewModel
import com.sideproject.manlihyang.side.contents.remote.model.User
import com.sideproject.manlihyang.side.contents.rx.SchedulerProvider
import com.sideproject.manlihyang.side.contents.util.Validation
import com.sideproject.manlihyang.side.contents.view.onboarding.OnBoardingDatamanager
import io.reactivex.Flowable
import java.util.regex.Pattern

class OnBoardingViewModel constructor(
    private var onBoardingDatamanager: OnBoardingDatamanager,
    schedulerProvider: SchedulerProvider)
    : BaseViewModel<BaseNavigator>(schedulerProvider) {

    val _user : MutableLiveData<User> by lazy { MutableLiveData<User>() }
    var email = MutableLiveData<String>("asdf")
//    val isValidEmail: MediatorLiveData<Boolean> = MediatorLiveData<Boolean>().apply{
//        addSource(email){
//            this.value = it.va
//        }
//    }
    var password = MutableLiveData<String>()


    fun check() {
        Log.e("check", "${email.value} + ${password.value}")
        Log.e("check", Validation.isValidOrNot(email.value.toString(), type = Validation.CheckType.Email).toString())
        Log.e("password", Validation.isValidOrNot(password.value.toString(), type = Validation.CheckType.Password).toString())
        Log.e("phonenumber", Validation.isValidOrNot("01012345678", type = Validation.CheckType.PhoneNumber).toString())
    }
}