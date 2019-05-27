package com.example.mapproy.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mapproy.R
import com.example.mapproy.presenter.LoginPresenter
import com.google.android.gms.auth.api.Auth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), ILoginView {

    private lateinit var loginPresenter: LoginPresenter
    private val signInCode = 777

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenter(this)

        loginPresenter.createGoogleSignInOptions()
        loginPresenter.createGoogleAPiClient(this, this)

        onClickSignButtonEvent()
    }

    private fun onClickSignButtonEvent(){
        btnSignIn.setOnClickListener {
            val mapIntent = loginPresenter.getMapIntent()
            startActivityForResult(mapIntent,777)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode ==  signInCode){
            val result = loginPresenter.getLoginResult(data)
            loginPresenter.handleLoginResult(result)
        }
    }
}
